import axios from "axios"
import { useEffect, useState } from "react";

const Axios_2 = () => {
  const [javaData, setJavaDate] = useState(''); // useState를 이용하는 이유는 나중에 바뀐 데이터를 화면에 반영시키기 위함이다.

  useEffect(() => { // useEffect로 바뀐 객체 때문에 계속 리렌더링 되는 현상을 막을 수 있다.
    // 자바의 데이터 조회
    axios.get('/api/getStr') // spring 서버에 접근하는 주소
    .then((res) => { // res매개변수엔 모든 통신 성공 결과가 들어간다.
      console.log(res.data);
      setJavaDate(res.data); // spring으로부터 들어온 데이터가 javaData를 변형시키며 리렌더링
    })
    .catch((error) => console.log(error));
  }, []);

  

  return (
    <div>{javaData}</div>
  )
}

export default Axios_2