import React, { useState } from 'react'
import styles from './UserQnA.module.css'
import PageTitle from '../common/PageTitle'
import Input from '../common/Input'
import Textarea from '../common/Textarea'
import Button from '../common/Button'
import axios from 'axios'
import { useNavigate } from 'react-router-dom'

const UserQnA = () => {
  const nav = useNavigate();

  // 로그인 정보를 받아올 변수
  const loginInfo = sessionStorage.getItem('loginInfo');

  // 로그인 정보 객체화
  const loginData = JSON.parse(loginInfo);

  // 문의 데이터를 저장할 state 변수
  const [qstData, setQstData] = useState({
    qstTitle: ''
    , qstContent: ''
  });

  // 문의 데이터를 세팅할 state 변수
  const handleQstData = e => {
    setQstData({
      ...qstData
      , [e.target.name]: e.target.value
    });
  };

  // 문의 등록 함수
  const regQst = () => {
    axios.post('/api/questions', {...qstData, memId: loginData.memId})
    .then(res => {
      alert('등록완료');
      nav('/user/info')
    })
    .catch(e => console.log(e));
  };

  return (
    <div className={styles.container}>
      <PageTitle 
        title='문의'
        fontSize='2rem'
      />
      <div className={styles.content}>
        <table className={styles.qna_table}>
          <colgroup>
            <col width='12%' />
            <col width='88%' />
          </colgroup>
          <tbody>
            <tr>
              <td><h2>제목</h2></td>
              <td>
                <Input 
                  size='100%'
                  name='qstTitle'
                  value={qstData.qstTitle}
                  onChange={e => handleQstData(e)}
                />
              </td>
            </tr>
            <tr>
              <td><h2>내용</h2></td>
              <td>
                <Textarea 
                  size='100%'
                  rows='15'
                  name='qstContent'
                  value={qstData.qstContent}
                  onChange={e => handleQstData(e)}
                />
              </td>
            </tr>
            <tr>
              <td><h2>첨부 파일</h2></td>
              <td>
                <input type="file" />
                <input type="file" multiple/>
              </td>
            </tr>
          </tbody>
        </table>
        <div className={styles.btn_div}>
          <Button 
            content='등 록'
            onClick={() => regQst()}
          />
        </div>
      </div>
    </div>
  )
}

export default UserQnA