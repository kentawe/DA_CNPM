package com.khoaga.dolist;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Them_CV extends AppCompatActivity {

    EditText edtTen;
    Button btnLuuCV;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them__cv);

        //ánh xạ
        edtTen = (EditText) findViewById(R.id.edtTen);
        btnLuuCV = (Button)findViewById(R.id.buttonLuuCV);

        taodata();
        btnLuuCV.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                themcv1();
            }
        });


    }
    //tạo database
    public void taodata()
    {
        database = openOrCreateDatabase("QuanLyCongViec1", MODE_PRIVATE, null);
        String taobang = "create table if not exists CongViec(tenviec TEXT)";
        database.execSQL(taobang);
    }

    public void themcv1() {
        ContentValues values = new ContentValues();
        values.put("tenviec", edtTen.getText().toString());

        //thêm vào csdl
        database.insert("CongViec", null, values);

        //hiển thị thông báo khi bấn Lưu
        Toast.makeText(getApplicationContext(), "Luu Thanh Cong", Toast.LENGTH_SHORT).show();
    }
}


