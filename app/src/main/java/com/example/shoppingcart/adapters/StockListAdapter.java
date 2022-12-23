package com.example.shoppingcart.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingcart.databinding.StockRowBinding;
import com.example.shoppingcart.entity.Stock;
import com.example.shoppingcart.entity.StockWithIngredientsAndUnit;

public class StockListAdapter extends ListAdapter<StockWithIngredientsAndUnit, StockListAdapter.StockViewHolder> {

    StockInterface stockInterface;
    public StockListAdapter(StockInterface stockInterface) {
        super(StockWithIngredientsAndUnit.itemCallback);
        this.stockInterface = stockInterface;
    }

    @NonNull
    @Override
    public StockViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        System.out.println("onCreateViewHolder");
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        StockRowBinding stockRowBinding = StockRowBinding.inflate(layoutInflater, parent, false);
        stockRowBinding.setStockInterface(stockInterface);

        return new StockViewHolder(stockRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull StockViewHolder holder, int position) {
        System.out.println("onBindViewHolder");
        StockWithIngredientsAndUnit stock = getItem(position);
        holder.stockRowBinding.setStock(stock);
        holder.stockRowBinding.executePendingBindings();

        // 削除（画像）ボタンクリックリスナー設定　2022.12.17
        holder.stockRowBinding.deleteStockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rt = stockInterface.deleteItem(stock);
                Log.d("★StockListAdapetr","deleteStockButtonクリック 削除行数："+rt);
            }
        });

    }

    public class StockViewHolder extends RecyclerView.ViewHolder {

        StockRowBinding stockRowBinding;

        public StockViewHolder(StockRowBinding binding) {
            super(binding.getRoot());
            this.stockRowBinding = binding;
        }
    }

    public interface StockInterface {
        //        void addItem(Stock stock, int suu );
//        void minusItem(Stock stock);
        void onItemClick(Stock stock);
        int deleteItem(StockWithIngredientsAndUnit stock);
    }

}