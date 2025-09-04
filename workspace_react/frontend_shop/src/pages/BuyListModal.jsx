import React, { useEffect, useState } from 'react'
import styles from './BuyListModal.module.css'
import Modal from '../common/Modal'
import PageTitle from '../common/PageTitle'
import Input from '../common/Input'
import Select from '../common/Select'
import Button from '../common/Button'
import axios from 'axios'

const BuyListModal = ({isOpenBuyModal, onClose, buyDetail}) => {

  return (
    <Modal
      size='1000px'
      isOpen={isOpenBuyModal}
      onClose={onClose}
    >
      <div className={styles.container}>
        <PageTitle 
          title='구매상세내역'
        />
        <div className={styles.table_div}>
          <table className={styles.table}>
            <colgroup>
              <col width='15%' />
              <col width='40%' />
              <col width='15%' />
              <col width='15%' />
              <col width='15%' />
            </colgroup>
            <thead>
              <tr>
                <td>No</td>
                <td>상품정보</td>
                <td>가격</td>
                <td>수량</td>
                <td>총가격</td>
              </tr>
            </thead>
            <tbody>
              {
                buyDetail.map((detail, i) => {
                  return(
                    <tr key={i}>
                      <td>{buyDetail.length - i}</td>
                      <td>
                        <div className={styles.img_div}>
                          <div>
                            <img src={`http://localhost:8080/upload/${detail.bookDTO.bookImgDTOList[0].attachedImgName}`} alt="" />
                          </div>
                          <p>{detail.bookDTO.title}</p>
                        </div>
                      </td>
                      <td>{detail.bookDTO.price.toLocaleString()}원</td>
                      <td>{detail.buyCnt}</td>
                      <td>{detail.totalPrice.toLocaleString()}원</td>
                    </tr>
                  )
                })
              }
            </tbody>
          </table>
        </div>
      </div>
    </Modal>
  )
}

export default BuyListModal