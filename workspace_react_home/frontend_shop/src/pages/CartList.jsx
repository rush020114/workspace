  import React, { useEffect, useRef, useState } from 'react'
  import styles from './CartList.module.css'
  import axios from 'axios';
  import Button from '../common/Button';
  import Input from '../common/Input';
  import dayjs from 'dayjs';
import { useNavigate } from 'react-router-dom';

  const CartList = () => {

    const nav = useNavigate();

    // axios실행 시 리렌더링 시켜주기 위한 state 변수
    const [reload, setReload] = useState(0);

    // 장바구니 목록 조회를 저장할 state변수
    const [cartList, setCartList] = useState([]);
    
    // 체크박스 데이터를 저장할 state 변수
    // 체크 박스는 중복을 허용하므로 배열이 적합하다.
    const [checkboxesData, setCheckboxesData] = useState([]);

    // 최종 금액을 받아올 state 변수
    // 최종 금액은 화면에 반영할 것이고 값이 유기적으로 변하기에 useState가 적합.
    const [finalPrice, setFinalPrice] = useState(0);

    // 전체 체크박스를 저장할 useRef
    // 등록할 체크박스의 배열 데이터는 유기적으로 변하기 때문에
    // 전체 체크박스를 체크할 때의 조건을 사용하기에 적합하지 않다.
    // 그러므로 고정된 전체 체크박스 value배열이 필요하다.
    // 하지만 이 값은 화면에 반영할 것도 아니기 때문에 값이 변경되어도 리렌더링(리렌더링은 많이 할수록 성능 저하) 시킬 필요 없다.
    // 그렇지만 일반 변수를 주기에는 리렌더링 시 값이 초기화되게 되는 문제가 발생한다.
    // 이 두 문제를 해결할 수 있는 hook이 useRef이다.
    // useRef의 매개변수에 초기값을 설정하면 객체를 반환하는데 키는 current(정해진 이름)이고 value는 초기로 준 값이다.
    // 이를 이용하면 리렌더링 시 최근 값을 계속 유지할 수 있다.
    const allCheckboxes = useRef([]);
    
    // 제목 체크박스 선택 시 사용할 최종금액을 저장할 useRef
    // 최종금액은 checkbox체크 여부에 따라 영향을 받기 때문에
    // 전체 체크박스 클릭 시에도 영향을 받는다. 
    // 이때 체크박스가 전체 클릭됐을 때 finalPrice 변수 역시 유기적으로 변하기 때문에 사용할 수 없다.
    // 그래서 useRef 훅을 쓴다.
    const price = useRef(0);
    
    // 장바구니 목록을 받아올 useEffect
    useEffect(() => {

      // 로그아웃을 위한 session저장공간 데이터 불러오는 변수
      const loginInfo = sessionStorage.getItem('loginInfo');
      
      if(!loginInfo){
        alert('접근 권한이 없습니다.');  
        nav('/')
        return;
      };

      // 저장된 로그인 정보의 객체화
      const loginData = JSON.parse(loginInfo);
      axios.get(`/api/carts/${loginData.memId}`)
      .then(res => {
        setCartList(res.data);
        // reload로 인해 다시 조회될 때 useRef 특성 상 리렌더링되어도 
        // 기존의 값을 유지하기 때문에 다시 조회 시 제거되거나 수정된 값을 정확히 반영할 수 없다.
        // 데이터 변형되기 전 값과 데이터 변형된 후의 값을 함께 계산하기 때문이다.
        // 그래서 변형된 값을 올바르게 반영하기 위해 화면이 마운트될 때의 초기값으로 주는 것이 적절하다.
        allCheckboxes.current = [];
        price.current = 0;
        for(const checkbox of res.data){
          allCheckboxes.current.push(checkbox.cartNum);
          price.current += checkbox.totalPrice;
        }
        setCheckboxesData(allCheckboxes.current)
        setFinalPrice(price.current);
      })
      .catch(e => console.log(e));
      // 데이터 변형 시 화면을 다시 반영시키기 위한 의존성 배열 추가
    }, [reload]);

    // 체크박스 값 변경 시 실행 함수
    const handleCheckboxes = e => {
      if(e.target.checked){
        setCheckboxesData([
          ...checkboxesData
          , parseInt(e.target.value)
        ])
      }
      else{
        setCheckboxesData(
          checkboxesData.filter(checkbox => checkbox !== parseInt(e.target.value))
        )
      }
    }

    // 개별 체크박스로 최종금액을 세팅할 함수
    const handleFinalPrice = (e, cart) => {
      // 전체를 체크하는 체크박스의 체크박스 체크여부가 결정된다면
      e.target.name === 'checkAll'
      ?
      // 최종가격을 체크박스가 체크될 시 각 바구니 가격 총합을 세팅 해제되면 0원을 세팅
      setFinalPrice(e.target.checked ? price.current : 0)
      // 장바구니 개별 체크박스의 체크여부가 결정된다면
      :
      // 한 개의 체크박스가 체크될 시 그 만큼 가격을 올리고 해제되면 그만큼 가격을 내린다.
      setFinalPrice(e.target.checked ? finalPrice + cart.totalPrice : finalPrice - cart.totalPrice)
    }

    // 장바구니 삭제 함수
    const deleteCart = cart => {
      confirm('삭제하시겠습니까?')
      &&
      axios.delete(`/api/carts/${cart.cartNum}`)
      // 삭제된 화면 반영
      .then(res => setReload(reload + 1))
      .catch(e => console.log(e));
    };

    // 장바구니 수량 수정
    const updateCart = (e, cart) => {
      axios.put(`/api/carts/${cart.cartNum}`, {
        cartCnt: e.target.value
        , bookNum: cart.bookNum
      })
      .then(res => setReload(reload + 1))
      .catch(e => console.log(e));
    };

    // 장바구니 구매
    const buyCartBook = () => {
      axios.post('/api/buys/carts', {
        memId: JSON.parse(sessionStorage.getItem('loginInfo')).memId
        , cartNumList: checkboxesData
      })
      .then(res => {
        setReload(reload + 1);
        alert('구매완료');
      })
      .catch(e => console.log(e));
    };

    console.log(reload)

    return (
      <div className={styles.container}>
        <table className={styles.table}>
          <colgroup>
            <col width='4%' />
            <col width='4%' />
            <col width='32%' />
            <col width='10%' />
            <col width='20%' />
            <col width='10%' />
            <col width='12%' />
            <col width='8%' />
          </colgroup>
          <thead>
            <tr>
              <td>
                <input
                  type="checkbox" 
                  name='checkAll'
                  checked={allCheckboxes.current.length === checkboxesData.length}
                  onChange={e => {
                    // 전체 체크박스 체크된다면 모든 체크박스 체크 아니면 빈 배열을 주어 checked의 조건이 틀리게 만듦
                    setCheckboxesData(e.target.checked ? allCheckboxes.current : [])
                    handleFinalPrice(e)
                  }}
                />
              </td>
              <td>No</td>
              <td>상품명</td>
              <td>가격</td>
              <td>수량</td>
              <td>총가격</td>
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
                        // checkbox의 value도 하나하나씩 구별할 수 있는 데이터를 넣어주어야 한다.
                        // 장바구니를 하나하나 구분지을 수 있는 것은 pk가 적합하다.
                        // value를 나중에 등록 데이터로 사용할 것이니 pk를 쓰면 구별이 된다.
                        type="checkbox" 
                        name='checkSingle'
                        value={cart.cartNum}
                        checked={checkboxesData.includes(cart.cartNum)}
                        onChange={e => {
                          // 체크박스 체크 여부 결정 함수
                          handleCheckboxes(e);
                          handleFinalPrice(e, cart);
                        }}
                      />
                    </td>
                    <td>{cartList.length - i}</td>
                    <td>
                      <div className={styles.img_div}>
                        <div>
                          <img src={`http://localhost:8080/upload/${cart.bookDTO.bookImgDTOList[0].attachedImgName}`} />
                        </div>
                        <p>{cart.bookDTO.title}</p>
                      </div>
                    </td>
                    <td>{cart && parseInt(cart.bookDTO.price).toLocaleString()}</td>
                    <td>
                      <div className={styles.cnt_div}>
                        <Input 
                          type='number'
                          min={1}
                          // 원래 value와 onChange는 한쌍이다. 그리고 그 때의 데이터는 동일하게 다루어졌다.
                          // ex) useState 변경 함수로 value의 값을 변형
                          // 하지만 간혹 onChange로 value데이터를 변경시키지 못하는 상황이 발생한다.
                          // 그래서 폼요소의 값이 변형되지 않는 상황이 발생하는데 이를 지키지 않고
                          // 스프링으로 넘긴 데이터로 화면에 폼요소의 값을 바꾸는 코딩은 순서가 잘못된 코딩이다.
                          // 이런 잘못될 상황을 막기 위해 defaultValue를 사용하는데 이 속성은 onChange없이도 값이 바뀐다.
                          // 그렇다고 이 속성을 남용하면 데이터를 관리할 수 없는 상황이 발생하기 때문에 기존의 방식을 지키는 것이 적절하다.
                          defaultValue={cart.cartCnt}
                          onChange={e => updateCart(e, cart)}
                        />
                      </div>
                    </td>
                    <td>{cart && parseInt(cart.totalPrice).toLocaleString()}</td>
                    <td>{dayjs(cart.cartDate).format('YYYY.MM.DD HH:mm')}</td>
                    <td>
                      <Button 
                        title='삭 제' 
                        size='60px'
                        color='gray'
                        onClick={e => deleteCart(cart)}
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
                >장바구니 목록이 없습니다.</td>
              </tr>
            }
          </tbody>
        </table>
        <div className={styles.totalPrice}>
          <div>
            <div><p>구매가격</p></div>
            <div><p>{finalPrice.toLocaleString()}</p></div>
          </div>
          <Button 
            size='200px'
            padding='10px 0px'
            fontSize='1.2rem'
            title='선택 구매'
            onClick={() => buyCartBook()}
          />
        </div>
      </div>
    )
  }

  export default CartList