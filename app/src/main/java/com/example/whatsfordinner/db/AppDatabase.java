package com.example.whatsfordinner.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.whatsfordinner.db.dao.UserDao;
import com.example.whatsfordinner.db.entity.User;
import com.example.whatsfordinner.db.entity.Recipe;

@Database(entities = {User.class, Recipe.class }, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    abstract public UserDao getUserDao();

    private static AppDatabase instance;

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "appDatabase").build();
        }
        return instance;
    }

    public static void destroyInstance() {
        instance = null;
    }

}