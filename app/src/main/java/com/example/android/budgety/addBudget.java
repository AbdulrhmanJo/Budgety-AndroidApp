package com.example.android.budgety;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import java.util.Map;


public class addBudget extends BottomSheetDialogFragment {

    FirebaseAuth fAuth;
    FirebaseFirestore firestore;
    String UserId;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        fAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();
        UserId = fAuth.getCurrentUser().getUid();
        for (int i = 0; i < 10; i++) {
            System.out.println("THE ID IS " + UserId);
        }

        final View view = inflater.inflate(R.layout.fragment_add_budget, container, false);

        final MaterialButton addBudget = view.findViewById(R.id.add_budget);
        addBudget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                TextInputEditText budgetName = view.findViewById(R.id.Budget_Name);
                TextInputEditText budgetTarget = view.findViewById(R.id.budget_target);


                String Budget_Name = budgetName.getText().toString();
                String Budget_Target = budgetTarget.getText().toString();


                // creating the document file in firebase site.......this for the sub collections
                DocumentReference documentReference = firestore.collection("users").document(UserId).collection("budgets").document();


                // set the variables inside the user and set it in the database in firebase
                Map<String,Object> user = new HashMap<>();
                user.put("Budegt Name" , Budget_Name);
                user.put("target",Budget_Target);
                user.put("current balance",0);

                documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(null," success"+UserId);
                    }
                });




                double bTagert = Double.parseDouble(budgetTarget.getText().toString());

                Budget budget = new Budget(Budget_Name, bTagert);
                FragmentManager fm = getFragmentManager();
                fragment_budget fragment_budget = (fragment_budget) fm.findFragmentById(R.id.fragment_container);

                fragment_budget.addBudget(budget);
                dismiss();



            }
        });

        return view;

    }


}
