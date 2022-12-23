package com.example.shoppingcart.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingcart.R;
import com.example.shoppingcart.models.Item;

import java.util.List;


public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder> {
    // フィールド
    private final Context context;
    private final List<Item> items;
    //コンストラクタ
    //2022.12.23
    // public ItemsAdapter(Context context,List<Item> items){
    public ItemsAdapter(ViewGroup context,List<Item> items){
        Log.d("★ItemsAdapter","コンストラクタ");
        this.context = context.getContext();
        this.items = items;
    }
    /* 以下３つのメソッドをオーバーライド */
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // itemのインスタンスをinflateして返す
        return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Log.d("★ItemsAdapter","onBindViewHolder");
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    // RecyclerView.ViewHolderを継承したItemViewHolder
    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        private final View view;
        // superクラスのコンストラクタを子クラスにも定義
        public ItemViewHolder(View view){
            super(view);
            this.view = view;
        }
        // TextViewにitemを設定するインスタンスメソッド
        public void bind(Item item){
            TextView textView = (TextView) view.findViewById(R.id.textViewContent);
            textView.setText(item.getContent());
            Log.d("★ItemsAdapter","item.getContent()："+item.getContent());
        }
    }
}
