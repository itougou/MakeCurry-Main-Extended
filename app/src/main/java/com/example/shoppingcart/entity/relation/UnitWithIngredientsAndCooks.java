package com.example.shoppingcart.entity.relation;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.shoppingcart.entity.Ingredient;
import com.example.shoppingcart.entity.Unit;
import com.example.shoppingcart.entity.relation.IngredientWithCooks;

import java.util.List;

public class UnitWithIngredientsAndCooks {
    @Embedded(prefix = "unit_ingredient_cook")
    public Unit unit;
    @Relation(
            entity = Ingredient.class,
            parentColumn = "unit_id",
            entityColumn = "unit_id"
    )
    public List<IngredientWithCooks> ingredientWithCooksList;
}
