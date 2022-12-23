package com.example.shoppingcart.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.shoppingcart.dao.IngredientAndCookIngredientXRefAndUnitDao;
import com.example.shoppingcart.database.CookRoom;
import com.example.shoppingcart.entity.Ingredient;
import com.example.shoppingcart.entity.relation.IngredientAndCookIngredientXRefAndUnit;

import java.util.List;

public class IngredientAndCookIngredientXRefAndUnitRepo {

    private IngredientAndCookIngredientXRefAndUnitDao mIngredientAndCookIngredientXRefAndUnitDao;
    Application mAllIngredientAndCookIngredientXRefAndUnit;

    public IngredientAndCookIngredientXRefAndUnitRepo(Application application){
        CookRoom db = CookRoom.getDatabase(application);

        mIngredientAndCookIngredientXRefAndUnitDao = db.IngredientAndCookIngredientXRefAndUnitDao();
    }

    public LiveData<List<IngredientAndCookIngredientXRefAndUnit>> getmAllIngredientAndCookIngredientXRefAndUnit(){
        return this.getmAllIngredientAndCookIngredientXRefAndUnit();
    }

//    public LiveData<List<IngredientAndCookIngredientXRefAndUnit>> getAllIngredientAndCookIngredientXRefAndUnit() {
//        Log.d("★H_P_A_P Repository","searchPlayerPosition()の中選手＋ポジション情報Listを返却");

//        return mIngredientAndCookIngredientXRefAndUnitDao.getAllIngredientAndCookIngredientXRefAndUnit();
//    }
}
