package com.joung.project;

import java.util.Scanner;

public class Id { // 회원가입 메서드

  Scanner sc = new Scanner(System.in);
  void memberJoin() {
    try {
      while(true) {
        MemberHandler mh = new MemberHandler();

        mh.selectAll();

        System.out.println("1.회원 가입 ");
        System.out.println("2.로그인");
        System.out.println("3.회원 탈퇴");
        System.out.println("4.로그아웃");
        System.out.println("5.종료 ");
        System.out.print("입력 :");
        int level = Integer.parseInt(sc.nextLine());
        switch(level) {
          case 1 : mh.insertMember(); break;
          case 2 : mh.login(); break;
          case 3 : mh.deleteMember(); break;
          case 4 : mh.Logout(); break;
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

