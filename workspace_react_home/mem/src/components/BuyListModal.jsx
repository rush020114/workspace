import React from 'react'
import styles from './BuyListModal.module.css'
import Modal from '../common/Modal'
import PageTitle from '../common/PageTitle'

const BuyListModal = ({
  buyDetail
  , isOpenBuyDetail
  , onClose
}) => {
  return (
    <Modal
      size='1000px'
      title='구매 상세 조회'
      isOpen={isOpenBuyDetail}
      onClose={onClose}
    >
      <div className={styles.container}>
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
                buyDetail.map((buy, i) => {
                  return(
                    <tr key={i}>
                      <td>{buyDetail.length - i}</td>
                      <td>
                        <div className={styles.img_div}>
                          <div>
                            <img src={`http://localhost:8080/upload/${buy.clothingDTO.clothingImgDTOList[0].attachedImgName}`} />
                          </div>
                          <p>{buy.clothingDTO.clothingName}</p>
                        </div>
                       </td>
                      <td>{buy.clothingDTO.price.toLocaleString() + '원'}</td>
                      <td>{buy.buyCnt}</td>
                      <td>{buy.totalPrice.toLocaleString() + '원'}</td>
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