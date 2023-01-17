package com.example.shoppingcart.entity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.room.ColumnInfo;
import androidx.room.DatabaseView;


@DatabaseView(
        viewName = "IngWithXRefAndUnitAndStock",
        value = "SELECT" +
                "  xref.cook_id AS xref_cook_id," +
                "  xref.quantity AS xref_quantity," +
                "  ing.ingredient_id AS ingredient_id," +
                "  ing.ing_name AS ing_name," +
                "  st.quantity AS st_quantity," +
                "  u.unit_name AS unit_name," +
                "  st.add_date AS add_date," +
                "  st.stock_id AS stock_id" +
                " FROM" +
                "  cook_ingredient_xref AS xref" +
                "  LEFT OUTER JOIN" +
                "  ingredient AS ing" +
                " ON xref.ingredient_id = ing.ingredient_id" +
                " LEFT OUTER JOIN" +
                "  unit AS u" +
                " ON ing.unit_id = u.unit_id" +
                " LEFT OUTER JOIN" +
                "  stock AS st" +
                " ON ing.ingredient_id = st.ingredient_id"

// 2023.1.16
//        value = "SELECT" +
//                " ing.ingredient_id AS ingredient_id," +
//                " ing.ing_name AS ing_name," +
//                " xref.quantity AS xref_quantity," +
//                " xref.cook_id AS xref_cook_id," +
//                " st.quantity AS st_quantity," +
//                " u.unit_name AS unit_name" +
//                " FROM " +
//                " ingredient AS ing " +
//                " INNER JOIN" +
//                " cook_ingredient_xref AS xref" +
//                " ON" +
//                " ing.ingredient_id = xref.ingredient_id" +
//                " INNER JOIN " +
//                " unit AS u" +
//                " ON ing.unit_id = u.unit_id" +
//                " INNER JOIN" +
//                " stock AS st" +
//                " ON ing.ingredient_id = st.ingredient_id"
)

public class IngWithXRefAndUnitAndStock {
    @ColumnInfo(name = "ingredient_id")
    private int ingredient_id;
    @ColumnInfo(name = "ing_name")
    private String ing_name;
    @ColumnInfo(name = "xref_quantity")
    private int xref_quantity;
    @ColumnInfo(name = "xref_cook_id")
    private int xref_cook_id;
    @ColumnInfo(name = "st_quantity")
    private int st_quantity;
    @ColumnInfo(name = "unit_name")
    private String unit_name;
    @ColumnInfo(name = "add_date")
    private String add_date;
    @ColumnInfo(name = "stock_id")
    private int stock_id;

    public IngWithXRefAndUnitAndStock(int ingredient_id, String ing_name, int xref_quantity, int xref_cook_id, int st_quantity, String unit_name, String add_date, int stock_id) {
        this.ingredient_id = ingredient_id;
        this.ing_name = ing_name;
        this.xref_quantity = xref_quantity;
        this.xref_cook_id = xref_cook_id;
        this.st_quantity = st_quantity;
        this.unit_name = unit_name;
        this.add_date = add_date;
        this.stock_id = stock_id;
    }

    public void setAdd_date(String add_date) {
        this.add_date = add_date;
    }

    public void setStock_id(int stock_id) {
        this.stock_id = stock_id;
    }

    public String getAdd_date() {
        return add_date;
    }

    public int getStock_id() {
        return stock_id;
    }

    public int getIngredient_id() {
        return ingredient_id;
    }

    public String getIng_name() {
        return ing_name;
    }

    public int getXref_quantity() {
        return xref_quantity;
    }

    public int getXref_cook_id() { return xref_cook_id; }

    public int getSt_quantity() {
        return st_quantity;
    }

    public String getUnit_name() {
        return unit_name;
    }

    public void setIngredient_id(int ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public void setIng_name(String ing_name) {
        this.ing_name = ing_name;
    }

    public void setXref_quantity(int xref_quantity) {
        this.xref_quantity = xref_quantity;
    }

    public void setXref_cook_id(int xref_cook_id) {
        this.xref_cook_id = xref_cook_id;
    }

    public void setSt_quantity(int st_quantity) {
        this.st_quantity = st_quantity;
    }

    public void setUnit_name(String unit_name) {
        this.unit_name = unit_name;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }

    public static DiffUtil.ItemCallback<IngWithXRefAndUnitAndStock> itemCallback = new DiffUtil.ItemCallback<IngWithXRefAndUnitAndStock>() {
        @Override
        public boolean areItemsTheSame(@NonNull IngWithXRefAndUnitAndStock oldItem, @NonNull IngWithXRefAndUnitAndStock newItem) {
            return oldItem.getIngredient_id() == newItem.getIngredient_id();
        }

        @Override
        public boolean areContentsTheSame(@NonNull IngWithXRefAndUnitAndStock oldItem, @NonNull IngWithXRefAndUnitAndStock newItem) {
            return oldItem.equals(newItem);
        }
    };
}
