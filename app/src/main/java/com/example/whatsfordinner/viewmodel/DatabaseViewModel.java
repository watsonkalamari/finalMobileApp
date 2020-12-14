package com.example.whatsfordinner.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.whatsfordinner.db.entity.Recipe;
import com.example.whatsfordinner.db.entity.User;
import com.example.whatsfordinner.repository.DataRepository;

import java.util.List;

public class DatabaseViewModel extends AndroidViewModel {

    private DataRepository repository;
    private LiveData<List<Recipe>> allRecipes;
    private LiveData<List<User>> allUsers;

    public DatabaseViewModel (Application application){
        super(application);
        repository = new DataRepository(application);
        allRecipes = repository.getAllRecipes();
        //TODO::add the one for the users
    }


    public LiveData<List<User>> getAllUsers(){return allUsers;}
    public void insert(Recipe recipe){
        repository.insert(recipe);
    }
    public void update(Recipe recipe){repository.update(recipe);}
    public void delete(Recipe recipe){repository.delete(recipe);}
    public void deleteAllRecipes(){repository.deleteAllRecipes();}

    public LiveData<List<Recipe>> getAllRecipes() {
        return allRecipes;
    }

    //TODO:: add the getAllUsers()
    //TODO:: add the insert for the users.
}
