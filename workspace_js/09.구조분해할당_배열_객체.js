// 구조분해할당 - 배열, 객체를 분해해서 일부분의 데이터를 다른 변수에 할당

// 배열에서의 구조분해 할당

const arr = [1,2,3];

const arr1 = [1,2,3];
const [a1,b1,c1] = arr1;

console.log(a1); // 1
console.log(b1); // 2
console.log(c1); // 3

const arr2 = [3, 5, 7];
const [a2, b2] = arr2; // a2 = 3, b2 = 5

// undefined : 변수가 선언되지 않았거나, 변수의 초기값이 없을 때
const arr3 = [4, 1];
const[a3, b3, c3] = arr3;
console.log(c3);

// 객체 구조분해 할당
const student = {
  name: '홍', 
  age: 20, 
  score: 80
};

// 객체의 구조분해할당 문법 사용을 위해서는
// 변수 이름을 반드시 객체의 key와 동일하게 선언해야 함.
const {age, score, name} = student;
console.log(age);