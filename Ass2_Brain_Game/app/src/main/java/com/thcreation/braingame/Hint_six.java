package com.thcreation.braingame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Hint_six extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint_six);
    }

    public void back(View v){
        Intent Rintent = new Intent(this,question6.class);
        startActivity(Rintent);
    }
}
