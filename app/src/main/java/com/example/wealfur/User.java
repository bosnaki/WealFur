package com.example.wealfur;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    public int userId;
    public String email;
    public String username;
    public String password;
}
