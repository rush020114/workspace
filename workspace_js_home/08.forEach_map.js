// foreach함수는 배열에.을 찍어 접근할 수 있고 각 요소의 데이터와 인덱스를 사용할 수 있다.
[1, 2, 3].forEach((e, i) => {
  console.log(`e : ${e}, i : ${i}`)
})

// map함수는 똑같지만 리턴할 수 있는 큰 장점이 있어서 jsx에 사용하기 딱 알맞다.
const a = [1, 3, 5].map((e, i) => {
  return `${e}, ${i}`
})

console.log(a)
