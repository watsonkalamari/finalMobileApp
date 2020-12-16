package com.example.whatsfordinner.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsfordinner.Fragments.FavoritesFragment;
import com.example.whatsfordinner.R;
import com.example.whatsfordinner.RecipeActivity;
import com.example.whatsfordinner.db.entity.Recipe;

import java.util.ArrayList;
import java.util.List;

public class FavoriteListAdapter extends RecyclerView.Adapter<FavoriteListAdapter.FavoriteListViewHolder> {

    private final LayoutInflater inflater;
    private List<Recipe> recipes = new ArrayList<>();
    private Context mContext;
   /* private AdapterView.OnItemClickListener onItemClickListener;*/

    public FavoriteListAdapter(Context context){
        mContext=context;
        inflater = LayoutInflater.from(mContext);
    }


    @Override
    public FavoriteListViewHolder onCreateViewHolder(ViewGroup parent, int viewType ){
        View itemView = inflater.from(parent.getContext()).inflate(R.layout.favorite_recipes_display_single_line3,parent,false);
        return new FavoriteListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteListViewHolder holder, int position){
        if(recipes!=null) {
            Recipe current = recipes.get(position);
            holder.recipetitle.setText(current.getName());
            int icon = mContext.getResources().getIdentifier(current.getRecipe_image(),"drawable",mContext.getPackageName());
            holder.bitmap.setImageResource(icon);
            holder.bitmap.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), RecipeActivity.class);
                    v.getContext().startActivity(intent);
                }
            });
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
