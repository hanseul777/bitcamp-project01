package com.a4.QnAboard;

import java.util.Scanner;

public class App extends MemberHandler{

  public static void main(String[] args) {

    Member join = new Member();
    Board board = new Board();
    Scanner keyScan = new Scanner(System.in);
    try {
      while (true) {
        System.out.println("1. 회원 관리");
        System.out.println("2. 게시판 관리");
        System.out.print("입력 >>> ");
        int input = Integer.parseInt(keyScan.nextLine());

        switch (input) {
          case 1:
            join.member();
            break;
          case 2:
            if(id == null && password == null) {
              System.out.println("로그인이 필요합니다.");
            }else {
              board.board();
            }
            break;
          case 3:
            System.exit(0);
          default:
            System.out.println("잘못 입력하셨습니다.");
            break;
        }
      }

    } catch(Exception ex) {
      System.out.println("잘못 입력하셨습니다.");
    }

  }

}


