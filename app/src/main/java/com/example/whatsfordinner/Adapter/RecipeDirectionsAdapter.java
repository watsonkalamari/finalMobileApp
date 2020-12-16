package com.example.whatsfordinner.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsfordinner.R;
import com.example.whatsfordinner.RecipeActivity;
import com.example.whatsfordinner.db.entity.Direction;
import com.example.whatsfordinner.db.entity.Recipe;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class RecipeDirectionsAdapter extends RecyclerView.Adapter<RecipeDirectionsAdapter.RecipeDirectionViewHolder> {

    private final LayoutInflater inflater;
    private List<Direction> directions = new ArrayList<>();


    public RecipeDirectionsAdapter(Context context){
        inflater =LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public RecipeDirectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.recipe_display_directions_single_line,parent,false);
        return new RecipeDirectionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeDirectionViewHolder holder, int position) {
        if(directions!=null) {
            Direction current = directions.get(position);
            holder.direction_step.setText(current.getStep_number());
            holder.direction_description.setText(current.getDirection_description());
        }else{
            holder.direction_step.setText("N/A");
            holder.direction_description.setText("DESCRIPTION NOT AVALIABLE");
        }
    }

    @Override
    public int getItemCount() {
        if(directions!=null)
            return directions.size();
        else return 0;
    }

    public class RecipeDirectionViewHolder extends RecyclerView.ViewHolder{
        TextView direction_step;
        TextView direction_description;


        public RecipeDirectionViewHolder(View v) {
            super(v);
            direction_step=v.findViewById(R.id.direction_step_display_tv);
            direction_description=v.findViewById(R.id.direction_display_tv);
        }
    }
}
