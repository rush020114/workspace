// 유효성 검사 결과 에러 메서지를 결정하는 함수
// 두 번째 매개변수 : 입력한 비밀번호
export const handleErrorMsg = (e, joinData) => {
  // 아이디 유효성 검사(정규식 사용)
  // 4~8글자, 영문과 숫자만 가능
  const memIdRegex = /^[a-zA-Z0-9]{4,8}$/;
  
  // 유효성 검사
  let errorStr = '' // 검사 결과 error 메시지를 저장할 변수

  // 영문과 숫자가 모두 포함되어야 하는 경우
  const memPwRegex = /^(?=.*[a-zA-Z])(?=.*\d)[a-zA-Z\d]+$/;

  switch(e.target.name){
  case 'memId':      
    if(!e.target.value){ // 빈문자열이면
      errorStr = '아이디는 필수입력입니다.'
    }
    else if(e.target.value.length < 4 || e.target.value.length > 8){
      errorStr = '아이디는 4~8글자입니다.'
    }
    else if(!memIdRegex.test(e.target.value)){
      errorStr = '아이디는 숫자, 영문만 가능합니다.'
    }
    break;
  case 'memPw':
    // 비밀번호
    // 1. 필수입력
    if(!e.target.value){
      errorStr = '비밀번호는 필수입력입니다.'
    }
    // 2. 6~12글자
    else if(e.target.value.length < 6 || e.target.value.length > 12){
      errorStr = '비밀번호는 6~12글자입니다.'
    }
    // 3. 영문 + 숫자 조합만 가능(정규식)
    else if(!memPwRegex.test(e.target.value)){
      errorStr = '비밀번호는 영문과 숫자의 조합입니다.'
    }
    break;
  case 'confirmPw':
    // 비밀번호와 일치하지 않으면...
    if(e.target.value !== joinData.memPw){
      errorStr = '비밀번호가 일치하지 않습니다.'
    }
    break;
  }
  return errorStr;
} 