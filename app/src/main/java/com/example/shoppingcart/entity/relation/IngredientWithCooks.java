package com.example.shoppingcart.entity.relation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.example.shoppingcart.entity.Cook;
import com.example.shoppingcart.entity.CookIngredientXRef;
import com.example.shoppingcart.entity.Ingredient;

import java.util.List;
//ingredientとcook多の関連付けエンティティクラス
public class IngredientWithCooks {
//    @Embedded(prefix = "ingredient_cooks")
//    public Ingredient ingredient;
//    @Relation(
//            entity = Cook.class,
//            parentColumn = "ingredient_id",
//            entityColumn = "cook_id",
//            associateBy = @Junction(
//                    value = CookIngredientXRef.class
//            )
//    )
//    public List<Cook> cooks;
//
//    public int getIngredient_id(){
//        return ingredient.getIngredient_id();
//    }
//
//    public List<Cook> getCooks(){
//        return cooks;
//    }
//
//    @Override
//    public boolean equals(@Nullable Object obj) {
//        return super.equals(obj);
//    }
//    public static DiffUtil.ItemCallback<IngredientWithCooks> itemCallback = new DiffUtil.ItemCallback<IngredientWithCooks>() {
//        @Override
//        public boolean areItemsTheSame(@NonNull IngredientWithCooks oldItem, @NonNull IngredientWithCooks newItem) {
//            return oldItem.getIngredient_id() == newItem.getIngredient_id();
//        }
//
//        @Override
//        public boolean areContentsTheSame(@NonNull IngredientWithCooks oldItem, @NonNull IngredientWithCooks newItem) {
//            return oldItem.equals(newItem);
//        }
//    };
}
