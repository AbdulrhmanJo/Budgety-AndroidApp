package com.example.android.budgety;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.FragmentManager;

public class WrongPassword extends AppCompatDialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

        builder.setTitle("Wrong Password !").setMessage("the password you have entered is not correct..").setPositiveButton("ok", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialogInterface, int i) {




            }
        });

return builder.create();


    }
}
