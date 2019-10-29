package com.example.android.budgety;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class fragment_Statistics extends Fragment {

    public fragment_Statistics() {

        // Required empty public constructor
    }


    public static fragment_Statistics newInstance() {

        fragment_Statistics fragment = new fragment_Statistics();

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




        return inflater.inflate(R.layout.fragment__statistics, container, false);
    }




}