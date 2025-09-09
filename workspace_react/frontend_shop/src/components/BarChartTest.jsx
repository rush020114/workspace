import React from 'react'
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend,
} from 'chart.js';
import { Bar } from 'react-chartjs-2'
ChartJS.register(
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend
);

const BarChartTest = () => {

  const options = {
  responsive: true,
  plugins: {
    legend: {
      position: 'bottom',
    },
    title: {
      display: true,
      text: '데이터',
    },
  },
};

const labels = ['1월', '2월', '3월', '4월', '5월', '6월', '7월'];

const data = {
  // 원래 형태 : labels : labels
  labels,
  datasets: [
    {
      label: '1번 데이터',
      data: [160, 120, 876, 200, 452, 215, 23],
      backgroundColor: 'rgba(255, 99, 132, 0.5)',
    },
    {
      label: '2번 데이터',
      data: [360, 790, 186, 222, 52, 915, 123],
      backgroundColor: 'rgba(53, 162, 235, 0.5)',
    },
    {
      label: '3번 데이터',
      data: [763, 20, 561, 922, 352, 635, 523],
      backgroundColor: 'rgba(255, 195, 67, 0.5)',
    },
  ],
};

  return (
    <div>
      <Bar 
        options={options}
        data={data}
      />
    </div>
  )
}

export default BarChartTest