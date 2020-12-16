package com.example.whatsfordinner;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsfordinner.adapter.RecipeDirectionsAdapter;
import com.example.whatsfordinner.adapter.RecipeIngredientsAdapter;
import com.example.whatsfordinner.db.entity.Recipe;
import com.example.whatsfordinner.viewmodel.DatabaseViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class RecipeActivity extends AppCompatActivity {


    private RecyclerView ingredientsList;
    private RecyclerView directionsList;
    private DatabaseViewModel databaseViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_display_activity);

       // databaseViewModel= ViewModelProviders.of(this).get(DatabaseViewModel.class);

        //ingredients
        ingredientsList=findViewById(R.id.display_recipe_ingredient_recycleview);
        RecyclerView.LayoutManager ingredientLayoutManager = new LinearLayoutManager(this);
        ingredientsList.setLayoutManager(ingredientLayoutManager);

        final RecipeIngredientsAdapter ingredientsAdapter = new RecipeIngredientsAdapter(this);
        ingredientsList.setAdapter(ingredientsAdapter);

        //directions
        directionsList=findViewById(R.id.display_recipe_directions_recyclerview);
        RecyclerView.LayoutManager directionLayoutManager = new LinearLayoutManager(this);
        directionsList.setLayoutManager(directionLayoutManager);

        final RecipeDirectionsAdapter directionsAdapter = new RecipeDirectionsAdapter(this);
        directionsList.setAdapter(directionsAdapter);

        //TODO::connect this activity to the database so that the recipe's name, image,
        // ingredients, and directions are gonna show up on the screen





    }
}
