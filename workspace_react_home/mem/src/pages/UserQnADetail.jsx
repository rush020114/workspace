import React, { useEffect, useState } from 'react'
import styles from './UserQnADetail.module.css'
import PageTitle from '../common/PageTitle'
import { useParams } from 'react-router-dom'
import axios from 'axios'
import dayjs from 'dayjs'

const UserQnADetail = () => {

  // 문의 상세 데이터 조회를 pk를 얻기 위한 params hook
  const {qstId} = useParams();

  // 로그인 정보를 받아올 변수
  const loginInfo = sessionStorage.getItem('loginInfo');

  // 로그인 정보 객체화
  const loginData = JSON.parse(loginInfo);

  // 문의 상세 데이터를 저장할 state 변수
  const [qstDetail, setQstDetail] = useState([]);

  // 문의 상세 데이터를 조회할 useEffect
  useEffect(() => {
    axios.get('/api/questions/detail', {params: {
      memRole: loginData.memRole
      , qstId
    }})
    .then(res => setQstDetail(res.data))
    .catch(e => console.log(e));
  }, []);

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
            <col width='16.66%' />
            <col width='16.66%' />
            <col width='16.66%' />
            <col width='16.66%' />
            <col width='16.66%' />
            <col width='16.66%' />
          </colgroup>
          <tbody>
            <tr>
              <td>제목</td>
              <td>{qstDetail.qstTitle}</td>
              <td>작성일</td>
              <td>{dayjs(qstDetail.qstDate).format('YYYY-MM-DD HH:mm:ss')}</td>
              <td>진행상황</td>
              <td>{qstDetail.qstStatus}</td>
            </tr>
            <tr>
              <td>내용</td>
              <td colSpan={5}>{qstDetail.qstContent}</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  )
}

export default UserQnADetail