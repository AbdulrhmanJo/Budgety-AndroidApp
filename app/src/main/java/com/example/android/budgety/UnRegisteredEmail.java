package com.example.android.budgety;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.lang.reflect.Method;

public class UnRegisteredEmail extends AppCompatDialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

        builder.setTitle("Unregistered Email  !").setMessage("the email you have entered is not registered in our system...").setPositiveButton("ok", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialogInterface, int i) {


           //    Method[] methods = MainActivity.class.getMethods();
            //    System.out.println(methods.length);
           //     System.out.println(methods[0].setAccessible(true));



            }
        });

        return builder.create();


    }

}
