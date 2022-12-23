package com.example.shoppingcart.repositories;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.shoppingcart.dao.CookDao;
import com.example.shoppingcart.dao.CookWithIngredientAndUnitDao;
import com.example.shoppingcart.database.CookRoom;
import com.example.shoppingcart.entity.Cook;
import com.example.shoppingcart.entity.relation.CookWithIngredientAndUnit;

import java.util.List;

public class CookWithIngredientAndUnitRepo {

    private MutableLiveData<List<CookWithIngredientAndUnit>> mutableCookWithIngredientAndUnit= new MutableLiveData<>();
    private LiveData<List<CookWithIngredientAndUnit>> mCookWithIngredientAndUnit;
    private CookWithIngredientAndUnitDao mCookWithIngredientAndUnitDao;

    public LiveData<List<CookWithIngredientAndUnit>> getCook() {
        if (mutableCookWithIngredientAndUnit.getValue() == null) {
            // initCook();
        }
        return mutableCookWithIngredientAndUnit;
    }

    public CookWithIngredientAndUnitRepo(Application application){
        //データベースクラスのインスタンス取得
        CookRoom db = CookRoom.getDatabase(application);

        mCookWithIngredientAndUnitDao = db.CookWithIngredientAndUnitDao();  //DAO取得
        //this.mCookWithIngredientAndUnit = mCookWithIngredientAndUnitDao.getCookWithIngredientAndUnit();   //全選手＆チーム情報取得
        Log.d("★CookRepository","CookRepository() mCookDao.getAlphabetizedCooks()呼び出し ﾌｨｰﾙﾄﾞmAllWordsへ格納:"+mCookWithIngredientAndUnit.toString());

    }

    //食材名検索
//    public LiveData<CookWithIngredientAndUnit> searchIngName(String Ingredient_id){
//        return mCookWithIngredientAndUnitDap.searchIngName(ingredient_id);
//    }

    // 全選手＆チーム情報取り出し用メソッド
    public LiveData<List<CookWithIngredientAndUnit>> getAll() {
        Log.d("★TeamRepository","getAllTeams()の中でmAllTeamsを返却");
        return this.mCookWithIngredientAndUnit;
    }




}
