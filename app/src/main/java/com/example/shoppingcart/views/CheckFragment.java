package com.example.shoppingcart.views;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.shoppingcart.R;
import com.example.shoppingcart.databinding.FragmentCheckBinding;

public class CheckFragment extends Fragment {

    FragmentCheckBinding fragmentCheckBinding;

    public CheckFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentCheckBinding = FragmentCheckBinding.inflate(inflater, container, false);
        return inflater.inflate(R.layout.fragment_check, container, false);
    }

}

