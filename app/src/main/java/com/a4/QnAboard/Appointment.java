package com.a4.QnAboard;

import java.util.Date;
import java.util.Scanner;

public class Appointment extends MemberHandler{ // 스터디 약속
  static Scanner sc = new Scanner(System.in);

  public void viewAppointment() {
    DBbase();
    try {
      msg = "select * from appointment";

      RS = ST.executeQuery(msg);
      //      System.out.println(msg);

      // 자바의 정석 39p 참고
      System.out.printf("%5s %10s %10s %10s %10s %10s %4s %4s%n"
          , "번호", "제목", "장소", "시간","날짜", "ID","정원", "조회수");
      System.out.println();
      while(RS.next() == true) {
        int num = RS.getInt("num");
        String title = RS.getString("title");
        String location = RS.getString("location");
        String time = RS.getString("time");
        Date date  = RS.getDate("written");
        String id = RS.getString("id");
        int numLimit = RS.getInt("numlimit");
        int viewCount = RS.getInt("viewcount");
        //System.out.printf(id + "\t" + grade +  "\t" + name+ "\t" + email+ "\t" + mobile+ "\t" + date+ "\t" + recommended+ "\t" + belongs);
        System.out.printf("%5s %10s %10s %10s %10s %10s %4s %4s%n"
            , num, title, location, time, date, id, numLimit, viewCount);
      }
    } catch(Exception ex) {
      System.out.println("잘못 입력입니다.");
    }
    System.out.println();
  }

  public void insertAppointment() {
    System.out.println("스터디원 모집 게시판");
    DBbase();
    try {
      ST = CN.createStatement();
      System.out.print("\n제목 : ");
      String title = sc.nextLine();
      System.out.print("장소 : ");
      String location = sc.nextLine();
      System.out.print("시간 : ");
      String time = sc.nextLine();
      System.out.print("정원 : ");
      int numLimit = Integer.parseInt(sc.nextLine());
      msg = "insert into appointment(num, title, location, time, written, id, numlimit, viewcount) "
          + "values(seq.nextval, ?, ?, ?, sysdate, '" + id  + "',? ,0)";
      PST = CN.prepareStatement(msg);
      PST.setString(1, title);
      PST.setString(2, location);
      PST.setString(3, time);
      PST.setInt(4, numLimit);

      int OK = PST.executeUpdate();
      if (OK > 0) {
        System.out.println(title + " 게시글이 등록되었습니다.");
      } else {
        System.out.println(title + " 게시글 등록이 실패했습니다.");
      }
    } catch (Exception e) {
      System.out.println("잘못된 입력입니다.");
    }
    System.out.println();
  }
  public void deleteBoard() {
    DBbase();
    //    NUM                                       NOT NULL NUMBER
    //    TITLE                                     NOT NULL VARCHAR2(10)
    //    LOCATION                                  NOT NULL VARCHAR2(10)
    //    TIME                                      NOT NULL VARCHAR2(8)
    //    REPLY                                              VARCHAR2(10)
    //    WRITTEN                                   NOT NULL DATE
    //    ID                                        NOT NULL VARCHAR2(10)
    //    NUMLIMIT                                           NUMBER
    //    VIEWCOUNT                                          NUMBER
    try {
      System.out.print("\n삭제할 게시글 번호 입력 : ");
      int num = Integer.parseInt(sc.nextLine());
      System.out.print("삭제할 게시글 제목 입력 : ");
      String title = sc.nextLine();

      if(!sc.nextLine().equals("y")) {
        System.out.println("회원 탈퇴 취소하셨습니다.");
      } else {
        msg = "delete from appointment where num = ? and title = ?" ;
        PST = CN.prepareStatement(msg);
        PST.setInt(1, num);
        PST.setString(2, title);

        int aa = PST.executeUpdate();
        if (aa > 0) {
          System.out.println(num + "번 게시글 '" + title +"' 삭제 성공했습니다.");
        } else {
          System.out.println(num + "번 게시글 '" + title +"' 삭제 실패했습니다.");
        }//내부 else end

      }//delete y/N end
    } catch (Exception e) {
      System.out.println("에러이유" + e);
    }
  }//delete end

  public void updateBoard() {
    DBbase();
    try {
      //수정처리는 대상필드 name,title
      System.out.print("수정할 게시물 번호 입력  :");
      int num = Integer.parseInt(sc.nextLine());

      System.out.print("제목 수정내역 입력  :");
      String updatetitle= sc.nextLine(); 
      System.out.print("장소 수정내역 입력  :");
      String location = sc.nextLine();


      msg = "update appointment set title =? , " ;
      System.out.println(msg);
      PST = CN.prepareStatement(msg);
      PST.setInt(1, num);
      PST.setString(2, location);


      int OK = ST.executeUpdate(msg);
      if (OK>0) {
        System.out.println( "게시글 수정 성공");
      }else {
        System.out.println( "게시글 수정 실패");
      }

    }catch(Exception ex) { }    
  }
}

