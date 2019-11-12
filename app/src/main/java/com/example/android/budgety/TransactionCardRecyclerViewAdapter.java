package com.example.android.budgety;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.DateFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TransactionCardRecyclerViewAdapter extends RecyclerView.Adapter<TransactionCardViewHolder> {

    private List<Transaction> TransactionList;

    TransactionCardRecyclerViewAdapter(List<Transaction> TransactionList){
        this.TransactionList =TransactionList;
    }


    @NonNull
    @Override
    public TransactionCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.transactioncard, parent, false);
        return new TransactionCardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionCardViewHolder holder, int position) {
        if(TransactionList.get(position).getMethod() == R.id.income){
            holder.img.setImageResource(R.drawable.round_keyboard_arrow_up_24);
        }else if(TransactionList.get(position).getMethod() == R.id.expenses){
            holder.img.setImageResource(R.drawable.round_keyboard_arrow_down_24);
            holder.img.setColorFilter(Color.rgb(201,16,16));
            holder.amount.setTextColor(Color.rgb(201,16,16));
        }else{
            holder.img.setImageResource(R.drawable.round_trending_up_24);
            holder.img.setColorFilter(Color.rgb(0,0,0));
            holder.amount.setTextColor(Color.rgb(0,0,0));
        }
        holder.CategoryName.setText(TransactionList.get(position).getCategory());
        holder.desc.setText(TransactionList.get(position).getDesc());
        holder.amount.setText(NumberFormat.getCurrencyInstance(new Locale("en","US")).format(TransactionList.get(position).getAmount()));
//        holder.date.setText(formatDate(TransactionList.get(position).getDate()));
    }

    @Override
    public int getItemCount() {
        return TransactionList.size();
    }

    private String formatDate(Date date){
        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("dd MMMM yyyy");
        String formatterDate = simpleDateFormat.format(date);
        return formatterDate;
    }
}
