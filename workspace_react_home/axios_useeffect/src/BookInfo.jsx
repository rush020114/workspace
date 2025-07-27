import { useEffect, useState } from "react"
import BookDetail from "./BookDetail"
import BookList from "./BookList"
import axios from "axios"


const BookInfo = () => {

  const [bookList, setBookList] = useState([])
  const [selectedBook, setSelectedBook] = useState({})
  const [isShow, setIsShow] = useState(false)

  useEffect(() => {
    axios.get('/api/books')
    .then(res => {
      console.log(res.data)
      setBookList(res.data)
    })
    .catch(error => console.log(error))
  }, [])

  return(
    <div>
      <BookList 
       bookList={bookList} 
       setSelectedBook={setSelectedBook}
       setIsShow={setIsShow}
      />
      {
        isShow
        ?
        <BookDetail 
         selectedBook={selectedBook}
        />
        :
        null
      }
    </div>
  )
}

export default BookInfo