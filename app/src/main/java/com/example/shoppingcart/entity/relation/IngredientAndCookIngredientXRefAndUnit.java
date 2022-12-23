package com.example.shoppingcart.entity.relation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.shoppingcart.entity.Unit;

public class IngredientAndCookIngredientXRefAndUnit {
    @Embedded(prefix = "ingredient")
    public IngredientAndCookIngredientXRef ingredientAndCookIngredientXRef;
    @Relation(
            parentColumn = "unit_id",
            entityColumn = "unit_id"
    )
    public Unit unit;

    public int getIngredient_id(){
        return ingredientAndCookIngredientXRef.ingredient.getIngredient_id();
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }
    public static DiffUtil.ItemCallback<IngredientAndCookIngredientXRefAndUnit> itemCallback = new DiffUtil.ItemCallback<IngredientAndCookIngredientXRefAndUnit>() {
        @Override
        public boolean areItemsTheSame(@NonNull IngredientAndCookIngredientXRefAndUnit oldItem, @NonNull IngredientAndCookIngredientXRefAndUnit newItem) {
            return oldItem.getIngredient_id() == newItem.getIngredient_id();
        }

        @Override
        public boolean areContentsTheSame(@NonNull IngredientAndCookIngredientXRefAndUnit oldItem, @NonNull IngredientAndCookIngredientXRefAndUnit newItem) {
            return oldItem.equals(newItem);
        }
    };


}
