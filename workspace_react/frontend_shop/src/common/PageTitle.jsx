import React from 'react'

const PageTitle = ({title='페이지제목'}) => {
  return (
    <p
      style={{
        fontStyle: 'italic'
        , width: '200px'
        , fontSize:'1.2rem'
        , fontWeight:'700'
        , borderBottom: '2px solid #cccccc'
        , paddingBottom:'3px'
        , marginBottom:'20px'
      }}
    >{title}</p>
  )
}

export default PageTitle