package com.example.shoppingcart.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.shoppingcart.entity.relation.IngredientAndIngCategory;

import java.util.List;
/*
    ingredientテーブルとing_categoryテーブルのリレーションのdaoクラス
 */
@Dao
public interface IngredientAndIngCategoryDao {
    // ingredientテーブルからすべての食材を表示するメソッド(category付きで)
    @Transaction
    @Query("SELECT * FROM ingredient")
    LiveData<List<IngredientAndIngCategory>> getIngredientAndIngCategory();
}
