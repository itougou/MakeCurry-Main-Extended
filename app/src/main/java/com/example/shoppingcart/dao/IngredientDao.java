package com.example.shoppingcart.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.shoppingcart.entity.Ingredient;

import java.util.List;

@Dao
public interface IngredientDao {
    @Transaction
    @Query("SELECT * FROM ingredient")
    LiveData<List<Ingredient>> getAll();

}
