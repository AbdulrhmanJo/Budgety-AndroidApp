package com.example.android.budgety;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.autofill.AutofillValue;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

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



        for (int i = 0; i <s.length ; i++) {
            MaterialCardView card = new MaterialCardView(this);


            // Set the CardView layoutParams
            LayoutParams params = new LayoutParams(
                    LayoutParams.MATCH_PARENT,
                    LayoutParams.WRAP_CONTENT
            );

            params.setMargins(0,15,0,20);
            card.setLayoutParams(params);

            // Set CardView corner radius
            card.setRadius(9);

            // Set cardView content padding
            card.setContentPadding(15, 15, 15, 15);

            // Set a background color for CardView
//            card.setCardBackgroundColor(Color.parseColor("#FFC6D6C3"));

            // Set the CardView maximum elevation

            // Set CardView elevation
            card.setCardElevation(9);

            // Initialize a new TextView to put in CardView
            TextView tv = new TextView(this);
            tv.setLayoutParams(params);
            tv.setText(s[i]);
//            tv.setTextSize(30);
            tv.setTextColor(Color.RED);

            // Put the TextView in CardView
            card.addView(tv);

            // Finally, add the CardView in root layout
            container.addView(card);


        }


//        t
    }
}
