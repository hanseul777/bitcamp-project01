package com.a4.QnAboard;

import java.util.Date;
import java.util.Scanner;

public class BoardHandler extends MemberHandler {
  static Scanner sc = new Scanner(System.in);

  void selectModu() { // 멤버 모두
    System.out.println("게시판 조회");
    System.out.println();
  }

  public void insertBoard(String table) { // 멤버 모두
    System.out.println("게시글 추가");
    DBbase();
    try {
      //첫 번째 명령어 생성 
      ST = CN.createStatement();

      //키보드에서 데이터 입력
      System.out.print("\n제목 : ");
      String title = sc.nextLine();
      // System.out.print("grade : "); // grade default 1
      // int grade = Integer.parseInt(sc.nextLine());
      System.out.print("내용 : ");
      String contents = sc.nextLine();
      System.out.print("댓글 : ");
      String reply = sc.nextLine();


      msg = "insert into " + table + " (num, title, contents, reply, recommended, written, id, viewcount)"
          + " values(seq.nextval, ?, ?, ?, 0, sysdate,'" + id + "', 0)";
      PST = CN.prepareStatement(msg);
      PST.setString(1, title);
      PST.setString(2, contents);
      PST.setString(3, reply);
      // PST.setString(5, id);

      System.out.println(msg);

      int OK = PST.executeUpdate();
      if (OK > 0) {
        System.out.println(title + "게시글이 등록되었습니다.");
      } else {System.out.println(title + "게시글 등록이 실패하였습니다.");}
    }catch (Exception e) { } 

    viewBoard(table);
  }

  void deleteBoard() { // 작성한 사람, admin
    System.out.println("게시글 삭제");
    System.out.println();
  }

  void updateBoard() { // 작성한 사람
    System.out.println("게시글 수정");
    System.out.println();
  }

  void deleteMem() { // admin 권한
    System.out.println("회원 삭제");
    System.out.println();
  }

  void search() { // 회원 모두
    System.out.println("검색");
  }

  public void viewBoard(String table) { //회원모두, 게시글 보기
    DBbase();
    try {
      msg = "select * from " + table;

      RS = ST.executeQuery(msg);
      //      System.out.println(msg);

      // 자바의 정석 39p 참고
      System.out.printf("%10s %10s %10s %20s %20s %15s %4s %3s%n"
          , "번호", "제목", "내용", "댓글","좋아요","날짜","ID","조회수");
      System.out.println();
      while(RS.next() == true) {
        int num = RS.getInt("num");
        String title = RS.getString("title");
        String contents = RS.getString("contents");
        String reply = RS.getString("reply");
        int recommended = RS.getInt("recommended");
        Date date  = RS.getDate("written");
        String id = RS.getString("id");
        int viewCount = RS.getInt("viewcount");
        //System.out.printf(id + "\t" + grade +  "\t" + name+ "\t" + email+ "\t" + mobile+ "\t" + date+ "\t" + recommended+ "\t" + belongs);
        System.out.printf("%10s %10s %10s %20s %20s %15s %4s %3s%n"
            , num, title, contents, reply, recommended, date, id, viewCount);
      }

    } catch (Exception e) {
      System.out.println("에러이유" + e);
    }    
    System.out.println();
  }
}