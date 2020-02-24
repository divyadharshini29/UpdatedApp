package com.example.receipt_sorter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
public class UserDataSharedPreference {
    SharedPreferences s;
    private User u;
    private static final String SP_NAME="user_data";

    public UserDataSharedPreference(Context context) {
        this.s=context.getSharedPreferences(SP_NAME,0);
    }
    public boolean writeData(User u)
    {
        Editor e=s.edit();
        e.putString("fname",u.getFname());
        e.putString("lname",u.getLname());
        e.putString("dob" ,u.getDob().toString());
        e.putString("email",u.getEmail().toString());
        e.putString("pwd",u.getPassword());
        if(e.commit())
            return true;
        else
            return false;
    }
    public User retrieveData()
    {
        User u=new User();
        u.setFname(s.getString("fname",""));//second param is default value;
        u.setFname(s.getString("lname",""));
        u.setFname(s.getString("dob",""));
        u.setFname(s.getString("email",""));
        u.setFname(s.getString("pwd",""));
        return u;

    }

}
