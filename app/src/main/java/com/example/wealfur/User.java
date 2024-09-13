package com.example.wealfur;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    public int userId;
    public String email;
    @Nullable
    public String username;
    public String password;

}
