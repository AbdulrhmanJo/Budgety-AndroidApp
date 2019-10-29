package com.example.android.budgety;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

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
                        case R.id.action_goal:

                            selectedFragment = new fragment_budget();
                            break;
                        case R.id.action_stat:
                            selectedFragment = new fragment_Statistics();
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
