const arr = [1, 4, ...[1,2,3]]; // 배열을 해제해주는 스프레드 연산자

console.log(arr) // 배열의 2번째 요소의 배열이 해제되어 5개 데이터를 가진 배열이 되었다.
console.log(...arr); // arr배열을 해제하여 5개의 값이 나열됨

const newScore = {
  korScore : 70,
  engScore : 100
}

const student = {
  name : 'kim',
  newScore // 변수가 만들어져 있어서 자동으로 newScore: newScore로 value와 key값을 만들어준다.
};

console.log(student)
console.log(student.newScore); // key값으로 접근 가능

// 객체는 key값이 같으면 마지막에 나온 값으로 덮어씌운다.
const stu = {
  name: 'lee',
  age: 20,
  korScore : 40,
  engScore : 50,
  ...newScore // 스프레드 연산자와 객체의 특성을 이용해 점수를 덮어씌웠다.
}

console.log(stu);

// console.log(...newScore) 객체는 객체 안에서만 스프레드 함수로 사용할 수 있다.