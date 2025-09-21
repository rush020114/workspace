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

  // 선택한 메인파일을 저장할 state 변수
  const [mainImg, setMainImg] = useState(null);

  // 선택한 상세파일들을 저장할 state 변수
  const [subImgs, setSubImgs] = useState([]);

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

    const fileConfig = {'Content-Type': 'multipart/form-data'};

    const formData = new FormData();
    formData.append('mainImg', mainImg);

    for(const img of subImgs){
      formData.append('subImgs', img);
    };
    formData.append('qstTitle', qstData.qstContent);
    formData.append('qstContent', qstData.qstContent);
    formData.append('memId', loginData.memId);


    axios.post('/api/questions', formData, fileConfig)
    .then(res => {
      alert('등록완료');
      nav('/user/info')
    })
    .catch(e => console.log(e));
  };
  console.log(mainImg)
  console.log(subImgs)

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
                    id='file-upload'
                    style={{display: 'none'}}
                    onChange={e => setMainImg(e.target.files[0])}
                  />
                  <label htmlFor="file-upload" className={styles.file_btn}>
                    메인 이미지
                  </label>
                  <div className={styles.file_list}>
                    {
                      mainImg
                      ?
                      mainImg.name
                      :
                      '선택된 파일 없음'
                    }
                  </div>
                  <input 
                    type="file" 
                    id="file-upload-detail" 
                    multiple
                    style={{display: 'none'}} 
                    onChange={e => setSubImgs(Array.from(e.target.files))}
                  />
                  {/* for 속성은 어떤 input요소와 연결되는지를 지정하는 속성 */}
                  <label htmlFor="file-upload-detail" className={styles.file_btn}>
                    상세 이미지
                  </label>
                  <div className={styles.file_list}>
                    {
                      subImgs.length > 0 
                      ?
                      <ul>
                        {
                          subImgs.map((file, i) => {
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