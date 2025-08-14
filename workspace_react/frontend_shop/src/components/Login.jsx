import React from 'react'
// ../는 상위 폴더로 찾아간다.
import Modal from '../common/Modal.jsx'
import Input from '../common/Input.jsx'
import Button from '../common/Button.jsx'
import styles from './Login.module.css'

// component는 페이지에 붙이면 좋은 것들, 쉽게 말해 common도 아니고 page도 아닌 것이다.
const Login = ({isOpenLogin, onClose}) => {
  return (
    <Modal
     isOpen={isOpenLogin}
     title='login'
     size='300px'
     onClose={onClose}
    >
      <div className={styles.login_div}>
        <div className={styles.login_input}>
          <Input 
           size='100%'
           placeholder='Input your ID'
          />
          <span><i className="bi bi-person-fill"></i></span>
        </div>
        <div className={styles.login_input}>
          <Input 
           size='100%'
           placeholder='Input your Password'
           type='password'
          />
          <span><i className="bi bi-lock-fill"></i></span>
        </div>
        <Button
         size='100%'
         title='Sign in'
         color='green'
        />
      </div>
    </Modal>
  )
}

export default Login