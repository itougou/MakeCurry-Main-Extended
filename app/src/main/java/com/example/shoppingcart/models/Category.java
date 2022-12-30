package com.example.shoppingcart.models;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

//分類ごとの食材情報（画面表示用）
public class Category{
    // フィールド
    private final String name;  //分類名
    private final List<Item> listOfItems;   //食材名
    //コンストラクタ
    public Category(String name, Item ... item){
        this.name = name;
        this.listOfItems = Arrays.asList(item);
    }
    // setter getter
    public String getName() { return name; }
    // public void setName(String name) { this.name = name;}

    // public void setListOfItems(List<Item> listOfItems) { this.listOfItems = listOfItems;}
    public List<Item> getListOfItems() { return listOfItems;}

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Category category = (Category) o;
//        return Objects.equals(name, category.name) && Objects.equals(listOfItems, category.listOfItems);
//    }
//
//
//    public static DiffUtil.ItemCallback<Category> itemCallback = new DiffUtil.ItemCallback<Category>() {
//        @Override
//        public boolean areItemsTheSame(@NonNull Category oldItem, @NonNull Category newItem) {
//            return oldItem.getName() == newItem.getName() && oldItem.getListOfItems() == newItem.getListOfItems();
//        }
//
//        @Override
//        public boolean areContentsTheSame(@NonNull Category oldItem, @NonNull Category newItem) {
//            return oldItem.equals(newItem);
//        }
//    };
}