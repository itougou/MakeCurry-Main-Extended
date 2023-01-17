package com.example.shoppingcart.repositories;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.shoppingcart.dao.CookDao;
import com.example.shoppingcart.dao.IngWithXRefAndUnitAndStockDao;
import com.example.shoppingcart.database.CookRoom;
import com.example.shoppingcart.entity.Cook;
import com.example.shoppingcart.entity.IngWithXRefAndUnitAndStock;

import java.util.List;

public class IngWithXRefAndUnitAndStockRepo {
    private MutableLiveData<List<Cook>> mutableCook= new MutableLiveData<>();
    private LiveData<List<Cook>> mCook;
    private IngWithXRefAndUnitAndStockDao ingWithXRefAndUnitAndStockDao;

    public IngWithXRefAndUnitAndStockRepo (Application application){
        //データベースクラスのインスタンス取得
        CookRoom db = CookRoom.getDatabase(application);

        ingWithXRefAndUnitAndStockDao = db.IngWithXRefAndUnitAndStockDao();  //DAO取得

    }

    // 全選手＆チーム情報取り出し用メソッド
    public LiveData<List<Cook>> getAll() {
        Log.d("★TeamRepository","getAllTeams()の中でmAllTeamsを返却");
        return this.mCook;
    }

    // 料理詳細画面用メソッド。指定したcook_idの食材データを取り出すためのもの
    public  LiveData<List<IngWithXRefAndUnitAndStock>> findByCookId(int cook_id) {
        return ingWithXRefAndUnitAndStockDao.findByCookId(cook_id);
    }
    public  LiveData<List<IngWithXRefAndUnitAndStock>> findByCookIdGroupByIng(int cook_id) {
        return ingWithXRefAndUnitAndStockDao.findByCookIdGroupByIng(cook_id);
    }

}
