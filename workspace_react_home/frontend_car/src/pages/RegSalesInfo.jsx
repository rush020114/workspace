import React from 'react'
import styles from './RegSalesInfo.module.css'
import Select from '../common/Select'
import Input from '../common/Input'
import Button from '../common/Button'

const RegSalesInfo = () => {
  return (
    <div className={styles.container}>
      <div className={styles.content}>
        <div>
          <p></p>
          <Input />
        </div>
        <div>
          <p></p>
          <Select></Select>
        </div>
        <div>
          <p></p>
          <Select></Select>
        </div>
        <div>
          <p></p>
          <Input />
        </div>
      </div>
      <div>
        <Button />
      </div>
    </div>
  )
}

export default RegSalesInfo