const Content = () => {
  return (
    <>
    <hr />
      <ul style={{listStyle: 'none', paddingLeft: '0px', display: 'flex', flexDirection: 'column', gap: '20px'}}>
        <li>
          <b>개인정보</b>
          <ul style={{listStyle: 'none', marginTop: '20px'}}>
            <li>
              이름
              <input type="text" placeholder="공백없이 입력하세요."/>
            </li>
            <li>
              연락처
              <input type="text" />
            </li>
          </ul>
        </li>
        <li>
          <b>지원 분야</b>
          <ul style={{listStyle: 'none', marginTop: '20px'}}>
            <li>
              <input type="radio" name="dev"/>
              웹퍼블리싱
            </li>
            <li>
              <input type="radio" name="dev"/>
              웹 프론트앤드
            </li>
            <li>
              <input type="radio" name="dev"/>
              모바일 앱
            </li>
          </ul>
        </li>
        <li>
          <b>지원동기</b> <br />
         <textarea rows={4} style={{width: '100%', marginTop: '20px'}}></textarea>
        </li>
      </ul>
    </>
  )
}

export default Content;