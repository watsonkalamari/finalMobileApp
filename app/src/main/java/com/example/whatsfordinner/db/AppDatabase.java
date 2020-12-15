package com.example.whatsfordinner.db;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.loader.content.AsyncTaskLoader;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.whatsfordinner.db.dao.RecipeDao;
import com.example.whatsfordinner.db.dao.ShoppingListDao;
import com.example.whatsfordinner.db.dao.UserDao;
import com.example.whatsfordinner.db.entity.Direction;
import com.example.whatsfordinner.db.entity.Ingredient;
import com.example.whatsfordinner.db.entity.MeasurementQty;
import com.example.whatsfordinner.db.entity.MeasurementUnits;
import com.example.whatsfordinner.db.entity.ShoppingList;
import com.example.whatsfordinner.db.entity.User;
import com.example.whatsfordinner.db.entity.Recipe;

@Database(version = 16, entities = {User.class, Recipe.class, Direction.class,Ingredient.class, MeasurementQty.class, MeasurementUnits.class, ShoppingList.class})
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    abstract public UserDao getUserDao();
    abstract public RecipeDao getRecipeDao();
    abstract public ShoppingListDao getShoppingListDao();



    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
                instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "appDatabase").createFromAsset("database/appData2.db").fallbackToDestructiveMigration().build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

        }
    };

    private static class populateDbAsyncTask extends AsyncTask<Void,Void,Void>{
        private RecipeDao recipeDao;

        private populateDbAsyncTask(AppDatabase db){
            recipeDao=db.getRecipeDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }

    public static void destroyInstance() {
        instance = null;
    }

    /*private static AppDatabase.Callback appDatabaseCallback = new AppDatabase.Callback(){
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db){
            super.onOpen(db);
           *//* new PopulateDbAsync(instance).execute();*//*
        }

       */
    /* private static class PopulateDbAsync extends AsyncTask<Void, Void,Void>{
            private final RecipeDao Dao;

            PopulateDbAsync(AppDatabase db){
                Dao = db.getRecipeDao();
            }

            @Override
            protected Void doInBackground(final Void...params){
                Dao.deleteAll();
                //
            }*//*
        };
*/
}