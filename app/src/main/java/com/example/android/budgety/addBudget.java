package com.example.android.budgety;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textfield.TextInputEditText;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;


public class addBudget extends BottomSheetDialogFragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        final View view = inflater.inflate(R.layout.fragment_add_budget, container, false);

        final MaterialButton addBudget = view.findViewById(R.id.add_budget);
        addBudget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText budgetName = view.findViewById(R.id.Budget_Name);
                String bName = budgetName.getText().toString();
                TextInputEditText budgetTarget = view.findViewById(R.id.budget_target);
                double bTagert = Double.parseDouble(budgetTarget.getText().toString());

                Budget budget = new Budget(bName, bTagert);
                FragmentManager fm = getFragmentManager();
                fragment_budget fragment_budget = (fragment_budget) fm.findFragmentById(R.id.fragment_container);
                fragment_budget.addBudget(budget);
                dismiss();
            }
        });

        return view;

    }




}
