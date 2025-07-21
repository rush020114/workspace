import React from 'react'
import './BookList.css'

const BookList = ({bookList, setSelectedBook, setIsShow}) => {

  return (
    <div className='list-container'>
      <h1>도 서 목 록</h1>
      <table className='list-table'>
        <colgroup>
          <col width='*' />
          <col width='17%' />
          <col width='35%' />
          <col width='20%' />
          <col width='20%' />
        </colgroup>
        <thead>
          <tr>
            <td>No</td>
            <td>도서번호</td>
            <td>도서명</td>
            <td>저자</td>
            <td>도서가격</td>
          </tr>
        </thead>
        <tbody>
          {
            bookList.map((book, i) => {
              return(
                <tr key={i} onClick={() => {
                  setSelectedBook(book)
                  setIsShow(true)
                  }}>
                  <td>{bookList.length - i}</td>
                  <td>{book.bookNum}</td>
                  <td>{book.title}</td>
                  <td>{book.writer}</td>
                  <td>{book.price}원</td>
                </tr>
              )
            })
          }
        </tbody>
      </table>
    </div>
  )
}

export default BookList