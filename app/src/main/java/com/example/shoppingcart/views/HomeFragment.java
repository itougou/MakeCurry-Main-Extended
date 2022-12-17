package com.example.shoppingcart.views;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.shoppingcart.R;
import com.example.shoppingcart.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    NavController navController;
    FragmentHomeBinding fragmentHomeBinding;

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

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
    }
}