import React, { useEffect, useState } from 'react'
import image1 from './assets/images/edit.png'
import image2 from './assets/images/delete.png'
import styles from './To_do_list.module.css'

const To_do_list = () => {

  // 할 일 목록 리스트 state변수
  const [toDoList, setToDoList] = useState([]);

  // id를 변경할 state변수
  const [id, setId] = useState(1);

  // 할 일 목록 state 변수
  const [toDo, setToDo] = useState({
    id: id
    , txt: ""
    , isShow: false
  });

  // 할 일 목록의 값을 세팅하는 함수
  const handleToDo = e => {
    setToDo({
      ...toDo
      , txt: e.target.value
    })
  }

  // 할 일을 등록해주는 함수
  const addToDo = () => {
    if(toDo.txt === ''){
      alert('할 일을 입력해주세요.')
      return;
    }
    setId(id + 1)
    const newToDoList = [...toDoList]
    newToDoList.unshift(toDo)
    setToDoList(newToDoList)
  }

  // id의 값을 변경시켜 줄 useEffect
  useEffect(() => {
    if(id === 1){
      return;
    }
    setToDo({
      ...toDo
      , id: id
    })
  }, [id])

  // 할 일을 삭제해주는 함수
  const deleteToDo = i => {
    if(!confirm('삭제하시겠습니까?')){
      return;
    }
    const newToDoList = [...toDoList]
    newToDoList.splice(i, 1)
    setToDoList(newToDoList)
  }

  // 할 일을 수정해주는 함수
  const updateToDo = i => {
    const newToDoList = [...toDoList]
    newToDoList[i].isShow = false
    setToDoList(newToDoList)
  }

  console.log(toDo)
  console.log(toDoList)

  return (
    <div className={styles.container}>
      <h1 className={styles.title}>To Do List</h1>
      <div className={styles.content}>
        <div className={styles.add}>
          <input
           type="text" 
           placeholder='+Add a Task'
           value={toDo.txt}
           onChange={e => handleToDo(e)}
          />
          <button
           type='button'
           onClick={e => addToDo()}
          >등록</button>
        </div>
        <div className={styles.to_do}>
           {
             toDoList.map((e, i) => {
               return(
                <div key={i}>
                  {e.isShow ? <input type="text" /> : <div>{e.txt}</div>}
                  <div>
                    <div>
                      {
                        e.isShow ?
                        <button type='button'>확인</button>
                        :
                        <img 
                        src={image1}
                        onClick={e => updateToDo(i)} 
                        />
                      }
                    </div>
                    <div>
                       {
                        e.isShow ?
                        <button type='button'>취소</button>
                        :
                        <img 
                        src={image2}
                        onClick={e => deleteToDo(i)} 
                        />
                       }
                    </div>
                  </div>
                </div>
               )
             })
           }
        </div>
      </div>
    </div>
  )
}

export default To_do_list