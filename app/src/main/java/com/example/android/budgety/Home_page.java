package com.example.android.budgety;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.autofill.AutofillValue;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

import com.google.android.material.card.MaterialCardView;

public class Home_page extends AppCompatActivity {


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)



    public void OpenSetting(){
        Intent intent = new Intent(Home_page.this,Activity_Setting.class);
        startActivity(intent);
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        // TO SETTING
        ImageButton SettingButton =(ImageButton)findViewById(R.id.Setting_ImageButton);
        SettingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_page.this,Activity_Setting.class);
                startActivity(intent);
            }
        });


        // TO GOAL
        ImageButton GoalButton =(ImageButton)findViewById(R.id.Goal_ImageButton);
        GoalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_page.this,activity_goal.class);
                startActivity(intent);
            }
        });
        // TO STAT
        ImageButton StatButton =(ImageButton)findViewById(R.id.Stat_ImageButton);
        StatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_page.this,activity_stat.class);
                startActivity(intent);
            }
        });



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

            LayoutParams params2 = new LayoutParams(
                    LayoutParams.MATCH_PARENT,
                    LayoutParams.WRAP_CONTENT
            );

            params2.setMargins(0,0,10,0);
            params.setMargins(0,15,0,20);

            card.setLayoutParams(params);

            // Set CardView corner radius
            card.setRadius(9);

            // Set cardView content padding
            card.setContentPadding(50, 50, 50, 50);

            // Set a background color for CardView
//            card.setCardBackgroundColor(Color.parseColor("#FFC6D6C3"));

            // Set the CardView maximum elevation

            // Set CardView elevation
            card.setCardElevation(5);

            // Initialize a new TextView to put in CardView
            LinearLayout linearLayout = new LinearLayout(this);

            ImageView img = new ImageView(this);
//            img.setLayoutParams(params2);
            img.setImageResource(R.drawable.round_keyboard_arrow_up_24);
            img.setScaleX(1.6f);
            img.setScaleY(1.6f);
            img.setImageTintList(ColorStateList.valueOf(Color.RED));
            TextView tv = new TextView(this);

            tv.setText(s[i]);
//            tv.setTextSize(30);
            tv.setTextColor(Color.RED);

            linearLayout.addView(img);
            linearLayout.addView(tv);



            // Put the TextView in CardView
            card.addView(linearLayout);

            // Finally, add the CardView in root layout
            container.addView(card);


        }


//        t
    }
}
