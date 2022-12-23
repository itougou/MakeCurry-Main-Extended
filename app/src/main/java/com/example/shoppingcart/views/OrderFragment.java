package com.example.shoppingcart.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shoppingcart.R;
import com.example.shoppingcart.adapters.CookAdapter;
import com.example.shoppingcart.databinding.FragmentOrderBinding;
import com.example.shoppingcart.entity.Cook;
import com.example.shoppingcart.viewmodels.CookViewModel;
import com.example.shoppingcart.viewmodels.ShopViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class OrderFragment extends Fragment implements CookAdapter.CookInterface {

    NavController navController;
    FragmentOrderBinding fragmentOrderBinding;
    ShopViewModel shopViewModel;
    CookViewModel cookViewModel;
    private CookAdapter adapter;

    public OrderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_order, container, false);

        fragmentOrderBinding = FragmentOrderBinding.inflate(inflater, container, false);
        return fragmentOrderBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        shopViewModel = new ViewModelProvider(requireActivity()).get(ShopViewModel.class);
        //final CookAdapter cookAdapter = new CookAdapter(this);
        adapter = new CookAdapter(this);
        fragmentOrderBinding.rvCook.setAdapter(adapter);

        cookViewModel = new ViewModelProvider(requireActivity()).get(CookViewModel.class);

        cookViewModel.getAllCooks().observe(getViewLifecycleOwner(), new Observer<List<Cook>>() {
            @Override
            public void onChanged(List<Cook> cooks) {
                adapter.submitList(cooks);
            }

        });

        fragmentOrderBinding.continueShoppingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shopViewModel.resetCart();
                navController.navigate(R.id.action_orderFragment_to_shopFragment);
                cookViewModel = new ViewModelProvider(requireActivity()).get(CookViewModel.class);
                cookViewModel.getAllCooks().observe(getViewLifecycleOwner(), new Observer<List<Cook>>() {
                    @Override
                    public void onChanged(List<Cook> cooks) {
                        adapter.submitList(cooks);
                    }
                });
            }
        });


    }

    //料理名のクリック時の処理(料理詳細画面へ)
    public void onItemClick(Cook cook){
        navController.navigate(R.id.action_orderFragment_to_cookDetailFragment);
    }

}