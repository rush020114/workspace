// Spread 연산자 - 배열, 객체에 저장된 여러 데이터를 개별로 흩뿌려주는 문법
// 배열과 객체의 괄호를 풀어준다는 느낌
const arr1 = [1, 2, 3];
const arr2 = [5, 8, arr1]; // [5, 8, [1, 2, 3]]
const arr3 = [5, 8, ...arr1]; // [5, 8, 1, 2, 3]
console.log(arr3);

// 객체의 key는 중복될 수 없음
// key가 중복이면 가장 마지막에 들어온 데이터만 저장!
const student = {
  name : 'kim',
  korScore : 80,
  engScore : 90,
  korScore : 100
};

console.log(student);

const newScore = {
  korScore : 70,
  engScore : 60
};

// const student1 = {
//   name : 'kim',
//   engScore : 90,
//   korScore : 100,
//   hobby : ['운동', '독서'],
//   basicInfo : {
//     addr : '울산시',
//     height : 170,
//   }
// };

// console.log(student1.hobby[0]);

// console.log(student1.basicInfo.height);


const student1 =  {
  name : 'kim',
  engScore : 90,
  korScore : 100,
  ...newScore
}
console.log(student1);