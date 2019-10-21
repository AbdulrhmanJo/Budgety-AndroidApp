package com.example.android.budgety;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

public class AccountInformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_information);

        Toolbar toolbar1 = (Toolbar) findViewById(R.id.Account_toolbar);
        setSupportActionBar(toolbar1);
        getSupportActionBar().setTitle("Account Information");


        toolbar1.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_home_page);
            }
        });

    }
}
