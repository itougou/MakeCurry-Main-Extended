package com.example.shoppingcart.entity.relation;


import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.shoppingcart.entity.CookIngredientXRef;
import com.example.shoppingcart.entity.Ingredient;

public class IngredientAndCookIngredientXRef {
    @Embedded(prefix = "cook_ingredient_xref")
    public Ingredient ingredient;
    @Relation(
            parentColumn = "ingredient_id",
            entityColumn = "ingredient_id"
    )
    public CookIngredientXRef cookIngredientXRef;
}
