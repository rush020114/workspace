import React from 'react'
import Modal from '../common/Modal'
import Input from '../common/Input'
import Button from '../common/Button'
import styles from './Login.module.css'

const Login = ({isOpenLogin, setIsOpenLogin}) => {
  return (
    <Modal
       title='Login'
       isOpen={isOpenLogin}
       onClose={setIsOpenLogin}
      >
        <div className={styles.container}>
          <div className={styles.input}>
            <div>
              <p>아이디</p>
              <Input 
              size='100%'
              placeholder='아이디를 입력하세요.'
              />
            </div>
            <div>
              <p>비밀번호</p>
              <Input 
              type='password'
              size='100%'
              placeholder='비밀번호를 입력하세요.'
              />
            </div>
          </div>
          <div>
            <Button 
             size='100%'
            />
          </div>
        </div>
      </Modal>
  )
}

export default Login