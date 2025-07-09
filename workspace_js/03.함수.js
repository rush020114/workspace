function hello(){
  console.log('hello');
}

// 매개변수로 받은 두 정수의 합을 출력
function printSum(a, b){
  console.log(a + b);
}

// 매개변수로 받은 두 정수의 곱을 리턴
function printMulti(a, b){
  return a * b;
}

// 1부터 매개변수로 받은 정수까지의 수 중 
// 3의 배수의 개수를 리턴하는 함수
function getCnt(num){
  let cnt = 0;
  for(let i = 1 ; i < num + 1 ; i++){
    if(i % 3 === 0){
      cnt++;
    }
  }
  return cnt;
}

// function getEvenArray(arr){
//   let index = 0;
//   const resultArr = [];
//   for(let i = 0 ; i < arr.length ; i++){
//     if(arr[i] % 2 === 0){ 
//       resultArr[index++] = arr[i];
//     }
//   }
//   return resultArr;
// }

// 매개변수로 정수만 들어있는 배열이 전달되면
// 해당 배열에서 짝수만을 갖는 새로운 배열을 리턴하는 함수

function getEvenArray(arr){
  let index = 0;
  const resultArr = [];
  for(let i = 0 ; i < arr.length ; i++){
    if(arr[i] % 2 === 0){ // 문자열 비교도 ===을 쓴다.
      resultArr.push(arr[i]); // push를 사용하면 새로운 변수를 선언할 필요 X
    }
  }
  return resultArr;
}

console.log('자바스크립트 실행');

hello();
printSum(10, 20);
const result = printMulti(3, 2);
console.log(result);
console.log(getCnt(52));
console.log(getEvenArray([1, 2, 5, 6, 8]));

console.log('자바스크립트 끝~');