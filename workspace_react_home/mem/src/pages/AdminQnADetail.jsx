import React, { useEffect, useState } from 'react'
import styles from './AdminQnADetail.module.css'
import { useParams } from 'react-router-dom';
import axios from 'axios';
import PageTitle from '../common/PageTitle';
import dayjs from 'dayjs';
import Button from '../common/Button';

const AdminQnADetail = () => {
  
  // 문의 번호를 받아올 params
  const {qstId} = useParams();

  // 로그인 정보를 받아올 변수
  const loginInfo = sessionStorage.getItem('loginInfo')
  
  // 로그인 정보 객체화
  const loginData = JSON.parse(loginInfo)

  // 문의 상세 데이터를 저장할 state 변수
  const [qstDetail, setQstDetail] = useState({});

  // 문의 상세 데이터를 세팅할 useEffect
  useEffect(() => {
    axios.get('/api/questions/detail', {params: {
      qstId
      , memRole: loginData.memRole
    }})
    .then(res => setQstDetail(res.data))
    .catch(e => console.log(e));
  }, []);

  console.log(qstId)
  console.log(qstDetail)
  return (
    <div className={styles.container}>
      <PageTitle 
        title='문의'
        fontSize='2rem'
      />
      <div className={styles.content}>
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
        <div className={styles.btn_div}>
          <Button 
            content='등 록'
            onClick={() => {}}
          />
        </div>
      </div>
    </div>
  )
}

export default AdminQnADetail