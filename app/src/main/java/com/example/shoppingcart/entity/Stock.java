package com.example.shoppingcart.entity;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "stock")
public class Stock {
    //@PrimaryKey(autoGenerate = false)　AutoIncrementに変更（テーブルも）
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int stock_id;

    @ColumnInfo(name = "ingredient_id" , defaultValue = "0")
    private int ingredient_id;

    @ColumnInfo(name = "quantity")
    private int quantity;

    @ColumnInfo(name = "add_date")
    private String add_date;

    public Stock(/*int stock_id,*/int ingredient_id, int quantity, String add_date) {
        //this.stock_id = stock_id;
        this.ingredient_id = ingredient_id;
        this.quantity = quantity;
        this.add_date = add_date;
    }

    public int getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(int ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAdd_date() {
        return add_date;
    }

    public void setAdd_date(String add_date) {
        this.add_date = add_date;
    }

    public void setStock_id(int stock_id) {
        this.stock_id = stock_id;
    }

    public int getStock_id() {
        return this.stock_id;
    }

    public static DiffUtil.ItemCallback<Cook> itemCallback = new DiffUtil.ItemCallback<Cook>() {
        @Override
        public boolean areItemsTheSame(@NonNull Cook oldItem, @NonNull Cook newItem) {
            return oldItem.getCook_id() == newItem.getCook_id();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Cook oldItem, @NonNull Cook newItem) {
            return oldItem.equals(newItem);
        }
    };

}

