package com.a4.QnAboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Admin {

  Connection CN = null; //DB서버연결정보 서버ip주소 계정id,pwd
  Statement ST = null;  //ST=CN.createStatement()명령어생성 삭제,신규등록,조회하라
  ResultSet RS = null;  //select조회결과값 전체데이터를 기억합니다
  String msg = "";
  int Gtotal = 0;  
  Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    Admin ad = new Admin();
    ad.DBbase();
  }

  public void DBbase() {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver"); 
      CN = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","1234");
      System.out.println("오라클 드라이브및 서버연결성공 ");    
      ST = CN.createStatement(); 
    } catch(Exception e) {System.out.println("error =" + e);}
  }
}

