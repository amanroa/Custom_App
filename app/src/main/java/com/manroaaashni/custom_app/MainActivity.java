package com.manroaaashni.custom_app;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button1;
    Button button2;
    TextView num1;
    TextView num2;
    TextView points_txt;
    int points;

    Random rand = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //use shared pref to save usernames and score?
    }
    public void color_change(){
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        double rand_1 = rand.nextDouble();
        if (rand_1 < 0.3){
            button1.setBackgroundColor(getResources().getColor(R.color.purple));
            button2.setBackgroundColor(getResources().getColor(R.color.purple));
        }
        else if (rand_1 >= 0.3  && rand_1 <0.6){
            button1.setBackgroundColor(getResources().getColor(R.color.blue));
            button2.setBackgroundColor(getResources().getColor(R.color.blue));
        }
        else{
            button1.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
            button2.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }
    public void button_1_clicked(){
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        points_txt = findViewById(R.id.points_txt);
        int val1 = Integer.parseInt((num1.getText()).toString());
        int val2 = Integer.parseInt((num2.getText()).toString());
        if (val1 >= val2){
            points++;
            points_txt.setText("Points: " + points);
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        }
        else{
            points--;
            points_txt.setText("Points: " + points);
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show();

        }
    }
    public void button_2_clicked(){
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        points_txt = findViewById(R.id.points_txt);
        int val1 = Integer.parseInt((num1.getText()).toString());
        int val2 = Integer.parseInt((num2.getText()).toString());
        if (val1 <= val2){
            points++;
            points_txt.setText("Points: " + points);
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        }
        else{
            points--;
            points_txt.setText("Points: " + points);
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show();

        }
    }
    public void new_rand_numbers(){
        int rand_num_1 = (int) (Math.random()*(10 - 1)) + 1;
        int rand_num_2 = (int) (Math.random()*(10 - 1)) + 1;
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        num1.setText(Integer.toString(rand_num_1));
        num2.setText(Integer.toString(rand_num_2));
    }

}
