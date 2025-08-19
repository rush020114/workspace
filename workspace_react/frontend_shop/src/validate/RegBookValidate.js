// 유효성 검사 결과 에러 메시지를 결정하는 함수
export const handleRegBookErrorMsg = (e) => {
  let errorStr = ''

  switch(e.target.name){
    case 'cateNum':
      if(e.target.value === '0'){
        errorStr = '카테고리를 선택해주세요.'
      }
      break;
    case 'title':
      if(!e.target.value){
        errorStr = '도서명은 필수 입력입니다.'
      }
      break;
    case 'publisher':
      if(!e.target.value){
        errorStr = '출판사는 필수 입력입니다.'
      }
      break;
    case 'price':
      if(!e.target.value){
        errorStr = '가격은 필수 입력입니다.'
      }
      break;
  }
  return errorStr;
};