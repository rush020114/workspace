// export를 씀으로써 다른 파일을 변수나 함수를 쓰고 싶은 파일에 import해서 쓸 수 있다.
export const handleJoinErrorMsg = (e, pw) => {

  // (1): 정규식을 변수에 저장한다.
  const memIdRegex = /^[a-zA-Z0-9]{4,8}$/;

  // 영문과 숫자가 모두 포함되어야 하는 경우
  const memPwRegex = /^(?=.*[a-zA-Z])(?=.*\d)[a-zA-Z\d]+$/;

  // 유효성 검사를 리턴하기 위한 변수(모두 해당이 안 되면 빈문자열 반환)
  let errorStr = ''

  // switch를 씀으로써 id, pw, pw확인이 변하는 것을 구분할 수 있다.
  switch(e.target.name){
    case 'memId':
      // 유효성 검사의 상태를 나타내는 조건문들
      // e.target.value는 비동기와 상관없이 값이 반영되기 때문에 사용한다.
      // e.target.value의 값을 이용해 truthy, falsy를 판단한다.
      if(!e.target.value){
        errorStr = '아이디는 필수입력입니다.';
      }
      else if(e.target.value.length < 4 || e.target.value.length > 8){
        errorStr = '아이디는 4~8자입니다.';
      }
      // (2): 정규식에 test함수를 쓴다.
      // (3): 매개변수에 필요한 값을 넣는다.
      // (4): 우리가 정의한 정규식과 일치하면 true 아니면 false를 반환
      else if(!memIdRegex.test(e.target.value)){
        errorStr = '아이디는 영문, 숫자만 입력가능합니다.';
      }
      break;
    case 'memPw':
      if(!e.target.value){
        errorStr = '비밀번호는 필수입력입니다.';
      }
      else if(e.target.value.length < 6 || e.target.value.length > 12){
        errorStr = '비밀번호는 6~12자입니다.';
      }
      else if(!memPwRegex.test(e.target.value)){
        errorStr = '비밀번호는 영문, 숫자 조합만 가능합니다.';
      }
      break;
    case 'checkPw':
      if(e.target.value !== pw){
        errorStr = '비밀번호가 일치하지 않습니다.';
      }
      break;
  }
  // 유효성 검사결과 리턴
  return errorStr;
}