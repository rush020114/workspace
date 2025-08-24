import React, { useEffect, useState } from 'react'
import styles from './ClothingList.module.css'
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const ClothingList = () => {
  
  const nav = useNavigate();

  // 옷 목록 조회를 저장할 state 변수
  const [clothingList, setClothingList] = useState([]);

  // 옷 목록 조회를 세팅할 useEffect
  useEffect(() => {
    axios.get('/api/clothes')
    .then(res => setClothingList(res.data))
    .catch(e => console.log(e));
  }, []);

  return (
    <div className={styles.container}>
      <div className={styles.content}>
        {
          clothingList.map((clothing, i) => {
            return(
              <div key={i} className={styles.list_div}>
                <div className={styles.img_div}>
                  <img src="./이글아이 워리어아머.png" 
                    onClick={() => nav(`/clothing-detail/${clothing.clothingNum}`)}
                  />
                </div>
                <div className={styles.info}>
                  <p>{clothing.clothingName}</p>
                  <p>{clothing.price}</p>
                </div>
              </div>
            )
          } )
        }
      </div>
    </div>
  )
}

export default ClothingList