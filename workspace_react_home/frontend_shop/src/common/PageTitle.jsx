import React from 'react'

const PageTitle = ({title='페이지 제목'}) => {
  return (
    <p
     style={{
      fontSize: '1.2rem'
      , fontWeight: '700'
      , borderBottom: '2px solid #cccccc'
      , width: '200px'
      , paddingBottom: '3px'
      , marginBottom: '20px'
      , fontStyle: 'italic'
     }}
    >{title}</p>
  )
}

export default PageTitle