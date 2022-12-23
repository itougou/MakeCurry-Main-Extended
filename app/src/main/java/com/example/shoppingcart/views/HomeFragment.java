package com.example.shoppingcart.views;

import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.shoppingcart.R;
import com.example.shoppingcart.databinding.FragmentHomeBinding;
import com.example.shoppingcart.entity.Cook;
import com.example.shoppingcart.viewmodels.CookViewModel;

public class HomeFragment extends Fragment {

    NavController navController;
    FragmentHomeBinding fragmentHomeBinding;
    CookViewModel cookViewModel;

    public HomeFragment() {
        // Required empty public constructor

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater,container,false);
        View view = fragmentHomeBinding.getRoot();

        fragmentHomeBinding.shopCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ShopFragmentへ遷移させる
                navController.navigate(R.id.action_homeFragment_to_shopFragment);
            }
        });

        fragmentHomeBinding.cartCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // CartFragmentへ遷移させる
                navController.navigate(R.id.action_homeFragment_to_cartFragment);
            }
        });

        fragmentHomeBinding.checkCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // CheckFragmentへ遷移させる
                navController.navigate(R.id.action_homeFragment_to_checkFragment);
            }
        });

        fragmentHomeBinding.searchCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // SearchFragmentへ遷移させる
                navController.navigate(R.id.action_homeFragment_to_searchFragment);
            }
        });

        fragmentHomeBinding.productDetailFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cook cook = new Cook();
                cook.setCook_id(1);
                cook.setCook_name("カレー");
                cook.setImg_url("https://makecurry.web.app/images/カレー.png");
                cookViewModel.setCook(cook);
                Log.i("☆HomeFragment","setOnClickListener");
                // CookDetailFragmentへ遷移させる
                navController.navigate(R.id.action_homeFragment_to_cookDetailFragment);
            }
        });
        //2022.12.23
        fragmentHomeBinding.tabSampleFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.i("☆HomeFragment","setOnClickListener");
                // 分類・食材一覧へ遷移させる
                navController.navigate(R.id.action_homeFragment_to_tabSampleFragment);

            }
        });
        //2022.12.23
        fragmentHomeBinding.palyerListFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.i("☆PlayerListFragment","setOnClickListener");
                // 選手一覧画面へ遷移させる
                navController.navigate(R.id.action_homeFragment_to_playerFragment);

            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cookViewModel = new ViewModelProvider(requireActivity()).get(CookViewModel.class);

        navController = Navigation.findNavController(view);
    }
}