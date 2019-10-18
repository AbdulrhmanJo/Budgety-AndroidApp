package com.example.android.budgety;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.autofill.AutofillValue;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

public class Home_page extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        LinearLayout container = (LinearLayout) findViewById(R.id.transaction_container);

        String[] s = {"hello", "hi", "Well done", "Keep up the good work", "you can do it",
                "hello", "hi", "Well done", "Keep up the good work", "you can do it", "hello", "hi",
                "Well done", "Keep up the good work", "you can do it", "hello", "hi", "Well done",
                "Keep up the good work", "you can do it"};


        for (int i = 0; i <20 ; i++) {
            MaterialCardView b = new MaterialCardView(this);
            TextView v = new TextView(this);
            v.setText("Hello");
            v.setPadding(50,50,50,50);
            b.addView(v);
            container.addView(b);
        }


//        t
    }
}
