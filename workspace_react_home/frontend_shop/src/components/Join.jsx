import React from 'react'
import styles from './Join.module.css'
import Modal from '../common/Modal'
import Input from '../common/Input'
import Button from '../common/Button'
import Select from '../common/Select'

const Join = ({isOpenJoin, onClose}) => {
  return (
    <Modal
     title={'Join'}
     isOpen={isOpenJoin}
     onClose={onClose}
    >
      <div className={styles.container}>
        <div className={styles.id_div}>
          <p>아이디</p>
          <div>
            <Input
             size='75%'
            />
            <Button 
             size='25%'
             title='중복 확인'
            />
          </div>
        </div>
        <div>
          <p>비밀번호</p>
          <Input
           type='password'
           size='100%'
          />
        </div>
        <div>
          <p>비밀번호 확인</p>
          <Input 
           type='password'
           size='100%'
          />
        </div>
        <div>
          <p>회원명</p>
          <Input 
           type='text'
           size='100%'
          />
        </div>
        <div className={styles.tel_div}>
          <p>연락처</p>
          <div>
            <Input 
             size='100%'
            />
            <Input 
             size='100%'
            />
            <Input 
             size='100%'
            />
          </div>
        </div>
        <div className={styles.email_div}>
          <p>이메일</p>
          <div>
            <Input 
             size='100%'
            />
            <Select
             size='100%'
            >
              <option>선택</option>
              <option>gmail.com</option>
              <option>naver.com</option>
            </Select>
          </div>
        </div>
        <div className={styles.addr_div}>
          <p>주소</p>
          <div>
            <div>
              <Input 
               size='80%'
              />
              <Button 
               size='20%'
               title='검 색'
              />
            </div>
            <Input 
             size='100%'
            />
          </div>
        </div>
        <div>
          <Button 
           size='100%'
           title='회원 가입'
          />
        </div>
      </div>
    </Modal>
  )
}

export default Join