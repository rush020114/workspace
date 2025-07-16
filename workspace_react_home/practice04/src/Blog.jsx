import { useState } from 'react'
import './Blog.css'

const Blog = () => {
  const [cnt, setCnt] = useState([0, 0, 0]); // 각 버튼을 클릭 시 각 버튼 하나만 수를 바꾸기 위한 useState문법
  const blogList = [
    {
      title: '남자코드 추천',
      btn: cnt[0], // 구조분해 할당으로 저장된 배열의 0번째 요소 저장
      date: '2월 17일 발행'
    },
    {
      title: '강남우동 맛집',
      btn: cnt[1],
      date: '2월 17일 발행'
    },
    {
      title: '파이썬 독학',
      btn: cnt[2],
      date: '2월 17일 발행'
    }
  ]


  return(
    <div className="blog_container">
      <div>ReactBlog</div>
      {
        blogList.map((e, i) => {
          return(
            <div key={i}>
              <div>{e.title} <button type='button' onClick={() => {
                // 첫번째 버튼을 클릭하면 0번째 인덱스의 div가 실행되며 state변경 함수의 실행 조건을 충족시키기 위해
                // 데이터는 그대로지만 배열 주소는 새롭게 하는 문법을 사용하여 새로운 배열에 저장시킨다.
                const newCnt = [...cnt]; 
                newCnt[i]++; // 첫번째 버튼을 클릭했다면 0번째 인덱스인 값이 활성화되므로 배열의 0번째 요소값만 바뀜
                setCnt(newCnt) // state변경 함수에는 변하는 값 자체만 넣는다.
              }}>{e.btn}</button></div>
              <div>{e.date}</div>
            </div>
          )
        })
      }
    </div>
  )
}

export default Blog