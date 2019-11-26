package com.jaimie.water;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText edMonthly;
    private EditText edNextMonthly;
    boolean isNext = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edMonthly = findViewById(R.id.month);
     //   edNextMonthly = findViewById(R.id.next);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test();


            }
        });

        Switch sw = findViewById(R.id.sw);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isNext = isChecked;
                TextView text = findViewById(R.id.type);
                text.setText(isNext ? getString(R.string.every_other_month) : getString(R.string.monthly));
            }
        });

    }

    public void test (){
        String monthString = edMonthly.getText().toString();
        if (!TextUtils.isEmpty(monthString)){
            float degree = Float.parseFloat(monthString);
            float cost = 0;
            if (degree >= 1 && degree <11){
                cost = degree*7.35f;
            } else if (degree >= 11 && degree<31){
                cost = degree* 9.45f - 21;
            } else if (degree >= 31 && degree<51){
                cost = degree* 11.55f - 84;
            }else{
                cost = degree* 12.075f - 110.5f;
            }
//            new AlertDialog.Builder(this)
//                    .setTitle("month")
//                    .setMessage("fee" + cost)
//                    .setPositiveButton("OK", null)
//                    .show();

            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra(getString(R.string.extra_cost), cost);
            startActivity(intent);
        }

        /*else {
            String nextString = edNextMonthly.getText().toString();
            if (!TextUtils.isEmpty(nextString)){
                float degree = Float.parseFloat(monthString);
                float cost = 0;
                if (degree >= 1 && degree <21){
                    cost = degree*7.35f;
                } else if (degree >= 21 && degree<61){
                    cost = degree* 9.45f - 21;
                } else if (degree >= 61 && degree<101){
                    cost = degree* 11.55f - 84;
                }else{
                    cost = degree* 12.075f - 110.5f;
                }
//                new AlertDialog.Builder(this)
//                        .setTitle("隔月抄表費用")
//                        .setMessage("費用" + cost)
//                        .setPositiveButton("OK", null)
//                        .show();
            }

        }*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
