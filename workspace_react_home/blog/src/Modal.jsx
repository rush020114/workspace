
const Modal = ({selectedTitle}) => {
  return(
    <div className='modal'>
      <h4>{selectedTitle}</h4>
      <p>날짜</p>
      <p>상세내용</p>
      <button type="button">글수정</button>
    </div>
  )
}

export default Modal