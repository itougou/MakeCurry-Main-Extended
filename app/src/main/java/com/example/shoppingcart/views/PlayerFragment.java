package com.example.shoppingcart.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shoppingcart.R;
import com.example.shoppingcart.adapters.PlayersAdapter;

public class PlayerFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_player, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        //RecyclerViewの取得
        RecyclerView recyclerView = view.findViewById(R.id.rvPlayerList);

                //Adapterの設定
        PlayersAdapter adapter = new PlayersAdapter();
        recyclerView.setAdapter( adapter );

        //LayoutManagerの設定
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager (layoutManager);
    }
}