package com.example.android.budgety;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Home_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        TextView elements = (TextView) findViewById(R.id.elements);

        String[] s = {"hello", "hi", "Well done", "Keep up the good work", "you can do it",
                "hello", "hi", "Well done", "Keep up the good work", "you can do it", "hello", "hi",
                "Well done", "Keep up the good work", "you can do it", "hello", "hi", "Well done",
                "Keep up the good work", "you can do it"};


        for (String ss : s) {
            elements.append("\n\n" + ss);
        }
    }
}
