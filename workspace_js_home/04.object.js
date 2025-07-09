// 객체생성 문법
// 자료형 변수명 = {key: value, key: value};
// value는 실제 데이터이며 key는 그 데이터를 찾기 위한 라벨이라고 생각하자
// 배열과 달리 순서를 기억하는 것이 아니라 라벨을 기억하고 찾는 구조이다.
// 데이터를 사용하고 싶을 땐 자바의 객체 사용처럼 .을 찍어 사용한다.

const student1 = {name: '김자바', age: 20};
const student2 = { // 코드가 너무 길어지기에 이 방법으로 사용한다.
  name: '이자바', 
  age: 21
};

console.log(`${student1.name}의 나이는 ${student1.age}입니다.`)
console.log(`${student2.name}의 나이는 ${student2.age}입니다.`)

const students = [
  {
    name: 'kim',
    korScore: 80,
    engScore: 90
  },
  {
    name: 'lee',
    korScore: 100,
    engScore: 100
  },
  {
    name: 'park',
    korScore: 80,
    engScore: 70
  }
];

let maxIndex = 0;
let max = students[0].korScore + students[0].engScore;
for(let i = 0 ; i < students.length ; i++){
  if(max < students[i].korScore + students[i].engScore){
    max = students[i].korScore + students[i].engScore;
    maxIndex = i;
  }
}
console.log(students[maxIndex].name);