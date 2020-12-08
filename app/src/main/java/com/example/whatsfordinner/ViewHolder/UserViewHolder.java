/* package com.example.whatsfordinner.ViewHolder;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.whatsfordinner.model.User;

import java.util.List;

import edu.ualr.roomdatabase.db.AppDatabase;
import edu.ualr.roomdatabase.db.entity.User;


public class UserViewModel extends AndroidViewModel {
    // TODO 28. Define a member to store a reference to the database
    private AppDatabase database;
    // TODO 29. Define a LiveData member used as observable field to automatically update the UI when
    // values returned from data queries are received
    private LiveData<List<User>> users;

    // TODO 30. Instead of retrieving the list of users from the database, retrieve the LiveData
    //  object from the DAO and use it to subscribe to changes

    // TODO 31. Define the constructor of the viewmodel
    public UserViewModel(@NonNull Application application) {
        super(application);
    }

    // TODO 32. Define a method to setup the database
    public void setupDB() {
        // TODO 32.01. Get a reference to the database
        database = AppDatabase.getInstance(getApplication());
        // TODO 32.02. Subscribe to db changes
        users = database.getUserDao().loadAllUsers();
    }

    // TODO 33. Populate the database with data. We'll reset the database to start from scratch every time we launch the app
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

    // TODO 34. Define a get method to allow the activity subscribe to changes in database
    public LiveData<List<User>> getUsers() {
        return this.users;
    }

    // TODO 36. Define a method to delete a user from the database
    public void deleteUser(User user) {
        new AsyncTask<User, Void, Void>(){
            @Override
            protected Void doInBackground(User... users) {
                database.getUserDao().deleteUser(users[0]);
                return null;
            }
        }.execute(user);
    }

    // TODO 38. Define a method to edit and update an user in the database
    public void updateUser(String name, String lastName, String street, String state, String city, int postCode, int index) {
        User user = users.getValue().get(index);
        user.setfName(name);
        user.setlName(lastName);
        user.getAddress().setCity(city);
        user.getAddress().setState(state);
        user.getAddress().setStreet(street);
        user.getAddress().setPostCode(postCode);
        user.setStreet(street);
        user.setCity(city);
        user.setState(state);
        user.getZipcode(postCode);
        TODO: KW: connect this to the user class. I think that the zipcode should be
        *  a string instead of a int because we aren't going to be manipulating the zipcode
        new AsyncTask<User, Void, Void>(){
            @Override
            protected Void doInBackground(User... users) {
                database.getUserDao().updateUser(users[0]);
                return null;
            }
        }.execute(user);
    }

}
        */

