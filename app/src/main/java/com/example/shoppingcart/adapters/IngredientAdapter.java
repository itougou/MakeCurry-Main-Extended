package com.example.shoppingcart.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingcart.R;
import com.example.shoppingcart.databinding.IngredientRowBinding;
import com.example.shoppingcart.entity.Ingredient;
import com.example.shoppingcart.entity.relation.IngredientAndUnit;

public class IngredientAdapter extends ListAdapter<IngredientAndUnit, IngredientAdapter.IngredientViewHolder> {

    IngredientInterface ingredientInterface;
    public IngredientAdapter(IngredientInterface ingredientInterface) {
        super(IngredientAndUnit.itemCallback);
        this.ingredientInterface = ingredientInterface;
    }

    @NonNull
    @Override
    public IngredientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        System.out.println("onCreateViewHolder");
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        IngredientRowBinding ingredientRowBinding = IngredientRowBinding.inflate(layoutInflater, parent, false);
        ingredientRowBinding.setIngredientInterface(ingredientInterface);

        return new IngredientViewHolder(ingredientRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientViewHolder holder, int position) {
        System.out.println("onBindViewHolder");
        IngredientAndUnit ingredientAndUnit = getItem(position);
        holder.ingredientRowBinding.setIngredientAndUnit(ingredientAndUnit);
        holder.ingredientRowBinding.executePendingBindings();

        //+ボタンのクリックハンドラーの登録　2022.12.13 ito
        //クリックした行の入力データ（数）を使用する必要があるため
        // Fragmentクラス内でなくAdapterクラス内にハンドラーを記述
        holder.ingredientRowBinding.addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView tv = holder.itemView.findViewById(R.id.SyokuzaiTextView);
                int suu = Integer.parseInt( String.valueOf( tv.getText() ) );
                suu ++;
                tv.setText( Integer.toString(suu) );
                long l = ingredientInterface.addItem( ingredientAndUnit, suu );

                Log.i("★IngredientAdapter","addToCartButton Clicked! suu:"+suu+" 更新数："+l);
            }
        });
        //-ボタンのクリックハンドラーの登録　2022.12.13 ito
        //クリックした行の入力データ（数）を使用する必要があるため
        // Fragmentクラス内でなくAdapterクラス内にハンドラーを記述
        holder.ingredientRowBinding.minusToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = holder.itemView.findViewById(R.id.SyokuzaiTextView);
                int suu = Integer.parseInt( String.valueOf( tv.getText() ) );
                if( suu==0 ) {  //現在0以下の場合は処理しない
                    Log.d("★IngredientAdapter","minusToCartButton 0以下のため中止");
                    return;
                }
                suu --;
                tv.setText( Integer.toString(suu) );
                long l = ingredientInterface.minusItem( ingredientAndUnit, suu );

                Log.i("★IngredientAdapter","minusToCartButton Clicked! suu:"+suu+" 更新数："+l);
            }
        });


    }
    public class IngredientViewHolder extends RecyclerView.ViewHolder {

        IngredientRowBinding ingredientRowBinding;

        public IngredientViewHolder(IngredientRowBinding binding) {
            super(binding.getRoot());
            this.ingredientRowBinding = binding;
        }
    }

    public interface IngredientInterface {
        long addItem(IngredientAndUnit ingredient, int suu );
        long minusItem(IngredientAndUnit ingredient, int suu );
        void onItemClick(IngredientAndUnit ingredient);
    }

}
