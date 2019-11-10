package com.example.android.budgety;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth fAuth;
    static customerAccount account;

    public void openHomePage() {
        Intent intent = new Intent(this, Home_page.class);
        startActivity(intent);
    }

    public void OpenSignUp() {
        Intent intent = new Intent(this, Signup.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UnRegisteredEmail u = new UnRegisteredEmail(MainActivity.this);

        final Button signIn = (Button) findViewById(R.id.sing_in);
        final Button SignUp = (Button) findViewById(R.id.signup);

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        fAuth = FirebaseAuth.getInstance();

        //  if(fAuth.getCurrentUser()!=null){
        //openHomePage();
        //}

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final EditText Email = (EditText) findViewById(R.id.Email_Signup);

                final EditText Password = (EditText) findViewById(R.id.Password_Signup);


                String email = Email.getText().toString().trim();
                String password = Password.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Email.setError("Email is Required.");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Password.setError("Password is Required.");
                    return;
                }

                if (password.length() < 6) {
                    Password.setError("Password Must be >= 6 Characters");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                // authenticate the user


                fAuth.signInWithEmailAndPassword(email, password).

                        addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(MainActivity.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                                    openHomePage();
                                    account = new customerAccount();

                                } else {
                                    Toast.makeText(MainActivity.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    progressBar.setVisibility(View.GONE);
                                }

                            }
                        });


            }
        });


        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenSignUp();
            }
        });


    }


    public void automatic() {
        fAuth = FirebaseAuth.getInstance();
        if (fAuth.getCurrentUser() != null) {
            System.out.println("im here");
            System.out.println(fAuth.getCurrentUser().getEmail());
            account = new customerAccount();
            openHomePage();

        }
    }


}
