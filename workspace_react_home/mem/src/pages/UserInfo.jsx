import React, { useEffect, useState } from 'react'
import styles from './UserInfo.module.css'
import PageTitle from '../common/PageTitle'
import Button from '../common/Button'
import axios from 'axios';
import dayjs from 'dayjs';
import { useNavigate } from 'react-router-dom';

const UserInfo = () => {
  const nav = useNavigate();

  // 로그인 정보를 받아올 변수
  const loginInfo = sessionStorage.getItem('loginInfo');

  // 로그인 정보 객체화
  const loginData = JSON.parse(loginInfo);

  // 문의 목록 조회리스트를 저장할 state 변수
  const [qstList, setQstList] = useState([]);

  // 문의 목록을 세팅할 useEffect
  useEffect(() => {
    axios.get(`/api/questions`, {params: {
      memId: loginData.memId
      , memRole: loginData.memRole
    }})
    .then(res => setQstList(res.data))
    .catch(e => console.log(e));
  }, []);

  console.log(qstList)

  return (
    <div className={styles.container}>
      <PageTitle 
        title='문의 목록'
        fontSize='2rem'
      />
      <div className={styles.content}>
        <table className={styles.table}>
          <colgroup>
            <col width='5%' />
            <col width='45%' />
            <col width='10%' />
            <col width='30%' />
            <col width='10%' />
          </colgroup>
          <thead>
            <tr>
              <td>No</td>
              <td>제목</td>
              <td>진행 상태</td>
              <td>작성일</td>
              <td colSpan={2}>관리</td>
            </tr>
          </thead>
          <tbody>
            {
              qstList.length
              ?
              qstList.map((qst, i) => {
                return(
                  <tr key={i}>
                    <td>{qstList.length - i}</td>
                    <td
                      onClick={() => nav(`/user/qna-detail/${qst.qstId}`)}
                    >{qst.qstTitle}</td>
                    <td>{qst.qstStatus}</td>
                    <td>{dayjs(qst.qstDate).format('YYYY-MM-DD HH:mm:ss')}</td>
                    <td>
                      <Button
                        content='수정'
                      />
                    </td>
                    <td>
                      <Button
                        content='삭제'
                      />
                    </td>
                  </tr>
                )
              })
              :
              <tr>
                <td 
                  colSpan={5}
                  style={{textDecoration: 'none', cursor: 'default', padding: '30px'}}
                >문의 목록이 존재하지 않습니다.</td>
              </tr>
            }
          </tbody>
        </table>
      </div>
    </div>
  )
}

export default UserInfo