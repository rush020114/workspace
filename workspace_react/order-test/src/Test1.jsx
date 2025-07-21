import axios from "axios"

const Test1 = () => {

  axios.get('/api/orders')
  .then((res) => {
    console.log(res.data)
  })
  .catch(err => console.log(err))

  return(
    <div>test1</div>
  )
}

export default Test1