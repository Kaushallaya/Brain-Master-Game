package com.thcreation.braingame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.thcreation.braingame.service.congratzServise;
import com.thcreation.braingame.service.failServise;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class question1 extends AppCompatActivity {
    public Intent cintent;
    public Intent fintent;
    public String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionone);
    }

    public void submit(View v){
        Button btn = (Button)v;
        EditText input = findViewById(R.id.answer);

        String txt = input.getText().toString();
        int num = Integer.parseInt(txt);


        ImageView cong = (ImageView)findViewById(R.id.congratzview);
        ImageView fail = (ImageView)findViewById(R.id.failview);
        Button play = (Button)findViewById(R.id.playBtn);
        Button home = (Button)findViewById(R.id.homeBtn);
        Button rst = (Button)findViewById(R.id.restartBtn);


        btn.setVisibility(View.INVISIBLE);
        play.setVisibility(View.VISIBLE);
        home.setVisibility(View.VISIBLE);
        rst.setVisibility(View.VISIBLE);

        if(num == 0){
            cong.setVisibility(View.VISIBLE);
            cintent = new Intent(this,congratzServise.class);
            startService(cintent);

            SharedPreferences pref = getSharedPreferences("store",MODE_PRIVATE);
            int txti = pref.getInt("number",0);
            txti = txti+50;

            SharedPreferences.Editor editor = getSharedPreferences("store",MODE_PRIVATE).edit();
            editor.putInt("number",txti);
            editor.commit();
        }
        else {
            fail.setVisibility(View.VISIBLE);
            fintent = new Intent(this,failServise.class);
            startService(fintent);
        }

    }

    public void Play(View v){
        Intent lintent = new Intent(this,level.class);
        startActivity(lintent);
        stopService(cintent);
        stopService(fintent);
    }

    public void Restart(View v){
        Intent Rintent = new Intent(this,question1.class);
        startActivity(Rintent);
        stopService(cintent);
        stopService(fintent);
    }

    public void Home(View v){
        Intent lintent = new Intent(this,MainActivity.class);
        startActivity(lintent);
        stopService(cintent);
        stopService(fintent);
    }

    public  void goHint(View v){
        Intent intent = new Intent(this,Hint_one.class);
        startActivity(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences pref = getSharedPreferences("store",MODE_PRIVATE);
        int score = pref.getInt("Hscore",0);
        int num = pref.getInt("number",0);

        if(num >= score ){
            SharedPreferences.Editor editor = getSharedPreferences("store",MODE_PRIVATE).edit();
            editor.putInt("Hscore",num);
            editor.putString("Date",date);
            editor.commit();
        }
    }
}
