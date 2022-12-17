package com.example.shoppingcart.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.shoppingcart.entity.Ingredient;
import com.example.shoppingcart.entity.Stock;
import com.example.shoppingcart.models.CartItem;
import com.example.shoppingcart.repositories.CartRepo;
import com.example.shoppingcart.repositories.ShopRepo;
import com.example.shoppingcart.repositories.StockRepo;

import java.util.List;

public class IngredientViewModel extends AndroidViewModel {

    private final LiveData<List<Ingredient>> mAllIngredient;

    ShopRepo shopRepo;
    StockRepo stockRepo;
//    CartRepo cartRepo = new CartRepo();

    public IngredientViewModel(@NonNull Application application) {
        super(application);
        this.shopRepo = new ShopRepo(application);
        this.stockRepo = new StockRepo(application);
        mAllIngredient = shopRepo.getmAllIngredients();
    }

    MutableLiveData<Ingredient> mutableIngredient = new MutableLiveData<>();

    public LiveData<List<Ingredient>> getIngredients() {
        return shopRepo.getIngredients();
    }

    public void setIngredient(Ingredient ingredient) {
        mutableIngredient.setValue(ingredient);
    }

    public LiveData<Ingredient> getIngredient() {
        return mutableIngredient;
    }

//    public LiveData<List<CartItem>> getCart() {
//        return cartRepo.getCart();
//    }

    public LiveData<List<Ingredient>> getAllIngredient() {
        return mAllIngredient;
    }
//
//    public boolean addItemToCart(Ingredient ingredient) {
//        return cartRepo.addItemToCart(ingredient);
//    }
//    public boolean minusItemToCart(Ingredient ingredient) {
//        return cartRepo.minusItemToCart(ingredient);
//    }
//
//    public void removeItemFromCart(CartItem cartItem) {
//        cartRepo.removeItemFromCart(cartItem);
//    }
//
//    public void changeQuantity(CartItem cartItem, int quantity) {
//        cartRepo.changeQuantity(cartItem, quantity);
//    }
    public int updateStock( Ingredient ingredient , String date, int suu ){
        return this.stockRepo.updateStock(ingredient.getIngredient_id(),date,suu);
    }
    public long insertStock( Stock stock ){
        return this.stockRepo.insertStock( stock );
    }
    public int deleteStock(Ingredient ingredient , String date){
        return this.stockRepo.deleteStock( ingredient.getIngredient_id(), date );

    }

//    public LiveData<Double> getTotalPrice() {
//        return cartRepo.getTotalPrice();
//    }
//
//    public void resetCart() {
//        cartRepo.initCart();
//    }
//
//    public boolean changeQuantity(Ingredient ingredient,int quantity){
//        if (quantity>=0) {
//            shopRepo.changeQuantiy(ingredient, quantity);
//            return true;
//        }else{
//            return false;
//        }
//    }
}