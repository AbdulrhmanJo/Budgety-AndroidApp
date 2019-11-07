package com.example.android.budgety;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textfield.TextInputEditText;


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

        Button newBudget =  (Button) view.findViewById(R.id.new_budget);
        newBudget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new addBudget().show(getFragmentManager(),"");
            }
        });

        return view;
    }




    public void createCard(Budget family) {
        LinearLayout container = (LinearLayout) this.getView().findViewById(R.id.BudgetContainer);
        MaterialCardView cardView = new MaterialCardView(getActivity());


        TextView budgetName = new TextView(getActivity());
        budgetName.setText(family.getbName());
        cardView.addView(budgetName,0);

        LinearLayout SubContainer = new LinearLayout(getActivity());
        TextView budgetCurrentBalance = new TextView(getActivity());
        budgetName.setText("$" + family.getCurrentBalance());
        TextView budgetTarget = new TextView(getActivity());
        budgetName.setText("$" + family.getbTarget());
        SubContainer.addView(budgetCurrentBalance,0);
        SubContainer.addView(budgetTarget,1);
        cardView.addView(SubContainer,1);

        container.addView(cardView,0);
    }


}