package com.example.baothuc;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class Music extends Service {

    MediaPlayer mediaPlayer;
    int id;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("music ", "xin chao");
        String key = intent.getExtras().getString("extra");

            Log.e("nhan key", key);

            if(key.equals("on")){
                id=1;
            }else if (key.equals("off")){
                id=0;
            }

            if (id==1){
                mediaPlayer = MediaPlayer.create(this,R.raw.chuongbaothuc);
                mediaPlayer.start();
                id=0;
            }else if (id==0){
                mediaPlayer.stop();
                mediaPlayer.reset();
            }


        return START_NOT_STICKY;
    }
}
