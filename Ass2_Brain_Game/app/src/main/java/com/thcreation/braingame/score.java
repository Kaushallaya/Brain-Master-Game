package com.thcreation.braingame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class score extends AppCompatActivity {
    public int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        SharedPreferences pref = getSharedPreferences("store",MODE_PRIVATE);
        int txti = pref.getInt("Hscore",0);
        String date = pref.getString("date","null");

        TextView dt = (TextView)findViewById(R.id.DtxtView);
        TextView sc = (TextView)findViewById(R.id.StxtView);
        sc.setText(""+txti);
        dt.setText(date);
    }

    public void back(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
