package com.example.shoppingcart.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingcart.R;
import com.example.shoppingcart.entity.Ingredient;
import com.example.shoppingcart.models.Category;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder> {
    // フィールド
    private final Context context;
    private final List<Category> listOfCategories;

    //2022.12.23
    ViewGroup parent;

    // コンストラクタ
    public CategoriesAdapter(Context context,List<Category> listOfCategories){

        this.context = context;
        this.listOfCategories = listOfCategories;
        Log.d("★CategoriesAdater","コンストラクタ");
    }
    /* 以下３つのメソッドをオーバーライド */
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("★CategoriesAdater","onCreateViewHolder()");
        //2022.12.23
        this.parent = parent;
        // カテゴリーのインスタンスをinflateして返す
        return new CategoryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Log.d("★CategoriesAdater","onBindViewHolder");
        //202.12.23
        // holder.bind(listOfCategories.get(position));
        holder.bind(listOfCategories.get(position),parent);
    }

    @Override
    public int getItemCount() {
        return listOfCategories.size();
    }

    // RecyclerView.ViewHolderを継承したCategoryViewHolder
    public static class CategoryViewHolder extends RecyclerView.ViewHolder{
        private final View view;
        // RecyclerView.ViewHolderを継承したCategoryViewHolder
        public CategoryViewHolder(View view){
            super(view);
            this.view = view;
            Log.d("★CategoriesAdapter","CategoryViewHolderコンストラクタ");
        }
        // TextViewとRecycleViewにカテゴリの設定をするインスタンス・メソッド
        //2022.12.23
        // public void bind(Category category){
        public void bind(Category category,ViewGroup parent){
            TextView textView = (TextView) view.findViewById(R.id.categoryName);
            textView.setText(category.getName());
            Log.d("★CategoriesAdapter","bind()");

            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView2);
            //2022.12.23
            // recyclerView.setAdapter(new ItemsAdapter(view.getContext(),category.getListOfItems()));
            Log.d("★CategoriesAdapter","Item siZe"+category.getListOfItems().size());
            recyclerView.setAdapter(new ItemsAdapter( parent, category.getListOfItems()) );
        }
    }
}
