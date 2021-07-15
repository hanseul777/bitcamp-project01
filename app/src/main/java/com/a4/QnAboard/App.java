package com.a4.QnAboard;

import java.util.Scanner;

public class App extends MemberHandler{

  public static void main(String[] args) {
    DB db = new DB();
    db.DBbase();
    MainScreen main = new MainScreen();
    MemberHandler memberManagement = new MemberHandler();
    Member join = new Member();
    Board board = new Board();

    main.mainScreen();

    while (true) {
      Scanner keyScan = new Scanner(System.in);
      main.bottom();
      int input = Integer.parseInt(keyScan.nextLine());
      switch(input) {
        case 1 : memberManagement.insertMember(); break;
        case 2 : memberManagement.login(); break;
        case 3 : memberManagement.deleteMember(); break;
        case 4 : memberManagement.Logout(); break;
        case 5 : board.board(); break;
        case 9 :
          System.out.println("메인화면으로 이동합니다."); break; 
        default : System.out.println("잘못 입력하셨습니다.");

      }//switch end
    }

  }

}


