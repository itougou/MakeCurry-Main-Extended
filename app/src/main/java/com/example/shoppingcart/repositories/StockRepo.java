package com.example.shoppingcart.repositories;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.shoppingcart.dao.IngredientDao;
import com.example.shoppingcart.dao.StockAndIngredientDao;
import com.example.shoppingcart.dao.StockDao;
import com.example.shoppingcart.dao.StockWithIngredientsAndUnitDao;
import com.example.shoppingcart.database.CookRoom;
import com.example.shoppingcart.entity.Ingredient;
import com.example.shoppingcart.entity.Stock;
import com.example.shoppingcart.entity.StockWithIngredientsAndUnit;
import com.example.shoppingcart.entity.relation.IngredientAndStockAndUnit;
import com.example.shoppingcart.entity.relation.StockAndIngredientAndUnit;
import com.example.shoppingcart.models.CartItem;
import com.example.shoppingcart.views.MainActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.example.shoppingcart.entity.relation.StockAndIngredient;
public class StockRepo {

    private LiveData<List<StockAndIngredient>> mAllStockAndIngredients;
    private LiveData<List<IngredientAndStockAndUnit>> mAllIngredientsAndStockAndUnit;
    private LiveData<List<StockWithIngredientsAndUnit>> mAllStockWithIngredientsAndUnit;
    private LiveData<List<Stock>> mAlls;
    private StockAndIngredientDao mStockAndIngredientDao;
    private StockWithIngredientsAndUnitDao mStockWithIngredientsAndUnitDao;
    private StockDao mStockDao;
    Application mApplication;

    public StockRepo (Application application) {
        mApplication = application;

        CookRoom db = CookRoom.getDatabase(application);
        mStockAndIngredientDao = db.StockAndIngredientDao();
        mStockDao = db.StockDao();
        mStockWithIngredientsAndUnitDao = db.StockWithIngredientsAndUnitDao();

        mAllStockAndIngredients = mStockAndIngredientDao.getStocksAndIngredients();
        mAllIngredientsAndStockAndUnit = mStockAndIngredientDao.getIngredientAndStocksAndUnit();
        mAllStockWithIngredientsAndUnit = mStockWithIngredientsAndUnitDao.getAll();
        mAlls = mStockDao.getAll();
    }

    public LiveData<List<StockAndIngredient>> getAllStocks() {
        return mAllStockAndIngredients;
    }
    public LiveData<List<IngredientAndStockAndUnit>> getAllStocksAndUnit() {
        return mAllIngredientsAndStockAndUnit;
    }
    public LiveData<List<Stock>> getAll(){
        return mAlls;
    }
    public LiveData<List<StockWithIngredientsAndUnit>> getAllStockWithIngredientsAndUnit(){
        return mAllStockWithIngredientsAndUnit;
    }

    //stockテーブル レコード追加処理
    public long insertStock(Stock stock){

        ExecutorService execService = null;
        long insertedLine=0;
        try {
            execService = Executors.newSingleThreadExecutor();// シングルスレッドでタスクを処理するオブジェクトを取得

            // 戻り値あり（ submit ）でタスクを実行
            Future<Long> result = execService.submit(new Callable<Long>() {
                public Long call() throws Exception {
                    long rt = mStockDao.insertStock(stock);
                    Log.d("★StockRepo","スレッド処理 mStockDao.insertStock() stock:"+stock+" rt:"+rt);
                    return rt;// 戻り値
                }
            } );

            try {
                insertedLine = result.get();// 戻り値(更新した行数)を取得
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }finally {
            execService.shutdown();     // ExecutorServiceを明示的に終了する
            Log.d("★StockRepo","ExecutorService をシャットダウン");
        }
        return insertedLine;    // 戻り値を返す
    }

    //stockテーブル レコード更新処理
    public int updateStock(int ing_id, String date,int suu){

        ExecutorService execService = null;
        int updatedLine=0;
        try {
            execService = Executors.newSingleThreadExecutor();// シングルスレッドでタスクを処理するオブジェクトを取得

            // 戻り値あり（ submit ）でタスクを実行
            Future<Integer> result = execService.submit(new Callable<Integer>() {
                public Integer call() throws Exception {
                    int rt = mStockDao.updateStock(ing_id,date,suu);
                    Log.d("★StockRepo","スレッド処理 mStockDao.updateStock() ing_id:"+ing_id+" date:"+date+" suu:"+suu+" rt:"+rt);
                    return rt;// 戻り値
                }
            } );

            try {
                updatedLine = result.get();// 戻り値(更新した行数)を取得
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }finally {
            execService.shutdown();     // ExecutorServiceを明示的に終了する
            Log.d("★StockRepo","ExecutorService をシャットダウン");
        }
        return updatedLine;    // 戻り値を返す
    }


    //stockテーブル レコード削除処理
    public int deleteStock(int ing_id, String date ){

        ExecutorService execService = null;
        int deletedLine = 0;
        try {
            execService = Executors.newSingleThreadExecutor();// シングルスレッドでタスクを処理するオブジェクトを取得

            // 戻り値あり（ submit ）でタスクを実行
            Future<Integer> result = execService.submit(new Callable<Integer>() {
                public Integer call() throws Exception {
                    int rt = mStockDao.deleteStock(ing_id,date);
                    Log.d("★StockRepo","スレッド処理 mStockDao.deleteStock() ing_id:"+ing_id+" date:"+date+" rt:"+rt);
                    return rt;// 戻り値
                }
            } );

            try {
                deletedLine = result.get();// 戻り値(更新した行数)を取得
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }finally {
            execService.shutdown();     // ExecutorServiceを明示的に終了する
            Log.d("★StockRepo","ExecutorService をシャットダウン");
        }
        return deletedLine;    // 戻り値を返す
    }
}
