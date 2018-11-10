package com.example.sois.befit;

import android.content.Intent;
import android.media.MediaCodec;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration extends AppCompatActivity {

    EditText Name, Email, NewPassword;
    Button ok, back;
    DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Name = (EditText) findViewById(R.id.editText);
        Email = (EditText) findViewById(R.id.editText2);
        NewPassword = (EditText) findViewById(R.id.editText3);
        ok = (Button) findViewById(R.id.button2);
        back = (Button) findViewById(R.id.button3);

        db = new DBHelper(this);


        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = Name.getText().toString();
                String s2 = Email.getText().toString();
                String s3 = NewPassword.getText().toString();
                if (signin() == true) {
                    boolean isInserted = db.insertData(s1, s2, s3);
                    if (isInserted == true) {
                        Toast.makeText(getApplicationContext(), "data is inserted ", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "data is not inserted ", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), login.class);
                startActivity(i);
            }
        });
    }

    private boolean signin() {
        if (TextUtils.isEmpty(Name.getText().toString().trim()) || TextUtils.isEmpty(Email.getText().toString().trim()) || TextUtils.isEmpty(NewPassword.getText().toString().trim())) {
            Name.setError("Fields cant be empty");
            Email.setError("Fields cant be empty");
            NewPassword.setError("Fields cant be empty");
            return false;
        } else if (!emailValidator(Email.getText().toString().trim())) {
            Email.setError("Please Enter Valid Email Address");
            return false;
        } else {
            Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_LONG).show();
            return true;
        }
    }

    public boolean emailValidator(String email) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z0-9]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();

    }
}