package com.example.lakshit.primeapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class PrimeActivity extends AppCompatActivity {


    private static TextView text_ques;
    private int number;
    private int isPrime;

    private static final String TAG = "PrimeActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Press NEXT for the new question", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        onButtonClickListener();
    }

    @SuppressLint("SetTextI18n")
    private void onButtonClickListener()
    {
        Button true_button,false_button,next_button;
        number=randInt();
        isPrime=isPrimeNumber(number);


        true_button = (Button) findViewById(R.id.true_button);
        false_button = (Button) findViewById(R.id.false_button);
        next_button = (Button) findViewById(R.id.next_button);
        text_ques = (TextView) findViewById(R.id.ques_textView);
        text_ques.setText("Is "+number+" a prime number?");

        next_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.d(TAG, "Clicked Next");
                number=randInt();
                isPrime=isPrimeNumber(number);
                text_ques.setText("Is "+number+" a prime number?.");
            }
        });
        true_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.d(TAG, "Clicked True");
                if(isPrime==1)
                {
                    Toast.makeText(PrimeActivity.this,"   Your answer in Correct\n" +
                            "Press NEXT for new question",Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(PrimeActivity.this,"   Your answer in Incorrect\n"+"Press NEXT for new question",Toast.LENGTH_SHORT).show();


            }
        });
        false_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.d(TAG, "Clicked False");
                if(isPrime==0)
                {
                    Toast.makeText(PrimeActivity.this,"   Your answer in Correct\n" +
                            "Press NEXT for new question",Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(PrimeActivity.this,"   Your answer in Incorrect\n" +
                            "Press NEXT for new question",Toast.LENGTH_SHORT).show();

            }
        });
    }
    private int isPrimeNumber(int number) {

        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return 0;
            }
        }
        return 1;
    }


    private int randInt()
    {
        Random r = new Random();
        return r.nextInt(1000 - 1) + 1;
    }


        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_prime, menu);
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

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "Inside onSaveInstance");
    }

    @Override
    public void onStart()
    {
        super.onStart();
        Log.d(TAG, "Inside OnStart");
    }

    @Override
    public void onPause()
    {
        super.onPause();
        Log.d(TAG,"Inside OnPause");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"Inside OnResume");

    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG, "Inside OnStop");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Inside OnDestroy");
    }
}
