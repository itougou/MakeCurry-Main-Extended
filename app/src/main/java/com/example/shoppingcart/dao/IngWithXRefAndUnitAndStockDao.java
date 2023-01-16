package com.example.shoppingcart.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.example.shoppingcart.entity.IngWithXRefAndUnitAndStock;

import java.util.List;

@Dao
public interface IngWithXRefAndUnitAndStockDao {
    //料理IDが一致するものを取り出す
    //2023.1.16
    // @Query("SELECT * FROM IngWithXRefAndUnitAndStock WHERE xref_cook_id = :cook_id" )
    @Query("SELECT xref_cook_id,xref_quantity,ingredient_id,ing_name,SUM(st_quantity) AS st_quantity,unit_name FROM IngWithXRefAndUnitAndStock WHERE xref_cook_id = :cook_id GROUP BY ingredient_id" )

    public LiveData<List<IngWithXRefAndUnitAndStock>> findByCookId(int cook_id);

}
