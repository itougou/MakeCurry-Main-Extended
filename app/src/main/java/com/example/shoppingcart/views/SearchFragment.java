package com.example.shoppingcart.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shoppingcart.R;
import com.example.shoppingcart.databinding.FragmentSearchBinding;


public class SearchFragment extends Fragment {

    FragmentSearchBinding fragmentSearchBinding;

    @Override
    public void onCreate(Bundle saveInterface) {
        super.onCreate(saveInterface);

    }

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentSearchBinding = FragmentSearchBinding.inflate(inflater, container, false);
        return inflater.inflate(R.layout.fragment_search, container, false);
    }


}