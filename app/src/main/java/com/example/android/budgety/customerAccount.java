package com.example.android.budgety;

import java.util.ArrayList;

public class customerAccount {

    private double savings;
    private double income;
    private double expenses;
    private double balance;
    ArrayList<Budget> budgets;
    private double totalSavings;

    customerAccount(){
        this.budgets= new ArrayList<>();
        this.balance= 0;
        this.expenses=0;
        this.income=0;
        this.savings=0;
    }

    public double getSavings() {
        return savings;
    }

    public void setSavings(double savings) {
        this.savings = savings;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
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
