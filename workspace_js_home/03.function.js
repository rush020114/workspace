function test1(a){
  const even = a % 2 === 0 ? alert(1) : alert(2); // 삼항연산자
}

function test2(num1, num2){
  let sum1 = 0;
  let sum2 = 0;
  for(let i = 0  ; i < num1.length ; i++){
    sum1 += num1[i];
  }
  for(const e of num2){
    sum2 += e;
  }
  alert(sum1 - sum2);
}

function test3(arr){
  alert(arr[2][1]); // 배열 안의 배열을 출력할 수도 있다. 자료형을 잘 신경쓰면 어렵지 않다.
}

function returnEvenCnt(a){
  let cnt = 0;
  for(const e of a){
    if(e % 2 === 0){
      cnt++;
    }
  }
  return cnt;
}

// return 함수를 만들었으면 호출한 값을 출력하면 된다.
console.log(`짝수의 개수 : ${returnEvenCnt([2, 4, 6, 7])}`);

function returnEvenNewArr(arr){
  const newArr = [];
  for(const e of arr){
    if(e % 2 === 0){
      newArr.push(e); // push함수를 사용하면 편하게 값을 넣을 수 있다.
    }
  }
  return newArr;
}

console.log(returnEvenNewArr([1,2,3,4,5,6,7,8]))

