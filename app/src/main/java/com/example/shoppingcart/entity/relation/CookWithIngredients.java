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

// cook多と食材多の関連付けエンティティクラス
public class CookWithIngredients {
//    @Embedded(prefix = "cook_with_ingredients")
//    public Cook cook;
//    @Relation(
//            entity = Ingredient.class,
//            parentColumn = "cook_id",
//            entityColumn = "ingredient_id",
//            associateBy = @Junction(
//                    value = CookIngredientXRef.class
//            )
//    )
////    @Embedded
////    CookIngredientXRef cookIngredientXRef;
////
////    @Relation( entity = Cook.class, parentColumn = "cook_id", entityColumn = "orderId")
////    Cook cook;
////    @Relation(entity = Ingredient.class, parentColumn = "ingredient_id", entityColumn = "ingredient_id")
////    Ingredient ingredient;
////
//    public List<Ingredient> ingredients;
//
//    public int getCook_id(){
//        return cook.getCook_id();
//    }
//    public List<Ingredient> getIngredients(){
//        return ingredients;
//    }
//
//    @Override
//    public boolean equals(@Nullable Object obj) {
//        return super.equals(obj);
//    }
//
//    public static DiffUtil.ItemCallback<CookWithIngredients> itemCallback = new DiffUtil.ItemCallback<CookWithIngredients>() {
//        @Override
//        public boolean areItemsTheSame(@NonNull CookWithIngredients oldItem, @NonNull CookWithIngredients newItem) {
//            return oldItem.getCook_id() == newItem.getCook_id();
//        }
//
//        @Override
//        public boolean areContentsTheSame(@NonNull CookWithIngredients oldItem, @NonNull CookWithIngredients newItem) {
//            return oldItem.equals(newItem);
//        }
//    };
}
