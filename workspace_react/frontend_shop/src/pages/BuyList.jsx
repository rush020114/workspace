import React, { useEffect, useState } from 'react'
import styles from './BuyList.module.css'
import PageTitle from '../common/PageTitle'
import Button from '../common/Button'
import Input from '../common/Input'
import Select from '../common/Select'
import axios from 'axios'
import dayjs from 'dayjs'
import BuyListModal from './BuyListModal'


const BuyList = () => {

  // 입력한 검색 조건 데이터를 저장할 state 변수
  const [searchData, setSearchData] = useState({
    orderNum: ''
    , memId: ''
    , fromDate: ''
    , toDate: ''
  });

  // 구매 상세 내역 리스트를 저장할 state 변수
  const [buyDetail, setBuyDetail] = useState([]);

  // 구매상세내역 모달창 숨김/보이기 여부
  const [isOpenBuyModal, setIsOpenBuyModal] = useState(false);

  // 구매 조회를 저장할 state 변수
  const [buyList, setBuyList] = useState([]);

  // 구매 목록을 조회할 useEffect
  useEffect(() => {
    axios.get('/api/buys/buy-list-admin')
    .then(res => setBuyList(res.data))
    .catch(e => console.log(e));
  }, []);

  // 행 클릭 시 구매 상세 조회
  const getDetail = orderNum => {
    axios.get(`/api/buys/${orderNum}`)
    .then(res => setBuyDetail(res.data))
    .catch(e => console.log(e));
  };

  // 검색 데이터를 입력할 때마다 실행하는 함수
  const handleSearchData = e => {
    setSearchData({
      ...searchData
      , [e.target.name]: e.target.value
    });
  };

  // 검색 버튼 클릭 시 실행 함수
  const doSearch = () => {
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
          <p>주문번호</p>
          <Input 
            name='orderNum'
            value={searchData.orderNum}
            onChange={e => handleSearchData(e)}
          />
        </div>
        <div>
          <p>구매자ID</p>
          <Input 
            name='memId'
            value={searchData.memId}
            onChange={e => handleSearchData(e)}
          />
        </div>
        <div>
          <p>구매일시</p>
          <Input 
            type='date'
            name='fromDate'
            value={searchData.fromDate}
            onChange={e => handleSearchData(e)}
          />- 
          <Input 
            type='date'
            name='toDate'
            value={searchData.toDate}
            onChange={e => handleSearchData(e)}
          />
        </div>
        <div>
          <Button
            title='검 색'
            onClick={() => doSearch()}
          />
        </div>
      </div>
      <div className={styles.table_div}>
        <p>{`총 ${buyList.length}건이 검색되었습니다.`}</p>
        <table className={styles.table}>
          <thead>
            <tr>
              <td>No</td>
              <td>구매번호</td>
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
              buyList.map((e, i) => {
                return(
                  <tr key={i}
                    onClick={() => {
                      setIsOpenBuyModal(true);
                      getDetail(e.orderNum);
                    }}
                  >
                    <td>{buyList.length - i}</td>
                    <td>{e.orderNum}</td>
                    <td>{e.title}</td>
                    <td>{e.memId}</td>
                    <td>{e.price.toLocaleString()}원</td>
                    <td>{dayjs(e.buyDate).format('YYYY.MM.DD HH:mm:ss')}</td>
                  </tr>
                )
              })
              :
              <tr>
                <td 
                  colSpan={6}
                  style={{padding: '50px 0px'}}
                >조회된 데이터가 없습니다.</td>
              </tr>
            }
          </tbody>
        </table>
      </div>
      <BuyListModal 
        isOpenBuyModal={isOpenBuyModal}
        onClose={() => setIsOpenBuyModal(false)}
        buyDetail={buyDetail}
      />
    </div>
  )
}

export default BuyList