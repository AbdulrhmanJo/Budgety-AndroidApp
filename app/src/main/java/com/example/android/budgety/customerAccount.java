package com.example.android.budgety;

import android.util.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import javax.annotation.Nullable;

public class customerAccount {

    private double savings;
    private double income;
    private double expenses;
    private double balance;
    ArrayList<Budget> budgets;
    ArrayList<Transaction> currentList;
    ArrayList<Transaction>[] transactions = new ArrayList[12];

    private double totalSavings;
    boolean brake = false;

    customerAccount() {
        this.budgets = new ArrayList<>();
        for (int i = 0; i < transactions.length; i++) {
            this.transactions[i] = new ArrayList<Transaction>();
        }
        this.balance = 0;
        this.expenses = 0;
        this.income = 0;
        this.savings = 0;
        this.currentList = new ArrayList<Transaction>();

    }

    public ArrayList<Transaction> getCurrentList() {
        return currentList;
    }

    public void setCurrentList(ArrayList<Transaction> currentList) {
        this.currentList = currentList;
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

    public ArrayList<Budget> getBudgets() {
        return this.budgets;
    }

    public void AddBudget(Budget budget) {
        budgets.add(0, budget);
    }

    public ArrayList<Transaction>[] getTransactions() {
        return this.transactions;
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
        Transaction transaction = new Transaction(amount, decs, category, date, TMethod);
        System.out.println("bbbbbbbbb" + date.getMonth());
        transactions[date.getMonth()].add(0, transaction);
        System.out.println("bbbbbbbbb2" + transactions[date.getMonth()].get(0).getDesc());

        if (TMethod == R.id.income) {
            addIncome(amount);
            this.balance += amount;
        } else if (TMethod == R.id.expenses) {
            addExpenses(amount);
            this.balance -= amount;
        } else {
            addSavings(amount);
            for (int i = 0; i < budgets.size(); i++) {
                if (category.equals(budgets.get(i).getbName())) {
                    budgets.get(i).addToBalance(amount);
                    int progress = (int) Math.floor((amount / budgets.get(i).getbTarget()) * 100);
                    budgets.get(i).setProgress(progress);
                    this.totalSavings += amount;
                    UpdateBudgets(category, amount);
                    break;
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

    private void UpdateBudgets(final String category, final double amount) {

        // ArrayList ListBudgets = new ArrayList();
        final FirebaseAuth fAuth = FirebaseAuth.getInstance();
        final FirebaseFirestore firestore = FirebaseFirestore.getInstance();

        //Current user id
        final String UserID = fAuth.getCurrentUser().getUid();

        firestore.collection("users").document(UserID).collection("budgets").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

            List<String> list;

            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    list = new ArrayList<>();
                    for (QueryDocumentSnapshot documentSnapshot : task.getResult()) {
                        list.add(documentSnapshot.getId());
                    }
                }
                for (int i = 0; i < list.size(); i++) {
                    final String BudgetID = list.get(i);
                    final DocumentReference documentReference = firestore.collection("users").document(UserID).collection("budgets").document(BudgetID);

                    documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
                        @Override
                        public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                            Double Target = documentSnapshot.getDouble("target");
                            String n = documentSnapshot.getString("Budegt Name");
                            double curr = documentSnapshot.getDouble("current balance") + amount;
                            if (n.equalsIgnoreCase(category)) {
                                System.out.println("Budget ID : " + BudgetID);
                            }
                        }
                    });
                }
            }
        });
    }

}
