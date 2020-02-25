package com.example.receipt_sorter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import java.text.ParseException;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

import java.util.*;
import java.text.SimpleDateFormat;

public class Register extends AppCompatActivity {
    private EditText fname;
    private EditText lname;
    private EditText email;
    private EditText password;
    private EditText confirm;
    private EditText date;
    private Button register;
    private Button cancel;
    private  Date d;//convert edit text to date format to save in user;
    private UserDataSharedPreference userDataSharedPreference;

    AwesomeValidation awesomeValidation;
    private DatePickerDialog mDatePickerDialog;
    final Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        userDataSharedPreference=new UserDataSharedPreference(this);

        setDateTimeField();
        date =findViewById(R.id.DateText);
        date.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mDatePickerDialog.show();
                return false;
            }
        });
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        UpdateUI();
    }

    private void setDateTimeField() {

        Calendar newCalendar = Calendar.getInstance();
        mDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
                final Date startDate = newDate.getTime();
                String fdate = sd.format(startDate);

                date.setText(fdate);

            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        mDatePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

    }

    public void Cancel(View view) {
        Intent i = new Intent(Register.this, MainActivity.class);
        startActivity(i);
    }
    public void UpdateUI() {
        fname =findViewById(R.id.FTxt);
        lname = findViewById(R.id.LText);
        password = findViewById(R.id.pwdText);
        confirm=findViewById(R.id.confText);
        email = findViewById(R.id.EmailText);
        register=findViewById(R.id.RegisterBtn);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");//format

        try {
           d = format.parse(date.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String regexPassword = "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{8,}";
          //Add Validation using Awesome validation
        awesomeValidation.addValidation(Register.this,R.id.FTxt,"[a-zA-Z\\s]+",R.string.FnameError);
        awesomeValidation.addValidation(Register.this,R.id.LText,"[a-zA-Z\\s]+",R.string.LnameError);
        awesomeValidation.addValidation(Register.this,R.id.EmailText,android.util.Patterns.EMAIL_ADDRESS,R.string.Email);
        awesomeValidation.addValidation(Register.this,R.id.pwdText,regexPassword,R.string.Password);
        awesomeValidation.addValidation(Register.this,R.id.confText,R.id.pwdText,R.string.ConfrimPwd);
        register.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                if(awesomeValidation.validate())
                {
                    User user=new User(fname.getText().toString(),lname.getText().toString(),d,email.getText().toString(),password.getText().toString());
                    boolean create=userDataSharedPreference.writeData(user);
                    if(create) {
                        Toast.makeText(Register.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(Register.this, MainActivity.class);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(Register.this, "Registration Unsuccessful", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
    }
}



