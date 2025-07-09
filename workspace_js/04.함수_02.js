function test(){
  alert(1); // html의 속성 onclick이 실행됐을 때 화면 위에 1을 띄워라.
}

function test1(num1, num2){
  alert((num1 + num2) % 2 === 0 ? 1 : 2);
}

function test2(arr1, arr2){
  let sum1 = 0;
  let sum2 = 0;
  for(let i = 0 ; i < arr1.length ; i++){
    sum1 += arr1[i];
  }
  
  for(let i = 0 ; i < arr2.length ; i++){
    sum2 += arr2[i];
  }

  alert(sum1 - sum2);
}

function test3(arr){
  alert(arr[2][2]); // 배열의 2번째 요소가 배열이므로 그 배열의 요소를 바로 출력하면 된다.
}

const array1 = [1, [1,2], [1,[5,6],3]]
console.log(array1[2][1][0])