import { Link } from 'react-router-dom'
import './Header.css'

const Header = () => {
  return(
    <div className="header-container">
      <div className='profile'>
        <span>
          <Link to={'/join'}>Join</Link>
        </span>
        <span>
          <Link to={'/login'}>Login</Link> 
        </span>
      </div>
      <div className='title'>P R O J E C T</div>
    </div>
  )
}

export default Header