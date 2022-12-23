package com.example.shoppingcart.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.example.shoppingcart.entity.IngWithXRefAndUnitAndStock;

import java.util.List;

@Dao
public interface IngWithXRefAndUnitAndStockDao {
    //料理IDが一致するものを取り出す
    @Query("SELECT * FROM IngWithXRefAndUnitAndStock WHERE xref_cook_id = :cook_id" )
    public LiveData<List<IngWithXRefAndUnitAndStock>> findByCookId(int cook_id);

}
