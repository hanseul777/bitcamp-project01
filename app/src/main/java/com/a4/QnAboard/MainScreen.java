package com.a4.QnAboard;

import java.util.Scanner;

public class MainScreen {
  static int selection = 0;
  Scanner selectionFor = new Scanner(System.in);
  BoardHandler mainScreenBoard = new BoardHandler();
  Appointment mainScreenAppointment = new Appointment();

  void mainScreen() {
    top();
    quarter1Mid();
    quarter2Mid();
    quarter3Mid();
    quarter4Mid();
  }

  void top () {
    System.out.printf("========================================\n");
    System.out.printf("비트캠프 수강생들을 위한 교류 공간 Since 1994\n");
    System.out.printf("==========================================\n");
  }
  void quarter1Mid () {
    System.out.println("\"-----------------------------------[자유 게시판]---------------------------------------");
    mainScreenBoard.viewBoard("freeboard");
    System.out.println("-----------------------------------------------------------------------------------------");
  }
  void quarter2Mid () {
    System.out.println("-----------------------------------[질문답변 게시판]-------------------------------------");
    mainScreenBoard.viewBoard("board");
    System.out.println("-----------------------------------------------------------------------------------------");
  }
  void quarter3Mid () {
    System.out.println("-----------------------------------[수업진도 게시판]-------------------------------------");
    mainScreenBoard.viewBoard("review");
    System.out.println("-----------------------------------------------------------------------------------------");
  }
  void quarter4Mid () {
    System.out.println("----------------------------------[스터디모집 게시판]------------------------------------");
    mainScreenAppointment.viewAppointment();
    System.out.println("-----------------------------------------------------------------------------------------");
  }
  void bottom () {
    System.out.printf("========================================\n");
    System.out.printf("\n1.회원 가입 2.로그인 3.회원 탈퇴 4.로그아웃 5. 게시판 관리\n");
    System.out.printf("==========================================\n");
    System.out.printf("9. 종료\n");
    System.out.printf("원하는 메뉴로 접근하려면 해당 숫자를 입력하세요. >>> ");

  }



}
