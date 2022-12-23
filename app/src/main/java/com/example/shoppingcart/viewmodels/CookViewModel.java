package com.example.shoppingcart.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.shoppingcart.entity.Cook;
import com.example.shoppingcart.entity.IngWithXRefAndUnitAndStock;
import com.example.shoppingcart.repositories.CookAndCookIngredientXRefRepo;
import com.example.shoppingcart.repositories.CookRepo;
import com.example.shoppingcart.repositories.IngWithXRefAndUnitAndStockRepo;

import java.util.List;

public class CookViewModel extends AndroidViewModel {

    CookRepo cookRepo;
    IngWithXRefAndUnitAndStockRepo ingWithXRefAndUnitAndStockRepo;
    CookAndCookIngredientXRefRepo cookandcookdetail;

    //
    MutableLiveData<Cook> mutableCook = new MutableLiveData<>();


    //liveDate
    private final LiveData<List<Cook>> mAllCook; //料理一覧表示
//    private final LiveData<List<CookAndCookdetail>> mAllCookandCookdetail;

//    private final LiveData<Cook> getCook() {
//        cookRepo
//    };


    public CookViewModel(@NonNull Application application) {
        super(application);
        this.cookRepo = new CookRepo(application);
        this.ingWithXRefAndUnitAndStockRepo = new IngWithXRefAndUnitAndStockRepo(application);
        //CookRepo cookRepo = new CookRepo();
        mAllCook = this.cookRepo.getAll();

//        this.cookandcookdetail = new CookAndCookdetail(application);
//        mAllCookandCookdetail = cookandcookdetail.getCookandCookdetail;
    }

    public LiveData<List<Cook>> getAllCooks() {
        return mAllCook;
    }
//    public LiveData<List<CookAndCookdetail>> getCookandCookdetail() {
//        return mAllCookandCookdetail;
//    }

    //料理詳細画面cook_idを渡してそのcook_idのデータを返す。
    public LiveData<List<IngWithXRefAndUnitAndStock>> findByCookId(int cook_id) {
        return ingWithXRefAndUnitAndStockRepo.findByCookId(cook_id);
    }

    //
    public LiveData<List<Cook>> getOneCook (int cook_id) {
        return cookRepo.getOneCook(cook_id);
    }

    //ゲッターセッター(料理詳細表示用)
    public Cook getCook(){
        return mutableCook.getValue();
    }
    public void setCook(Cook cook) { mutableCook.setValue(cook);}
}

