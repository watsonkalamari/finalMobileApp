package com.example.whatsfordinner.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecipeDirectionsAdapter extends RecyclerView.Adapter<RecipeDirectionsAdapter.RecipeDirectionViewHolder> {


    @NonNull
    @Override
    public RecipeDirectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeDirectionViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class RecipeDirectionViewHolder extends RecyclerView.ViewHolder{
        TextView direction_step;
        TextView direction_description;


        public RecipeDirectionViewHolder(@NonNull View itemView) {
            super(itemView);
            
        }
    }
}
