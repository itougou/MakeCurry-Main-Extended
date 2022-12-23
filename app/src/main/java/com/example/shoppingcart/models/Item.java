package com.example.shoppingcart.models;

//食材名（画面表示用）
public class Item {
    // フィールド
    private final String content;   //食材名
    //コンストラクタ
    public Item(String content){
        this.content = content;
    }
    // ゲッターセッター
    public String getContent() { return content;}
    // public void setContent(String content) { this.content = content;}
}
