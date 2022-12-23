package com.example.shoppingcart.entity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

/*
* 料理と食材の関係をあらわす中間（ジャンクション）？結合テーブルcook_ingredient_xref
*/

@Entity( tableName = "cook_ingredient_xref",
        indices = @Index(value = "ingredient_id") ,
        primaryKeys = {"cook_id" , "ingredient_id"}
        )

public class CookIngredientXRef {
    //　複合主キー
    @ColumnInfo(name = "cook_id")
    @NonNull
    private int cook_id;
    @ColumnInfo(name = "ingredient_id")
    @NonNull
    private int ingredient_id;

    //　
    @ColumnInfo(name = "quantity")
    private int quantity;

    //ゲッター
    public int getCook_id() {
        return cook_id;
    }

    public int getIngredient_id() {
        return ingredient_id;
    }

    public int getQuantity() {
        return quantity;
    }

    //セッター
    public void setCook_id(int cook_id) {
        this.cook_id = cook_id;
    }

    public void setIngredient_id(int ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }
}
