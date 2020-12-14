package com.example.whatsfordinner.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsfordinner.R;
import com.example.whatsfordinner.db.entity.Recipe;

import java.util.ArrayList;
import java.util.List;

public class HomeListAdapter extends RecyclerView.Adapter<HomeListAdapter.HomeListViewHolder> {

    private final LayoutInflater inflater;
    private List<Recipe> recipes = new ArrayList<>();

    public HomeListAdapter(Context context){
        inflater = LayoutInflater.from(context);
    }


    @Override
    public HomeListViewHolder onCreateViewHolder(ViewGroup parent, int viewType ){
        View itemView = inflater.from(parent.getContext()).inflate(R.layout.home_activity_single_line,parent,false);
        return new HomeListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeListViewHolder holder, int position){
        if(recipes!=null) {
            Recipe current = recipes.get(position);
            holder.recipetitle.setText(current.getName());
        }else{
            holder.recipetitle.setText("NO TITLE");

        }
    }

    public void setRecipes(List<Recipe> Recipe){
        recipes = Recipe;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount(){
        if(recipes!=null)
            return recipes.size();
        else return 0;
    }


    public class HomeListViewHolder extends RecyclerView.ViewHolder{
        public ImageView bitmap;
        public TextView recipetitle;

        private HomeListViewHolder (View v){
            super(v);
            recipetitle = v.findViewById(R.id.home_name);
            bitmap = v.findViewById(R.id.home_imageView);
        }
    }



}
