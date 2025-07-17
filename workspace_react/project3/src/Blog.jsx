import { useState } from 'react'
import './Blog.css'

const Blog = () => {
  const [cnt,setCnt] = useState([0, 0, 0])
  const blogList = [
    {
      title: '제목1',
      btn: cnt[0],
      date: '25.7.17'
    },
    {
      title: '제목2',
      btn: cnt[1],
      date: '25.7.17'
    },
    {
      title: '제목2',
      btn: cnt[2],
      date: '25.7.17'
    }
  ]

  return (
    <div className="blog_container">
      <div>react blog</div>
      {
        blogList.map((e, i) => {
          return(
            <div key={i}>
              <div>{e.title} <button type='button' onClick={() => {
                const newCnt = [...cnt];
                newCnt[i]++;
                setCnt(newCnt)
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