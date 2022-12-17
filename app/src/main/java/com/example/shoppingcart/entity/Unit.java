package com.example.shoppingcart.entity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity( tableName = "unit")
public class Unit {
    @PrimaryKey(autoGenerate = false)
    @NonNull
    private int unit_id;

    @ColumnInfo(name = "unit_name")
    private String unit_name;

    public Unit(int unit_id, String unit_name) {
        this.unit_id = unit_id;
        this.unit_name = unit_name;
    }


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

    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }

    public static DiffUtil.ItemCallback<Unit> itemCallback = new DiffUtil.ItemCallback<Unit>() {
        @Override
        public boolean areItemsTheSame(@NonNull Unit oldItem, @NonNull Unit newItem) {
            return oldItem.getUnit_id() == newItem.getUnit_id();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Unit oldItem, @NonNull Unit newItem) {
            return oldItem.equals(newItem);
        }
    };
}
