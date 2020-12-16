package com.example.whatsfordinner.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsfordinner.R;
import com.example.whatsfordinner.db.entity.Ingredient;
import com.example.whatsfordinner.db.entity.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeIngredientsAdapter extends RecyclerView.Adapter<RecipeIngredientsAdapter.RecipeIngredientViewHolder> {

    private final LayoutInflater inflater;
    private List<Ingredient> ingredients = new ArrayList<>();

    public RecipeIngredientsAdapter(Context context){
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecipeIngredientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.recipe_display_ingredients_single_line,parent,false);
        return new RecipeIngredientViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeIngredientViewHolder holder, int position) {
        if(ingredients!=null) {
            Ingredient current = ingredients.get(position);
            holder.ingredient.setText(current.getIngredient_name());
        }else{
           holder.ingredient.setText("INGREDIENTS NOT AVALIABLE");

        }
    }

    @Override
    public int getItemCount() {
        if(ingredients!=null)
            return ingredients.size();
        else return 0;
    }

    public class RecipeIngredientViewHolder extends RecyclerView.ViewHolder{
        TextView ingredient;

        public RecipeIngredientViewHolder(@NonNull View itemView) {
            super(itemView);
            ingredient = itemView.findViewById(R.id.display_recipe_ingredient_tv);
        }
    }
}
