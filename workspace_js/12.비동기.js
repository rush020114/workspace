  const [num, setNum] = useState(5);

  // 비동기 : 앞의 코드가 끝날 때까지 기다리지 않는다.
  // 리렌더링할 것이 두 개 이상되면 그림을 다 그리고 리렌더링한다.
  // 코드가 실행되자마자 다음 코드를 실행하기에
  // 두 state변수는 전부 값이 5에서 5를 더하게 된다. 
  useEffect(() => {
    setNum(num + 5);
    setNum(num + 5);
  }, []);

  console.log(`num = ${num}`)