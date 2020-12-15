package com.example.whatsfordinner.viewmodel;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import com.example.whatsfordinner.MainActivity;
import com.example.whatsfordinner.R;
import com.example.whatsfordinner.db.AppDatabase;
import com.example.whatsfordinner.db.entity.User;
import com.google.android.material.snackbar.Snackbar;


public class UserViewModel extends AndroidViewModel {
    private AppDatabase database;
    private LiveData<List<User>> users;

    public UserViewModel(@NonNull Application application) {
        super(application);
    }

    public void setupDB() {
        database = AppDatabase.getInstance(getApplication());
        users = database.getUserDao().loadAllUsers();
    }

    public void populateAppDatabase(final List<User> dataset) {
        new AsyncTask<List<User>, Void, Void>(){
            @Override
            protected Void doInBackground(List<User>... userLists) {
                database.getUserDao().deleteAll();
                database.getUserDao().insertUsers(userLists[0].toArray(new User[userLists[0].size()]));
                return null;
            }
        }.execute(dataset);
    }

    public LiveData<List<User>> getUsers() {
        return this.users;
    }

    public void deleteUser(User user) {
        new AsyncTask<User, Void, Void>(){
            @Override
            protected Void doInBackground(User... users) {
                database.getUserDao().deleteUser(users[0]);
                return null;
            }
        }.execute(user);
    }

    public void updateUser(String emailAddress, String username, String password, int index) {
        User user = users.getValue().get(index);
        user.setEmailAddress(emailAddress);
        user.setUsername(username);
        user.setPassword(password);
        new AsyncTask<User, Void, Void>(){
            @Override
            protected Void doInBackground(User... users) {
                database.getUserDao().updateUser(users[0]);
                return null;
            }
        }.execute(user);
    }

    public void loginUser(Activity activity, String username, String password){
        new AsyncTask<String, Void, List<User>>(){
            @Override
            protected List<User> doInBackground(String... data) {
                List<User> result = database.getUserDao().userLogin(data[0], data[1]);
                return result;
            }
            @Override
            protected void onPostExecute(List<User> result) {
                if (result == null || result.isEmpty()) {
                    //Snackbar.make(findViewById(android.R.id.content), "Wrong password. Try again.", Snackbar.LENGTH_LONG).show();
                } else {
                    activity.startActivity(new Intent(activity, MainActivity.class));
                }
            }
        }.execute(username, password);
    }

}