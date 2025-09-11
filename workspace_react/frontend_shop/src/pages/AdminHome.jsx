import React, { useEffect, useRef, useState } from 'react';
import styles from './AdminHome.module.css';
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  PointElement,
  LineElement,
  Title,
  Tooltip,
  Legend,
  Filler, // ✅ Filler 꼭 추가해야 fill이 적용됨
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
  Legend,
  Filler // ✅ 등록
);

const AdminHome = () => {
  const chartRef = useRef(null);

  const [labels, setLabels] = useState([]);
  const [salesData, setSalesData] = useState([]);
  const [gradient, setGradient] = useState(null);

  // 날짜 데이터 불러오기
  useEffect(() => {
    axios.get('/api/buys/date-10-day')
      .then(res => setLabels(res.data))
      .catch(e => console.error(e));
  }, []);

  // 매출 데이터 불러오기
  useEffect(() => {
    axios.get('/api/buys/sales-10-day')
      .then(res => setSalesData(res.data))
      .catch(e => console.error(e));
  }, []);

  // gradient 설정
  useEffect(() => {
    const chart = chartRef.current;

    if (!chart) return;

    const { ctx, chartArea } = chart;

    // chartArea는 초기 렌더링 시 undefined일 수 있으므로 update 호출
    if (!chartArea) {
      setTimeout(() => {
        chart.update();
      }, 200);
      return;
    }

    const grad = ctx.createLinearGradient(0, chartArea.top, 0, chartArea.bottom);
    grad.addColorStop(0, 'rgba(75,192,192,0.4)');
    grad.addColorStop(1, 'rgba(75,192,192,0)');
    setGradient(grad);
  }, [labels, salesData]); // ✅ 데이터가 다 들어왔을 때만 실행

  const data = {
    labels,
    datasets: [
      {
        label: '매출',
        data: salesData,
        fill: true,
        backgroundColor: gradient || 'rgba(0,0,0,0)', // 초기 렌더링 보호
        borderColor: 'rgba(75,192,192,1)',
        tension: 0.4,
      },
    ],
  };

  const options = {
    responsive: true,
    maintainAspectRatio: false,
    plugins: {
      legend: {
        position: 'top',
      },
      title: {
        display: true,
        text: '최근 10일 매출',
      },
    },
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
          ref={chartRef}
          data={data}
          options={options}
        />
      </div>
    </div>
  );
};

export default AdminHome;
