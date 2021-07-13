package com.a4.QnAboard;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {

    Member join = new Member();
    Board board = new Board();
    Scanner keyScan = new Scanner(System.in);
    try {
      while (true) {
        System.out.print("입력 >>> ");
        int input = Integer.parseInt(keyScan.nextLine());

        switch (input) {
          case 1:
            join.member();
            break;
          case 2:
            board.board();
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


