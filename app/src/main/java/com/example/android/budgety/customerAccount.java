package com.example.android.budgety;

import java.util.ArrayList;

public class customerAccount {

    ArrayList<Budget> budgets;
    private double totalSavings;

    customerAccount(){
        budgets= new ArrayList<>();
    }

    public ArrayList<Budget> getBudgets(){
        return this.budgets;
    }

    public void AddBudget(Budget budget){
        budgets.add(0,budget);
    }


    public double getTotalSavings() {
        return totalSavings;
    }

    public void setTotalSavings(double totalSavings) {
        this.totalSavings = totalSavings;
    }

    public void addTotalSavings(double amount) {
        this.totalSavings += amount;
    }
}
