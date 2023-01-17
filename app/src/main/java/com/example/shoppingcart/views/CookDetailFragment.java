package com.example.shoppingcart.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.shoppingcart.adapters.CookAdapter;
import com.example.shoppingcart.adapters.CookDetailAdapter;
import com.example.shoppingcart.entity.Cook;
import com.example.shoppingcart.entity.IngWithXRefAndUnitAndStock;
import com.example.shoppingcart.entity.relation.IngredientAndCookIngredientXRefAndUnit;
import com.example.shoppingcart.viewmodels.CookViewModel;
import com.example.shoppingcart.databinding.FragmentCookDetailBinding;

import java.util.List;

public class CookDetailFragment extends Fragment implements CookDetailAdapter.CookDetailInterface  {

    FragmentCookDetailBinding fragmentCookDetailBinding;
    CookViewModel cookViewModel;
    CookDetailAdapter cookDetailAdapter;
    CookAdapter cookAdapter;
    //2023.1.17
    List<IngWithXRefAndUnitAndStock> myIngWithXRefAndUnitAndStocks; //その料理に必要な食材の情報
    List<IngWithXRefAndUnitAndStock> myIngWithXRefAndUnitAndStocksGroupByIng; //その料理に必要な食材の情報（食材ごとにグループ化）

    public CookDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentCookDetailBinding = FragmentCookDetailBinding.inflate(inflater, container, false);
        return fragmentCookDetailBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cookViewModel = new ViewModelProvider(requireActivity()).get(CookViewModel.class);

        cookDetailAdapter = new CookDetailAdapter(this);
//        cookAdapter = new CookAdapter(CookAdapter.CookInterface);
        fragmentCookDetailBinding.setCookViewModel(cookViewModel);
        fragmentCookDetailBinding.CookIngList.setAdapter(cookDetailAdapter);


//2023.1.16
// cookViewModel.findByCookId(1).observe(getViewLifecycleOwner(), new Observer<List<IngWithXRefAndUnitAndStock>>() {
//            @Override
//            public void onChanged(List<IngWithXRefAndUnitAndStock> ingWithXRefAndUnitAndStocks) {
//                for (IngWithXRefAndUnitAndStock i:ingWithXRefAndUnitAndStocks){
//                    Log.i("★CookDetailFragment","ing_name:"+i.getIng_name() + " nuit:" + i.getUnit_name());
//                }
//
//                cookDetailAdapter.submitList(ingWithXRefAndUnitAndStocks);
//            }
//        });

        fragmentCookDetailBinding.setCookViewModel(cookViewModel);

        //2023.1.16　↓
        fragmentCookDetailBinding.spinner.setSelection(1);
        fragmentCookDetailBinding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //　アイテムが選択された時
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               String spn = fragmentCookDetailBinding.spinner.getSelectedItem().toString(); //人数取り出し
               //Log.d("★CookDetailFragment","Spnner value:"+spn );
               //その料理に必要な食材の情報（食材ごとにグループ化）をテーブルから読みだす処理
               cookViewModel.findByCookIdGroupByIng(1).observe(getViewLifecycleOwner(), new Observer<List<IngWithXRefAndUnitAndStock>>() {
                   @Override
                   public void onChanged(List<IngWithXRefAndUnitAndStock> ingWithXRefAndUnitAndStocks) {
                       for (IngWithXRefAndUnitAndStock i : ingWithXRefAndUnitAndStocks) {
                           Log.i("★CookDetailFragment", "setOnItemSelectedListener→onChange ing_name:" + i.getIng_name() + " 必要数：" + i.getXref_quantity() + " 在庫：" + i.getSt_quantity()+ " nuit:" + i.getUnit_name());
                           int require_quantity = i.getXref_quantity() * Integer.parseInt(spn);
                           if (require_quantity > i.getSt_quantity()) {
                               Toast.makeText(getActivity(), "足りない食材があります！", Toast.LENGTH_SHORT).show();
                               Log.d("★CookDetailFragment", "足りないものあり！");
                           }
                           i.setXref_quantity( i.getXref_quantity() * Integer.parseInt(spn) );  //必要数を人数倍する
                       }
                       cookDetailAdapter.submitList(ingWithXRefAndUnitAndStocks);   //Recyclerビューへセットしてもらう

                       myIngWithXRefAndUnitAndStocksGroupByIng = ingWithXRefAndUnitAndStocks;//その料理に必要な食材の情報（食材ごとにグループ化）を後でテーブル削除変更する時のために取っておく
                   }
               });
               //その料理に必要な食材の情報をテーブルから読みだす処理
               cookViewModel.findByCookId(1).observe(getViewLifecycleOwner(), new Observer<List<IngWithXRefAndUnitAndStock>>() {
                   @Override
                   public void onChanged(List<IngWithXRefAndUnitAndStock> ingWithXRefAndUnitAndStocks) {

                       myIngWithXRefAndUnitAndStocks = ingWithXRefAndUnitAndStocks;//その料理に必要な食材の情報を後でテーブル削除変更する時のために取っておく
                   }
               });
           }
           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {
           }
            //2023.1.16　↑

        });

        //「作ったボタン」のクリック時の処理
        fragmentCookDetailBinding.stockReduceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //fragmentCookDetailBinding.spinner.setSelection(0);
                Log.d("★CookDetailFragment","onClick()！");
                //突き合わせ処理
                for( IngWithXRefAndUnitAndStock stcokGrouppByIng : myIngWithXRefAndUnitAndStocksGroupByIng){
                    Log.d("★CookDetailFragment","stcokGrouppByIng："+stcokGrouppByIng.getIng_name()+" 必要数:" +stcokGrouppByIng.getXref_quantity()+" 在庫数:" +stcokGrouppByIng.getSt_quantity());
                    int reqNum = stcokGrouppByIng.getXref_quantity();
                    for( IngWithXRefAndUnitAndStock stcok : myIngWithXRefAndUnitAndStocks ) {
                        if (stcokGrouppByIng.getIngredient_id() == stcok.getIngredient_id()) {
                            int stockNum = stcok.getSt_quantity();
                            Log.d("★CookDetailFragment", " 素材：" + stcok.getIng_name() + " 在庫数:" + stcok.getSt_quantity());
                            if (reqNum < stockNum) {
                                Log.d("★CookDetailFragment", "  Upadate文で、在庫を" + (reqNum) + "減らす");
                                cookViewModel.updateStockByStockId(stcok.getStock_id(), stockNum - reqNum);
                                break;
                            } else {
                                Log.d("★CookDetailFragment", "  Delete文で、在庫数：" + stockNum + "の行を削除");
                                cookViewModel.deleteStockByStockId(stcok.getStock_id());
                                reqNum -= stockNum;
                            }
                        }
                    }
                }
                Toast.makeText(getActivity(), "料理を作った分在庫減らしました！", Toast.LENGTH_SHORT).show();
                Log.d("★CookDetailFragment", "料理を作った分在庫減らしました！");
            }
        });
    }

    @Override
    public void onItemClick( IngWithXRefAndUnitAndStock ingWithXRefAndUnitAndStock ) {
    }
}
