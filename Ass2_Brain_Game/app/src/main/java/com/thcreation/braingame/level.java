package com.thcreation.braingame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.thcreation.braingame.service.BgServise;
import com.thcreation.braingame.service.LevelServise;

public class level extends AppCompatActivity {
    public int count=0;
    public Intent srvintent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        srvintent = new Intent(this, LevelServise.class);
        startService(srvintent);
    }

    public void Home(View v){
        Intent intent =  new Intent(this,MainActivity.class);
        startActivity(intent);
        stopService(srvintent);
    }


    public void stopMusic(View v){
        Button btn = (Button)v;

        count++;
        if(count%2 == 1) {
            btn.setBackgroundResource(R.drawable.mute);
            stopService(srvintent);
        }else{
            btn.setBackgroundResource(R.drawable.volume);
            startService(srvintent);
        }
    }

    public void goQuestion1(View v){
        stopService(srvintent);

        Intent qintent = new Intent(this,question1.class);
        startActivity(qintent);
    }

    public void goQuestion2(View v){
        stopService(srvintent);

        Intent qintent = new Intent(this,question2.class);
        startActivity(qintent);
    }

    public void goQuestion3(View v){
        stopService(srvintent);

        Intent qintent = new Intent(this,question3.class);
        startActivity(qintent);
    }

    public void goQuestion4(View v){
        stopService(srvintent);

        Intent qintent = new Intent(this,question4.class);
        startActivity(qintent);
    }

    public void goQuestion5(View v){
        stopService(srvintent);

        Intent qintent = new Intent(this,question5.class);
        startActivity(qintent);
    }

    public void goQuestion6(View v){
        stopService(srvintent);

        Intent qintent = new Intent(this,question6.class);
        startActivity(qintent);
    }

    public void goQuestion7(View v){
        stopService(srvintent);

        Intent qintent = new Intent(this,question7.class);
        startActivity(qintent);
    }

    public void goQuestion8(View v){
        stopService(srvintent);

        Intent qintent = new Intent(this,question8.class);
        startActivity(qintent);
    }

    public void goShop(View v)
    {
        Button btn = (Button)v;
        ImageView img = (ImageView)findViewById(R.id.shImgView);

        img.setVisibility(View.VISIBLE);
        btn.setVisibility(View.INVISIBLE);
    }
}
