package com.example.whatsfordinner;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class RecipeActivity extends AppCompatActivity {


    private RecyclerView ingredientsList;
    private RecyclerView directionsList;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_display_activity);
        ingredientsList=findViewById(R.id.display_recipe_ingredient_recycleview);
        RecyclerView.LayoutManager ingredientLayoutManager = new LinearLayoutManager(this);
        ingredientsList.setLayoutManager(ingredientLayoutManager);

        directionsList=findViewById(R.id.display_recipe_directions_recyclerview);
        RecyclerView.LayoutManager directionLayoutManager = new LinearLayoutManager(this);
        directionsList.setLayoutManager(directionLayoutManager);

        //TODO::connect this activity to the database so that the recipe's name, image,
        // ingredients, and directions are gonna show up on the screen





    }
}
