package com.example.shoppingcart.entity.relation;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.shoppingcart.entity.Ingredient;

public class IngredientAndIngCategoryAndUnit {
    @Embedded(prefix = "ingredient_ing_category_unit")
    public Ingredient ingredient;
    public IngredientAndIngCategory ingredientAndIngCategory;
    public IngredientAndUnit ingredientAndUnit;
}
