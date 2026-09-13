"""
LangChain PDF 기반 QA봇 템플릿
- 단순 방식(create_stuff_documents_chain): 문서 전체를 프롬프트에 넣는 방식
- RAG 방식(create_retrieval_chain): 질문과 관련된 청크만 검색해서 답변하는 방식

사용 전 준비:
  pip install langchain langchain-openai langchain-community langchain-huggingface faiss-cpu

API KEY는 .env 파일에 OPENAI_API_KEY로 저장해두고 load_dotenv()로 불러오는 걸 권장.
(os.environ["OPENAI_API_KEY"] = "..." 처럼 코드에 직접 박아넣지 말 것)
"""

import os
from dotenv import load_dotenv
from langchain_openai import ChatOpenAI
from langchain_community.document_loaders import PyPDFLoader
from langchain_core.prompts import ChatPromptTemplate
from langchain.chains.combine_documents.stuff import create_stuff_documents_chain
from langchain.text_splitter import RecursiveCharacterTextSplitter
from langchain_huggingface import HuggingFaceEmbeddings
from langchain_community.vectorstores import FAISS
from langchain.chains import create_retrieval_chain

load_dotenv()


# ---------------------------------------------------------
# 1) 단순 방식: 문서 전체를 프롬프트에 넣어서 답변 생성
#    - 짧은 문서에 적합, 문서가 길면 입력 제한에 걸릴 수 있음
# ---------------------------------------------------------
def qa_bot_simple(pdf_path, question, model="gpt-4o-mini"):
  llm = ChatOpenAI(model=model, temperature=0)

  loader = PyPDFLoader(pdf_path)
  pages = loader.load()

  prompt = ChatPromptTemplate.from_messages(
    [
      (
        "system",
        "주어진 텍스트를 이용하여 한 줄로 요약하여 대답하세요. 만약 답을 모른다면 모른다고 말하세요. \n\n {context}",
      ),
      ("human", "{input}"),
    ]
  )

  chain = create_stuff_documents_chain(llm, prompt)
  answer = chain.invoke({"context": pages, "input": question})
  return answer


# ---------------------------------------------------------
# 2) RAG 방식: 질문과 관련된 청크만 검색해서 답변 생성
#    - 문서가 길거나 질문과 무관한 내용이 많을 때 정확도가 더 높음
#    - 로드 → 분할 → 임베딩 → 벡터DB 저장 → 검색기 변환 → RAG 체인
# ---------------------------------------------------------
def build_rag_chain(pdf_path, model="gpt-4o-mini", chunk_size=2000, chunk_overlap=100):
  llm = ChatOpenAI(model=model, temperature=0)

  # 1. 문서 로드
  loader = PyPDFLoader(pdf_path)
  pages = loader.load()

  # 2. 청크 단위로 분할 (긴 문서를 그대로 넣을 수 없으므로 쪼갬)
  splitter = RecursiveCharacterTextSplitter(
    chunk_size=chunk_size, chunk_overlap=chunk_overlap
  )
  chunks = splitter.split_documents(pages)

  # 3. 임베딩 생성 (HuggingFace 모델은 무료/로컬 실행 가능)
  embeddings = HuggingFaceEmbeddings(
    model_name="sentence-transformers/all-MiniLM-L6-v2"
  )

  # 4. 벡터DB(FAISS)에 저장
  vectorstore = FAISS.from_documents(chunks, embeddings)

  # 5. 검색기(retriever)로 변환 — 질문과 유사한 청크를 찾아주는 역할
  retriever = vectorstore.as_retriever()

  # 6. 검색된 청크를 context로 받아 답변을 생성하는 프롬프트
  system_prompt = (
    "주어진 Context를 사용하여 질문에 답하세요"
    "답을 모르면 모른다고 말하세요."
    "Context: {context}"
  )
  prompt = ChatPromptTemplate.from_messages(
    [
      ("system", system_prompt),
      ("human", "{input}"),
    ]
  )

  # 7. 검색(retriever) + 응답 생성(question_answer_chain)을 하나로 묶은 RAG 체인
  question_answer_chain = create_stuff_documents_chain(llm, prompt)
  rag_chain = create_retrieval_chain(retriever, question_answer_chain)

  return rag_chain


def qa_bot_rag(rag_chain, question):
  response = rag_chain.invoke({"input": question})
  return response["answer"]


# ---------------------------------------------------------
# 사용 예시
# ---------------------------------------------------------
if __name__ == "__main__":
  pdf_path = "주택임대차보호법(법률)(제19356호)(20230418).pdf"

  # 단순 방식
  answer_simple = qa_bot_simple(
    pdf_path, "임대차가 끝난 후, 보증금이 반환되지 않으면 어떻게 해야 할까요?"
  )
  print("[단순 방식]", answer_simple)

  # RAG 방식 — 체인은 한 번만 만들어두고 여러 질문에 재사용
  rag_chain = build_rag_chain(pdf_path)

  answer_rag = qa_bot_rag(rag_chain, "전입신고는 언제까지 해야 하나요?")
  print("[RAG 방식]", answer_rag)