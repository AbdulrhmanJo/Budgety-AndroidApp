package com.example.android.budgety;

public class Budget {
    private String bName;
    private double bTarget;
    private double CurrentBalance;

    Budget(String bName, double bTarget){
        this.bName=bName;
        this.bTarget=bTarget;
        this.CurrentBalance = 0.0;
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
}
