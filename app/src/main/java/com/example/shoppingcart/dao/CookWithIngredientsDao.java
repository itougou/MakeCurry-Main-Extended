package com.example.shoppingcart.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.shoppingcart.entity.relation.CookWithIngredients;

import java.util.List;

@Dao
public interface CookWithIngredientsDao {
    /* 試しのメソッド */
    @Transaction
    @Query("SELECT * FROM cook WHERE cook_name = :name")
    public LiveData<List<CookWithIngredients>> getCookWithIngredientByName(String name);
}
