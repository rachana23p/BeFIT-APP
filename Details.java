package com.example.sois.befit;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.sois.befit.R.id.editText10;
import static com.example.sois.befit.R.id.editText12;
import static com.example.sois.befit.R.id.editText2;
import static com.example.sois.befit.R.id.editText4;
import static com.example.sois.befit.R.id.editText8;

public class Details extends AppCompatActivity {


    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        final EditText name=(EditText)findViewById(editText12);
        final EditText gender=(EditText)findViewById(editText4);
        final EditText height=(EditText)findViewById(R.id.editText7);
        final EditText weigth=(EditText)findViewById(editText8);
        final EditText age=(EditText)findViewById(R.id.editText9);
        final EditText bloodgroup=(EditText)findViewById(editText10);

        Button save=(Button)findViewById(R.id.button5);
        Button next=(Button)findViewById(R.id.button6);

        SQLiteDatabase.CursorFactory context;
        db= new DBHelper(this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = name.getText().toString();
                String s2 = gender.getText().toString();
                String s3 = height.getText().toString();
                String s4 = weigth.getText().toString();
                String s5 = age.getText().toString();
                String s6 = bloodgroup.getText().toString();


                boolean isInserted1 = db.insertData1(s1,s2,s3,s4,s5,s6);
                if (isInserted1 == true) {
                    Toast.makeText(getApplicationContext(), "data inserted",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "datanot inserted",Toast.LENGTH_LONG).show();
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener()
        {

            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), Search.class);

                startActivity(i);
            }
        });


    }
}
