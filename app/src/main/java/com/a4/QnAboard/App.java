package com.a4.QnAboard;

import java.sql.SQLException;
import java.util.Scanner;

public class App extends MemberHandler{

  public static void main(String[] args) {
    DB db = new DB();
    db.DBbase();
    MainScreen main = new MainScreen();
    Id memberJoin = new Id();
    MemberHandler memberManagement = new MemberHandler();
    Member join = new Member();
    Board board = new Board();
    
    main.top();
    
    main.quarter1Mid();
    
    main.quarter2Mid();
    
    main.quarter3Mid();
    
    main.quarter4Mid();
    
    main.bottom();
      Scanner keyScan = new Scanner(System.in);
      System.out.print("입력 :");
      int input = Integer.parseInt(keyScan.nextLine());
      switch(input) {
        case 1 : memberManagement.insertMember(); break;
        case 2 : try {
            memberManagement.login();
          } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          } break;
        case 3 : memberManagement.deleteMember(); break;
        case 4 : try {
            memberManagement.Logout();
          } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          } break;
        case 5 : board.board();
        case 9 :
          System.out.println("메인화면으로 이동합니다."); break; 
          default : System.out.println("잘못 입력하셨습니다.");
      }//switch end

  }

}


