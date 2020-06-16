package com.example.baothuc;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Music1 extends AppCompatActivity {

    ListView listviewNhac;
    ImageButton btnThoatNC;
    ArrayList<Nhacchuong> arrayNhacChuong;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music);
        setControl();
        setEvent();
    }

    private void setEvent() {
        AddNhacChong();
        btnThoatNC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Music1.this, BaothucActivity.class);
                startActivity(intent);
            }
        });
    }

    private void AddNhacChong() {
        arrayNhacChuong = new ArrayList<>();
        arrayNhacChuong.add(new Nhacchuong("Nhạc chuông 1", R.raw.chuongbao1));
        arrayNhacChuong.add(new Nhacchuong("Nhạc chuông 2", R.raw.chuongbaothuc));
        arrayNhacChuong.add(new Nhacchuong("Nhạc chuông 3", R.raw.chuongbaothuc));
        arrayNhacChuong.add(new Nhacchuong("Nhạc chuông 4", R.raw.chuongbaothuc));
        arrayNhacChuong.add(new Nhacchuong("Nhạc chuông 5", R.raw.chuongbaothuc));
        arrayNhacChuong.add(new Nhacchuong("Nhạc chuông 6", R.raw.chuongbaothuc));
        arrayNhacChuong.add(new Nhacchuong("Nhạc chuông 7", R.raw.chuongbaothuc));
        arrayNhacChuong.add(new Nhacchuong("Nhạc chuông 8", R.raw.chuongbaothuc));

    }

    private void setControl() {
        listviewNhac = findViewById(R.id.Listviewnhac);
        btnThoatNC = findViewById(R.id.btnthoatnhacchuong);
    }
}
