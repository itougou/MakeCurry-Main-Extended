package com.example.shoppingcart.models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

//食材名（画面表示用）
public class Item {
    // フィールド
    private final String content;   //食材名
    private final int suu;   //数
    private final String unit_name;   //単位名
    //コンストラクタ
    public Item(String content, int suu, String unit_name) {
        this.content = content;
        this.suu = suu;
        this.unit_name = unit_name;
    }

    // ゲッターセッター

    public int getSuu() {
        return suu;
    }
    public String getUnit_name() {
        return unit_name;
    }
    public String getContent() { return content;}

//    @Override
//    public boolean equals(@Nullable Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Item item = (Item) o;
//        return item.getUnit_name().equals(this.getUnit_name()) &&
//                item.getContent().equals(this.getContent()) &&
//                item.getSuu() == this.getSuu();
//    }
//
//    public static DiffUtil.ItemCallback<Item> itemCallback = new DiffUtil.ItemCallback<Item>() {
//        @Override
//        public boolean areItemsTheSame(@NonNull Item oldItem, @NonNull Item newItem) {
//            return oldItem.getContent() == newItem.getContent() && oldItem.getSuu() == newItem.getSuu();
//        }
//
//        @Override
//        public boolean areContentsTheSame(@NonNull Item oldItem, @NonNull Item newItem) {
//            return oldItem.equals(newItem);
//        }
//    };
}
