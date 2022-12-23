package com.example.shoppingcart.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.shoppingcart.entity.relation.CookWithIngredientAndUnit;

import java.util.List;

@Dao
public interface CookWithIngredientAndUnitDao {
//    @Transaction
//    @Query("select * from cook")
//    LiveData<List<CookWithIngredientAndUnit>> getCookWithIngredientAndUnit();
}
