import React from 'react'
import styles from './Login.module.css'

const Login = () => {
  return (
    <div className={styles.container}>
      <div className={styles.content}>
        <div className={styles.input}>
          <span>
            <i class="bi bi-person-fill"></i>
          </span>
          <input
           type="text" 
           placeholder='Username'
          />
        </div>
        <div className={styles.input}>
          <span>
            <i class="bi bi-lock-fill"></i>
          </span>
          <input
           type="text" 
           placeholder='Password'
          />
        </div>
        <div>
          <button type='button'>Sign In</button>
        </div>
      </div>
    </div>
  )
}

export default Login