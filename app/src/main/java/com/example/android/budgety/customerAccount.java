package com.example.android.budgety;

import java.util.ArrayList;
import java.util.Date;

public class customerAccount {

    private double savings;
    private double income;
    private double expenses;
    private double balance;
    ArrayList<Budget> budgets;
    ArrayList<Transaction> transactions;

    private double totalSavings;

    customerAccount(){
        this.budgets= new ArrayList<>();
        this.transactions = new ArrayList<>();
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

    public ArrayList<Transaction> getTransactions(){
        return this.transactions;
    }

    public void AddTransaction(Transaction transaction){
        transactions.add(0,transaction);
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

    public void makeTransaction(int TMethod, double amount, String category, String decs, Date date) {
        Transaction transaction = new Transaction(amount,decs,category,date);
        transactions.add(0,transaction);
        if(TMethod == R.id.income){
            addIncome(amount);
            this.balance += amount;
        }
        else if(TMethod == R.id.expenses) {
            addExpenses(amount);
            this.balance -= amount;
        }
        else{
            addSavings(amount);
            for (int i = 0; i<budgets.size(); i++){
                if (category.equals(budgets.get(i).getbName())){
                    budgets.get(i).addToBalance(amount);
                    this.totalSavings += amount;
                }
            }
        }



    }

    private void addSavings(double amount) {
        this.savings += amount;
    }

    private void addExpenses(double amount) {
        this.expenses -= amount;
    }

    private void addIncome(double amount) {
        this.income += amount;
    }
}
