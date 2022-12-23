package com.example.shoppingcart.repositories;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.shoppingcart.dao.CookDao;
import com.example.shoppingcart.database.CookRoom;
import com.example.shoppingcart.entity.Cook;
import com.example.shoppingcart.entity.IngWithXRefAndUnitAndStock;
import com.example.shoppingcart.models.CartItem;

import java.util.List;

public class CookRepo {

    private MutableLiveData<List<Cook>> mutableCook= new MutableLiveData<>();
    private LiveData<List<Cook>> mCook;
    private CookDao mCookDao;

    public LiveData<List<Cook>> getCook() {
        if (mutableCook.getValue() == null) {
            // initCook();
        }
        return mutableCook;
    }

    public CookRepo(Application application){
        //データベースクラスのインスタンス取得
        CookRoom db = CookRoom.getDatabase(application);

        mCookDao = db.CookDao();  //DAO取得
        this.mCook = mCookDao.getAll();   //全選手＆チーム情報取得
        Log.d("★CookRepository","CookRepository() mCookDao.getAlphabetizedCooks()呼び出し ﾌｨｰﾙﾄﾞmAllWordsへ格納:"+mCook.toString());

    }

    // 全料理取得
    public LiveData<List<Cook>> getAll() {
        Log.d("★TeamRepository","getAllTeams()の中でmAllTeamsを返却");
        return this.mCook;
    }

    // 1件取得
    public LiveData<List<Cook>> getOneCook(int cook_id) {
//        Log.d("★TeamRepository","getAllTeams()の中でmAllTeamsを返却");
        return this.mCook;
    }



}
