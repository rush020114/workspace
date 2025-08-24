export const handleSignUpErrorMsg = (e, pw) => {
  // 4~8글자, 영문과 숫자만 가능
  const memIdRegex = /^[a-zA-Z0-9]{4,8}$/;

  // 영문과 숫자가 모두 포함되어야 하는 경우
  const memPwRegex = /^(?=.*[a-zA-Z])(?=.*\d)[a-zA-Z\d]+$/;

  let errorStr = ''

  switch(e.target.name){
    case 'memId':
      if(!e.target.value){
        errorStr='아이디는 필수입력입니다.'
      }
      else if(e.target.value.length < 4 || e.target.value.length > 8){
        errorStr='아이디는 4~8자입니다.'
      }
      else if(!memIdRegex.test(e.target.value)){
        errorStr='아이디는 영문과 숫자만 입력 가능합니다.'
      }
      break;
    case 'memPw':
      if(!e.target.value){
        errorStr='비밀번호는 필수입력입니다.'
      }
      else if(e.target.value.length < 6 || e.target.value.length > 12){
        errorStr='비밀번호는 6~12자입니다.'
      }
      else if(!memPwRegex.test(e.target.value)){
        errorStr='비밀번호는 영문과 숫자만 조합만 입력 가능합니다.'
      }
      break;
    case 'confirmPw':
      if(e.target.value !== pw){
        errorStr='아이디와 비밀번호가 일치하지 않습니다.'
      }
      break;
  }

  return errorStr
}