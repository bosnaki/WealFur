package com.example.wealfur;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PetDAO {

    @Query("SELECT * from pet")
    List<Pet> getAllPets();

    @Insert
    void insertPet(Pet pet);

    @Delete
    void deletePet(Pet pet);



}
