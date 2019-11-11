package com.example.android.budgety;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.ImageView;

import java.util.Date;


public class Transaction {
    private double amount;
    private String desc;
    private String category;
    private Date date;

    public Transaction(double amount, String desc, String category, Date date) {
        this.amount = amount;
        this.desc = desc;
        this.category = category;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
