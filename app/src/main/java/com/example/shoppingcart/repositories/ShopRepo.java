package com.example.shoppingcart.repositories;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.shoppingcart.dao.IngredientDao;
import com.example.shoppingcart.database.CookRoom;
import com.example.shoppingcart.entity.Ingredient;
import com.example.shoppingcart.models.CartItem;
import com.example.shoppingcart.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShopRepo {
    private LiveData<List<Ingredient>> mAllIngredients;
    private IngredientDao mIngredientDao;
    Application mApplication;
    public ShopRepo (Application application) {
        mApplication = application;
        CookRoom db = CookRoom.getDatabase(application);
        mIngredientDao = db.IngredientDao();
        this.mAllIngredients = mIngredientDao.getAll();
    }
    public LiveData<List<Ingredient>> getmAllIngredients(){
        return mAllIngredients;
    }

    private MutableLiveData<List<Product>> mutableProductList;
    public LiveData<List<Ingredient>> getIngredients() {

        return this.mAllIngredients;
    }

//    private void loadProducts() {
//        List<Product> productList = new ArrayList<>();
//        productList.add(new Product(UUID.randomUUID().toString(), "iMac 21", 1299, true, "https://firebasestorage.googleapis.com/v0/b/teama-61c64.appspot.com/o/Cooks%2Fanmochizouni.jpg?alt=media&token=ab6ebda0-4b76-4464-b024-3405e92a865d" ));
//        productList.add(new Product(UUID.randomUUID().toString(), "iPad Air", 799, true, "https://firebasestorage.googleapis.com/v0/b/notes-16738.appspot.com/o/products%2Fipadair.jpeg?alt=media&token=da387155-bd8f-4343-954b-e46da7d252ae"));
//        productList.add(new Product(UUID.randomUUID().toString(), "iPad Pro", 999, true, "https://firebasestorage.googleapis.com/v0/b/notes-16738.appspot.com/o/products%2Fipadpro.jpeg?alt=media&token=5d433343-f3b3-43eb-8bf2-5298eb5bf11c"));
//        productList.add(new Product(UUID.randomUUID().toString(), "iPhone 11", 699, false, "https://firebasestorage.googleapis.com/v0/b/notes-16738.appspot.com/o/products%2Fiphone11.jpeg?alt=media&token=c6874af2-c81e-48eb-96e9-2f1f3fad617f"));
//        productList.add(new Product(UUID.randomUUID().toString(), "iPhone 11 Pro", 999, true, "https://firebasestorage.googleapis.com/v0/b/notes-16738.appspot.com/o/products%2Fiphone11pro.jpg?alt=media&token=c4547c4f-7a46-483d-80e5-8f1a93d96a03"));
//        productList.add(new Product(UUID.randomUUID().toString(), "iPhone 11 Pro Max", 1099, true, "https://firebasestorage.googleapis.com/v0/b/notes-16738.appspot.com/o/products%2Fiphone11promax.png?alt=media&token=109a89bd-e52b-4b76-91d4-5175aa516a23"));
//        productList.add(new Product(UUID.randomUUID().toString(), "iPhone SE", 399, true, "https://firebasestorage.googleapis.com/v0/b/notes-16738.appspot.com/o/products%2Fiphonese.jpeg?alt=media&token=8a3a144d-0cd8-4f6d-94cb-0d81634ea5d0"));
//        productList.add(new Product(UUID.randomUUID().toString(), "MacBook Air", 999, true, "https://firebasestorage.googleapis.com/v0/b/notes-16738.appspot.com/o/products%2Fmacbookair.jpeg?alt=media&token=aae96a4a-e86a-4a15-825a-3da9851330c8"));
//        productList.add(new Product(UUID.randomUUID().toString(), "MacBook Pro 13", 1299, true, "https://firebasestorage.googleapis.com/v0/b/notes-16738.appspot.com/o/products%2Fmbp13touch.jpeg?alt=media&token=88c2bf8e-e72d-4243-a9ab-4cc32e3aff18"));
//        productList.add(new Product(UUID.randomUUID().toString(), "MacBook Pro 16", 2399, true, "https://firebasestorage.googleapis.com/v0/b/notes-16738.appspot.com/o/products%2Fmbp16touch.jpeg?alt=media&token=24498b7f-09b8-42ea-9edb-1bad649902d4"));
//        mutableProductList.setValue(productList);
//    }

    //個数変更
    public void changeQuantiy(Ingredient ingredient,int quantity){
        Log.d("★ShopRepo","changeQuantity() suu:"+quantity);
        //ここに Stockテーブルレコード追加処理OR更新処理を記述 （stock_id と　日付が同じレコードがあれば更新なければ追加）
        //該当するingredianetIDを持つStockのレコードがない場合はレコード追加、ある場合は数の更新

//        if(mutableProductList.getValue()==null) return;
//
//        List<Product> productList = new ArrayList<>(mutableProductList.getValue());
//        Product updateProduct = new Product(product,quantity);
//        Log.d("★ShopRepo","product.name"+product.getName());
//        Log.d("★ShopRepo","productList.size"+productList.size());
//        int i = productList.indexOf(product);
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
