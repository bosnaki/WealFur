package com.example.wealfur;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity(tableName = "Pet", foreignKeys = @ForeignKey(entity = User.class, parentColumns = {"userId"}, childColumns = {"Owner ID"}, onUpdate = CASCADE))
public class Pet {
    @PrimaryKey(autoGenerate = true)
    public int petId;
    @ColumnInfo(name = "Type of animal(Dog,Cat etc)")
    public String typeOfAnimal;
    @ColumnInfo(name = "Name")
    public String petName;
    @ColumnInfo(name= "Breed")
    public String breed;
    @ColumnInfo(name = "Age")
    public int age;
    @ColumnInfo(name = "Weight (in kilos)")
    public int weightInKilos;
    @ColumnInfo(name = "Owner ID")
    public int ownerId;
}
