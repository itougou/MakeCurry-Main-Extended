package com.example.shoppingcart.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shoppingcart.viewmodels.CookViewModel;
import com.example.shoppingcart.databinding.FragmentCookDetailBinding;

/**
 * 選手詳細情報表示フラグメント
 */

public class CookDetailFragment extends Fragment {

        FragmentCookDetailBinding fragmentCookDetailBinding;
        CookViewModel baseballViewModel;

        public CookDetailFragment() {
            // Required empty public constructor
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            //2022.10.29 ito
            fragmentCookDetailBinding = FragmentCookDetailBinding.inflate(inflater, container, false);
            return fragmentCookDetailBinding.getRoot();
            //return inflater.inflate(R.layout.fragment_fourth, container, false);
        }

        //2022.10.29 ito
        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            baseballViewModel = new ViewModelProvider(requireActivity()).get(CookViewModel.class);
            fragmentCookDetailBinding.setBaseballViewModel(baseballViewModel);
        }

}
