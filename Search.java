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

public class Search extends AppCompatActivity {
    EditText name;
    Button search;
    ListView list;
    TextView Signout;
    List itm;
    String gender1;
    String height1;
    String weight1;
    String age1;
    String bloodgroup1;
    DBHelper database;
    ArrayAdapter<String> adapter;
    DBHelper db;
    Button gotonext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        name = (EditText) findViewById(R.id.editText11);
        search = (Button) findViewById(R.id.button7);
        list = (ListView) findViewById(R.id.mylist);
        Signout = (TextView)findViewById(R.id.textView14);

        Signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),login.class);
                startActivity(i);
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchButtonClick();


            }
        });



        itm = new ArrayList<>();
        //String[] listItems = new String[]{name};
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itm);
        list.setAdapter(adapter);
    }



    private void searchButtonClick() {
        String searchInoutText = name.getText().toString();
        database = new DBHelper(getApplicationContext());
        gender1 = database.fetchByID(searchInoutText);
        height1=database.fetchByID1(searchInoutText);
        weight1=database.fetchByID2(searchInoutText);
        age1=database.fetchByID3(searchInoutText);
        bloodgroup1=database.fetchByID4(searchInoutText);
        if (gender1 != null) {
            Toast.makeText(getApplicationContext(), gender1, Toast.LENGTH_LONG).show();
            adapter.add(gender1);
            database.close();
        } else {
            Toast.makeText(getApplicationContext(), "Not found", Toast.LENGTH_LONG).show();
        }
        if (height1 != null) {
            Toast.makeText(getApplicationContext(), height1, Toast.LENGTH_LONG).show();
            adapter.add(height1);
            database.close();
        } else {
            Toast.makeText(getApplicationContext(), "Not found", Toast.LENGTH_LONG).show();
        }
        if (weight1 != null) {
            Toast.makeText(getApplicationContext(), weight1, Toast.LENGTH_LONG).show();
            adapter.add(weight1);
            database.close();
        } else {
            Toast.makeText(getApplicationContext(), "Not found", Toast.LENGTH_LONG).show();
        }
        if (age1 != null) {
            Toast.makeText(getApplicationContext(), age1, Toast.LENGTH_LONG).show();
            adapter.add(age1);
            database.close();
        } else {
            Toast.makeText(getApplicationContext(), "Not found", Toast.LENGTH_LONG).show();
        }
        if (bloodgroup1!=null) {
            Toast.makeText(getApplicationContext(), bloodgroup1, Toast.LENGTH_LONG).show();
            adapter.add(bloodgroup1);
            database.close();
        } else {
            Toast.makeText(getApplicationContext(), "Not found", Toast.LENGTH_LONG).show();
        }
    }
}
