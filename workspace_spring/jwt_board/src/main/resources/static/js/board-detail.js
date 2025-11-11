// 삭제 페이지 이동
const goDelete = boardNum => {
  const result = confirm('게시글을 삭제할까요?');
  if(result) location.href = `/boards/delete/${boardNum}`
}

// 목록 페이지 이동
const goList =  () => {
  // 웹 브라우저의 뒤로 가기 버튼과 같은 역할
  location.href = '/boards'
}

// 수정 페이지 이동
const goUpdate = boardNum => {
  location.href = `/boards/update/${boardNum}`
}