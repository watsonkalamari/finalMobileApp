package com.example.whatsfordinner.Adapter;

import android.content.Context;
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

public class SearchListAdapter extends RecyclerView.Adapter<SearchListAdapter.SearchListViewHolder> {

    private List<Recipe> mItems = new ArrayList<>();
    private final LayoutInflater inflater;
    private List<Recipe> recipes = new ArrayList<>();
    private Context mContext;

    public void updateItems(List<Recipe> recipes) {
        this.mItems = recipes;
        notifyDataSetChanged();
    }

    public SearchListAdapter(Context context){
        mContext=context;
        inflater = LayoutInflater.from(mContext);
    }


    public void setRecipes(List<Recipe> Recipe){
        recipes = Recipe;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SearchListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_page_single_line, parent, false);
        return new SearchListViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull SearchListViewHolder holder, int position) {
        if(recipes!=null) {
            Recipe current = recipes.get(position);
            holder.recipeTitle.setText(current.getName());
            holder.recipeDescription.setText(current.getRecipe_description());
            int icon = mContext.getResources().getIdentifier(current.getRecipe_image(),"drawable",mContext.getPackageName());
            holder.recipeImg.setImageResource(icon);
        }else{
            holder.recipeTitle.setText("NO TITLE");

        }
    }


    @Override
    public int getItemCount() {
        if(recipes!=null)
            return recipes.size();
        else return 0;
    }

    public class SearchListViewHolder extends RecyclerView.ViewHolder {

        public ConstraintLayout containerLyt;
        public ImageView recipeImg;
        public TextView recipeTitle;
        public TextView recipeDescription;

        public SearchListViewHolder(View v) {
            super(v);
            containerLyt = v.findViewById(R.id.container);
            recipeImg = v.findViewById(R.id.search_imageView);
            recipeTitle = v.findViewById(R.id.search_result_name);
            recipeDescription = v.findViewById(R.id.search_result_description);
        }
    }
}