package com.example.android.budgety;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.lang.reflect.Method;

public class UnRegisteredEmail extends AppCompatDialogFragment {

MainActivity m;
    UnRegisteredEmail(MainActivity mm){
        m=mm;


    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("Unregistered Email  !").setMessage("the email you have entered is not registered in our system...");



        builder.setPositiveButton("SignUp", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialogInterface, int i) {

               m.OpenSignUp();
            }

        });

        builder.setNegativeButton("OK",null);
    






        return builder.create();


    }

}
