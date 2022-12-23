package com.example.shoppingcart.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.shoppingcart.entity.relation.IngredientAndStock;
import com.example.shoppingcart.entity.relation.IngredientAndStockAndUnit;

import java.util.List;

@Dao
public interface IngredientAndStockAndUnitDao {

    @Transaction
    @Query("SELECT * FROM ingredient")
    public LiveData<List<IngredientAndStockAndUnit>> getIngredientAndStocksAndUnit();
}
