package com.example.sois.befit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class login extends AppCompatActivity {

    EditText email,password;
   Button login;
    TextView createnew;
   DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.editText5);
        password = (EditText) findViewById(R.id.editText6);
        login = (Button) findViewById(R.id.button4);
        createnew = (TextView) findViewById(R.id.textView);
        db = new DBHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String e=email.getText().toString();
                String p=password.getText().toString();
                boolean validate=db.validate(e,p);
                if(validate==true) {
                    Toast.makeText(login.this,"login successful",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(), Details.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(login.this,"not successful",Toast.LENGTH_LONG).show();
                }
            }
        });



        createnew.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i= new Intent(getApplicationContext(),Registration.class);
                startActivity(i);
            }
        });

    }
}
