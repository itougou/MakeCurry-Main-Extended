package com.example.shoppingcart.entity;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
/*
 *   単位のマスターテーブル
 */
@Entity(tableName = "unit")
public class Unit {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "unit_id")
    private int unit_id;//単位id

    @ColumnInfo(name = "unit_name")
    private String unit_name;// 単位名mlなど

    // getter and setter
    public int getUnit_id() {
        return unit_id;
    }

    public void setUnit_id(int unit_id) {
        this.unit_id = unit_id;
    }

    public String getUnit_name() {
        return unit_name;
    }

    public void setUnit_name(String unit_name) {
        this.unit_name = unit_name;
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