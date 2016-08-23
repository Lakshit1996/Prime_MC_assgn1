package com.example.lakshit.primeapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private static TextView cheat_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras=getIntent().getExtras();
        int number=extras.getInt("Number");
        int isPrime=extras.getInt("isPrime");

        cheat_text = (TextView) findViewById(R.id.cheat_text);
        if(isPrime==1)
            cheat_text.setText(number+" is a prime number");
        else
            cheat_text.setText(number+" is not a prime number");

    }
    @Override
    public void onBackPressed() {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("result","Cheat was taken");
        setResult(Activity.RESULT_OK,returnIntent);
        finish();

    }

}
