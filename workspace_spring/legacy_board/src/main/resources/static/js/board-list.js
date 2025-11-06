// 글쓰기 이동
const goWriteForm =  () => {
  // 페이지 이동 코드
  location.href = '/boards/write-form';
}

// 상세 페이지 이동
const goDetail = boardNum => {
  location.href = `/boards/detail/${boardNum}`
}
