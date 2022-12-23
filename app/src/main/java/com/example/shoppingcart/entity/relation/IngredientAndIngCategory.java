package com.example.shoppingcart.entity.relation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.shoppingcart.entity.IngCategory;
import com.example.shoppingcart.entity.Ingredient;

/*
    ingredientテーブルとcategoryテーブルの多:1リレーションクラス
 */
public class IngredientAndIngCategory {
    @Embedded(prefix = "ingredient_ing_category")
    public Ingredient ingredient;
    @Relation(
            parentColumn = "category_id",
            entityColumn = "category_id"
    )
    public IngCategory ing_category;

    public int getIngredient_id() {
        return ingredient.getIngredient_id();
    }

    public int getCategory_id() {
        return ing_category.getCategory_id();
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }

    public static DiffUtil.ItemCallback<IngredientAndIngCategory> itemCallback = new DiffUtil.ItemCallback<IngredientAndIngCategory>() {
        @Override
        public boolean areItemsTheSame(@NonNull IngredientAndIngCategory oldItem, @NonNull IngredientAndIngCategory newItem) {
            return oldItem.getIngredient_id() == newItem.getIngredient_id();
        }

        @Override
        public boolean areContentsTheSame(@NonNull IngredientAndIngCategory oldItem, @NonNull IngredientAndIngCategory newItem) {
            return oldItem.equals(newItem);
        }
    };
}
