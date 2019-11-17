package com.example.comp3606assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class QuizActivity extends AppCompatActivity {

    Button quizT;
    String fileName = "high_scores.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        quizT = (Button) findViewById(R.id.buttonF);
    }

    public void saveFile(String file, String text){
        try{
            FileOutputStream fos = openFileOutput(file, Context.MODE_PRIVATE);
            fos.write(text.getBytes());
            Toast.makeText(this, "Saved!!", Toast.LENGTH_SHORT).show();
        }
        catch(Exception e){
            e.printStackTrace();
            Toast.makeText(this, "Error saving file!!!", Toast.LENGTH_SHORT).show();
        }
    }

    public  String readFile(String file){
        String text = "";
        try{
            FileInputStream fis = openFileInput(file);
            int size = fis.available();
            byte[] buffer = new byte[size];
            fis.read(buffer);
            fis.close();
            text = new String(buffer);
        }catch(Exception e){
            e.printStackTrace();
            Toast.makeText(this, "Error reading file!", Toast.LENGTH_SHORT).show();
        }
        return text;
    }

    public  void  saveMe(){
    }


    public void calculate(View view){
        if(view == quizT){
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
            readFile(fileName);
            doCalculations();
        }
    }
    public  void  doCalculations(){
        EditText Question1;
        EditText Question2;
        EditText Question3;
        EditText Question4;
        EditText Question5;
        EditText mEdit;

        int score1 = 0;
        int score2 = 0;
        int score3 = 0;
        int score4 = 0;
        int score5 = 0;

        String ans1;
        String ans2;
        String ans3;
        String ans4;
        String ans5;

        Question1 = (EditText) findViewById(R.id.editText);
        ans1 = Question1.getText().toString();

        if(ans1.equals("Button")){
            score1 =  1;
        }

        Question2 = (EditText) findViewById(R.id.editText2);
        ans2 = Question2.getText().toString();

        if(ans2.equals("Spinner")){
            score2 =  1;
        }

        Question3 = (EditText) findViewById(R.id.editText3);
        ans3 = Question3.getText().toString();

        if(ans3.equals("ImageView")){
            score3 =  1;
        }

        Question4 = (EditText) findViewById(R.id.editText4);
        ans4 = Question4.getText().toString();

        if(ans4.equals("Toast")){
            score4 =  1;
        }

        Question5 = (EditText) findViewById(R.id.editText5);
        ans5 = Question5.getText().toString();

        if(ans5.equals("EditText")){
            score5 =  1;
        }

        int finalscore = score1+score2+score3+score4+score5;
        String f = String.valueOf(finalscore);
        mEdit = (EditText) findViewById(R.id.editText7);

        mEdit.setText(f + "");
        mEdit = (EditText) findViewById(R.id.editText8);
        mEdit.setText(readFile(fileName));
        saveFile(fileName,f);
    }
}
