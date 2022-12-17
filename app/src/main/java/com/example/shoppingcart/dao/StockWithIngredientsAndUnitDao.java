package com.example.shoppingcart.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.example.shoppingcart.entity.StockWithIngredientsAndUnit;

import java.util.List;

@Dao
public interface StockWithIngredientsAndUnitDao {
    @Query("SELECT * FROM StockWithIngredientsAndUnit")
    public LiveData<List<StockWithIngredientsAndUnit>> getAll();
}
