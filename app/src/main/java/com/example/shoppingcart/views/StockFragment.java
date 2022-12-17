package com.example.shoppingcart.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shoppingcart.adapters.StockListAdapter;
import com.example.shoppingcart.databinding.FragmentStockBinding;
import com.example.shoppingcart.entity.Stock;
import com.example.shoppingcart.entity.StockWithIngredientsAndUnit;
import com.example.shoppingcart.viewmodels.StockViewModel;

import java.util.List;
public class StockFragment extends Fragment  implements StockListAdapter.StockInterface{

    private static final String TAG = "StockFragment";
    StockViewModel stockViewModel;
    FragmentStockBinding fragmentStockBinding;
    NavController navController;
    private StockListAdapter stockListAdapter;

    public StockFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentStockBinding = FragmentStockBinding.inflate(inflater, container, false);

        return fragmentStockBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        stockListAdapter = new StockListAdapter(this);
        fragmentStockBinding.stockRecyclerView.setAdapter(stockListAdapter);
        fragmentStockBinding.stockRecyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));

        stockViewModel = new ViewModelProvider(requireActivity()).get(StockViewModel.class);
        stockViewModel.getAllStockWithIngredientsAndUnit().observe(getViewLifecycleOwner(), new Observer<List<StockWithIngredientsAndUnit>>() {
            @Override
            public void onChanged(List<StockWithIngredientsAndUnit> stock) {
                stockListAdapter.submitList(stock);
                Log.d("★StockFragment","StockWithIngredientsAndUnit.size"+stock.size());
            }
        });

    }

    @Override
    public void onItemClick(Stock stock) {
        Log.i("★StockFragment","onItemClick()");
    }

    @Override
    public int deleteItem( StockWithIngredientsAndUnit stock ) {
       return stockViewModel.deleteStock( stock.getIngredient_id(), stock.getAdd_date());
    }
}