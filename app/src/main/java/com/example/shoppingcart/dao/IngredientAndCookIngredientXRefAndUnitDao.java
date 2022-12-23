package com.example.shoppingcart.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.shoppingcart.entity.CookIngredientXRef;
import com.example.shoppingcart.entity.relation.IngredientAndCookIngredientXRefAndUnit;

import java.util.List;

@Dao
public interface IngredientAndCookIngredientXRefAndUnitDao {

//    @Transaction
//    @Query("SELECT * FROM cook")
//    LiveData<List<IngredientAndCookIngredientXRefAndUnit>> getAllIngredientAndCookIngredientXRefAndUnit();
}
