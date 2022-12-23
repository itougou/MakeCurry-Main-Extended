package com.example.shoppingcart.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.shoppingcart.entity.relation.IngredientAndUnit;

import java.util.List;
/*
    ingredientテーブルとunitテーブルのリレーションのdaoクラス
 */
@Dao
public interface IngredientAndUnitDao {
    // ingredientテーブルからすべての食材を表示するメソッド(単位付きで)
    @Transaction
    @Query("SELECT * FROM ingredient")
    public LiveData<List<IngredientAndUnit>> getIngredientWithUnit();

    /* 食材名,単位名,食材の画像カラムを表示するメソッド*/
    // キーワード検索(前方一致) 単位付き
    @Transaction
    @Query( "SELECT ingredient.ing_name,unit.unit_name,ingredient.img_url " +
            "FROM ingredient,unit " +
            "WHERE ingredient.ing_name " + "LIKE :ing_name + '%'")
    public LiveData<List<IngredientAndUnit>> getIngredientsByName(String ing_name);
    // キーワード検索(完全一致) 単位付き
    @Transaction
    @Query( "SELECT ingredient.ing_name,unit.unit_name,ingredient.img_url " +
            "FROM ingredient,unit " +
            "WHERE ingredient.ing_name LIKE :ing_name")
    public LiveData<List<IngredientAndUnit>> getIngredientsByFUllName(String ing_name);
}
