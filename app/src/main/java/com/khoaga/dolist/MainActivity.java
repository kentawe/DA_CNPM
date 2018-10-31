package com.khoaga.dolist;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase database;
    ListView lvCongViec;
    Button btnThem;
    ArrayList lvcv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taodata();
        lvCongViec = (ListView)findViewById(R.id.lvCongViec);
        btnThem = (Button)findViewById(R.id.buttonThem);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Them_CV.class);
                startActivity(intent);
            }
        });


    }
    public void taodata()
    {
        database = openOrCreateDatabase("QuanLyCongViec1", MODE_PRIVATE, null);
        String taobang = "create table if not exists CongViec(tenviec TEXT)";
        database.execSQL(taobang);
    }
}
