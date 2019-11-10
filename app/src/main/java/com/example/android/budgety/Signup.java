package com.example.android.budgety;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class Signup extends AppCompatActivity {

    static customerAccount account;
    FirebaseAuth fAuth;
    FirebaseFirestore firestore;
String UserId ;

    public void openHomePage() {
        Intent intent = new Intent(this, Home_page.class);
        startActivity(intent);
    }

    public void openSignIn() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        final TextView Email = (TextView) findViewById(R.id.Email_Signup);
        final TextView UserName = (TextView) findViewById(R.id.Username_Signup);
        final TextView Password = (TextView) findViewById(R.id.Password_Signup);
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar2);

        fAuth = FirebaseAuth.getInstance();
        firestore=FirebaseFirestore.getInstance();

        final Button signIn = (Button) findViewById(R.id.signIn);
        Button SignUp_Actions = (Button) findViewById(R.id.SignUp_Action);


        //  if(fAuth.getCurrentUser() != null){
        //    startActivity(new Intent(getApplicationContext(),Home_page.class));
        //  finish();
        //}


        SignUp_Actions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = Email.getText().toString().trim();
                String password = Password.getText().toString().trim();
                final String name = UserName.getText().toString();


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

                // register the user in firebase

                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Toast.makeText(Signup.this, "User Created.", Toast.LENGTH_SHORT).show();
                           UserId = fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = firestore.collection("users").document(UserId);
                            Map<String,Object> user = new HashMap<>();
                            user.put("Name" , name);
                            user.put("Email",email);
                            user.put("Current Balance" , 0);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d(null,"Customer success"+UserId);
                                }
                            });

                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        } else {
                            Toast.makeText(Signup.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                            progressBar.setVisibility(View.GONE);

                        }
                    }
                });
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
