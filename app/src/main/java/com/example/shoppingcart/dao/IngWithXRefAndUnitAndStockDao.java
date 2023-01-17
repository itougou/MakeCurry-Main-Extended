package com.example.shoppingcart.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.example.shoppingcart.entity.IngWithXRefAndUnitAndStock;

import java.util.List;

@Dao
public interface IngWithXRefAndUnitAndStockDao {
    //料理IDが一致するものを取り出す
    @Query("SELECT * FROM IngWithXRefAndUnitAndStock WHERE xref_cook_id = :cook_id ORDER BY ingredient_id" )
    public LiveData<List<IngWithXRefAndUnitAndStock>> findByCookId(int cook_id);
    //2023.1.16
    @Query("SELECT xref_cook_id,xref_quantity,ingredient_id,ing_name,SUM(st_quantity) AS st_quantity,unit_name,add_date,stock_id FROM IngWithXRefAndUnitAndStock WHERE xref_cook_id = :cook_id GROUP BY ingredient_id ORDER BY ingredient_id,add_date" )

    public LiveData<List<IngWithXRefAndUnitAndStock>> findByCookIdGroupByIng(int cook_id);

}
