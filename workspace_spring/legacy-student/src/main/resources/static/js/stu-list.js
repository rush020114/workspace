// 선택한 반 학생 목록 조회
const getStuList = () => {
  // select 태그를 선택
  const select = document.querySelector('#class-select');

  // select 태그에 선택한 option의 value
  console.log(select.value);

  location.href = `/getStuListAgain/${select.value}`;

}

// 선택한 반 학생 목록 조회(비동기)
const getStuList2 = () => {
  // select 태그를 선택
  const select = document.querySelector('#class-select');

  // select 태그에 선택한 option의 value
  console.log(select.value);

  // 선택한 반 학생 목록 조회
  axios.get(`/getStuListAgain2/${select.value}`)
  .then(res => {
    console.log(res.data)
    
    // 그림 다시 그리기
    const tbodyTag = document.querySelector('.list-table tbody');

    // 그릴 태그 작성
    let str = ``;
    for(let i = 0 ; i < res.data.length ; i++){
      str += `<tr>`;
      str += `<td>${i + 1}</td>`;

      str += `<td><span onclick="getDetail(${res.data[i].stuNum})">`;
      str += `${res.data[i].stuName}`;
      str += `</span></td>`;

      str += `<td>${res.data[i].stuAge}</td>`;
      str += `</tr>`;
    }

    // 선택한 태그 안의 내용을 수정
    tbodyTag.innerHTML = str;
  })
  .catch(e => console.log(e));
}

const getDetail = stuNum => {

  axios.get(`/getStuDetail/${stuNum}`)
  .then(res => {
    console.log(res.data);
    
    // 그림 그리기
    const divTag = document.querySelector('#detail-div');

    let str = ``;

    str += `<table border="1">`;
    str += `  <tr>`;
    str += `    <td>학번</td>`;
    str += `    <td>이름</td>`;
    str += `    <td>나이</td>`;
    str += `  </tr>`;
    str += `  <tr>`;
    str += `    <td>${res.data.stuNum}</td>`;
    str += `    <td>${res.data.stuName}</td>`;
    str += `    <td>${res.data.stuAge}</td>`;
    str += `  </tr>`;
    str += `</table>`;

    divTag.innerHTML = str;
  })
  .catch(e => console.log(e));
}