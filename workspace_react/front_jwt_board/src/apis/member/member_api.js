import axios from "axios"
import { axiosInstance } from "../../jwt/jwt_util";

/**
 * 회원가입 API
 * @param {*} joinData 
 */
export const joinApi = async joinData => {
  try {
    await axiosInstance.post('/api/members', joinData);
  } catch(e) {
    console.log('회원 가입 API 오류, join()');
    console.log(e);
    throw e;
  }
}

/**
 * 회원가입 API
 * @param {*} joinData 
 */
export const loginApi = async loginData => {
  try {
    const response = await axiosInstance.post('/api/member/login', loginData);

    // 응답 헤더에 담긴 토큰 정보 추출
    const  accessToken = response.headers['authorization'];

    console.log(response)
    console.log(accessToken)

    // 전달받은 토큰을 localStorage에 저장
    localStorage.setItem("accesstoken", accessToken);
  
  } catch(e) {
    if(e.status === 401){
      alert("로그인 실패");
    } else{
      alert(e.message);
    }
    throw e;
  }
}
