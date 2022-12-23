package com.example.shoppingcart.entity.relation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.shoppingcart.entity.Ingredient;
import com.example.shoppingcart.entity.Unit;

/*
    ingredientテーブルとunitテーブルの1:1リレーションクラス
 */
public class IngredientAndUnit {
    @Embedded(prefix = "ingredient_unit")
    public Ingredient ingredient;
    @Relation(
            parentColumn = "unit_id",
            entityColumn = "unit_id"
    )
    public Unit unit;

    public int getIngredient_id(){
        return ingredient.getIngredient_id();
    }
    public int getUnit_id(){
        return unit.getUnit_id();
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }
    public static DiffUtil.ItemCallback<IngredientAndUnit> itemCallback = new DiffUtil.ItemCallback<IngredientAndUnit>() {
        @Override
        public boolean areItemsTheSame(@NonNull IngredientAndUnit oldItem, @NonNull IngredientAndUnit newItem) {
            return oldItem.getIngredient_id() == newItem.getIngredient_id();
        }

        @Override
        public boolean areContentsTheSame(@NonNull IngredientAndUnit oldItem, @NonNull IngredientAndUnit newItem) {
            return oldItem.equals(newItem);
        }
    };
}
