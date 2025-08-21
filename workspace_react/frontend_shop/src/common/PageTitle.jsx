import React from 'react'

const PageTitle = ({title='페이지제목', fontSize='1.2rem'}) => {
  return (
    <p
      style={{
        fontStyle: 'italic'
        , width: '200px'
        , fontSize: fontSize
        , fontWeight:'700'
        , borderBottom: '2px solid #cccccc'
        , paddingBottom:'3px'
        , marginBottom:'20px'
      }}
    >{title}</p>
  )
}

export default PageTitle