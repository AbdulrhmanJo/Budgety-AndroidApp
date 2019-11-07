package com.example.android.budgety;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Account extends Fragment {

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

        View view =  inflater.inflate(R.layout.fragment_account, container, false);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.account_toolbar);
        toolbar.setTitle(null);
        toolbar.setNavigationIcon(R.drawable.round_keyboard_backspace_24);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStackImmediate();
            }
        });


        return view;
    }



}