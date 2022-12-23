package com.example.shoppingcart.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;


import com.example.shoppingcart.entity.Cook;
import com.example.shoppingcart.entity.CookIngredientXRef;
import com.example.shoppingcart.entity.relation.CookWithIngredients;

import java.util.List;

@Dao
public interface CookDao {
    @Transaction
    @Query("SELECT * FROM cook")
    LiveData<List<Cook>> getAll();
}