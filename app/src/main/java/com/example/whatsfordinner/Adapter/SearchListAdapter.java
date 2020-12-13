package com.example.whatsfordinner.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.example.whatsfordinner.R;
import com.example.whatsfordinner.db.entity.Recipe;

public class SearchListAdapter extends RecyclerView.Adapter {

    private List<Recipe> mItems = new ArrayList<>();

    public void updateItems(List<Recipe> recipes) {
        this.mItems = recipes;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopping_list_page_single_line, parent, false);
        return new RecipeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Recipe recipe = mItems.get(position);
        RecipeViewHolder vh = (RecipeViewHolder) holder;
        vh.recipeTitle.setText(recipe.getName());
        vh.recipeDescription.setText(recipe.getDescription());
    }

    @Override
    public int getItemCount() {
        return this.mItems.size();
    }

    public class RecipeViewHolder extends RecyclerView.ViewHolder {

        public ConstraintLayout containerLyt;
        public ImageView recipeImg;
        public TextView recipeTitle;
        public TextView recipeDescription;

        public RecipeViewHolder(View v) {
            super(v);
            containerLyt = v.findViewById(R.id.container);
            recipeImg = v.findViewById(R.id.search_imageView);
            recipeTitle = v.findViewById(R.id.search_result_name);
            recipeDescription = v.findViewById(R.id.search_result_description);
        }
    }
}