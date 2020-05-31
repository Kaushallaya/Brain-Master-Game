package com.thcreation.braingame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Hint_one extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint_one);
    }

    public void back(View v){
        Intent Rintent = new Intent(this,question1.class);
        startActivity(Rintent);
    }
}
