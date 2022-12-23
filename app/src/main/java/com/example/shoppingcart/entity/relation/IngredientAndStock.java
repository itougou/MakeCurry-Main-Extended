package com.example.shoppingcart.entity.relation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Relation;

import com.example.shoppingcart.entity.Ingredient;
import com.example.shoppingcart.entity.Stock;

import java.util.List;

@Entity
public class IngredientAndStock {
    @Embedded
    public Ingredient ingredient;
    @Relation(
            parentColumn = "ingredient_id",
            entityColumn = "ingredient_id"
    )
    public Stock stock;


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

    public static DiffUtil.ItemCallback<IngredientAndStock> itemCallback = new DiffUtil.ItemCallback<IngredientAndStock>() {
        @Override
        public boolean areItemsTheSame(@NonNull IngredientAndStock oldItem, @NonNull IngredientAndStock newItem) {
            return oldItem.getStock_id() == newItem.getStock_id() && oldItem.getStock_id() == newItem.getStock_id();
        }

        @Override
        public boolean areContentsTheSame(@NonNull IngredientAndStock oldItem, @NonNull IngredientAndStock newItem) {
            return oldItem.equals(newItem);
        }
    };

}
