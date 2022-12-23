package com.example.shoppingcart.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface StockWithIngredientsDao {
    // 在庫テーブルの食材たちを表すメソッド
    @Transaction
    @Query("SELECT * FROM stock　ORDER BY stock_id")
    public LiveData<List<StockWithIngredientsDao>> getStocksWithIngredients();

    // 食材名　量　単位　
    @Transaction
    @Query( "SELECT ingredient.ing_name,quantity,unit.unit_name " +
            "FROM stock,ingredient,unit " +
            "WHERE ingredient.ing_name = :ing_name")
    public  LiveData<List<StockWithIngredientsDao>> searchStockByName( String ing_name);
}
