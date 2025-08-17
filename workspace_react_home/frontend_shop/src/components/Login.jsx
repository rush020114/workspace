import React from 'react'
import Modal from '../common/Modal'
import Input from '../common/Input'
import Button from '../common/Button'
import styles from './Login.module.css'

const Login = ({isOpenLogin, onClose}) => {
  return (
    <Modal
     isOpen={isOpenLogin}
     title={'login'}
     size={'300px'}
     onClose={onClose}
    >
      <div className={styles.container}>
        <div className={styles.login_input}>
          <Input 
           size='100%'
           type='text'
           placeholder={'Username'}
          />
          <span><i className="bi bi-person-fill"></i></span>
        </div>
        <div className={styles.login_input}>
          <Input 
           size='100%'
           type='password'
           placeholder={'Password'}
          />
          <span><i className="bi bi-lock-fill"></i></span>
        </div>
        <div className={styles.login_btn}>
          <Button 
           size='100%'
           title='로그인'
          />
        </div>
      </div>
    </Modal>
  )
}

export default Login