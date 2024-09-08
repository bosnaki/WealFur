package com.example.wealfur;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "Appointments", foreignKeys = @ForeignKey(entity = Pet.class, parentColumns = {"petId"}, childColumns = {"petId"}, onUpdate = CASCADE))
public class Appointments {
    @PrimaryKey(autoGenerate = true)
    public int appointmentId;
    public String name;
    public String type;
    public String date;
    public int petId;


}
