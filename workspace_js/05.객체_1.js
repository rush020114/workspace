// 객체 : 배열과 같이 다수의 데이터를 저장할 수 있는 자료형
// 객체에 저장된 데이터는 순번이 존재하지 않음
// 객체의 데이터는 key값으로 관리된다.

const student1 = {}; // 빈 객체
const student2 = {name: '홍길동', age: 20}; // 빈 객체

// 홍길동이라는 문자열 데이터에 접근
// -> key가 name인 데이터에 접근하겠습니다.

// 객체의 각 데이터에 접근하는 법
console.log(student2.name);
console.log(student2.age);
console.log(student2);

// 객체의 각 데이터를 수정하는 법
student2.name = '이순신';
console.log(student2);

// 객체의 새로운 데이터를 추가하는 법
student2.addr = '울산시';
console.log(student2);

const phone = {
  modelName : 's10', 
  price : 1000,
  color : 'white'
}

// phone 객체의 모델명은 s20으로 변경하세요
phone.modelName = 's20';
console.log(phone)

const students = [
  {
    name : 'kim',
    korScore : 80,
    engScore : 70
  }, 
  {
    name : 'lee',
    korScore : 100,
    engScore : 100
  }, 
  {
    name : 'park',
    korScore : 100,
    engScore : 80
  }
];
// 1. students 배열에 저장된 학생 중 첫번째 학생의 모든 정보를 출력
console.log(students[1]);

// 2. students 배열에 저장된 학생 중 첫번째 학생의 국어 점수를 출력
console.log(students[1].korScore);

// 3. students 배열에 저장된 모든 학생의 이름을 출력
for(const e of students){
  console.log(e.name);
}

// 4. students 배열에 저장된 학생 중 이름이 'park'인 학생의 국어점수와 영어점수를 출력
for(let i = 0 ; i < students.length ; i++){
  if(students[i].name === 'park'){
    console.log(`${students[i].name}의 국어점수 : ${students[i].korScore}`);
    console.log(`${students[i].name}의 영어점수 : ${students[i].engScore}`);
  }
}

// 5. students 배열에 저장된 학생들의 국어점수의 합을 출력
let sum = 0
for(const e of students){
  sum += e.korScore;
}
console.log(sum);

// 6. students 배열에 저장된 학생들의 수학점수를 요소로 갖는 배열을 생성하고 해당 배열을 출력
for(let i = 0 ; i < students.length ; i++){
  students[i].mathScore = null;
  console.log(students[i]);
}
console.log(3);
// 7. 국어와 영어점수의 총합이 가장 높은 학생의 이름을 출력
let max = students[0].korScore + students[0].engScore;
let cnt = 0
for(let i = 0 ; i < students.length ; i++){
  if(max < students[i].korScore + students[i].engScore){
    max = students[i].korScore + students[i].engScore;
    cnt++;
  }
}
console.log(max)
console.log(cnt)
console.log(students[cnt].name);

// 8. 모든 학생에 총점 데이터를 추가해보세요. 총점의 key는 totalScore로 지정하고,
//    총점의 value는 국어와 영어점수의 합으로 지정한다.

for(let i = 0 ; i < students.length ; i++){
  students[i].totalScore = students[i].korScore + students[i].engScore;
}

console.log(students);