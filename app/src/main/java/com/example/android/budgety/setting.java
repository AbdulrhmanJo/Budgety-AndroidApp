package com.example.android.budgety;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;


public class setting extends Fragment{


    public setting() {
        // Required empty public constructor
    }


    public static setting newInstance(String param1, String param2) {
        setting fragment = new setting();

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

        View view = inflater.inflate(R.layout.fragment_setting, container, false);


        GridLayout gridLayout = (GridLayout) view.findViewById(R.id.mainGrid);

        setSingleEvent(gridLayout);

        return view;
    }

    private void setSingleEvent(GridLayout gridLayout) {
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            final MaterialCardView cardView = (MaterialCardView) gridLayout.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View view) {
                    cardView.setCardBackgroundColor(R.color.design_default_color_primary_dark);
                }
            });
        }
    }

}
