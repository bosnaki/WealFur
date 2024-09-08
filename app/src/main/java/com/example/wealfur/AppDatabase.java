package com.example.wealfur;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {Appointments.class, Pet.class, User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDAO userDAO();
    public abstract AppointmentsDAO appointmentsDAO();
    public abstract PetDAO petDAO();
}
