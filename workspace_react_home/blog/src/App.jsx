import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Modal from './Modal';

function App() {
  
  const [title, setTitle] = useState(['남자코트 추천','강남 우동 맛집', '파이썬독학']);
  const [goodCnt, setGoodCnt] = useState([0,0,0]);
  const [modal, setModal] = useState(false);
  const [selectedTitle, setSelectedTitle] = useState('');
  const [insertValue, setInsertValue] = useState('');

  console.log(title)

  console.log(title);
  return (
    <div className='app'>
      <div className='black-nav'>
        <h4>ReactBlog</h4>
      </div>

      {
        title.map((e, i) => {
          return(
            <div className='list' key={i}>
              <h4 onClick={() => {
                setModal(true)
                setSelectedTitle(e)
              }}>{e} <span onClick={e => {
                  e.stopPropagation()
                  const newGoodCnt = [...goodCnt]
                  newGoodCnt[i]++;
                  setGoodCnt(newGoodCnt)
                }}>👍</span> {goodCnt[i]}</h4>
              <p>2월 17일 발행</p>
              <div>
                <button type='butto' onClick={e => {
                  const copy = [...title]
                  copy.splice(i, 1)
                  setTitle(copy)
                  const newGoodCnt = [...goodCnt]
                  newGoodCnt.splice(i, 1)
                  setGoodCnt(newGoodCnt)
                }}>삭제</button>
              </div>
            </div>
          )
        })
      }

      <input type="text" value={insertValue} onChange={e => setInsertValue(e.target.value)} />
      <button type='button' onClick={e => {
          const copy = [...title]
          copy.unshift(insertValue)
          setTitle(copy)
          const newGoodCnt = [...goodCnt]
          newGoodCnt.unshift(0)
          setGoodCnt(newGoodCnt)
        }}>등록</button>
    
      {
        modal
        ?
        <Modal selectedTitle={selectedTitle}/>
        :
        null
      }

    </div>
  )
}

export default App
