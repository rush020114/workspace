import React, { useEffect, useState } from 'react'
import styles from './BuyList.module.css'
import PageTitle from '../common/PageTitle'
import Button from '../common/Button'
import Input from '../common/Input'
import axios from 'axios'
import dayjs from 'dayjs'
import BuyListModal from '../components/BuyListModal'

const BuyList = () => {

  // 검색 데이터를 저장할 state 변수
  const [searchData, setSearchData] = useState({
    orderNum: ''
    , memId: ''
    , fromDate: ''
    , toDate: ''
  });

  // 구매 상세 내역 모달창을 열고 닫기 위한 state 변수
  const [isOpenBuyDetail, setIsOpenBuyDetail] = useState(false)

  // 구매 상세 내역을 저장할 state 변수
  const [buyDetail, setBuyDetail] = useState([]);

  // 구매 이력 조회를 저장할 state 변수
  const [buyList, setBuyList] = useState([]);

  // 구매 이력을 조회할 useEffect
  useEffect(() => {
    axios.get('/api/buys/buy-list-admin')
    .then(res => setBuyList(res.data))
    .catch(e => console.log(e));
  }, []);

  // 구매 상세 내역을 조회할 함수
  const getBuyDetail = orderNum => {
    axios.get(`/api/buys/buy-detail/${orderNum}`)
    .then(res => setBuyDetail(res.data))
    .catch(e => console.log(e));
  };

  // 검색 데이터를 세팅할 함수
  const handleSearchData = e => {
    setSearchData({
      ...searchData
      , [e.target.name]: e.target.value
    });
  };

  // 검색 데이터를 불러올 함수
  const searchBuy = () => {
    axios.get('/api/buys/buy-list-admin', {params: searchData})
    .then(res => {
      setBuyList(res.data);
      setSearchData({
        orderNum: ''
        , memId: ''
        , fromDate: ''
        , toDate: ''
      })
    })
    .catch(e => console.log(e));
  };

  return (
    <div className={styles.container}>
      <div>
        <PageTitle 
          title='구매 이력 조회'
        />
      </div>
      <div className={styles.search_div}>
        <div>
          <p>구매번호</p>
          <Input 
            size='150px'
            name='orderNum'
            value={searchData.orderNum}
            onChange={e => handleSearchData(e)}
          />
        </div>
        <div>
          <p>구매자ID</p>
          <Input 
            size='150px'
            name='memId'
            value={searchData.memId}
            onChange={e => handleSearchData(e)}
          />
        </div>
        <div>
          <p>구매일시</p>
          <Input 
            type='date'
            size='150px'
            name='fromDate'
            value={searchData.fromDate}
            onChange={e => handleSearchData(e)}
          />
          -
          <Input 
            type='date'
            size='150px'
            name='toDate'
            value={searchData.toDate}
            onChange={e => handleSearchData(e)}
          />
        </div>
        <div>
          <Button 
            content='검 색'
            onClick={() => searchBuy()}
          />
        </div>
      </div>
      <div className={styles.table_div}>
        <h3>{`총 ${buyList.length}건이 검색되었습니다.`}</h3>
        <table className={styles.table}>
          <thead>
            <tr>
              <td>No</td>
              <td>주문번호</td>
              <td>구매상품</td>
              <td>구매자ID</td>
              <td>결제금액</td>
              <td>구매일시</td>
            </tr>
          </thead>
          <tbody>
            {
              buyList.length
              ?
              buyList.map((buy, i) => {
                return(
                  <tr 
                    key={i}
                    onClick={() => {
                      setIsOpenBuyDetail(true);
                      getBuyDetail(buy.orderNum);
                    }}
                  >
                    <td>{buyList.length - i}</td>
                    <td>{buy.orderNum}</td>
                    <td>{buy.clothingName}</td>
                    <td>{buy.memId}</td>
                    <td>{buy.totalPrice.toLocaleString() + '원'}</td>
                    <td>{dayjs(buy.buyDate).format('YYYY.MM.DD HH:mm:ss')}</td>
                  </tr>
                )
              })
              :
              <tr>
                <td colSpan={6}>조회된 데이터가 없습니다.</td>
              </tr>
            }
          </tbody>
        </table>
      </div>
      <BuyListModal 
        buyDetail={buyDetail}
        isOpenBuyDetail={isOpenBuyDetail}
        onClose={() => setIsOpenBuyDetail(false)}
      />
    </div>
  )
}

export default BuyList