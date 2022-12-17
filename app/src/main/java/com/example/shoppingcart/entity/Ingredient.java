package com.example.shoppingcart.entity;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.shoppingcart.models.Product;

@Entity( tableName = "ingredient")

public class Ingredient {
    //テーブル定義
    @PrimaryKey(autoGenerate = false)
    @NonNull
    private int ingredient_id;

    @ColumnInfo(name = "category_id")
    private int category_id;

    @ColumnInfo(name = "unit_id")
    private int unit_id;

    @ColumnInfo(name = "ing_name")
    private String ing_name;

    @ColumnInfo(name = "expiration_date")
    private int expiration_date;

    @ColumnInfo(name = "img_url")
    private String img_url;

    //ゲッターたち
    public int getIngredient_id() {return ingredient_id;}

    public int getCategory_id() {return category_id;}

    public int getUnit_id() {return unit_id;}

    public String getIng_name() {return ing_name;}

    public int getExpiration_date() {return expiration_date;}

    public String getImg_url() {return img_url;}

    //セッターたち
    public void setIngredient_id(int ingredient_id) {this.ingredient_id = ingredient_id;}

    public void setCategory_id(int category_id) {this.category_id = category_id;}

    public void setUnit_id(int unit_id) {this.unit_id = unit_id;}

    public void setIng_name(String ing_name) {this.ing_name = ing_name;}

    public void setExpiration_date(int expiration_date) {this.expiration_date = expiration_date;}

    public void setImg_url(String img_url) {this.img_url = img_url;}

    //
    public boolean equals(Ingredient ingredient) {
        return this.ingredient_id == ingredient.ingredient_id;
    }


    public static DiffUtil.ItemCallback<Ingredient> itemCallback = new DiffUtil.ItemCallback<Ingredient>() {
        @Override
        public boolean areItemsTheSame(@NonNull Ingredient oldItem, @NonNull Ingredient newItem) {
            return oldItem.getIngredient_id() == newItem.getIngredient_id();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Ingredient oldItem, @NonNull Ingredient newItem) {
            return oldItem.equals(newItem);
        }
    };
}
