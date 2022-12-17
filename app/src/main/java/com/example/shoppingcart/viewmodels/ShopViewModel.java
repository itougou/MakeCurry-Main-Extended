package com.example.shoppingcart.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.example.shoppingcart.entity.Ingredient;
import com.example.shoppingcart.models.CartItem;
import com.example.shoppingcart.models.Product;
import com.example.shoppingcart.repositories.CartRepo;
import com.example.shoppingcart.repositories.ShopRepo;

import java.util.List;

public class ShopViewModel extends AndroidViewModel {

    private final LiveData<List<Ingredient>> mAllIngredient;

    ShopRepo shopRepo;
    CartRepo cartRepo = new CartRepo();

    public ShopViewModel(@NonNull Application application) {
        super(application);
        this.shopRepo = new ShopRepo(application);
        mAllIngredient = shopRepo.getmAllIngredients();
    }

    MutableLiveData<Product> mutableProduct = new MutableLiveData<>();

    public LiveData<List<Ingredient>> getIngredients() {
        return shopRepo.getIngredients();
    }

    public void setProduct(Product product) {
        mutableProduct.setValue(product);
    }

    public LiveData<Product> getProduct() {
        return mutableProduct;
    }

    public LiveData<List<CartItem>> getCart() {
        return cartRepo.getCart();
    }

    public LiveData<List<Ingredient>> getAllIngredient() {
        return mAllIngredient;
    }

    public boolean addItemToCart(Ingredient ingredient) {
        return cartRepo.addItemToCart(ingredient);
    }
    public boolean minusItemToCart(Ingredient ingredient) {
        return cartRepo.minusItemToCart(ingredient);
    }

    public void removeItemFromCart(CartItem cartItem) {
        cartRepo.removeItemFromCart(cartItem);
    }

    public  void resetProduct(Product product){
        shopRepo.resetProduct(product);
    }
    public void resetProductList(){shopRepo.resetProductList();}

    public void changeQuantity(CartItem cartItem, int quantity) {
        cartRepo.changeQuantity(cartItem, quantity);
    }

    public LiveData<Double> getTotalPrice() {
        return cartRepo.getTotalPrice();
    }

    public void resetCart() {
        cartRepo.initCart();
    }

    public boolean changeQuantity_in_shop(Ingredient ingredient,int quantity){
        if (quantity>=0) {
            shopRepo.changeQuantiy(ingredient, quantity);
            return true;
        }else{
            return false;
        }
    }


}
