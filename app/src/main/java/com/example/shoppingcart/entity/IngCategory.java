package com.example.shoppingcart.entity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/*
    食材のカテゴリ（分類)のマスタテーブル
 */
@Entity(tableName = "ing_category")
public class IngCategory {
    @PrimaryKey
    @NonNull
    private int category_id;

    @ColumnInfo(name = "category_name")
    private String category_name;// 分類名

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
    @Override
    public boolean equals(@Nullable Object obj){
        return super.equals(obj);
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
