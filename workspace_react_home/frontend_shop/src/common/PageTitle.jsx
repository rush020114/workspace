import React from 'react'

const PageTitle = ({
  title='페이지 제목'
  , fontSize='1.2rem'
  , size='200px'
}) => {
  return (
    <p
     style={{
      fontSize: fontSize
      , fontWeight: '700'
      , borderBottom: '2px solid #cccccc'
      , width: size
      , paddingBottom: '3px'
      , marginBottom: '20px'
      , fontStyle: 'italic'
     }}
    >{title}</p>
  )
}

export default PageTitle