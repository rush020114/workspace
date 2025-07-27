
const BookDetail = ({selectedBook}) => {
  return(
    <div>
      <table>
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
          <tr>
            <td>도서소개</td>
            <td colSpan={3}>{selectedBook.info}</td>
          </tr>
        </tbody>
      </table>
    </div>
  )
}

export default BookDetail;