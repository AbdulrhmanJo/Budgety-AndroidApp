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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Nullable;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth fAuth;
    FirebaseFirestore firestore;
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
        firestore = FirebaseFirestore.getInstance();


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
                                    RetriveData(fAuth);


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


    public void RetriveData(FirebaseAuth firebaseAuth) {


        // ArrayList ListBudgets = new ArrayList();
        // firebaseAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        //Current user id
        final String UserID = firebaseAuth.getCurrentUser().getUid();

        // to get all budgets from the current user
        firestore.collection("users").document(UserID).collection("budgets").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

            List<String> list;


            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    //creating the array list that we will save budget  in
                    list = new ArrayList<>();

                    for (QueryDocumentSnapshot document : task.getResult()) {

                        list.add(document.getId());

                    }
                    Log.d("fragment_budget", list.toString());
                } else {
                    Log.d("fragment_budget", "Error getting documents: ", task.getException());
                }

                for (int i = 0; i < list.size(); i++) {

                    String BudgetID = list.get(i);

                    DocumentReference documentReference = firestore.collection("users").document(UserID).collection("budgets").document(BudgetID);


                    documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
                        @Override
                        public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {

                            //  String s = documentSnapshot.getString("current balance");
                            Double Target = Double.parseDouble(documentSnapshot.getString("target"));


                            Budget b = new Budget(documentSnapshot.getString("Budegt Name"), Target);
                            b.setCurrentBalance(documentSnapshot.getDouble("current balance"));
                            //addBudget(b);
                            MainActivity.account.AddBudget(b);

                            // System.out.println();
                            //System.out.println("THE BUDGET NAME  IS : " + documentSnapshot.getString("Budegt Name"));
                            //System.out.println("THE BUDGET GOAL  IS : " + documentSnapshot.getString("target"));
                            //System.out.println("THE BUDGET BALANCE  IS : " + documentSnapshot.getString("current balance"));
                            //System.out.println();


                        }
                    });


                }
            }


        });


    }


}
