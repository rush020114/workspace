import React from 'react'

const Calculator = () => {
  const [number, setNumber] = useState(0);
  const [dark, setDark] = useState(false);

  // number가 바뀔 때만 계산, dark가 바뀌어도 재계산 안함
  const expensiveResult = useMemo(() => {
    console.log('계산 중...');
    return number * number;
  }, [number]);

  return (
    <div>
      <input 
        value={number} 
        onChange={(e) => setNumber(e.target.value)} 
      />
      <p>결과: {expensiveResult}</p>
      <button onClick={() => setDark(!dark)}>테마 변경</button>
    </div>
  );
}

export default Calculator