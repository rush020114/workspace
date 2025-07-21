import { useEffect, useState } from "react"
import BookDetail from "./BookDetail"
import BookList from "./BookList"
import axios from "axios"

const BookInfo = () => {

  const [bookList, setBookList] = useState([])
  const [selectedBook, setSelectedBook] = useState({})
  const [isShow, setIsShow] = useState(false)

  console.log(bookList)
  console.log(selectedBook)
  console.log(isShow)

  useEffect(() => {
    axios.get('/api/books')
    .then(res => {
      console.log(res.data)
      setBookList(res.data)
    })
    .catch(error => console.log(error))
  }, [])

  return(
    <>
      <BookList bookList={bookList} setSelectedBook={setSelectedBook} setIsShow={setIsShow} />
      {
        isShow
        ?
        <BookDetail selectedBook={selectedBook} />
        :
        null
      }
    </>
  )
}

export default BookInfo