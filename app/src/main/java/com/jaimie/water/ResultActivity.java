package com.jaimie.water;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private static final String TAG = ResultActivity.class.getSimpleName();
    private static final float DEFAULT_FEE = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
//      Intent intent = getIntent();
        float cost = getIntent().getFloatExtra(getString(R.string.extra_cost), DEFAULT_FEE);
        Log.d(TAG, cost + "");
        Log.d("ResultActivity", cost + "");
        TextView feeText = findViewById(R.id.fee);
        int n = (int)(cost + 0.5f);
        feeText.setText(n + "");
    }
}
