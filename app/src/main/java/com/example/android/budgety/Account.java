package com.example.android.budgety;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;


public class Account extends Fragment {
    FirebaseFirestore firestore;
    FirebaseAuth firebaseAuth;
    static String name;
    static  String Email ;

    public Account() {

        // Required empty public constructor
    }


    public static Account newInstance() {

        Account fragment = new Account();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_account, container, false);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.account_toolbar);
        toolbar.setTitle(null);
        toolbar.setNavigationIcon(R.drawable.round_keyboard_backspace_24);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStackImmediate();
            }
        });

        TextView IN = (TextView) view.findViewById(R.id.TotalINCOME);
        int income = (int) MainActivity.account.getIncome();
        System.out.println("INCOME IS " + income);
        IN.setText(income + " $ ");


        TextView OUT = (TextView) view.findViewById(R.id.TotalOUT);
        int out = (int) MainActivity.account.getExpenses();
        System.out.println("INCOME IS " + income);
        OUT.setText(out + " $ ");


        final EditText MyName = (EditText) view.findViewById(R.id.Name_Acc_Setting);
        final EditText MyEmail = (EditText) view.findViewById(R.id.Email_Acc_Setting);

        firebaseAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        //Current user id
        final String UserID = firebaseAuth.getCurrentUser().getUid();
        //Setup the Reference from database
        final DocumentReference documentReference = firestore.collection("users").document(UserID);

        documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document != null) {

                        name = document.getString("Name");
                        Email= document.getString("Email");
                        MyName.setText(name + " ");
                        MyEmail.setText(Email+" ");
                        System.out.println("NAME " + name);

                    } else {
                        Log.d("LOGGER", "No such document");
                    }
                } else {
                    Log.d("LOGGER", "get failed with ", task.getException());
                }
            }

        });


        return view;
    }





}