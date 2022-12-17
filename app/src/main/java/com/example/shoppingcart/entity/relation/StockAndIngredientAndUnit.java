package com.example.shoppingcart.entity.relation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.shoppingcart.entity.Ingredient;
import com.example.shoppingcart.entity.Stock;
import com.example.shoppingcart.entity.Unit;

/*
 *   冷蔵庫と食材のリレーション( 1:１ = 冷蔵庫:食材s)を表すクラス
 */
public class StockAndIngredientAndUnit {
//    @Embedded public StockAndIngredient stockAndIngredient;
//    @Relation(
//            entity = Ingredient.class,
//            parentColumn = "unit_id",
//            entityColumn = "unit_id"
//    )
//    public Unit unit;
//
//    public int getStock_id(){
//        return this.getStock_id();
//    }
//    public StockAndIngredient getStockAndIngredient() {
//        return stockAndIngredient;
//    }
//
//    public void setStockAndIngredient(StockAndIngredient stockAndIngredient) {
//        this.stockAndIngredient = stockAndIngredient;
//    }
//
//    public Unit getUnit() {
//        return unit;
//    }
//
//    public void setUnit(Unit unit) {
//        this.unit = unit;
//    }
//
//
//
//    @Override
//    public boolean equals(@Nullable Object obj) {
//        return super.equals(obj);
//    }
//
//    public static DiffUtil.ItemCallback<StockAndIngredientAndUnit> itemCallback = new DiffUtil.ItemCallback<StockAndIngredientAndUnit>() {
//        @Override
//        public boolean areItemsTheSame(@NonNull StockAndIngredientAndUnit oldItem, @NonNull StockAndIngredientAndUnit newItem) {
//            return oldItem.getStock_id() == newItem.getStock_id() && oldItem.getStock_id() == newItem.getStock_id();
//        }
//
//        @Override
//        public boolean areContentsTheSame(@NonNull StockAndIngredientAndUnit oldItem, @NonNull StockAndIngredientAndUnit newItem) {
//            return oldItem.equals(newItem);
//        }
//    };
}