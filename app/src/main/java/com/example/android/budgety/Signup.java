package com.example.android.budgety;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
<<<<<<< HEAD
import android.widget.EditText;

public class Signup extends AppCompatActivity {


=======

public class Signup extends AppCompatActivity {

>>>>>>> 8e9a98b179b076941ea43d7dc8a3ad790080f97b
    public void openHomePage() {
        Intent intent = new Intent(this,Home_page.class);
        startActivity(intent);
    }

<<<<<<< HEAD


=======
>>>>>>> 8e9a98b179b076941ea43d7dc8a3ad790080f97b
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

<<<<<<< HEAD

        Button SignUp_Actions = (Button) findViewById(R.id.SignUp_Action);


    SignUp_Actions.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            openHomePage();
        }
    });
=======
        Button SignUp_Actions = (Button) findViewById(R.id.SignUp_Action);


        SignUp_Actions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePage();
            }
        });
>>>>>>> 8e9a98b179b076941ea43d7dc8a3ad790080f97b

    }



}
