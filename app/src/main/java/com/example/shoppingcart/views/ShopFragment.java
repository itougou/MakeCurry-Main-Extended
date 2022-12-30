package com.example.shoppingcart.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
//import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.DividerItemDecoration;

//import android.util.Log;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shoppingcart.R;
import com.example.shoppingcart.adapters.IngredientAdapter;
import com.example.shoppingcart.databinding.FragmentShopBinding;
import com.example.shoppingcart.entity.Stock;
import com.example.shoppingcart.entity.Ingredient;
import com.example.shoppingcart.entity.relation.IngredientAndUnit;
import com.example.shoppingcart.viewmodels.IngredientViewModel;
//import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.example.shoppingcart.viewmodels.StockViewModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class ShopFragment extends Fragment implements IngredientAdapter.IngredientInterface {

    private static final String TAG = "ShopFragment";
    FragmentShopBinding fragmentShopBinding;
    private IngredientAdapter ingredientAdapter;
    private IngredientViewModel ingredientViewModel;
    private StockViewModel stockViewModel;
    private NavController navController;

    public ShopFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        fragmentShopBinding = FragmentShopBinding.inflate(inflater, container, false);
        return fragmentShopBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        ingredientAdapter = new IngredientAdapter(this);
        fragmentShopBinding.shopRecyclerView.setAdapter(ingredientAdapter);
        fragmentShopBinding.shopRecyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
        fragmentShopBinding.shopRecyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.HORIZONTAL));


        ingredientViewModel = new ViewModelProvider(requireActivity()).get(IngredientViewModel.class);

        ingredientViewModel.getAllIngredientAndUnit().observe(getViewLifecycleOwner(), new Observer<List<IngredientAndUnit>>() {
            @Override
            public void onChanged(List<IngredientAndUnit> ingredientAndUnit) {
                ingredientAdapter.submitList(ingredientAndUnit);
            }
        });

//        ingredientViewModel.getIngredients().observe(getViewLifecycleOwner(), new Observer<List<Ingredient>>() {
//            @Override
//            public void onChanged(List<Ingredient> ingredients) {
//                ingredientAdapter.submitList(ingredients);
//            }
//        });

        navController = Navigation.findNavController(view);

    }

    // +ボタン
    @Override
//    public void addItem(Ingredient ingredient) {
//        Log.d("★ShopFragment","addItem quantity:"+ingredient.getQuantity());
//        ingredientViewModel.changeQuantity_in_shop(ingredient,ingredient.getQuantity()+1);
//
//        boolean isAdded =  ingredientViewModel.addItemToCart(ingredient);
//        if (isAdded) {
//            Snackbar.make(requireView(), ingredient.getName() + " added to cart.", Snackbar.LENGTH_LONG)
//                    .setAction("Checkout", new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            navController.navigate(R.id.action_shopFragment_to_cartFragment);
//                        }
//                    })
//                    .show();
//        } else {
//            Snackbar.make(requireView(), "Already have the max quantity in cart.", Snackbar.LENGTH_LONG)
//                    .show();
//        }
    public long addItem(IngredientAndUnit ingredient, int suu) {
        //前回クリックから一定時間経過していなければクリックイベントを実行しない
        if (!ShopFragment.isClickEvent()) return -1 ;
//        Log.d("★ShopFragment","addItem quantity:"+ingredient.getQuantity());
//        shopViewModel.changeQuantity_in_shop(ingredient,ingredient.getQuantity()+1);

//        Log.d("★ShopFragment","addItem stockTemp.quantity:"+stockTemp.getQuantity());
        //現在不要2012.12.15
        // 　ingredientViewModel.changeQuantity(ingredient,suu);

        //現在年月日の文字列取得
        Calendar c  = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String addDate = sdf.format(c.getTime());

        //食材の在庫数更新処理実行
        int iRt = ingredientViewModel.updateStock(ingredient,addDate,suu);
        Log.d("★ShopFragment","addItem stock更新行数："+iRt);

        long lngRet = iRt;
        if(iRt == 0) {  //更新失敗＝Stockに同じ日付の食材が存在しない場合
            //食材レコード追加
            lngRet = ingredientViewModel.insertStock(new Stock(ingredient.getIngredient_id(), suu, addDate));
            Log.d("★ShopFragment","addItem stock追加行数："+lngRet);
        }

        return lngRet;  //行数または行番号を返す
        //ingredientViewModel.notifyDataSetChanged();

        // boolean isAdded = shopViewModel.addItemToCart(ingredient);
        // if (isAdded) {
        //     Snackbar.make(requireView(), ingredient.getName() + "が在庫に登録されました", Snackbar.LENGTH_LONG)
        //             .setAction("登録", new View.OnClickListener() {
        //                 @Override
        //                 public void onClick(View v) {

        //                     navController.navigate(R.id.action_shopFragment_to_cartFragment);
        //                 }
        //             })
        //             .show();
        // } else {
        //     Snackbar.make(requireView(), "これ以上この品目を追加することは出来ません", Snackbar.LENGTH_LONG)
        //             .show();
        // }

    }


    // -button

    //nakaobranch の内容
//   public void minusItem(Ingredient ingredient) {
//        boolean isAdded =  ingredientViewModel.changeQuantity_in_shop(product,product.getQuantity()-1);
//        ingredientViewModel.minusItemToCart(product);
//        if (isAdded) {
//            Snackbar.make(requireView(), ingredient.getName() + " minus to cart.", Snackbar.LENGTH_LONG)
//                    .setAction("Checkout", new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            navController.navigate(R.id.action_shopFragment_to_cartFragment);
//                        }
//                    })
//                    .show();
//        } else {
//            Snackbar.make(requireView(), "数量は０以下にできません。", Snackbar.LENGTH_LONG)
//                    .show();
//        }
    //↓田中変更文？
    @Override
    public long minusItem(IngredientAndUnit ingredient, int suu) {
        // 前回クリックから一定時間経過していなければクリックイベントを実行しない
        if (!ShopFragment.isClickEvent()) return -1;

        //現在年月日文字列取得
        Calendar c  = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String addDate = sdf.format(c.getTime());

        long lngRet;
        if( suu<=0 ) {  //数量が0以下になった場合
            //食材の該当日のレコード削除実行
            lngRet = ingredientViewModel.deleteStock(ingredient, addDate);
            Log.d("★ShopFragment", "minusItem stock 削除行数：" + lngRet);
        }else{
            //食材の在庫量の更新処理実行
            int iRt = ingredientViewModel.updateStock( ingredient, addDate, suu );
            lngRet = iRt;
            Log.d("★ShopFragment","minusItem stock 更新行数："+iRt);
        }
        return lngRet; //削除・更新行数を返す

//        boolean isAdded = shopViewModel.changeQuantity_in_shop(ingredient,ingredient.getQuantity()-1);
//        shopViewModel.minusItemToCart(ingredient);
//        if (isAdded) {
//            Snackbar.make(requireView(), ingredient.getName() + "を減らしました", Snackbar.LENGTH_LONG)
//                    .setAction("登録", new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            navController.navigate(R.id.action_shopFragment_to_cartFragment);
//                        }
//                    })
//                    .show();
//        } else {
//            Snackbar.make(requireView(), "数量は０以下にできません。", Snackbar.LENGTH_LONG)
//                    .show();
//        }
    }

    @Override
    public void onItemClick(IngredientAndUnit ingredient) {
        ingredientViewModel.setIngredient(ingredient);
        navController.navigate(R.id.action_shopFragment_to_productDetailFragment);

    }

//    @Override
//    public void onClick(View v) {
//
//    }

    /** クリック連打制御時間(ミリ秒) */
    private static final long CLICK_DELAY = 0;  //現在ダブルクリック禁止OFF状態に2022.12.16
    /** 前回のクリックイベント実行時間 */
    private static long mOldClickTime;

    /**
     * クリックイベントが実行可能か判断する。
     * @return クリックイベントの実行可否 (true:可, false:否)
     */
    public static boolean isClickEvent() {
        // 現在時間を取得する
        long time = System.currentTimeMillis();

        // 一定時間経過していなければクリックイベント実行不可
        if (time - mOldClickTime < CLICK_DELAY) {
            return false;
        }

        // 一定時間経過したらクリックイベント実行可能
        mOldClickTime = time;
        return true;
    }

}