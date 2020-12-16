package com.example.whatsfordinner.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.whatsfordinner.db.entity.Direction;
import com.example.whatsfordinner.db.entity.Ingredient;
import com.example.whatsfordinner.db.entity.Recipe;
import com.example.whatsfordinner.repository.DataRepository;

import java.util.List;

public class SecondActivityViewModel extends AndroidViewModel {
    private DataRepository repository;
    private LiveData<List<Recipe>> allRecipes;
    private LiveData<List<Direction>> allDirections;
    private LiveData<List<Ingredient>> allIngredients;
    private String recipe_name;


    public SecondActivityViewModel(Application application){
        super(application);
        repository = new DataRepository(application);
        allRecipes = repository.getRecipeInfo();
        allIngredients=repository.getAllIngredientForRecipe(repository.setRecipe_name(repository.getRecipeInfo().getValue().get(0).getName()););
        allDirections =repository.getAllRecipeDirections();

    }
}
