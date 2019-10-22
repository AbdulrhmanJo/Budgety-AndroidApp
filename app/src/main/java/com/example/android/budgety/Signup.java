package com.example.android.budgety;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;






public class Signup extends AppCompatActivity {



    public void openHomePage() {
        Intent intent = new Intent(this,Home_page.class);
        startActivity(intent);
    }

    public void openSignIn() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        Button signIn = (Button) findViewById(R.id.signIn);
        Button SignUp_Actions = (Button) findViewById(R.id.SignUp_Action);


    SignUp_Actions.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            openHomePage();
        }
    });


        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignIn();
            }
        });


    }



}
