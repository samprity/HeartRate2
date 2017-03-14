package com.example.sampr.heartrateapp;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.widget.Toast;

public class BatteryService extends Service {
    public BatteryService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    private final BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context arg0, Intent intent) {
            int rawLevel = intent.getIntExtra("level", -1);
            int scale = intent.getIntExtra("scale", -1);
            int status = intent.getIntExtra("status", -1);
            Toast.makeText(arg0, "Battery : " + status, Toast.LENGTH_LONG).show();
        }
    };
    public void onCreate() {
        registerReceiver(this.mBatInfoReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }

    public void onDestroy() {
        unregisterReceiver(this.mBatInfoReceiver);
    }
}
