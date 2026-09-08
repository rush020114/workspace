// n8n은 "이벤트 발생 → 데이터 처리 → 결과 전송" 흐름을 코드 대신 노드로 연결해 만드는 로우코드 자동화 툴이고, 필요하면 Code 노드에 직접 JS를 넣을 수 있음

const results = [];  // 결과를 담을 빈 배열 생성

for (const item of items) {  // n8n이 넘겨준 입력 데이터를 하나씩 순회
  const title = item.json.title;  // 각 항목의 title 필드 값 추출

  if (title.includes("AI")) {  // 제목에 "AI"가 포함되어 있는지 검사
    results.push({ json: item.json });  // 조건에 맞으면 결과 배열에 추가
  }
}

return results;  // 필터링된 데이터를 다음 노드로 전달