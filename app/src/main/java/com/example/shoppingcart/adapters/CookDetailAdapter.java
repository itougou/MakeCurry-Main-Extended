package com.example.shoppingcart.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingcart.databinding.CookdetailRowBinding;
import com.example.shoppingcart.databinding.IngredientRowBinding;
import com.example.shoppingcart.entity.IngWithXRefAndUnitAndStock;
import com.example.shoppingcart.entity.Ingredient;
import com.example.shoppingcart.entity.relation.IngredientAndCookIngredientXRefAndUnit;

//料理詳細リサイクラービューのアダプタークラス
public class CookDetailAdapter extends ListAdapter<IngWithXRefAndUnitAndStock, CookDetailAdapter.CookDetailViewHolder> {

    CookDetailAdapter.CookDetailInterface cookDetailInterface;
    public CookDetailAdapter(CookDetailInterface cookDetailInterface) {
        super(IngWithXRefAndUnitAndStock.itemCallback);
        this.cookDetailInterface = cookDetailInterface;

    }

    @NonNull
    @Override
    public CookDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        CookdetailRowBinding binding = CookdetailRowBinding.inflate(layoutInflater, parent, false);
        binding.setCookDetailInterface(cookDetailInterface);

        return new CookDetailViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CookDetailAdapter.CookDetailViewHolder holder, int position) {
        //System.out.println("onBindViewHolder");
        IngWithXRefAndUnitAndStock ingWithXRefAndUnitAndStock = getItem(position);
        holder.cookdetailRowBinding.setCookInglist(ingWithXRefAndUnitAndStock);
        holder.cookdetailRowBinding.executePendingBindings();

    }

    //リサイクルビュー
    public class CookDetailViewHolder extends RecyclerView.ViewHolder {

        CookdetailRowBinding cookdetailRowBinding;

        public CookDetailViewHolder(CookdetailRowBinding binding) {
            super(binding.getRoot());
            this.cookdetailRowBinding = binding;
        }
    }

    //
    public interface CookDetailInterface {
        void onItemClick(IngWithXRefAndUnitAndStock ingWithXRefAndUnitAndStock);
    }


}
