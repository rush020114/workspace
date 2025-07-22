package academy.product;

import java.util.Scanner;

public class ProductInfo {
  public static void main(String[] args){
    Product[] products = new Product[10];
    Scanner sc = new Scanner(System.in);
    boolean isRunning = true;
    int cnt = 0;

    while(isRunning){
      System.out.print("상품 추가<1>, 모든 상품 조회<2>, 끝내기<3>: ");
      int selectNo1 = sc.nextInt();

      switch (selectNo1){
        case 1:
          System.out.print("상품 종류 - 책<1>, 음악<2>, 회화책<3>: ");
          int selectNo2 = sc.nextInt();
          if(cnt < 10){
            switch(selectNo2){
              case 1:
                products[cnt] = regBook();
                products[cnt].setProdId(cnt++);
                break;
              case 2:
                products[cnt] = regCompactDisc();
                products[cnt].setProdId(cnt++);
                break;
              case 3:
                products[cnt] = regConversationBook();
                products[cnt].setProdId(cnt++);
                break;
              default:
                System.out.println("일치하는 책이 없습니다.");
            }
          }
          break;
        case 2:
          for(int i = 0 ; i < cnt ; i++){
            System.out.println(products[i]);
          }
          break;
        case 3:
        default:
          isRunning = !isRunning;
      }
    }
  }

  public static Book regBook(){
    Scanner sc = new Scanner(System.in);
    System.out.print("상품 설명: ");
    String prodInfo = sc.next();
    System.out.print("생산자: ");
    String creator = sc.next();
    System.out.print("가격: ");
    int price = sc.nextInt();
    System.out.print("책 제목: ");
    String title = sc.next();
    System.out.print("저자: ");
    String writer = sc.next();
    System.out.print("ISBN: ");
    String isbn = sc.next();
    return new Book(prodInfo, creator, price, isbn, writer, title);
  }

  public static CompactDisc regCompactDisc(){
    Scanner sc = new Scanner(System.in);
    System.out.print("상품 설명: ");
    String prodInfo = sc.next();
    System.out.print("생산자: ");
    String creator = sc.next();
    System.out.print("가격: ");
    int price = sc.nextInt();
    System.out.print("앨범 제목: ");
    String albumTitle = sc.next();
    System.out.print("가수: ");
    String singer = sc.next();
    return new CompactDisc(prodInfo, creator, price, albumTitle, singer);
  }

  public static ConversationBook regConversationBook(){
    Scanner sc = new Scanner(System.in);
    System.out.print("상품 설명: ");
    String prodInfo = sc.next();
    System.out.print("생산자: ");
    String creator = sc.next();
    System.out.print("가격: ");
    int price = sc.nextInt();
    System.out.print("책 제목: ");
    String title = sc.next();
    System.out.print("저자: ");
    String writer = sc.next();
    System.out.print("언어: ");
    String language =sc.next();
    System.out.print("ISBN: ");
    String isbn = sc.next();
    return new ConversationBook(prodInfo, creator, price, isbn, writer, title, language);
  }
}
