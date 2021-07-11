package com.a4.QnAboard;

import java.util.Scanner;

public class MainBoard {

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    DB db = new DB();
    Notice nt = new Notice();
    db.DBbase();

    try {
      while(true) {

        System.out.println("1.공지사항");
        System.out.println("2.QnA게시판");
        System.out.println("3.스터디게시판");
        System.out.println("4.자유게시판");
        System.out.println("5.게시판 종료");
        System.out.print("입력 :");
        int sel = Integer.parseInt(sc.nextLine());
        switch(sel) {
          case 1 : nt.choice();
          case 2 :  break;
          case 3 :  break;
          case 4 :  break;
          case 5 : 
            System.out.println("종료합니다.");
            System.exit(0);
          default :
            System.out.println("잘못 입력하셨습니다.");
            break;
        }//switch end
      }//while end
    }catch (Exception e) { }
  }  
}