package com.example.shoppingcart.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface CookAndCookdetailDao {
//    @Transaction
//    @Query("SELECT * FROM cook")
//    LiveData<List>

//    @Transaction
//    @Query("SELECT * FROM cook WHERE cook.cook_id = :cook_id")
//    LiveData<List<CookAndCookdetail>> search(int cook_id);
}
