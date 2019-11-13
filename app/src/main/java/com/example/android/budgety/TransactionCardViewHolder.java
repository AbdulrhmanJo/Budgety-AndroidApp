package com.example.android.budgety;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TransactionCardViewHolder extends RecyclerView.ViewHolder{

    TextView CategoryName;
    TextView desc;
    TextView date;
    TextView amount;
    ImageView img;

    public TransactionCardViewHolder(@NonNull View itemView) {
        super(itemView);
        this.img = itemView.findViewById(R.id.img_holder);
        this.CategoryName = itemView.findViewById(R.id.category_holder);
        this.desc = itemView.findViewById(R.id.desc_holder);
        this.date = itemView.findViewById(R.id.date_holder);
        this.amount = itemView.findViewById(R.id.amount_holder);
    }
}
