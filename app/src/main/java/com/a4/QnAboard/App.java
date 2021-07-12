package com.a4.QnAboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class App {

  Connection CN = null;
  Statement ST = null;
  ResultSet RS = null;
  String msg = "isud = crud 쿼리문 기술";
  static Scanner keyScan = new Scanner(System.in);

  public static void main(String[] args) {

  }
  void connect() {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
      CN = DriverManager.getConnection(url, "system", "1234"); 
      ST =  CN.createStatement(); // 첫번째. 명령어 생성
      System.out.println("오라클 DB 연결 성공");
    } catch(Exception ex) {
      System.out.println("오라클 DB 연결 실패");
    }
  }
}
