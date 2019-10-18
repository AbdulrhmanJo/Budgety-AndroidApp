package com.example.android.budgety;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView elements;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        elements = (TextView) findViewById(R.id.elements);

        String [] s = {"hello","hi", "Well done", "Keep up the good work", "you can do it","hello","hi", "Well done", "Keep up the good work", "you can do it","hello","hi", "Well done", "Keep up the good work", "you can do it","hello","hi", "Well done", "Keep up the good work", "you can do it"};


        for (String ss: s) {
            elements.append("\n\n"+ss);
        }


    }

//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.bottom_nav_menu, menu);
//        return true;
//    }

}
