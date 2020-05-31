package com.thcreation.braingame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.thcreation.braingame.service.congratzServise;
import com.thcreation.braingame.service.failServise;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class question2 extends AppCompatActivity {
    public Intent cintent;
    public String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_two);
    }

    public void submit(View v){
        Button btn = (Button)v;

        ImageView cong = (ImageView)findViewById(R.id.congratzview);
        ImageView fail = (ImageView)findViewById(R.id.failview);
        Button play = (Button)findViewById(R.id.playBtn);
        Button home = (Button)findViewById(R.id.homeBtn);
        Button rst = (Button)findViewById(R.id.restartBtn);


        play.setVisibility(View.VISIBLE);
        home.setVisibility(View.VISIBLE);
        rst.setVisibility(View.VISIBLE);


            cong.setVisibility(View.VISIBLE);
            cintent = new Intent(this, congratzServise.class);
            startService(cintent);

        SharedPreferences pref = getSharedPreferences("store",MODE_PRIVATE);
        int txti = pref.getInt("number",0);
        txti = txti+50;

        SharedPreferences.Editor editor = getSharedPreferences("store",MODE_PRIVATE).edit();
        editor.putInt("number",txti);
        editor.commit();


    }

    public void Play(View v){
        Intent lintent = new Intent(this,level.class);
        startActivity(lintent);
        stopService(cintent);
    }

    public void Restart(View v){
        Intent Rintent = new Intent(this, question2.class);
        startActivity(Rintent);
        stopService(cintent);
    }

    public void Home(View v){
        Intent lintent = new Intent(this,MainActivity.class);
        startActivity(lintent);
        stopService(cintent);
    }

    public  void goHint(View v){
        Intent intent = new Intent(this,Hint_two.class);
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
