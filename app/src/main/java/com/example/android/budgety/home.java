package com.example.android.budgety;


import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import com.google.android.material.chip.ChipGroup;

import java.text.NumberFormat;
import java.util.Locale;


public class home extends Fragment {

    TransactionCardRecyclerViewAdapter myAdapter;

    public home() {
        // Required empty public constructor
    }


    public static home newInstance() {
        home fragment = new home();
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

        final View view = inflater.inflate(R.layout.fragment_home, container, false);
        updateHeader(view);
        final Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setTitle(null);
        toolbar.setNavigationIcon(R.drawable.round_account_circle_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_container,
                        new Account()).commit();
                ft.addToBackStack("homePage");
            }
        });

        toolbar.inflateMenu(R.menu.top_nav_menu);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.notfication_icon:
                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.fragment_container,
                                new notification()).commit();
                        ft.addToBackStack("homePage");
                        break;
                }
                return true;
            }
        });

        final HorizontalScrollView horizontalScrollView = (HorizontalScrollView) view.findViewById(R.id.month_navigation_bar);
        horizontalScrollView.post(new Runnable() {

            @Override
            public void run() {
                ChipGroup group = view.findViewById(R.id.chip_group);
                horizontalScrollView.smoothScrollTo(group.getChildAt(11).getLeft(), 0);
            }

        });

        RecyclerView mRecyclerView = view.findViewById(R.id.recycler_view);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(getActivity(), 1);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        myAdapter = new TransactionCardRecyclerViewAdapter(MainActivity.account.getTransactions());
        mRecyclerView.setAdapter(myAdapter);
        return view;
    }


    public void updateHeader(View view){
        TextView currentBalance = view.findViewById(R.id.CurrentBalance);
        currentBalance.setText(NumberFormat.getCurrencyInstance(new Locale("en","US")).format(MainActivity.account.getBalance()));
        TextView income = view.findViewById(R.id.income_amount);
        income.setText(NumberFormat.getCurrencyInstance(new Locale("en","US")).format(MainActivity.account.getIncome()));
        TextView savings = view.findViewById(R.id.saving_amount);
        savings.setText(NumberFormat.getCurrencyInstance(new Locale("en","US")).format(MainActivity.account.getSavings()));
        TextView expenses = view.findViewById(R.id.expenses_amount);
        expenses.setText(NumberFormat.getCurrencyInstance(new Locale("en","US")).format(MainActivity.account.getExpenses()));

    }

}
