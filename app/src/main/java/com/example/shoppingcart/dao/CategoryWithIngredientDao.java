package com.example.shoppingcart.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.shoppingcart.entity.CategoryWithIngredient;
import com.example.shoppingcart.entity.CategoryWithIngredient2;

import java.util.List;

@Dao
public interface CategoryWithIngredientDao {
    //全部のカテゴリーごとの食材情報を取り出す
    @Query("SELECT * FROM categoryWithIngredient" )
    public LiveData<List<CategoryWithIngredient>> findAll();

    @Transaction
    @Query("SELECT * FROM ing_category" )
    public LiveData<List<CategoryWithIngredient2>> findAll2();
}
