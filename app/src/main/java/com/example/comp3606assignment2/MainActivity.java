package com.example.comp3606assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageButton introButton, guiButton, quizButton;
    private Button intentsButton, paper1Button, paper2Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        introButton = (ImageButton) findViewById(R.id.introButton);
        guiButton = (ImageButton) findViewById(R.id.guiButton);
        quizButton = (ImageButton) findViewById(R.id.quizButton);

        intentsButton = (Button) findViewById(R.id.intentsButton);
        paper1Button = (Button) findViewById(R.id.paper1Button);
        paper2Button = (Button) findViewById(R.id.paper2Button);

        intentsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processIntentsCallback();
            }
        });
        paper1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        paper2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });
    }

    public void onImageButtonClick(View view) {
        if(view == introButton) {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
            openIntro();
        }
        else if(view == guiButton) {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
            openGUI();
        }
        else if(view == quizButton) {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
            openQuiz();
        }
    }

    public void processIntentsCallback() {
        Intent intent = new Intent(getApplicationContext(), CallbackActivity.class);
        startActivityForResult(intent, 1);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1){
            if(resultCode == Activity.RESULT_OK){
                String result = data.getStringExtra("result");
                Toast.makeText(MainActivity.this, "Callback Screen Data: " + result, Toast.LENGTH_LONG).show();
            }
            else if(resultCode == Activity.RESULT_CANCELED){
                Toast.makeText(this, "Return was cancelled.", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void openIntro() {
        Intent intent = new Intent(this, IntroActivity.class);
        startActivity(intent);
    }

    public void openGUI() {
        Intent intent = new Intent(this, GUIActivity.class);
        startActivity(intent);
    }

    public void openQuiz() {
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
    }

    public void openActivity2() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void openActivity3() {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }
}