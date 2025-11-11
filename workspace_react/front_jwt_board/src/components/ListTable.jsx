import React from 'react'
import styles from './ListTable.module.css'

const ListTable = ({cols=[], dataList=[], dataName=[]}) => {
  
  return (
    <table className={styles.list_table}>
      <thead>
        <tr>
          <td>No</td>
          {
            cols.map((e, i) => <td key={i}>{e}</td>)
          }
        </tr>
      </thead>
      <tbody>
          {
            !dataList.length ?
            <tr>
              <td colSpan={cols.length}>조회된 데이터가 없습니다.</td>
            </tr> :
            dataList.map((data, rowIndex) => {
              return(
                <tr key={rowIndex}>
                  <td>
                    {dataList.length - rowIndex}
                  </td>
                  {
                    dataName.map((name, colIndex) => {
                      return(
                        <td key={colIndex}>
                          {data[name]}
                        </td>
                      )
                    })
                  }
                </tr>
              )
            })
          }
      </tbody>
    </table>
  )
}

export default ListTable