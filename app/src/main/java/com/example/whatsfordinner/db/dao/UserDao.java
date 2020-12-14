package com.example.whatsfordinner.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import com.example.whatsfordinner.db.entity.Recipe;
import com.example.whatsfordinner.db.entity.User;

import static androidx.room.OnConflictStrategy.IGNORE;
import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface UserDao {
    @Insert(onConflict = IGNORE)
    void insertUser(User user);

    @Insert(onConflict = IGNORE)
    void insertUsers(User... users);

    @Insert(entity = User.class)
    void updateUserAddress(User fullName);

    @Delete
    void deleteUser(User user);

    @Update(onConflict = REPLACE)
    void updateUser(User user);

    @Query("select * from users")
    LiveData<List<User>> loadAllUsers();

    @Query("DELETE FROM users")
    void deleteAll();

    @Query("select * from users where uid = :id")
    User loadUserById(int id);

    @Query("select * from users where username = :username")
    List<User> findUserByUsername(String username);

    @Query("select * from users where email_address = :emailAddress")
    List<User> findUserByEmail(String emailAddress);

    @Query ("select * from users where username = :username and password = :password")
    List<User> userLogin(String username, String password);

    @Query("SELECT * FROM users ORDER BY uid ASC")
    LiveData<List<User>> getAllUsers();

}
