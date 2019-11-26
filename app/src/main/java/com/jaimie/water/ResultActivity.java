package com.jaimie.water;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
//      Intent intent = getIntent();
        float cost = getIntent().getFloatExtra("COST", -1);
        Log.d("ResultActivity", cost + "");
        TextView feeText = findViewById(R.id.fee);
        int n = (int)(cost + 0.5f);
        feeText.setText(n + "");
    }
}
