package com.example.receipt_sorter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Login extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button login;
    private Button Cancel;

    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }

    public void Cancel(View view) {
        Intent i = new Intent(Login.this, MainActivity.class);
        startActivity(i);

    } /*
    public void UpdateUI() {
        email = findViewById(R.id.EmailText);
        password = findViewById(R.id.pwdText);

        String regexPassword = "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{8,}";
        //Add Validation using Awesome validation
        awesomeValidation.addValidation(Login.this,R.id.EmailText,android.util.Patterns.EMAIL_ADDRESS,R.string.Email);
        awesomeValidation.addValidation(Login.this,R.id.pwdText,regexPassword,R.string.Password);
        login.setOnClickListener(new View.OnClickListener() {

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
                        Toast.makeText(Login.this, "Login Unsuccessful", Toast.LENGTH_SHORT).show();
                    }
                } */

}
