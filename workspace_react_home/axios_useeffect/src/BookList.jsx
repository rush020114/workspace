
const BookList = ({bookList, setSelectedBook, setIsShow}) => {
  return(
    <div>
      <table>
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
                <tr 
                 key={i}
                 onClick={e => {
                  setSelectedBook(book)
                  setIsShow(true)
                 }}
                >
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

export default BookList;