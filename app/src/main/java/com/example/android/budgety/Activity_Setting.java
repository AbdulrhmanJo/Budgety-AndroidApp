package com.example.android.budgety;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Activity_Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__setting);


        // TO HOME
        ImageButton HomeButton =(ImageButton)findViewById(R.id.Home_ImageButton);
        HomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Setting.this,Home_page.class);
                startActivity(intent);
            }
        });


        // TO STAT
        ImageButton StatButton =(ImageButton)findViewById(R.id.Stat_ImageButton);
        StatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Setting.this,activity_stat.class);
                startActivity(intent);
            }
        });

        // TO GOAL
        ImageButton GoalButton =(ImageButton)findViewById(R.id.Goal_ImageButton);
        GoalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Setting.this,activity_goal.class);
                startActivity(intent);
            }
        });










    }
}
