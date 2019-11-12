package com.example.android.budgety;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BudgetCardViewHolder extends RecyclerView.ViewHolder {

    TextView BudgetName;
    TextView BudgetCurrentBalance;
    TextView BudgetTarget;
    ProgressBar progressBar;

    public BudgetCardViewHolder(@NonNull View itemView) {
        super(itemView);
        BudgetName = itemView.findViewById(R.id.Budget_Name);
        BudgetCurrentBalance = itemView.findViewById(R.id.CurrentBalance_Budget);
        BudgetTarget = itemView.findViewById(R.id.BugetTarget);
        progressBar = itemView.findViewById(R.id.progressBar);
    }
}
