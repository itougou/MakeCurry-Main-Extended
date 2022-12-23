package com.example.shoppingcart.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.shoppingcart.entity.Stock;
import com.example.shoppingcart.entity.StockWithIngredientsAndUnit;
import com.example.shoppingcart.entity.relation.IngredientAndStockAndUnit;
import com.example.shoppingcart.entity.relation.StockAndIngredient;
import com.example.shoppingcart.repositories.StockRepo;

import java.util.List;

public class StockViewModel extends AndroidViewModel {

    private final LiveData<List<Stock>> mAllStocks2;
    private final LiveData<List<StockAndIngredient>> mAllStocks;
    private final LiveData<List<IngredientAndStockAndUnit>> mAllStocksAndUnit;
    private final LiveData<List<StockWithIngredientsAndUnit>> mAllStockWithIngredientsAndUnit;

    StockRepo stockRepo;

    public StockViewModel(@NonNull Application application) {
        super(application);
        stockRepo = new StockRepo(application);
        mAllStocks = stockRepo.getAllStocks();
        mAllStocks2 = stockRepo.getAll();
        mAllStocksAndUnit = stockRepo.getAllStocksAndUnit();
        mAllStockWithIngredientsAndUnit = stockRepo.getAllStockWithIngredientsAndUnit();

    }

    public LiveData<List<StockAndIngredient>> getAllStocks(){
        return mAllStocks;
    }
    public LiveData<List<Stock>> getAll(){
        return mAllStocks2;
    }
    public LiveData<List<IngredientAndStockAndUnit>> getAllStocksAndUnit(){
        return mAllStocksAndUnit;
    }
    public LiveData<List<StockWithIngredientsAndUnit>> getAllStockWithIngredientsAndUnit(){
        return mAllStockWithIngredientsAndUnit;
    }
    public int deleteStock(int ingredient_id , String date){
        return stockRepo.deleteStock( ingredient_id, date );
    }

}