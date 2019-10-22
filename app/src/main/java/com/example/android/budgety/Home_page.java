package com.example.android.budgety;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.autofill.AutofillValue;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.card.MaterialCardView;

public class Home_page extends AppCompatActivity {
    BottomSheetBehavior bottomSheetBehavior;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        //bottom bar navigation code
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new home()).commit();





        //I added this if statement to keep the selected fragment when rotating the device
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                    new home()).commit();
//        }


//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("");
//
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Home_page.this, AccountInformation.class);
//                startActivity(intent);
//            }
//        });


//        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.action_home:
//                        setContentView(R.layout.activity_home_page);
//                        break;
//                    case R.id.action_goal:
//                        setContentView(R.layout.activity_goal);
//                        break;
//                    case R.id.action_stat:
//                        setContentView(R.layout.activity_stat);
//                        break;
//                    case R.id.action_setting:
//                        setContentView(R.layout.activity__setting);
//                        break;
//                }
//                return true;
//            }
//        });


//        // TO SETTING
//        ImageButton SettingButton =(ImageButton)findViewById(R.id.Setting_ImageButton);
//        SettingButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Home_page.this,Activity_Setting.class);
//                startActivity(intent);
//            }
//        });
//
//
//        // TO GOAL
//        ImageButton GoalButton =(ImageButton)findViewById(R.id.Goal_ImageButton);
//        GoalButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Home_page.this,activity_goal.class);
//                startActivity(intent);
//            }
//        });
//        // TO STAT
//        ImageButton StatButton =(ImageButton)findViewById(R.id.Stat_ImageButton);
//        StatButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Home_page.this,activity_stat.class);
//                startActivity(intent);
//            }
//        });


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.action_home:
                            selectedFragment = new home();

                            break;
                        case R.id.action_setting:
                            selectedFragment = new setting();
                            break;

                        case R.id.action_add:
                            new BottomSheetListDialogFragment().show(getSupportFragmentManager(),"");
                            break;

                    }

                    if(selectedFragment != null){
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                selectedFragment).commit();
                    }


                    return true;
                }
            };


}
