import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'

// main.jsx를 읽으며 이 코드를 읽게 된다.
// 이 코드의 해석은 root라는 아이디를 찾아서 그림을 그리겠다는 뜻이다.
createRoot(document.getElementById('root')).render(
  <StrictMode>
    <App /> {/* 그런데 그 태그에 앱 컴포넌트를 그리겠다는 뜻이다 */}
  </StrictMode>,
)
