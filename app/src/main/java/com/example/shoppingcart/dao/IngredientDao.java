package com.example.shoppingcart.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.shoppingcart.entity.CookIngredientXRef;
import com.example.shoppingcart.entity.Ingredient;
import com.example.shoppingcart.entity.relation.IngredientWithCooks;

import java.util.List;

@Dao
public interface IngredientDao {
    @Transaction
    @Query("SELECT * FROM ingredient")
    LiveData<List<Ingredient>> getAll();

    // ingredientテーブルから食材名,単位,画像をすべて表示するメソッド
    // 食材名テーブルingredientから食材名,単位,画像をすべて表示するメソッド
    @Transaction
    @Query("SELECT * FROM ingredient")
    LiveData<List<Ingredient>> getAllIngredients();

//    @Transaction
//    @Query("SELECT * FROM ingredient")
//    LiveData<List<IngredientWithCooks>> getIngredientWithCooks();

    @Transaction
    @Query("SELECT * FROM cook_ingredient_xref")
    List<CookIngredientXRef> getCookIngredientXRef();



    // 分類でソートされた食材をすべて表示
    @Transaction
    @Query("SELECT * FROM ingredient WHERE category_id = :category_id")
    LiveData<List<Ingredient>> getIngredientsByCategory(int category_id);

    // キーワード検索(前方一致)
    @Transaction
    @Query("SELECT * FROM ingredient WHERE ing_name LIKE :ing_name + '%'")
    LiveData<List<Ingredient>> getIngredientsByName(String ing_name);

    // キーワード検索(完全一致)
    @Transaction
    @Query("SELECT * FROM ingredient WHERE ing_name LIKE :ing_name")
    LiveData<List<Ingredient>> getIngredientsByFUllName(String ing_name);
}
