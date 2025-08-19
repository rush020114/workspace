import React from 'react'
import styles from './Textarea.module.css'

const Textarea = ({
  size='200px'
  , rows='5'
  , children
  , ...props
}) => {
  return (
    <textarea
     className={styles.textarea}
     style={{width: size, resize: 'none'}}
     rows={rows}
     {...props}
    >
      {children}
    </textarea>
  )
}

export default Textarea