package com.manroaaashni.custom_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Random;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button1;
    Button button2;
    Button color_change;
    Button bg_change;
    Button enter_button;
    TextView num1;
    TextView num2;
    TextView points_txt;
    TextView users_points;
    ConstraintLayout cl;
    int points;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    EditText editText;


    Random rand = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new_rand_numbers();
        sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.clear();
        //use shared pref to save user names and score?
        bg_change = findViewById(R.id.bg_button);
        bg_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cl = findViewById(R.id.cl);
                double rand_1 = rand.nextDouble();
                if (rand_1 < 0.2){
                    cl.setBackgroundColor(Color.LTGRAY);
                }
                else if (rand_1 >= 0.2 && rand_1 < 0.4){
                    cl.setBackgroundColor(Color.CYAN);
                }
                else if (rand_1 >= 0.4  && rand_1 <0.6){
                    cl.setBackgroundColor(Color.YELLOW);
                }
                else if (rand_1 >= 0.6  && rand_1 <0.8){
                    cl.setBackgroundColor(Color.MAGENTA);
                }
                else{
                    cl.setBackgroundColor(Color.BLUE);
                }
            }
        });

        editText = findViewById(R.id.editText);
        users_points = findViewById(R.id.users_points);
        enter_button = findViewById(R.id.enter_button);
        final String usernames = sharedPreferences.getString("usernames", "");
        final String points_list = sharedPreferences.getString("points_list", "");
        enter_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = editText.getText().toString();
                editText.setText(" ");

                StringBuilder sb = new StringBuilder();
                sb.append(usernames).append(",");
                sb.append(user).append(",");
                editor.putString("usernames", sb.toString());
                editor.apply();
                String[] usernames = sharedPreferences.getString("usernames", " ").split(",");

                StringBuilder sb_1 = new StringBuilder();
                sb_1.append(points_list).append(",");
                sb_1.append(points).append(",");
                System.out.println(sb_1.toString());
                points = 0;
                editor.putString("points_list", sb_1.toString());
                editor.apply();
                String[] points_list = sharedPreferences.getString("points_list", " ").split(",");

                String enter = "Previous Users:" + "\n";
                for (int i = 0; i< usernames.length; i++){
                    enter = enter + usernames[i] + "\n";
//                    enter = enter + usernames[i] + " " + points_list[i] + "\n";
                }
                users_points.setText(enter);
            }
        });

        color_change = findViewById(R.id.color_change);
        color_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1 = findViewById(R.id.button1);
                button2 = findViewById(R.id.button2);
                double rand_1 = rand.nextDouble();
                if (rand_1 < 0.2){
                    button1.setBackgroundColor(getResources().getColor(R.color.purple));
                    button2.setBackgroundColor(getResources().getColor(R.color.purple));
                }
                else if (rand_1 >= 0.2 && rand_1 < 0.4){
                    button1.setBackgroundColor(getResources().getColor(R.color.bright_green));
                    button2.setBackgroundColor(getResources().getColor(R.color.bright_green));
                }
                else if (rand_1 >= 0.4  && rand_1 <0.6){
                    button1.setBackgroundColor(getResources().getColor(R.color.blue));
                    button2.setBackgroundColor(getResources().getColor(R.color.blue));
                }
                else if (rand_1 >= 0.6  && rand_1 <0.8){
                    button1.setBackgroundColor(getResources().getColor(R.color.salmon));
                    button2.setBackgroundColor(getResources().getColor(R.color.salmon));
                }
                else{
                    button1.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                    button2.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                }
            }
        });

        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button2 = findViewById(R.id.button2);
                num1 = findViewById(R.id.num1);
                num2 = findViewById(R.id.num2);
                points_txt = findViewById(R.id.points_txt);
                points = sharedPreferences.getInt("points", 0);
                int val1 = Integer.parseInt((num1.getText()).toString());
                int val2 = Integer.parseInt((num2.getText()).toString());
                if (val1 >= val2){
                    points++;
                    points_txt.setText("Points: " + points);
                    Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
                }
                else{
                    points--;
                    points_txt.setText("Points: " + points);
                    Toast.makeText(getApplicationContext(), "Incorrect!", Toast.LENGTH_SHORT).show();
                }
                editor.putInt("points", points);
                editor.apply();
                new_rand_numbers();
            }
        });

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1 = findViewById(R.id.button1);
                num1 = findViewById(R.id.num1);
                num2 = findViewById(R.id.num2);
                points_txt = findViewById(R.id.points_txt);
                int val1 = Integer.parseInt((num1.getText()).toString());
                int val2 = Integer.parseInt((num2.getText()).toString());
                points  = sharedPreferences.getInt("points", 0);
                if (val1 <= val2){
                    points++;
                    points_txt.setText("Points: " + points);
                    Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
                }
                else{
                    points--;
                    points_txt.setText("Points: " + points);
                    Toast.makeText(getApplicationContext(), "Incorrect!", Toast.LENGTH_SHORT).show();
                }
                editor.putInt("points", points);
                editor.apply();
                new_rand_numbers();
            }
        });
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
