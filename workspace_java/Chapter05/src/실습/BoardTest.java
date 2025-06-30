package 실습;

public class BoardTest {
  public static void main(String[] args){
    // 게시글 5개 생성하고 생성한 다섯개의 게시글을 배열에 저장!

    Board b1 = new Board(1, "게시글1", "김자바", 5);
    Board b2 = new Board(2, "게시글2", "이자바", 4);
    Board b3 = new Board(3, "게시글3", "박자바", 3);
    Board b4 = new Board(4, "게시글4", "최자바", 2);
    Board b5 = new Board(5, "게시글5", "정자바", 1);

    Board[] boards = new Board[5];
    boards[0] = b1;
    boards[1] = b2;
    boards[2] = b3;
    boards[3] = b4;
    boards[4] = b5;

    // 1. 배열에 저장된 모든 게시글이 글번호, 제목, 작성자, 조회수 출력(for)
    for(int i = 0 ; i  < boards.length ; i++){
      boards[i].display();
    }

    // 2. 배열에 저장된 게시글 중 작성자가 '김자바;'인 게시글의 모든 정보 출력(for-each)
    for(Board e : boards){
      if(e.getWriter().equals("김자바")){
        e.display();
      }
    }

    // 3. 배열에 저장된 게시글 중 조회수가 2이상인 게시글의 제목만 출력(for)
    for(int i = 0 ; i < boards.length ; i++){
      if(boards[i].getReadCnt() > 1){
        System.out.println(boards[i].getTitle());
      }
    }

    // 4. 배열에 저장된 모든 게시글의 조회수 총합을 출력(for-each)
    int sum = 0;
    for(Board e : boards){
      sum = sum + e.getReadCnt();
    }
    System.out.println(sum);

    // 5. 배열에 저장된 게시글중 조회수가 홀수인 게시글의 개수 출력(for)
    int cnt = 0;
    for(int i = 0 ; i < boards.length ; i++){
      if(boards[i].getReadCnt() % 2 != 0){
        cnt++;
      }
    }
    System.out.println(cnt);
  }
}
