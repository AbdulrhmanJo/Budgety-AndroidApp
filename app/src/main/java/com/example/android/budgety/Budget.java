package com.example.android.budgety;

import android.content.res.Resources;

import java.util.List;

public class Budget {
    private String bName;
    private double bTarget;
    private double CurrentBalance;
    private int progress;

    Budget(String bName, double bTarget){
        this.bName=bName;
        this.bTarget=bTarget;
        this.CurrentBalance = 0.0;
    }



    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public double getbTarget() {
        return bTarget;
    }

    public void setbTarget(double bTarget) {
        this.bTarget = bTarget;
    }

    public double getCurrentBalance() {
        return CurrentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        CurrentBalance = currentBalance;
    }

    public void addToBalance(double amount){
        this.CurrentBalance += amount;
    }
}
