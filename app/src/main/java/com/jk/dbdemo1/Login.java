package com.jk.dbdemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.lang.String;


public class Login extends AppCompatActivity {
    EditText t1,t2;
    String name,pass;
    String a,b;
    int flag;
    SQLiteDatabase sql;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        t1=findViewById(R.id.username1);
        t2=findViewById(R.id.pass1);
        sql=openOrCreateDatabase("Student", Context.MODE_PRIVATE,null);
    }

    public void demo(View view) {
        name=t1.getText().toString();
        pass=t2.getText().toString();

        Cursor c=sql.rawQuery("select * from register",null);
        while(c.moveToNext()) {
            a = c.getString(0);
            b = c.getString(2);
          //  Toast.makeText(getApplicationContext(),"'"+a+"','"+b+"'", Toast.LENGTH_SHORT).show();
            if (a.equals(name) && b.equals(pass)) {
                flag = 1;

            } else {
                flag = 0;
            }
        }
        if(flag==1) {
            Toast.makeText(getApplicationContext(), "Login Successfull", Toast.LENGTH_SHORT).show();

        }
        else {
            Toast.makeText(getApplicationContext(),"Invalid Credentials",Toast.LENGTH_SHORT).show();
        }

        }



    }

