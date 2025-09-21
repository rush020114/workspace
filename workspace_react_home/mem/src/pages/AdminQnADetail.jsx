import React, { useEffect, useState } from 'react'
import styles from './AdminQnADetail.module.css'
import { useNavigate, useParams } from 'react-router-dom';
import axios from 'axios';
import PageTitle from '../common/PageTitle';
import dayjs from 'dayjs';
import Button from '../common/Button';
import Textarea from '../common/Textarea';

const AdminQnADetail = () => {
  
  const nav = useNavigate();
  
  // 문의 번호를 받아올 params
  const {qstId} = useParams();

  // 답변 수정 데이터를 저장할 state 변수
  const [updateAnswer, setUpdateAnswer] = useState('');

  // 수정 버튼 클릭 시 답변으로 바뀌게 하는 state 변수
  const [isOkayAnswer, setIsOkayAnswer] = useState(false);

  // 답변 조회를 저장할 state 변수
  const [answerData, setAnswerData] = useState({});

  // 문의 답변을 저장할 state 변수
  const [ansContent, setAnsContent] = useState('');

  // 로그인 정보를 받아올 변수
  const loginInfo = sessionStorage.getItem('loginInfo')
  
  // 로그인 정보 객체화
  const loginData = JSON.parse(loginInfo)

  // 문의 상세 데이터를 저장할 state 변수
  const [qstDetail, setQstDetail] = useState({});

  // 답변 조회 useEffect
  useEffect(() => {
    axios.get(`/api/answers/${qstId}`)
    .then(res => setAnswerData(res.data))
    .catch(e => console.log(e));
  }, []);

  // 문의 상세 데이터를 세팅할 useEffect
  useEffect(() => {
    axios.get('/api/questions/detail', {params: {
      qstId
      , memRole: loginData.memRole
    }})
    .then(res => setQstDetail(res.data))
    .catch(e => console.log(e));
  }, []);

  // 문의 등록 함수
  const regAnswer = () => {
    axios.post('/api/answers', {
      ansContent: !isOkayAnswer ? ansContent : updateAnswer
      , qstId
      , memId: loginData.memId
    })
    .then(res => {
      alert('답변 완료');
      nav('/admin/qna');
    })
    .catch(e => console.log(e));
  };

  // 답변 수정을 세팅할 useEffect
  useEffect(() => {
    if(!answerData.ansContent){
      return;
    }
    setUpdateAnswer(answerData.ansContent)
  }, [isOkayAnswer])

  console.log(qstDetail)
  console.log(answerData)
  console.log(updateAnswer)

  return (
    <div className={styles.container}>
      <PageTitle 
        title='문의'
        fontSize='2rem'
      />
      <div className={styles.content}>
        <div className={styles.qna_img} style={{width: '200px'}}>
          <div className={styles.img_div}>
          {
            qstDetail.questionImgDTOList
            &&
            qstDetail.questionImgDTOList.map((img, i) => {
              if(img.isMain === 'Y'){
                return(
                  <img 
                    key={i}
                    src={`http://localhost:8080/answer_upload/${img.attachedImgName}`} 
                    style={{width: '100%'}} 
                  />
                )
              }
            })
          }
          </div>
        </div>
        <table className={styles.qna_table}>
          <colgroup>
            <col width='12.5%' />
            <col width='12.5%' />
            <col width='12.5%' />
            <col width='12.5%' />
            <col width='12.5%' />
            <col width='12.5%' />
            <col width='12.5%' />
            <col width='12.5%' />
          </colgroup>
          <tbody>
            <tr>
              <td>제목</td>
              <td>{qstDetail.qstTitle}</td>
              <td>글쓴이</td>
              <td>{qstDetail.memId}</td>
              <td>작성일</td>
              <td>{dayjs(qstDetail.qstDate).format('YYYY-MM-DD HH:mm:ss')}</td>
              <td>진행상황</td>
              <td>{qstDetail.qstStatus}</td>
            </tr>
            <tr>
              <td>내용</td>
              <td colSpan={7}>{qstDetail.qstContent}</td>
            </tr>
          </tbody>
        </table>
        <div>
        {
          (qstDetail.qstStatus !== '답변완료' || isOkayAnswer)
          ?
          <Textarea 
            rows='10'
            size='100%'
            placeholder='답변을 입력해주세요.'
            value={!isOkayAnswer ? ansContent : updateAnswer}
            onChange={e => {
              !isOkayAnswer
              ?
              setAnsContent(e.target.value)
              :
              setUpdateAnswer(e.target.value)
            }}
          />
          :
          <div className={styles.answer_div}>
            {answerData.ansContent}
          </div>
        }
        </div>
        <div className={styles.btn_div}>
        {
          (qstDetail.qstStatus !== '답변완료' || isOkayAnswer)
          ?
          <Button 
            content='답 변'
            onClick={() => regAnswer()}
          />
          :
          <Button 
            content='수 정'
            onClick={() => setIsOkayAnswer(true)}
          />
        }
        </div>
      </div>
    </div>
  )
}

export default AdminQnADetail