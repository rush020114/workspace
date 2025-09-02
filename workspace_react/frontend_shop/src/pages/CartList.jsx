import React, { useEffect, useRef, useState } from 'react'
import styles from './CartList.module.css'
import { useNavigate, useParams } from 'react-router-dom'
import axios from 'axios';
import dayjs from 'dayjs';
import Input from '../common/Input';
import Button from '../common/Button'

const CartList = () => {
  const nav = useNavigate();

  // 장바구니 목록 데이터를 조회하는 useEffect를 재실행하기 위한 변수
  const[reload, setReload] = useState(0);

  // 조회한 장바구니 목록을 저장할 state변수
  const [cartList, setCartList] = useState([]);
  
  // 선택한 체크박스 값을 저장할 state 변수
  // 모든 체크박스가 선택된 채로 화면에 나오려면 조회한 모든 cartNum이 초기값으로 세팅되어야 함.
  const [checkData, setCheckData] = useState([]);

  // 최종 구매 가격을 저장할 state 변수
  const [finalPrice, setFinalPrice] = useState(0);
  
  // 조회한 장바구니 목록의 모든 cartNum을 저장할 배열
  // arr 변수는 화면에 보여줄 데이터가 아니기 때문에 state 변수로 줄 필요가 없다.
  // 하지만, state 변수가 아니면 리렌더링 됐을 때 arr이 초기화되어버리는 문제가 발생
  // 1. 우리가 원하는 건 변수의 값이 초기화되지 않아야 한다. 
  // 2. 값이 변해도 리렌더링 할 필요는 없다.(화면에 보여줄 데이터가 아니므로) 
  // -> 이 두 조건을 만족하기 위해서는 useRef로 변수를 선언한다.
  // useRef를 사용하면 초기값이 current라는 키의 value로 저장된다.
  const arr = useRef([]); // arr ={current : []}
  
  // 조회한 장바구니 목록 전체 가격의 합을 저장할 변수
  const price = useRef(0);

  // 장바구니 목록을 조회할 useEffect
  useEffect(() => {
    // 로그인한 사용자 정보 받아오기
    const loginInfo = sessionStorage.getItem('loginInfo');
    
    // 장바구니 페이지를 들어왔는데 만약 로그인이 되어 있지 않으면
    // 강제로 상품 목록 페이지로 이동
    if(!loginInfo){
      nav('/');
      alert('접근 권한이 없습니다.');
      return;
    };
    // 로그인한 사용자 정보 객체화(JSON 데이터)
    const loginData = JSON.parse(loginInfo);

    axios.get(`/api/carts/${loginData.memId}`)
    .then(res => {
      setCartList(res.data);
      // 체크박스 초기값 세팅
      // 총 구매 가격 세팅
      // 장바구니 목록을 조회할 때마다 총 가격은 0으로 checkbox데이터는 빈 배열로 초기화 후 계산
      // useRef는 리렌더링 시에도 최근 값을 유지하기 때문이다.
      arr.current = [];
      price.current = 0;
      for(const e of res.data){
        arr.current.push(e.cartNum);
        price.current += e.totalPrice
      }
      setCheckData(arr.current);
      setFinalPrice(price.current);
    })
    .catch(e => console.log(e));
  }, [reload]);

  // 체크박스 값 변경 시 실행 함수
  const handleCheckbox = e => {
    // 체크가 됐다면...
    // cartNum을 숫자로 변환해서 저장
    if(e.target.checked){
      setCheckData([
        ...checkData
        , parseInt(e.target.value)
      ])
    }
    // 체크가 해제됐다면
    else{
      setCheckData(checkData.filter(cartNum => cartNum !== parseInt(e.target.value)))
    }
  }

  // 내용 줄의 체크박스가 변할 때, 총 구매 가격을 변경하는 함수
  const handleFinalPrice = (e, price) => {
    setFinalPrice(e.target.checked
      ? finalPrice + price 
      : finalPrice - price);
  }

  // 제목 줄의 체크박스가 변할 때, 총 구매 가격을 변경하는 함수
  const handleFinalPriceAtTitle = e => {
    setFinalPrice(e.target.checked ? price.current : 0)
  }

  // 장바구니 삭제
  const deleteCart = (cart) => {

    if(confirm('삭제하시겠습니까?')){
      axios.delete(`/api/carts/${cart.cartNum}`)
      .then(res => {
        alert('삭제되었습니다.');
        // reload 값이 바뀌면서 useEffect 안의 장바구니 목록 조회가 재실행
        setReload(reload + 1)
      })
      .catch(e => console.log(e));
    }
  }

  // 장바구니 수량 변경 함수
  const updateCart = (e, cart) => {
    axios.put(`/api/carts/${cart.cartNum}`, {
      cartCnt: e.target.value
      , bookNum: cart.bookNum
    })
    .then(
      setReload(reload + 1)
    )
    .catch(e => console.log(e));
  };

  // 선택 구매
  const buyAll = () => {
    axios.post(`/api/buys/all`, {
      memId: JSON.parse(sessionStorage.getItem('loginInfo')).memId
      , cartNumList: checkData
    })
    .then(res => {
      alert('구매완료')
      setReload(reload + 1)
    })
    .catch(e => console.log(e));
  }

  console.log(reload)
  return (
    <div className={styles.container}>
      <table className={styles.table}>
        <colgroup>
          <col width='3%' />
          <col width='3%' />
          <col width='34%' />
          <col width='10%' />
          <col width='20%' />
          <col width='10%' />
          <col width='10%' />
          <col width='10%' />
        </colgroup>
        <thead>
          <tr>
            <td>
              <input
                type="checkbox" 
                checked={arr.current.length === checkData.length} 
                onChange={e => {
                  // 전체 체크박스가 체크 -> 모든 체크박스 체크
                  // 전체 체크박스가 체크해제 -> 모든 체크박스 해제
                  e.target.checked ? setCheckData(arr.current) : setCheckData([]);
                  
                  // 제목 줄의 체크박스에 따라 총 구매 가격 변경
                  handleFinalPriceAtTitle(e)
                }}
              />
            </td>
            <td>No</td>
            <td>상품정보</td>
            <td>가격</td>
            <td>수량</td>
            <td>총 가격</td>
            <td>등록일</td>
            <td>삭제</td>
          </tr>
        </thead>
        <tbody>
          {
            cartList.length
            ?
            cartList.map((cart, i) => {
              return(
                <tr key={i}>
                  <td>
                    <input  
                      type="checkbox" 
                      checked={checkData.includes(cart.cartNum)}
                      value={cart.cartNum}
                      onChange={e => {
                        // 내용 줄의 체크여부를 결정
                        handleCheckbox(e);

                        // 내용 줄의 체크박스 체크여부에 따른 총 구매 가격 변경
                        handleFinalPrice(e, cart.totalPrice);
                      }}
                    />
                  </td>
                  <td>
                    <p>{cartList.length - i}</p>
                  </td>
                  <td>
                    <div className={styles.img_div}>
                      <div>
                        <img
                          src={`http://localhost:8080/upload/${cart.bookDTO.bookImgDTOList[0].attachedImgName}`} 
                        />
                      </div>
                      <p>{cart.bookDTO.title}</p>
                    </div>
                  </td>
                  <td>{cart.bookDTO.price.toLocaleString()}</td>
                  <td>
                    <div className={styles.cnt_div}>
                      {/* 
                        input 태그의 value와 onChange는 한 쌍이다.
                        정상 작동을 위해서는 value에 사용하는 데이터와
                        onChage에서 컨트롤하는 데이터는 동일해야 한다.
                        만약 value와 onChange에서 사용하는 데이터가 다르면
                        input 태그에 입력한 내용이 화면에 반영되지 않는다.

                        결론1. value와 onChange에 사용하는 데이터는 동일하게 사용하자
                        하지만 vale와 onChange의 코드를 작성하면 두 곳에서 사용하는
                        데이터가 다른 경우도 존재한다.
                        이럴 경우에는,
                        결론2. value대신 defaultValue를 사용한다.
                      */}
                      <Input 
                        type='number'
                        defaultValue={cart.cartCnt}
                        onChange={e => updateCart(e, cart)}
                        min='1'
                        onInput={e => {
                          // 키보드를 눌렀을 때 입력한 값이 숫자가 아니면 더 이상 이벤트를 진행하지 않겠다.

                          // 기본 이벤트를 막겠다.
                          e.preventDefault();
                        }}
                      />
                    </div>
                  </td>
                  <td>{cart.totalPrice.toLocaleString()}</td>
                  <td>{dayjs(cart.cartDate).format('YYYY.MM.DD HH:mm')}</td>
                  <td>
                    <Button 
                      title='삭 제'
                      color='gray' 
                      onClick={() => deleteCart(cart)}
                    />
                  </td>
                </tr>
              )
            })
            :
            <tr>
              <td 
                colSpan={8}
                style={{padding: '50px 0px'}}
              >장바구니에 담은 도서가 없습니다.</td>
            </tr>
          }
        </tbody>
      </table>
      <div className={styles.totalPrice}>
        <div>
          <div><p>구매가격</p></div>
          <div><p>{'￦' + finalPrice.toLocaleString()}</p></div>
        </div>
        <Button 
          size='200px'
          padding='10px 0px'
          fontSize='1.2rem'
          title='선택 구매'
          onClick={() => buyAll()}
        />
      </div>
    </div>
  )
}

export default CartList