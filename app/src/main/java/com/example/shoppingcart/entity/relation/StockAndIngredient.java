package com.example.shoppingcart.entity.relation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.shoppingcart.entity.Ingredient;
import com.example.shoppingcart.entity.Stock;

import java.util.List;

/*
*   冷蔵庫と食材のリレーション( 1:多 = 冷蔵庫:食材s)を表すクラス
*/
public class StockAndIngredient {
    @Embedded/*(prefix = "stock_ingredient")*/
    public Stock stock;
    @Relation(
            parentColumn = "ingredient_id",
            entityColumn = "ingredient_id"
    )
    public Ingredient ingredient;

    public int getStock_id(){
        return stock.getStock_id();
    }
    public int getIngredient_id(){
        return stock.getIngredient_id();
    }
    public Ingredient getIngredient(){
        return ingredient;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }

    public static DiffUtil.ItemCallback<StockAndIngredient> itemCallback = new DiffUtil.ItemCallback<StockAndIngredient>() {
        @Override
        public boolean areItemsTheSame(@NonNull StockAndIngredient oldItem, @NonNull StockAndIngredient newItem) {
            return oldItem.getStock_id() == newItem.getStock_id() && oldItem.getStock_id() == newItem.getStock_id();
        }

        @Override
        public boolean areContentsTheSame(@NonNull StockAndIngredient oldItem, @NonNull StockAndIngredient newItem) {
            return oldItem.equals(newItem);
        }
    };
}
