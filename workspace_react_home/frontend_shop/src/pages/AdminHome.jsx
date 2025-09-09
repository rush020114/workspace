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

// 10일 간의 날짜 조회를 저장할 state변수
const [labels, setLabel] = useState([]);

// 10일 간의 매출 조회를 저장할 state변수
const [salesData, setSalesData] = useState([]);

// 10일 간의 날짜를 조회할 useEffect
useEffect(() => {
  axios.all([axios.get('/api/buys/date-10-day'), axios.get('/api/buys/sales-10-day')])
  .then(axios.spread((res1, res2) => {
    setLabel(res1.data);
    setSalesData(res2.data);
  }))
  .catch(e => console.log(e));
}, []);

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
        <div>a</div>
        <div>b</div>
        <div>c</div>
        <div>d</div>
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