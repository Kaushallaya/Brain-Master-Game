package com.thcreation.braingame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Hint_eight extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint_eight);
    }

    public void back(View v){
        Intent Rintent = new Intent(this,question8.class);
        startActivity(Rintent);
    }
}
