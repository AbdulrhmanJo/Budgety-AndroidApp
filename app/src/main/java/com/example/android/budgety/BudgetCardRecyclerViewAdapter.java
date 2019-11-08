package com.example.android.budgety;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BudgetCardRecyclerViewAdapter extends RecyclerView.Adapter<BudgetCardViewHolder> {

    private List<Budget> budgetList;

    BudgetCardRecyclerViewAdapter(List<Budget> budgetList){
        this.budgetList =budgetList;
    }

    @NonNull
    @Override
    public BudgetCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.budgetcard, parent, false);
        return new BudgetCardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull BudgetCardViewHolder holder, int position) {
        holder.BudgetName.setText(budgetList.get(position).getbName());
        holder.BudgetCurrentBalance.setText(NumberFormat.getCurrencyInstance(new Locale("en","US")).format(budgetList.get(position).getCurrentBalance()));
        holder.BudgetTarget.setText(NumberFormat.getCurrencyInstance(new Locale("en","US")).format(budgetList.get(position).getbTarget()));
    }

    @Override
    public int getItemCount() {
        return budgetList.size();
    }
}
