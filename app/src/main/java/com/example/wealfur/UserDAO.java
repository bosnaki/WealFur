package com.example.wealfur;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface UserDAO {

    @Query("SELECT * FROM user")
    List<User> getAllUsers();

    @Insert
    void insertUser(User user);

    @Delete
    void deleteUser(User user);

    @Query("SELECT userId FROM User WHERE email LIKE :email AND " + " password LIKE :password LIMIT 1 ")
    int getAccountWithCredentials(String email, String password);

    @Query("SELECT userId from User where email like :email")
    int getAccountWithEmail(String email);

    @Query("SELECT password from User where email like :email")
    String getPasswordFromEmail(String email);



}
