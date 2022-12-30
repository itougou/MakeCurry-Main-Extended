package com.example.shoppingcart.repositories;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.shoppingcart.dao.IngredientAndUnitDao;
import com.example.shoppingcart.dao.IngredientDao;
import com.example.shoppingcart.database.CookRoom;
import com.example.shoppingcart.entity.Ingredient;
import com.example.shoppingcart.entity.relation.IngredientAndUnit;
import com.example.shoppingcart.models.CartItem;
import com.example.shoppingcart.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShopRepo {
    private LiveData<List<Ingredient>> mAllIngredients;
    private LiveData<List<IngredientAndUnit>> mIngredientAndUnit;

    private IngredientDao mIngredientDao;
    private IngredientAndUnitDao mIngredientAndUnitDao;
    Application mApplication;
    public ShopRepo (Application application) {
        mApplication = application;
        CookRoom db = CookRoom.getDatabase(application);
        mIngredientDao = db.IngredientDao();
        mIngredientAndUnitDao = db.IngredientAndUnitDao();

        mAllIngredients = mIngredientDao.getAll();
        mIngredientAndUnit = mIngredientAndUnitDao.getIngredientWithUnit();
    }
    public LiveData<List<Ingredient>> getmAllIngredients(){
        return mAllIngredients;
    }

    private MutableLiveData<List<Product>> mutableProductList;
    public LiveData<List<Ingredient>> getIngredients() {
        return this.mAllIngredients;
    }
    public LiveData<List<IngredientAndUnit>> getIngredientAntUnit() {
        return this.mIngredientAndUnit ;
    }

    public void changeQuantiy(Ingredient ingredient,int quantity){
//        if(mutableProductList.getValue()==null) return;
//
//        List<Ingredient> productList = new ArrayList<>(mutableProductList.getValue());
//        Ingredient updateProduct = new Ingredient(ingredient,quantity);
//        int i = productList.indexOf(ingredient);
//        if(i==-1) return;
//        productList.set(i,updateProduct);
//        mutableProductList.setValue(productList);

    }

    public void resetProductList() {

        List<Product> productList = new ArrayList<>(mutableProductList.getValue());
        for (Product product: productList) {

            int index = productList.indexOf(product);
            Log.i("★cartfragment","cartItem.getQuantity():" + product.getQuantity());
            product.setQuantity(0);
            Log.i("★cartfragment","cartItemList.size():" + productList.size()+ product.getName());

            productList.set(index, product);

            mutableProductList.setValue(productList);

        }
        return;
    }

    public void resetProduct(Product product) {
        List<Product> productList = new ArrayList<>(mutableProductList.getValue());
        for (Product p: productList) {
            if (product.getId().equals(p.getId())){
                int index = productList.indexOf(product);
                Log.i("★cartfragment","cartItem.getQuantity():" + product.getQuantity());
                product.setQuantity(0);
                Log.i("★cartfragment","cartItemList.size():" + productList.size()+ product.getName());
                productList.set(index, product);
            }
            mutableProductList.setValue(productList);
        }
        return;
    }



}
