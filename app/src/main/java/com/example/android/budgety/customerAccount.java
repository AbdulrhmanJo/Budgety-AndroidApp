package com.example.android.budgety;

import java.util.ArrayList;

public class customerAccount {

    ArrayList<Budget> budgets;


    customerAccount(){
        budgets= new ArrayList<>();
    }

    public ArrayList<Budget> getBudgets(){
        return this.budgets;
    }

    public void AddBudget(Budget budget){
        budgets.add(0,budget);
    }














}
