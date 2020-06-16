package com.example.baothuc;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class BaothucActivity extends AppCompatActivity {

    TimePicker timePicker;
    Button btnHenGio, btnTat, btnTamDung;
    Calendar calendar;
    TextView tvHienThi;
    AlarmManager alarmManager;
    PendingIntent pendingIntent;
    ImageButton btnThoat, btnNhac;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baothuc_main);
        setControl();
        setEvent();
    }

    private void setEvent() {
        intent = new Intent(BaothucActivity.this, AlarmRecevice.class);
        btnHenGio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar.set(Calendar.HOUR_OF_DAY,timePicker.getCurrentHour());
                calendar.set(Calendar.MINUTE, timePicker.getCurrentMinute());
                int gio = timePicker.getCurrentHour();
                int phut = timePicker.getCurrentMinute();
                String stringGio = String.valueOf(gio);
                String stringPhut = String.valueOf(phut);
                if(phut < 10){
                    stringPhut = "0" + String.valueOf(phut);
                }
                tvHienThi.setText("Báo thức: \t" + stringGio + ":" + stringPhut);
                intent.putExtra("extra", "on");
                pendingIntent = PendingIntent.getBroadcast(
                        BaothucActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT); //tồn tại khi thoát ứng dụng
                long Time = calendar.getTimeInMillis();
                alarmManager.set(AlarmManager.RTC_WAKEUP, Time, pendingIntent);

                //Toast.makeText(BaothucActivity.this, , Toast.LENGTH_LONG).show();
            }
        });
        btnTamDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvHienThi.setText("Báo lại sau 5 phút.");

                alarmManager.cancel(pendingIntent);
                intent.putExtra("extra", "off");
                sendBroadcast(intent);

                intent.putExtra("extra", "on");
                pendingIntent = PendingIntent.getBroadcast(
                        BaothucActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                long Time1 = calendar.getTimeInMillis() + 10000;
                alarmManager.set(AlarmManager.RTC_WAKEUP, Time1, pendingIntent);

            }
        });
        btnTat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvHienThi.setText("Tắt báo thức");
                alarmManager.cancel(pendingIntent);
                intent.putExtra("extra", "off");
                intent.putExtra("extra", "off");
                sendBroadcast(intent);
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BaothucActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnNhac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BaothucActivity.this, Music1.class);
                startActivity(intent);
            }
        });
    }


    private void setControl() {
        timePicker = findViewById(R.id.tpbaothuc);
        btnHenGio = findViewById(R.id.btnhengio);
        btnTamDung = findViewById(R.id.btntamdung);
        btnTat = findViewById(R.id.btntat);
        btnNhac = findViewById(R.id.btnnhac);
        tvHienThi = findViewById(R.id.tvhienthi);
        btnThoat = findViewById(R.id.btnthoatnhacchuong);
        calendar = Calendar.getInstance();
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE); // cho phép truy cập vào hệ thống máy khi ứng dụng tắt
    }

}
