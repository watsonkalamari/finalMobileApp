package com.example.whatsfordinner.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsfordinner.R;
import com.example.whatsfordinner.db.entity.Recipe;
import com.example.whatsfordinner.viewmodel.DatabaseViewModel;

import java.util.List;

public class FavoriteListAdapter extends RecyclerView.Adapter<FavoriteListAdapter.FavoriteListViewHolder> {

    private final LayoutInflater inflater;
    private List<Recipe> recipes;

    public FavoriteListAdapter(Context context){
        inflater = LayoutInflater.from(context);
    }


    @Override
    public FavoriteListViewHolder onCreateViewHolder(ViewGroup parent, int viewType ){
        View itemView = inflater.inflate(R.layout.favorite_recipes_display_single_line,parent,false);
        return new FavoriteListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteListViewHolder holder, int position){
        if(recipes!=null) {
            Recipe current = recipes.get(position);
            holder.recipetitle.setText(current.getName());
        }else{
            holder.recipetitle.setText("NO TITLE");

        }
    }

    void setRecipes(List<Recipe> Recipe){
        recipes = Recipe;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount(){
        if(recipes!=null)
            return recipes.size();
        else return 0;
    }


   public class FavoriteListViewHolder extends RecyclerView.ViewHolder{
        public Bitmap bitmap;
        public TextView recipetitle;

        private FavoriteListViewHolder (View v){
            super(v);
            recipetitle = v.findViewById(R.id.favorite_title_tv);
        }
   }



}
