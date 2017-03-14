package com.example.sampr.heartrateapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerReceiver(this.mBatInfoReceiver,
                new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }
    private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver(){

        @Override
        public void onReceive(Context arg0, Intent intent) {
            int level = intent.getIntExtra("level", 0);
            // TODO: Preform action based upon battery level
            Toast.makeText(arg0, "Battery : " + level, Toast.LENGTH_LONG).show();
        }
    };

    public void monitorButtonHandler(View view) {
        Intent intent = new Intent(MainActivity.this, MonitorActivity.class);
        intent.putExtra("cardioZone", "135");
        intent.putExtra("fatBurnZone", "110");
        intent.putExtra("customeZone", "89");
        MainActivity.this.startActivity(intent);
    }

    public void submitButtonHandler(View view) {
        Intent intent = new Intent(MainActivity.this, SubmitActivity.class);
        MainActivity.this.startActivity(intent);
    }
}
