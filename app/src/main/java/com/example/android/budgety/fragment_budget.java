package com.example.android.budgety;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textfield.TextInputEditText;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class fragment_budget extends Fragment {
    BudgetCardRecyclerViewAdapter myAdapter;

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

        View view = inflater.inflate(R.layout.fragment_fragment_budget, container, false);

        Button newBudget = (Button) view.findViewById(R.id.new_budget);
        newBudget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new addBudget().show(getFragmentManager(), "");
            }
        });


        final Toolbar toolbar = (Toolbar) view.findViewById(R.id.Budget_toolbar);
        toolbar.setTitle(null);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container,
                        new Account()).commit();
                ft.addToBackStack(null);
            }
        });


        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.notfication_icon:
                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.fragment_container,
                                new notification()).commit();
                        ft.addToBackStack(null);
                        break;
                }
                return true;
            }
        });


        RecyclerView mRecyclerView = view.findViewById(R.id.recycler_view);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(getActivity(), 1);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        myAdapter = new BudgetCardRecyclerViewAdapter(MainActivity.account.getBudgets());
        mRecyclerView.setAdapter(myAdapter);


        TextView totalSavings = view.findViewById(R.id.total_Savings);
        totalSavings.setText(NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(MainActivity.account.getTotalSavings()));


        return view;
    }


    public void addBudget(Budget budget) {
        MainActivity.account.AddBudget(budget);
        myAdapter.notifyItemInserted(0);

    }


}