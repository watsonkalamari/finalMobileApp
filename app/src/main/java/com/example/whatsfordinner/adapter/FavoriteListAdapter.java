package com.example.whatsfordinner.Adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsfordinner.R;
import com.example.whatsfordinner.db.entity.Recipe;
import com.example.whatsfordinner.viewmodel.DatabaseViewModel;

import java.util.ArrayList;
import java.util.List;

public class FavoriteListAdapter extends RecyclerView.Adapter<FavoriteListAdapter.FavoriteListViewHolder> {

    private final LayoutInflater inflater;
    private List<Recipe> recipes = new ArrayList<>();

    public FavoriteListAdapter(Context context){
        inflater = LayoutInflater.from(context);
    }


    @Override
    public FavoriteListViewHolder onCreateViewHolder(ViewGroup parent, int viewType ){
        View itemView = inflater.from(parent.getContext()).inflate(R.layout.favorite_recipes_display_single_line,parent,false);
        return new FavoriteListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteListViewHolder holder, int position){
        if(recipes!=null) {
            Recipe current = recipes.get(position);
            holder.recipetitle.setText(current.getName());
            //Drawable icon = getResources().getIdentifier(current.getRecipe_image(),"drawable",com.example.whatsfordinner);
           holder.bitmap.setImageResource(R.drawable.greek_salad);
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


   public class FavoriteListViewHolder extends RecyclerView.ViewHolder{
        public ImageView bitmap;
        public TextView recipetitle;

        private FavoriteListViewHolder (View v){
            super(v);
            recipetitle = v.findViewById(R.id.favorite_title_tv);
            bitmap = v.findViewById(R.id.favorite_img_imageView);
        }
   }

}
