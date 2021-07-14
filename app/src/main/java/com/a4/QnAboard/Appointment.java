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
      System.out.println("정원 : ");
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
  }





}
