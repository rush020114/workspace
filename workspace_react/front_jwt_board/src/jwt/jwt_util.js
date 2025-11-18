import axios from "axios";
import { jwtDecode } from "jwt-decode";

// axios 객체
export const axiosInstance = axios.create({
  baseURL: 'http://localhost:8080'
  , withCredentials: true
});

axiosInstance.interceptors.request.use(
  config => {
    const token = localStorage.getItem('accessToken');
    if(token){
      config.headers.Authorization = token;
    }
    return config;
  }, 
  // 에러 발생 시 axios 실패로 간주
  error => Promise.reject(error))

// 토큰이 존재하는지 검사하는 함수
export const getToken = () => {
  const token = localStorage.getItem('accessToken');

  if(token === null) return null;

  const {exp} = jwtDecode(token);
  const currentDate = Date.now() / 1000;

  // 만료일이 지났으면
  if(exp < currentDate){
    localStorage.removeItem('accesstoken');
    return null;
  } else {
    return token;
  }
}