package com.example.shoppingcart.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.shoppingcart.entity.CategoryWithIngredient;
import com.example.shoppingcart.entity.CategoryWithIngredient2;
import com.example.shoppingcart.entity.CategoryWithIngredientAndUnit;

import java.util.List;

@Dao
public interface CategoryWithIngredientAndUnitDao {
    //全部のカテゴリーごとの食材情報を取り出す
    @Query("SELECT * FROM categoryWithIngredientAndUnit" )
    public LiveData<List<CategoryWithIngredientAndUnit>> findAll();

}
