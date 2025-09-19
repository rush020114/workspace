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

  // 선택한 파일들을 저장할 state 변수
  const [selectedFiles, setSelectedFiles] = useState([]);

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

  // 파일을 배열화 시켜줄 함수
  const handleFileChange = e => {
    setSelectedFiles(Array.from(e.target.files));
  }

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
                <div className={styles.file}>
                  <input 
                    type="file" 
                    id="file-upload" 
                    multiple
                    style={{display: 'none'}} 
                    onChange={e => handleFileChange(e)}
                  />
                  {/* for 속성은 어떤 input요소와 연결되는지를 지정하는 속성 */}
                  <label htmlFor="file-upload" className={styles.file_btn}>
                    파일 선택
                  </label>
                  <div className={styles.file_list}>
                    {
                      selectedFiles.length > 0 
                      ?
                      <ul>
                        {
                          selectedFiles.map((file, i) => {
                            return(
                              <li key={i}>{file.name}</li>
                            )
                          })
                        }
                      </ul>
                      :
                      '선택된 파일 없음'
                    }
                  </div>
                </div>
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