package com.example.shoppingcart.entity;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.bumptech.glide.Glide;

/*
    料理のマスタテーブル
 */
@Entity( tableName = "cook")
public class Cook {
    //テーブル定義
    @PrimaryKey(autoGenerate = false)
    @NonNull
    private int cook_id;

    @ColumnInfo(name = "cook_name")
    private String cook_name;

    @ColumnInfo(name = "favorite")
    private int favorite;

    @ColumnInfo(name = "img_url")
    private String img_url;

    @ColumnInfo(name = "recipe_url")
    private String recipe_url;

    @ColumnInfo(name = "cook_time")
    private int cook_time;

    //ゲッターたち
    public int getCook_id() {
        return cook_id;
    }

    public String getCook_name() {
        return cook_name;
    }

    public int getFavorite() {
        return favorite;
    }

    public String getImg_url() {
        return img_url;
    }

    public String getRecipe_url() {
        return recipe_url;
    }

    public int getCook_time() {
        return cook_time;
    }

    //セッターたち
    public void setCook_id(int cook_id) {
        this.cook_id = cook_id;
    }

    public void setCook_name(String cook_name) {
        this.cook_name = cook_name;
    }

    public void setFavorite(int favorite) {
        this.favorite = favorite;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public void setRecipe_url(String recipe_url) {
        this.recipe_url = recipe_url;
    }

    public void setCook_time(int cook_time) {
        this.cook_time = cook_time;
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

        @BindingAdapter("android:cookImage")
            public static void loadImage(ImageView imageView, String imageUrl) {
                Glide.with(imageView)
                        .load(imageUrl)
                        .fitCenter()
                        .into(imageView);
             }

}

