package com.a4.QnAboard;

import java.util.Date;
import java.util.Scanner;

public class BoardHandler extends MemberHandler {
  static Scanner sc = new Scanner(System.in);

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

  }

  void updateBoard(String table) { // 작성한 사람
    //    DBbase();
    try {
      //수정처리는 대상필드 name,title

      System.out.print("수정할 게시물 제목 입력  :");
      String title = sc.nextLine(); 
      System.out.print("제목 수정내역 입력  :");
      String updatetitle= sc.nextLine(); 
      System.out.print("내용 수정내역 입력  :");
      String contents = sc.nextLine();

      msg = "update " + table + " set title='" + updatetitle +"', contents='"+ contents +"'  where  = '"+ title + "'";

      System.out.println(msg);


      int OK = ST.executeUpdate(msg);
      if (OK>0) {
        System.out.println( "게시글 수정 성공");
      }else {
        System.out.println( "게시글 수정 실패");
      }

    }catch(Exception ex) { }    
  }

  void deleteBoard(String table) { // admin 권한
    try {
      System.out.println("\n삭제할 게시글 번호 입력 : ");
      int a = Integer.parseInt(sc.nextLine());

      msg = "delete from " + table + " where num = " + a ;
      System.out.println(msg);
      int aa = ST.executeUpdate(msg);

      if (aa>0) {
        System.out.println(a + "게시글 삭제");
      } else {System.out.println(a + "게시글 삭제실패했습니다.");}

    }catch (Exception e) {System.out.println("에러이유" + e);}
  }

  void search(String table)  { // 회원 모두

    try {
      System.out.println("게시글 검색 키워드: ");
      String a = sc.nextLine();
      String msg = "select title,contents from " + table + " where title like '%" + a + "%' or contents like '%" + a + "%'" ;
      RS = ST.executeQuery(msg);
      while(RS.next()==true) {
        String contents = RS.getString("contents");
        String title = RS.getString("title");
        System.out.println(title +"\t" + contents);
      }
    }catch(Exception e) { }
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
      //게시글 번호로 내용 출력
      //      System.out.println("게시글 번호 입력: ");
      //      String a = sc.nextLine();
      //      String msg = "select contents from " + table + " where num= '" + a + "'" ;
      //      RS = ST.executeQuery(msg);
      //      while(RS.next()==true) {
      //        String contents = RS.getString("contents");
      //        System.out.println(contents);
      //      }

    } catch (Exception e) {
      System.out.println("에러이유" + e);
    }    
    System.out.println();
  }
}