// 1. 인사 함수 만들기 (기본함수)
// 이름을 매개변수로 받아서 "안녕하세요, [이름]님!"을 반환하는 함수를 작성하세요.
const f1 = name => `안녕하세요, ${name}님!`
console.log(f1('이승형'));

// 2. 두 수의 합 계산하기 (기본함수)
// 두 개의 숫자를 매개변수로 받아서 그 합을 반환하는 함수를 작성하세요.
function f2(a,b){
  return a + b;
}
console.log(f2(1, 2));

// 3. 짝수 홀수 판별하기 (함수표현식)
// 숫자를 매개변수로 받아서 짝수면 "짝수", 홀수면 "홀수"를 반환하는 함수를 작성하세요.
const f3 = function(num){
  return num % 2 === 0 ? '짝수' : '홀수';
};
console.log(f3(4));

// -중급-
// 1. 배열의 최댓값 찾기 (함수표현식)
// 숫자 배열을 매개변수로 받아서 가장 큰 값을 반환하는 함수를 작성하세요. (Math.max 사용 금지)
const f4 = function(arr){
  let max = arr[0];
  for(let i = 0 ; i < arr.length ; i++){
    if(max < arr[i]){
      max = arr[i];
    }
  }
  return max;
};
console.log(f4([6,2,9,7,3]))


// 2. 문자열 뒤집기 (화살표함수)
// 문자열을 매개변수로 받아서 뒤집은 문자열을 반환하는 함수를 작성하세요.
const f5 = str => {
  let newStr = '';
  for(let i = str.length - 1 ; i > -1 ; i--){
    newStr += str[i];
  }
  return newStr;
};
console.log(f5('java'))


// 3. 팩토리얼 계산하기 (화살표함수)
// 양의 정수를 매개변수로 받아서 팩토리얼을 계산하는 함수를 작성하세요.
const f6 = num => {
  for(let i = num - 1 ; i > 0 ; i--){
    num *= i;
  }
  console.log(num);
};
f6(5);

// -고급-
// 4. 배열 중복 제거하기 (화살표함수)
// 배열을 매개변수로 받아서 중복된 요소를 제거한 새로운 배열을 반환하는 함수를 작성하세요.
const f7 = arr => {
  const newArr = [];
  for(let i = 0 ; i < arr.length ; i++){
    let cnt = 0;
    for(let j = 0 ; j < i; j++){
      if(arr[i] === arr[j]){
        cnt++;
      }
    }
    if(cnt < 1){
      newArr.push(arr[i]);
    }
  }
  return newArr;
};
console.log(f7([3,2,2,3,5]));