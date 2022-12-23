package com.example.shoppingcart.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.shoppingcart.entity.Stock;

import java.util.List;

@Dao
public interface StockDao {
    @Transaction
    @Query("SELECT * FROM stock")
    LiveData<List<Stock>> getAll();

    @Transaction
    @Insert
    long insertStock(Stock stock);

    @Transaction
    @Query("UPDATE stock SET quantity = :suu WHERE ingredient_id =:id AND add_date = :date")
    int updateStock( int id, String date, int suu );

    @Transaction
    @Query("DELETE FROM stock WHERE ingredient_id =:id AND add_date = :date")
    int deleteStock( int id, String date );
}