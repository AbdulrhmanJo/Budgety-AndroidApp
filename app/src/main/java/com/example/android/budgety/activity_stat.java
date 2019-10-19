package com.example.android.budgety;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class activity_stat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stat);



        // TO HOME
        ImageButton HomeButton =(ImageButton)findViewById(R.id.Home_ImageButton);
        HomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_stat.this,Home_page.class);
                startActivity(intent);
            }
        });

        // TO GOAL
        ImageButton GoalButton =(ImageButton)findViewById(R.id.Goal_ImageButton);
        GoalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_stat.this,activity_goal.class);
                startActivity(intent);
            }
        });

        // TO SETTING
        ImageButton SettingButton =(ImageButton)findViewById(R.id.Setting_ImageButton);
        SettingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity_stat.this,Activity_Setting.class);
                startActivity(intent);
            }
        });


    }
}
