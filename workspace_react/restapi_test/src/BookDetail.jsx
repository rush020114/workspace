import React from 'react'
import './BookDetail.css'

const BookDetail = ({selectedBook}) => {
  return (
    <div className='detail-container'>
      <h1>도서 상세 정보</h1>
      <table className='detail-table'>
        <colgroup>
          <col width='25%' />
          <col width='25%' />
          <col width='25%' />
          <col width='25%' />
        </colgroup>
        <tbody>
          <tr>
            <td>도서번호</td>
            <td>{selectedBook.bookNum}</td>
            <td>도서명</td>
            <td>{selectedBook.title}</td>
          </tr>
          <tr>
            <td>저자</td>
            <td>{selectedBook.writer}</td>
            <td>가격</td>
            <td>{selectedBook.price}원</td>
          </tr>
          <tr className='summary-tr'>
            <td >도서소개</td>
            <td colSpan={3} >{selectedBook.summary}</td>
          </tr>
        </tbody>
      </table>
    </div>
  )
}

export default BookDetail