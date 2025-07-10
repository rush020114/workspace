// 함수표현식
// 자바스크립트에선 함수도 자료형으로 판단하여 변수에 저장가능하다.
const f = function (a, b){
  return a * b;
};
console.log(f(2, 5));

// 화살표 함수
// 함수의 내용이 한 줄이면 중괄호 생략 가능
const f1 = () => console.log(1);

const f2 = () => console.log(a + b);

// 매개변수로 전달된 데이터를 출력하는 화살표 함수
// 매개변수가 하나라면 매개변수의 소괄호 생략 가능
const f3 = data => console.log(data);

// 매개변수로 전달된 수 * 3한 데이터 리턴
// 리턴이 있는 함수는 화살표 함수로 바꿀 때
// 중괄호 생략과 함께 리턴 키워드도 함께 생략해야 한다.
const f4 = num => num * 3;

console.log(f4(35))

// 배열 중복 제거하기
// 매개변수로 배열을 받아 중복된 요소를 제거하는 새로운 배열을 만드는 함수를 화살표 함수로 만들기

// 매개변수로 arr를 받아 기능을 구현하는 함수를 받은 test변수
// test의 자료형은 함수가 되어 함수처럼 사용 가능.
const test = arr => {
  const newArr = [];
  for(let i = 0 ; i < arr.length ; i++){ // 배열에 저장할 i번째 인덱스 
    let cnt = 0;
    for(let j = 0 ; j < i ; j++){ // i번째 배열과 비교할 배열 j번째 인덱스
      if(arr[i] === arr[j]){ 
        cnt++; // 중복이 한 번이라도 있으면 cnt증가
      }
    }
    if(cnt === 0){ 
      // 중복이 한 번이라도 생기지 않으면 그 값을 새로운 배열에 저장
      newArr.push(arr[i]);
    }
  }
  return newArr;
}

console.log(test([2,4,1,2,5,3,6,3,2,3]));