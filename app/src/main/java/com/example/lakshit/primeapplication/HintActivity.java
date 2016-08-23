package com.example.lakshit.primeapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class HintActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView hint_text = (TextView) findViewById(R.id.hint_text);
        hint_text.setText("A prime number is a natural number greater than 1 that has no positive divisors other than 1 and itself.");

    }
    @Override
    public void onBackPressed() {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("result", "Hint was taken");
        setResult(Activity.RESULT_OK, returnIntent);
        finish();

    }




}
