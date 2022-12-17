package com.example.shoppingcart.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.shoppingcart.entity.Cook;
import com.example.shoppingcart.repositories.CookAndCookIngredientXRefRepo;
import com.example.shoppingcart.repositories.CookRepo;

import java.util.List;

public class CookViewModel extends AndroidViewModel {

    CookRepo cookRepo;
    CookAndCookIngredientXRefRepo cookandcookdetail;

    //liveDate
    private final LiveData<List<Cook>> mAllCook; //料理一覧表示
//    private final LiveData<List<CookAndCookdetail>> mAllCookandCookdetail;


    public CookViewModel(@NonNull Application application) {
        super(application);
        this.cookRepo = new CookRepo(application);
        //CookRepo cookRepo = new CookRepo();
        mAllCook = this.cookRepo.getAll();

//        this.cookandcookdetail = new CookAndCookdetail(application);
//        mAllCookandCookdetail = cookandcookdetail.getCookandCookdetail;
    }

    public LiveData<List<Cook>> getCook() {
        return mAllCook;
    }
//    public LiveData<List<CookAndCookdetail>> getCookandCookdetail() {
//        return mAllCookandCookdetail;
//    }
}
