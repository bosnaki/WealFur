package com.example.wealfur;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {Appointments.class, Pet.class, User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDAO userDAO();
    public abstract AppointmentsDAO appointmentsDAO();
    public abstract PetDAO petDAO();

    public static final String DATABASE_NAME = "wf_database.db";
    public static AppDatabase instance;

    public static AppDatabase getInstance(Context context){
        if (instance == null){
            instance= Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class,
                            DATABASE_NAME )
                    .build();
        }
        return instance;
    }

}
