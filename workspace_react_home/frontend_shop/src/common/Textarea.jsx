import React from 'react'
import styles from './Textarea.module.css'

const Textarea = ({size='120px', rows='5', ...props}) => {
  return (
    <textarea
      className={styles.textarea}
      style={{width: size}}
      rows={rows}
      {...props}
    >

    </textarea>
  )
}

export default Textarea