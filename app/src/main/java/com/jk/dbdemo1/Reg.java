package com.jk.dbdemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Reg extends AppCompatActivity {
    EditText t1,t2,t3;
    String name,pass,email;
    SQLiteDatabase sql;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        t1=findViewById(R.id.username2);
        t2=findViewById(R.id.pass2);
        t3=findViewById(R.id.email);
        sql=openOrCreateDatabase("Student", Context.MODE_PRIVATE,null);
        sql.execSQL("create table if not exists register(username varchar(100),password varchar(100),email varchar(100));");


    }

    public void demo(View view) {
        name=t1.getText().toString();
        pass=t2.getText().toString();
        email=t3.getText().toString();
        if(name.isEmpty()||pass.isEmpty()||email.isEmpty())
        {
            Toast.makeText(getApplicationContext(),"All the fields are required",Toast.LENGTH_SHORT).show();
        }
        else
        {
            sql.execSQL("insert into register values('"+name+"','"+pass+"','"+email+"');");
            Toast.makeText(getApplicationContext(),"Successfully ",Toast.LENGTH_SHORT).show();
        }
    }
}
