package com.a4.QnAboard;

import java.util.Scanner;

public class Board extends DB{
  static Scanner keyScan = new Scanner(System.in);

  public void board() {

    BoardHandler boardHandler = new BoardHandler();
    DB db = new DB();
    db.DBbase();
    System.out.print("게시판을 선택하세요 : ");
    String input = keyScan.nextLine();

    try {
      while(true) {

        System.out.println("1.게시판 조회");
        System.out.println("2.게시글 작성");
        System.out.println("3.게시글 수정");
        System.out.println("4.게시글 삭제");
        System.out.println("5.게시글 검색");
        System.out.println("6.뒤로 가기");
        int select  = keyScan.nextInt();
        switch(select) {

          case 1: boardHandler.viewBoard(input); break;
          case 2:boardHandler.insertBoard(input); break;
          case 3:boardHandler.updateBoard(input); break;
          case 4:boardHandler.deleteBoard(input); break;
          case 5:boardHandler.search(input); break;
          case 6: break;
        }
      }
    } catch(Exception ex) {
      System.out.println("존재하지 않는 게시판입니다.");
    }
  }
}
/*
  void boardList() {
    System.out.println("\t[게시판 목록]");
    System.out.println("1. QnA 게시판");
    System.out.println("2. 자유 게시판");
    System.out.println("3. 수업진도 게시판");
    System.out.println("4. 스터디 게시판");
    System.out.print("입력 : ");
    String input = keyScan.nextLine();

    switch (input) {
      case "1":
        System.out.println("QnA 게시판");
        break;
      case "2":
        System.out.println("자유 게시판");
        break;
      case "3":
        System.out.println("수업진도 게시판");
        break;
      case "4":
        System.out.println("스터디 게시판");
        break;
      default:
        System.out.println("잘못 입력하셨습니다.");
    }

  }
 */



