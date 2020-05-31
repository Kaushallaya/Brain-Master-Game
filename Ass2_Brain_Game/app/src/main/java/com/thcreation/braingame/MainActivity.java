package com.thcreation.braingame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.thcreation.braingame.service.BgServise;

public class MainActivity extends AppCompatActivity {
    public int count = 0;
    public Intent intent;
    MyReceive myReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(this, BgServise.class);
        startService(intent);

        SharedPreferences.Editor editor = getSharedPreferences("store",MODE_PRIVATE).edit();
        editor.putInt("number",0);
        editor.commit();

        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.PHONE_STATE");
        myReceiver = new MyReceive();
        registerReceiver(myReceiver, filter);

    }

    public void stop(View v){
        Button btn = (Button)v;

        count++;
        if(count%2 == 1) {
            btn.setBackgroundResource(R.drawable.mute);
            stopService(intent);
        }else{
            btn.setBackgroundResource(R.drawable.volume);
            startService(intent);
        }
    }

    public void  play(View v){
        stopService(intent);

        Intent intent = new Intent(this,level.class);
        startActivity(intent);
    }

    public void  score(View v){
        stopService(intent);

        Intent intent = new Intent(this,score.class);
        startActivity(intent);
    }

    public void  setting(View v){
        stopService(intent);

        Intent intent = new Intent(this,setting.class);
        startActivity(intent);
    }

    public void shop(View v){
        ImageView img = (ImageView)findViewById(R.id.shopImgView);
        Button play = (Button)findViewById(R.id.plBtn);
        Button setting = (Button)findViewById(R.id.stBtn);
        Button score = (Button)findViewById(R.id.scBtn);
        Button shop = (Button)findViewById(R.id.shBtn);
        Button shopAcc = (Button)findViewById(R.id.accBtn);

        img.setVisibility(View.VISIBLE);
        shopAcc.setVisibility(View.VISIBLE);
        play.setVisibility(View.INVISIBLE);
        setting.setVisibility(View.INVISIBLE);
        score.setVisibility(View.INVISIBLE);
        shop.setVisibility(View.INVISIBLE);

    }

    public void shopAccept(View v){
        stopService(intent);

        Intent lintent = new Intent(this,MainActivity.class);
        startActivity(lintent);
    }

}
