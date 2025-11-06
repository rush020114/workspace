const goWriteForm =  () => {
  // 페이지 이동 코드
  location.href = '/boards/write-form';
}

const goDetail = boardNum => {
  location.href = `/boards/detail/${boardNum}`
}