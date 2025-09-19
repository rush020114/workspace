import React, { useEffect, useState } from 'react'
import styles from './AdminQnA.module.css'
import PageTitle from '../common/PageTitle'
import axios from 'axios'
import dayjs from 'dayjs'
import Button from '../common/Button'
import { useNavigate, useParams } from 'react-router-dom'

const AdminQnA = () => {
  const nav = useNavigate();

  // 로그인 정보를 받아올 변수
  const loginInfo = sessionStorage.getItem('loginInfo')
  
  // 로그인 정보 객체화
  const loginData = JSON.parse(loginInfo)

  // 문의사항 조회 목록을 저장할 state 변수
  const [qstList, setQstList] = useState([]);

  // 문의사항 조회 목록을 세팅할 useEffect
  useEffect(() => {
    axios.get('/api/questions', {params: {
      memId: loginData.memId
      , memRole: loginData.memRole
    }})
    .then(res => setQstList(res.data))
    .catch(e => console.log(e));
  }, []);

  return (
    <div>
      <PageTitle 
        title='문의사항'
        fontSize='2rem'
      />
      <div className={styles.content}>
        <table className={styles.table}>
          <colgroup>
            <col width='50%' />
            <col width='10%' />
            <col width='10%' />
            <col width='20%' />
            <col width='10%' />
          </colgroup>
          <thead>
            <tr>
              <td>제목</td>
              <td>문의자</td>
              <td>진행 상태</td>
              <td>작성일</td>
              <td>답변</td>
            </tr>
          </thead>
          <tbody>
            {
              qstList.length
              ?
              qstList.map((qst, i) => {
                return(
                  <tr key={i}>
                    <td
                      onClick={() => nav(`/admin/qna-detail/${qst.qstId}`)}
                    >{qst.qstTitle}</td>
                    <td>{qst.memId}</td>
                    <td>{qst.qstStatus}</td>
                    <td>{dayjs(qst.qstDate).format('YYYY-MM-DD HH:mm:ss')}</td>
                    <td>
                      <Button
                        content='답 변'
                      />
                    </td>
                  </tr>
                )
              })
              :
              <tr>
                <td colSpan={5}>문의 목록이 존재하지 않습니다.</td>
              </tr>
            }
          </tbody>
        </table>
      </div>
    </div>
  )
}

export default AdminQnA