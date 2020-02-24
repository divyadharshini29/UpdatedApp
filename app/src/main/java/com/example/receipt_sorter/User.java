package com.example.receipt_sorter;
import android.provider.ContactsContract;

import java.util.*;
public class User {
    private String fname;
    private String lname;
    private Date dob;
    private String email;
    private String password;

    public User(String fname, String lname, Date dob, String email, String password) {
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.email = email;
        this.password = password;
    }
  public User()
  {

  }
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}




