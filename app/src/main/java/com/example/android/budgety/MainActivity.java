package com.example.android.budgety;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static customerAccount account;
    public void openHomePage() {
        Intent intent = new Intent(this,Home_page.class);
        startActivity(intent);
    }

    public void OpenSignUp(){
        Intent intent = new Intent(this,Signup.class);
        startActivity(intent);
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
UnRegisteredEmail u = new UnRegisteredEmail(MainActivity.this);

        Button signIn = (Button) findViewById(R.id.sing_in);
        Button SignUp =(Button) findViewById(R.id.signup);





        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                EditText Email = (EditText) findViewById(R.id.Email_SignIn) ;
                String Str_Email = Email.getText().toString();

                EditText Password= (EditText) findViewById(R.id.password_SignIn);
                String Str_Password = Password.getText().toString();



                if(Str_Email.equalsIgnoreCase("ray")){


                    if(Str_Password.equals("123")){

                        openHomePage();
                        account = new customerAccount();

                    }else{
                        WrongAnswerDialog();
                    }



                }else{
                    UnregisteredEmail();
                }


            }
        });

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenSignUp();
            }
        });



    }

    public void WrongAnswerDialog(){

        WrongPassword WP =new WrongPassword();
        WP.show(getSupportFragmentManager(),"wrong entery");



    }

    public void UnregisteredEmail(){

        UnRegisteredEmail UE =new UnRegisteredEmail(MainActivity.this);
        UE.show(getSupportFragmentManager(),"wrong email");
    }



}
