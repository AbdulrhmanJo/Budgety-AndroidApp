package com.example.android.budgety;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


public class fragment_budget extends Fragment {

    public fragment_budget() {

        // Required empty public constructor
    }


    public static fragment_budget newInstance() {

        fragment_budget fragment = new fragment_budget();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_fragment_budget, container, false);

        Button icon =  (Button) view.findViewById(R.id.add_budget);

        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new addBudget().show(getFragmentManager(),"");
            }
        });

        return view;
    }




}