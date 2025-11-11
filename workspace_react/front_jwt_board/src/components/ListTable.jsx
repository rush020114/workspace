import React from 'react'
import styles from './ListTable.module.css'
import { useNavigate } from 'react-router-dom'

const ListTable = ({cols=[], dataList=[], dataName=[], link, indexName}) => {
  const nav = useNavigate();
  
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
                <tr 
                  key={rowIndex}
                  onClick={() => nav(`${link}/${data[indexName]}`)}
                >
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