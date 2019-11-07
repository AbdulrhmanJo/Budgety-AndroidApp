package com.example.android.budgety;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.IdRes;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;


public class home extends Fragment {

    public home() {
        // Required empty public constructor
    }

    int y, m, d;
    String dop = " ";



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


        return view;
    }






}
