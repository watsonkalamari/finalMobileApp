package com.example.whatsfordinner.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecipeDirectionsAdapter extends RecyclerView.Adapter<RecipeDirectionsAdapter.RecipeDirectionViewHolder> {



    public class RecipeDirectionViewHolder extends RecyclerView.ViewHolder{
        TextView direction_step;
        TextView direction_description;


        public RecipeDirectionViewHolder(@NonNull View itemView) {
            super(itemView);
            
        }
    }
}
