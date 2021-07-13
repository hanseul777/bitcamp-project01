package com.a4.QnAboard;

import java.util.Scanner;

public class Board extends DB{
  static Scanner keyScan = new Scanner(System.in);

  public void board() {

    DB db = new DB();
    db.DBbase();

    BoardHandler boardHandler = new BoardHandler();
    try {
      System.out.print("게시판을 선택하세요 : ");
      String input = keyScan.nextLine();

      boardHandler.viewBoard(input);
      boardHandler.insertBoard(input);
      boardHandler.viewBoard(input);

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



