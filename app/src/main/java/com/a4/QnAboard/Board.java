package com.a4.QnAboard;

import java.util.Scanner;

public class Board extends MemberHandler{
  static Scanner keyScan = new Scanner(System.in);

  public void board() {

    Appointment appointment = new Appointment();
    BoardHandler boardHandler = new BoardHandler();
    DB db = new DB();
    db.DBbase();
    System.out.println("\"-----------------------------------[자유 게시판]---------------------------------------");
    boardHandler.viewBoard("freeboard");
    System.out.println("-----------------------------------------------------------------------------------------");
    System.out.println("-----------------------------------[질문답변 게시판]-------------------------------------");
    boardHandler.viewBoard("board");
    System.out.println("-----------------------------------------------------------------------------------------");
    System.out.println("-----------------------------------[수업진도 게시판]-------------------------------------");
    boardHandler.viewBoard("review");
    System.out.println("-----------------------------------------------------------------------------------------");
    System.out.println("----------------------------------[스터디모집 게시판]------------------------------------");
    appointment.viewAppointment();
    System.out.println("-----------------------------------------------------------------------------------------");
    System.out.println();
    System.out.println("[게시판 목록] : freeBoard/ board/ review/ appointment");
    System.out.println("[단축어] : [f]-freeBoard [b]-board [r]-review [a]-appointment");
    System.out.println();
    System.out.print("입장할 게시판을 입력해주세요 : ");
    String input = keyScan.nextLine();

    try {
      if (input.equals("a")) {
        input = "appointment";
        appointment.viewAppointment();

        loop: while (true) {
          System.out.println("1.게시판 조회");
          System.out.println("2.게시글 작성");
          System.out.println("3.게시글 수정");
          System.out.println("4.게시글 삭제");
          System.out.println("5. 뒤로 가기");
          System.out.print("입력 : ");
          int select = keyScan.nextInt();

          switch (select) {
            case 1: appointment.viewAppointment(); break;
            case 2: appointment.insertAppointment(); break;
            case 3: appointment.updateBoard(); break;
            case 4: appointment.deleteBoard(); break;
            //case 5: boardHandler.search(input); break;
            //case 3: boardHandler.updateBoard(); break;
            //case 5: boardHandler.search(); break;
            case 5: break loop;
          }
        }
      } else {
        if (input.equals("f")) {
          input = "freeBoard";
          boardList(input);
        } else if (input.equals("b")) {
          input = "board";
          boardList(input);
        } else if (input.equals("r")) {
          input = "review";
          boardList(input);
        }
      }
    } catch(Exception ex) {
      System.out.println("존재하지 않는 게시판입니다.");
    }
  }

  public void boardList(String input) {

    BoardHandler boardHandler = new BoardHandler();
    DBbase();

    boardHandler.viewBoard(input);
    try {
      loop: while (true) {
        String grd = "select grade from id where id = '" + id + "'";//입력값 id가 포함된 쿼리문을 변수grd에 입력
        RS = ST.executeQuery(grd);

        //변수 grd를 데이터베이스 변수 RS에 입력한다.
        while(RS.next() == true) {
          int grade = RS.getInt("grade");// id필드 데이터에에 종속되어 있는 grade필드 데이터를 int변수로 저장
          System.out.println(id + "님의 회원 등급은 " + grade + "번 입니다.");
          System.out.println();

          switch (grade) {
            case 4:
              System.out.print("[d] 게시글 삭제\t");
            case 3:
              System.out.print("[u] 게시글 수정\t");
            case 2:
              System.out.print("[i] 게시글 작성\t");
            case 1:
              System.out.print("[v] 게시판 조회\t");
              System.out.print("[s] 게시글 검색\t");
              System.out.println("[b] 뒤로 가기");
            default:
              break;
          }
          System.out.print("입력 : ");
          String select  = keyScan.nextLine();
          switch (select) {
            case "d": boardHandler.deleteBoard(input); break;
            case "s": boardHandler.search(input); break;
            case "u": boardHandler.updateBoard(input); break;
            case "i": boardHandler.insertBoard(input); break;
            case "v": boardHandler.viewReply(input); break;
            case "b": break loop;
          }
        }

      }
    } catch(Exception e) { System.out.println(e);}
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



