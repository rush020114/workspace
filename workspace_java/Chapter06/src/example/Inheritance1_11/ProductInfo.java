package example.Inheritance1_11;

import java.util.Scanner;

public class ProductInfo {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    Product[] products = new Product[10];
    int productCnt = 0;
    boolean isRunning = true;

    while(isRunning){
      System.out.print("상품 추가<1>, 모든 상품 조회<2>, 끝내기<3> : ");
      int selectNo = sc.nextInt();

      switch(selectNo){
        case 1:
          System.out.print("상품 종류 (책<1>, 음악CD<2>, 회화책<3>) : ");
          int selectProduct = sc.nextInt();
          switch(selectProduct){
            case 1:
              System.out.print("상품 설명 : ");
              String description2 = sc.next();
              System.out.print("생산자 : ");
              String producer2 = sc.next();
              System.out.print("가격 : ");
              int price2 = sc.nextInt();
              System.out.print("ISBN : ");
              int isbn1 = sc.nextInt();
              System.out.print("책 제목 : ");
              String title1 = sc.next();
              System.out.print("저자 : ");
              String writer1 = sc.next();
              products[productCnt] = new Book(productCnt, description2, producer2, price2, isbn1, title1, writer1);
              break;
            case 2:
              System.out.print("상품 설명 : ");
              String description1 = sc.next();
              System.out.print("생산자 : ");
              String producer1 = sc.next();
              System.out.print("가격 : ");
              int price1 = sc.nextInt();
              System.out.print("앨범제목 : ");
              String albumTitle = sc.next();
              System.out.print("가수 : ");
              String singer = sc.next();
              products[productCnt] = new CompactDisc(productCnt, description1, producer1, price1, albumTitle, singer);
              break;
            case 3:
              System.out.print("상품 설명 : ");
              String description3 = sc.next();
              System.out.print("생산자 : ");
              String producer3 = sc.next();
              System.out.print("가격 : ");
              int price3 = sc.nextInt();
              System.out.print("ISBN : ");
              int isbn2 = sc.nextInt();
              System.out.print("책 제목 : ");
              String title2 = sc.next();
              System.out.print("저자 : ");
              String writer2 = sc.next();
              System.out.print("언어 : ");
              String language = sc.next();
              products[productCnt] = new ConversationBook(productCnt, description3, producer3, price3, isbn2, title2, writer2, language);
              break;
            default:
          }
          productCnt++;
          break;
        case 2:
          for(int i = 0 ; i < productCnt ; i++){
            System.out.println(products[i]);
          }
          break;
        case 3:
        default:
          isRunning = !isRunning;
      }
    }
  }
}
