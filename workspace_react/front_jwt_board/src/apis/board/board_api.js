import axios from "axios"
import { axiosInstance } from "../../jwt/jwt_util";

// 게시글 관련된 api를 모아놓는 파일


// 게시글 목록 조회
export const getBoardListApi = async () => {  
  try{
    const res = await axiosInstance.get('/boards');
    // 조회한 다음 코드 작성
    return res.data;
  } catch (e) {
    console.log('게시글 목록 조회 API 호출 시 오류 발생 : getBoardListApi');
    console.log(e);
  }
  
}

/**
 * 게시글 상세 조회 API
 * @param {*} boardNum 게시글 번호 
 */
export const getBoardDetailApi = async boardNum => {
  try {
    const res = await axiosInstance.get(`/boards/${boardNum}`);
    return res.data;
  } catch (e) {
    console.log('게시글 목록 조회 API 호출 시 오류 발생 : getBoardDetailApi');
    console.log(e);
  }
}

/**
 * 게시글 등록 API
 * @param {*} boardInfo {'title' : '제목데이터', 'content' : '내용데이터'}
 */
export const regBoardApi = async boardInfo => {
  try{
    await axiosInstance.post('/boards', boardInfo);
  } catch (e) {
    console.log('게시글 목록 조회 API 호출 시 오류 발생 : regBoardApi');
    console.log(e);
  }
}

// 게시글 삭제

// 게시글 수정