const handleRegCarErrorMsg = e => {

  // 유효성 메시지를 저장할 변수
  let errorStr = ''
  
  // 숫자만 입력 정규식
  const priceRegex = /^(?:\d{1,3})(?:,\d{3})*$/;

  switch(e.target.name){
    case 'carMaker':
      if(!e.target.value){
        errorStr = '제조사를 선택해주세요.'
      }
      break;
    case 'modelName':
      if(!e.target.value){
        errorStr = '모델명은 필수입력입니다.'
      }
      break;
    case 'price':
      if(!e.target.value){
        errorStr = '가격은 필수입력입니다.'
      }
      else if(!priceRegex.test(e.target.value)){
        errorStr = '숫자만 입력가능합니다.'
      }
      break;
  }

  return errorStr;
}