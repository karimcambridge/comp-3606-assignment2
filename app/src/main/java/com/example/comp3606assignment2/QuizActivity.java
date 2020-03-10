package com.example.comp3606assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class QuizActivity extends AppCompatActivity {
    Button quizButton, goBackButton;
    String fileName = "high_scores.txt";
    String prevScore = "NONE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        quizButton = (Button) findViewById(R.id.quizButton);
        goBackButton = (Button) findViewById(R.id.goBackButton);
    }

    public void saveFile(String file, String text){
        try {
            FileOutputStream fos = openFileOutput(file, Context.MODE_PRIVATE);
            fos.write(text.getBytes());
            Toast.makeText(this, "Saved!!", Toast.LENGTH_SHORT).show();
        }
        catch(Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error saving file!!!", Toast.LENGTH_SHORT).show();
        }
    }

    public String readFile(String file){
        String text = "";
        try {
            FileInputStream fis = openFileInput(file);
            int size = fis.available();
            byte[] buffer = new byte[size];
            fis.read(buffer);
            fis.close();
            text = new String(buffer);
        }
        catch(Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error reading file!", Toast.LENGTH_SHORT).show();
        }
        return text;
    }

    public void calculateQuiz(View view) {
        if(view == quizButton) {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
            readFile(fileName);
            answerQuiz();
        }
    }

    public void answerQuiz(){
        EditText Question1, Question2, Question3, Question4, Question5, mEdit;
        String ans1, ans2, ans3, ans4, ans5, finalScoreStr;
        int score1 = 0, score2 = 0, score3 = 0, score4 = 0, score5 = 0, finalscore;

        Question1 = (EditText) findViewById(R.id.editText);
        ans1 = Question1.getText().toString();

        if(ans1.equalsIgnoreCase("Button")){
            score1 =  1;
        }

        Question2 = (EditText) findViewById(R.id.editText2);
        ans2 = Question2.getText().toString();

        if(ans2.equalsIgnoreCase("Spinner")){
            score2 =  1;
        }

        Question3 = (EditText) findViewById(R.id.editText3);
        ans3 = Question3.getText().toString();

        if(ans3.equalsIgnoreCase("ImageView")){
            score3 =  1;
        }

        Question4 = (EditText) findViewById(R.id.editText4);
        ans4 = Question4.getText().toString();

        if(ans4.equalsIgnoreCase("Toast")){
            score4 =  1;
        }

        Question5 = (EditText) findViewById(R.id.editText5);
        ans5 = Question5.getText().toString();

        if(ans5.equalsIgnoreCase("EditText")){
            score5 =  1;
        }

        finalscore = score1 + score2 + score3 + score4 + score5;
        finalScoreStr = String.valueOf(finalscore);
        mEdit = (EditText) findViewById(R.id.editText7);

        mEdit.setText(finalScoreStr);
        mEdit = (EditText) findViewById(R.id.editText8);
        //mEdit.setText(readFile(fileName));
        mEdit.setText(prevScore);
        prevScore = finalScoreStr;
        saveFile(fileName, finalScoreStr);
    }

    public void goBack(View view) {
        if(view == goBackButton) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    }
}
