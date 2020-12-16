package com.example.whatsfordinner;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsfordinner.Adapter.RecipeDirectionsAdapter;
import com.example.whatsfordinner.adapter.RecipeIngredientsAdapter;
import com.example.whatsfordinner.viewmodel.DatabaseViewModel;

public class RecipeActivity extends AppCompatActivity {


    private RecyclerView ingredientsList;
    private RecyclerView directionsList;
    private DatabaseViewModel databaseViewModel;
    /*private SecondActivityViewModel secondActivityViewModel;*/

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_display_activity);

       // databaseViewModel= ViewModelProviders.of(this).get(DatabaseViewModel.class);
        //secondActivityViewModel =ViewModelProviders.of(this).get(SecondActivityViewModel.class);
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

        final RecipeDirectionsAdapter recipeDirectionsAdapter = new RecipeDirectionsAdapter(this);
        directionsList.setAdapter(recipeDirectionsAdapter);



        //TODO::connect this activity to the database so that the recipe's name, image,
        // ingredients, and directions are gonna show up on the screen





    }
}
