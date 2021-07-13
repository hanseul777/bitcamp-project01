package com.a4.QnAboard;

public class Member {

  public void member() {

    DB db = new DB();
    Id id = new Id();


    db.DBbase();

    id.memberJoin();

  }  

}