import React, { useEffect, useState } from 'react'
import styles from './UserQnADetail.module.css'
import PageTitle from '../common/PageTitle'
import { useParams } from 'react-router-dom'
import axios from 'axios'
import dayjs from 'dayjs'

const UserQnADetail = () => {

  // 문의 상세 데이터 조회를 pk를 얻기 위한 params hook
  const {qstId} = useParams();

  // 답변 정보를 저장할 state 변수
  const [answerData, setAnswerData] = useState({});

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

  // 답변 정보를 조회할 useEffect
  useEffect(() => {
    axios.get(`/api/answers/${qstId}`)
    .then(res => setAnswerData(res.data))
    .catch(e => console.log(e));
  }, []);

  console.log(qstDetail)
  console.log(answerData)

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
        {
        qstDetail.qstStatus === '답변완료'
        &&
        <div className={styles.answer_div}>
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
                <td>문의 번호</td>
                <td>{answerData.qstId}</td>
                <td>답변자</td>
                <td>{answerData.memId}</td>
                <td>답변 날짜</td>
                <td>{dayjs(answerData.ansDate).format('YYYY-MM-DD HH:mm:ss')}</td>
              </tr>
              <tr>
                <td colSpan={6}>{answerData.ansContent}</td>
              </tr>
            </tbody>
          </table>
        </div>
        }
      </div>
    </div>
  )
}

export default UserQnADetail