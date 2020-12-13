package com.example.whatsfordinner.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.whatsfordinner.db.dao.RecipeDao;
import com.example.whatsfordinner.db.dao.UserDao;
import com.example.whatsfordinner.db.entity.Ingredient;
import com.example.whatsfordinner.db.entity.User;
import com.example.whatsfordinner.db.entity.Recipe;

@Database(version = 2, entities = {User.class, Recipe.class})
public abstract class AppDatabase extends RoomDatabase {

    abstract public UserDao getUserDao();
    abstract public RecipeDao getRecipeDao();

    private static AppDatabase instance;

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "appDatabase").createFromAsset("database/appData.db").build();
        }
        return instance;
    }

    public static void destroyInstance() {
        instance = null;
    }

}