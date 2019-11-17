package com.example.comp3606assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.Random;

public class CallbackActivity extends AppCompatActivity {
    private Button myButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callback);
        myButton = findViewById(R.id.button101);
        int num = new Random().nextInt(777);
        String returnVal = "CallBack returned value " + Integer.toString(num);
        Intent returnIntent = new Intent();
        returnIntent.putExtra("result", returnVal);
        setResult(Activity.RESULT_OK, returnIntent);
        myButton.setOnClickListener(new Button_Clicker());

        final TextView counttime = findViewById(R.id.counttime);
        new CountDownTimer(15000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                counttime.setText(String.valueOf(millisUntilFinished / 1000));
            }
            @Override
            public void onFinish() {
                myButton.setText("Going back...");
                counttime.setText("Finished");
                finish();
            }
        }.start();
    }

    class Button_Clicker implements Button.OnClickListener{
        @Override
        public  void onClick(View v){
            myButton.setText("Going back...");
            finish();
        }
    }

}
