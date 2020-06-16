package com.example.baothuc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AlarmRecevice extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("alam", "Xin chao");
        String chuoi = intent.getExtras().getString("extra");
        Log.e("ban truyen ", chuoi);
        Intent myIntent = new Intent(context,Music.class);
        myIntent.putExtra("extra", chuoi);
        context.startService(myIntent);

    }
}
