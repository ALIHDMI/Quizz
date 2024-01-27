package com.example.quizz;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<Model> models;
    public RecycleViewAdapter(Context context, ArrayList<Model> models) {
        this.context = context;
        this.models = models;

    }

    @NonNull
    @Override
    public RecycleViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recyclechoose_view_row, parent, false);
        return new RecycleViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewAdapter.MyViewHolder holder, int position) {
        holder.textView4.setText(models.get(position).getCount());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public CardView cardView;
        TextView textView4;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textView4 = itemView.findViewById(R.id.textView4);
        }
    }
}
