import React, { useEffect, useState } from 'react'
import styles from './AdminHome.module.css'
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  PointElement,
  LineElement,
  Title,
  Tooltip,
  Legend,
} from 'chart.js';
import { Line } from 'react-chartjs-2';
import axios from 'axios';

ChartJS.register(
  CategoryScale,
  LinearScale,
  PointElement,
  LineElement,
  Title,
  Tooltip,
  Legend
);

const AdminHome = () => {

  const options = {
    responsive: true,
    plugins: {
      legend: {
        position: 'top',
      },
      title: {
        display: true,
        text: 'Chart.js Line Chart',
      },
    },
  };

  // 10일 날짜를 표현할 값을 저장할 state 변수
  const [labels, setLabels] = useState([]);

  // 10일 매출을 표현할 값을 저장할 state 변수
  const [salesData, setSalesData] = useState([]);
  
  // 10일 날짜를 조회할 useEffect
  useEffect(() => {
    axios.get('/api/buys/date-10-day')
    .then(res => setLabels(res.data))
    .catch(e => console.log(e))
  }, []);
  
  // 10일 매출을 조회할 useEffect
  useEffect(() => {
    axios.get('/api/buys/sales-10-day')
    .then(res => setSalesData(res.data))
    .catch(e => console.log(e))
  }, []);

  console.log(labels)

  const data = {
    labels,
    datasets: [
      {
        label: 'Dataset 1',
        data: salesData,
        borderColor: 'rgb(255, 99, 132)',
        backgroundColor: 'rgba(255, 99, 132, 0.5)',
      },
    ],
  };

  return (
    <div className={styles.container}>
      <div className={styles.first_row}>
        <div>오늘의 매출</div>
        <div>전체 매출</div>
        <div>오늘의 방문자 수</div>
        <div>이번달 방문자 수</div>
      </div>
      <div className={styles.second_row}>
        <Line 
          options={options}
          data={data}
        />
      </div>
    </div>
  )
}

export default AdminHome