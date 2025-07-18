import React from 'react'

const Footer = (props) => {
  console.log(`cnt = ${props.cnt}`);


  return (
    <>
      <div>{props.cnt}</div>
      <button type='button' onClick={() => {props.setCnt(props.cnt + 1)}}>Footer 버튼</button>
    </>
  )
}

export default Footer