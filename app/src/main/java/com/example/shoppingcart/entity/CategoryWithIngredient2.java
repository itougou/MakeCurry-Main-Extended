package com.example.shoppingcart.entity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.room.ColumnInfo;
import androidx.room.DatabaseView;
import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.shoppingcart.models.Category;

import java.util.List;

//2022.12.23
/*
 *   カテゴリーと食材のリレーション( 1:多 )を表すクラス
 */
public class CategoryWithIngredient2 {

    @Embedded
    public IngCategory ingCategory;
    @Relation(
            parentColumn = "category_id",
            entityColumn = "category_id"
    )
    public List<Ingredient> ingredients;

    public int getCategory_id() {
        return ingCategory.getCategory_id();
    }

    public String getCategory_name() {
        return ingCategory.getCategory_name();
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }


    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }

    public static DiffUtil.ItemCallback<CategoryWithIngredient2> itemCallback = new DiffUtil.ItemCallback<CategoryWithIngredient2>() {
        @Override
        public boolean areItemsTheSame(@NonNull CategoryWithIngredient2 oldItem, @NonNull CategoryWithIngredient2 newItem) {
            return oldItem.getCategory_id() == newItem.getCategory_id() ;
        }

        @Override
        public boolean areContentsTheSame(@NonNull CategoryWithIngredient2 oldItem, @NonNull CategoryWithIngredient2 newItem) {
            return oldItem.equals(newItem);
        }
    };
}
