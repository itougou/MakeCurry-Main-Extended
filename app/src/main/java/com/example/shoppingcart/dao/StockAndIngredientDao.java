package com.example.shoppingcart.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.shoppingcart.entity.relation.IngredientAndStockAndUnit;
import com.example.shoppingcart.entity.relation.StockAndIngredient;

import java.util.List;

@Dao
public interface StockAndIngredientDao {
    @Transaction
    @Query("SELECT * FROM stock")
    public LiveData<List<StockAndIngredient>> getStocksAndIngredients();

    @Transaction
    @Query("SELECT * FROM ingredient")
    public LiveData<List<IngredientAndStockAndUnit>> getIngredientAndStocksAndUnit();
}