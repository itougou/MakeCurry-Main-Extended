package com.example.shoppingcart.entity.relation;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.shoppingcart.entity.IngCategory;
import com.example.shoppingcart.entity.Ingredient;

import java.util.List;

public class IngCategoryWithIngredientsAndCooks {
    @Embedded(prefix = "ing_category_with_ingredients_cooks")
    public IngCategory ingCategory;
    @Relation(
            entity = Ingredient.class,
            parentColumn = "category_id",
            entityColumn = "category_id"
    )
    public List<IngredientWithCooks> ingredientWithCooksList;

}
