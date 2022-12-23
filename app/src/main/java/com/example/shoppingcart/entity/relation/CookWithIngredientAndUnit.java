package com.example.shoppingcart.entity.relation;

import androidx.lifecycle.LiveData;
import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.example.shoppingcart.entity.Cook;
import com.example.shoppingcart.entity.CookIngredientXRef;
import com.example.shoppingcart.entity.Unit;

import java.util.List;

public class CookWithIngredientAndUnit {
//    @Embedded(prefix = "cook_with_ingredient_unit")
//    public Cook cook;
//
//    @Relation(
//            entity = Unit.class,
//            parentColumn = "cook_id",
//            entityColumn = "unit_id"
//    )
//    public List<CookIngredientXRef> cookWithIngredientAndUnitList ;
}
