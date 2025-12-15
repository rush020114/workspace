import React, { useCallback, useState } from 'react'

const Child = ({onClick}) => {
  console.log('Child 렌더링됨');
  return <button onClick={onClick}>클릭</button>
}

const Parent = () => {
  const [count, setCount] = useState(0);
  const [name, setName] = useState('');

  // name이 바뀌어도 이 함수는 재생성이 안 됨.
  const handleClick = useCallback(() => {
    console.log("Count", count);

  }, [count]);

  return (
    <div>
      <Child onClick={handleClick} />
      <input value={name} onChange={e => setName(e.target.value)} /> 
      <button onClick={() => setCount(prev => prev + 1)}>
        Count: {count}
      </button>
    </div>
  )
}

export default Parent