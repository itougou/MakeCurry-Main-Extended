package com.example.shoppingcart.models;


import java.util.Arrays;
import java.util.List;

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

}