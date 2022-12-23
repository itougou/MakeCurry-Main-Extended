package com.example.shoppingcart.entity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.room.DatabaseView;

/*
 Stock　と　Ingredient　と　Unit　を INNER JOIN で結合した 表を取り出すSQL文を実行し結果を格納するクラス
 */
@DatabaseView(
        viewName = "StockWithIngredientsAndUnit",
        value = "SELECT" +
                " ingredient.ingredient_id,ingredient.ing_name,stock.quantity,unit.unit_name,stock.add_date" +
                " FROM" +
                " stock" +
                " INNER JOIN ingredient ON stock.ingredient_id = ingredient.ingredient_id" +
                " INNER JOIN unit ON ingredient.unit_id = unit.unit_id" +
                " ORDER BY ing_name,add_date"
)
public class StockWithIngredientsAndUnit {
    private int ingredient_id;
    private String ing_name;
    private int quantity;
    private String unit_name;
    private String add_date;

    public StockWithIngredientsAndUnit(int ingredient_id, String ing_name, int quantity, String unit_name, String add_date) {
        this.ingredient_id = ingredient_id;
        this.ing_name = ing_name;
        this.quantity = quantity;
        this.unit_name = unit_name;
        this.add_date = add_date;
    }

    public int getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(int ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public String getIng_name() {
        return ing_name;
    }

    public void setIng_name(String ing_name) {
        this.ing_name = ing_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit_name() {
        return unit_name;
    }

    public void setUnit_name(String unit_name) {
        this.unit_name = unit_name;
    }

    public String getAdd_date() {
        return add_date;
    }

    public void setAdd_date(String add_date) {
        this.add_date = add_date;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }

    public static DiffUtil.ItemCallback<StockWithIngredientsAndUnit> itemCallback = new DiffUtil.ItemCallback<StockWithIngredientsAndUnit>() {
        @Override
        public boolean areItemsTheSame(@NonNull StockWithIngredientsAndUnit oldItem, @NonNull StockWithIngredientsAndUnit newItem) {
            return oldItem.getIng_name().equals(newItem.getIng_name()) && oldItem.getAdd_date().equals(newItem.getAdd_date());
        }

        @Override
        public boolean areContentsTheSame(@NonNull StockWithIngredientsAndUnit oldItem, @NonNull StockWithIngredientsAndUnit newItem) {
            return oldItem.equals(newItem);
        }
    };
}