package com.thcreation.braingame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Hint_three extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint_three);
    }

    public void back(View v){
        Intent Rintent = new Intent(this,question3.class);
        startActivity(Rintent);
    }
}
