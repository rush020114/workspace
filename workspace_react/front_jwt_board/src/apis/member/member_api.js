import axios from "axios"

/**
 * 회원가입 API
 * @param {*} joinData 
 */
export const joinApi = async joinData => {
  try {
    await axios.post('/api/members', joinData)
  } catch(e) {
    console.log('회원 가입 API 오류, join()')
    console.log(e)
  }
}