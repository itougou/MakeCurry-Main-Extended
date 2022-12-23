package com.example.shoppingcart.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.example.shoppingcart.R;
import com.example.shoppingcart.databinding.CookRowBinding;
import com.example.shoppingcart.entity.Cook;
import com.example.shoppingcart.models.Product;

public class CookAdapter extends ListAdapter<Cook,CookAdapter.ViewHolder> {

    CookInterface cookInterface;
    public CookAdapter(CookInterface cookInterface) {
        super(Cook.itemCallback);
        this.cookInterface = cookInterface;
    }

    // セルのレイアウトを読み込んでViewHolderと紐付ける (1セルごとに毎回呼び出される）
    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from( viewGroup.getContext() );
        CookRowBinding binding = CookRowBinding.inflate(layoutInflater, viewGroup, false);
        binding.setCookInterface(cookInterface);

        return new ViewHolder(binding);
    }

    // 取得したセルデータをViewHolderが参照してきたView(各パーツ)にセットする (1セルごとに毎回呼び出される）
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Cook cook = getItem(viewHolder.getAdapterPosition());

        TextView tv = viewHolder.itemView.findViewById(R.id.txtCookFavorite);
        if(cook.getFavorite() == 1){
            tv.setText("★");
        }else{
            tv.setText("☆");
        }
        viewHolder.cookRowBinding.setCook(cook);
        viewHolder.cookRowBinding.executePendingBindings();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CookRowBinding cookRowBinding;
        public ViewHolder(CookRowBinding m_cookViewBinding) {
            super(m_cookViewBinding.getRoot());
            this.cookRowBinding = m_cookViewBinding;
        }
    }

    public interface CookInterface {
        void onItemClick(Cook cook);
    }
}
