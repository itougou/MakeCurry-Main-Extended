package com.example.shoppingcart.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.shoppingcart.entity.Ingredient;
import com.example.shoppingcart.models.CartItem;
import com.example.shoppingcart.views.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class CartRepo {

    MainActivity mainActivity;
    private MutableLiveData<List<CartItem>> mutableCart = new MutableLiveData<>();
    private MutableLiveData<Double> mutableTotalPrice = new MutableLiveData<>();

    public LiveData<List<CartItem>> getCart() {
        if (mutableCart.getValue() == null) {
            initCart();
        }
        return mutableCart;
    }

    public void initCart() {
        mutableCart.setValue(new ArrayList<CartItem>());
    }

    public boolean addItemToCart(Ingredient ingredient) {

        if (mutableCart.getValue() == null) {
            initCart();
        }
        List<CartItem> cartItemList = new ArrayList<>(mutableCart.getValue());
        for (CartItem cartItem: cartItemList) {
            if (cartItem.getIngredient().getIngredient_id()==ingredient.getIngredient_id()) {
                if (cartItem.getQuantity() == 5) {
                    return false;
                }
                int index = cartItemList.indexOf(cartItem);
                cartItem.setQuantity(cartItem.getQuantity() + 1);

                cartItemList.set(index, cartItem);

                mutableCart.setValue(cartItemList);



                return true;
            }
        }
        CartItem cartItem = new CartItem(ingredient, 1);
        cartItemList.add(cartItem);
        mutableCart.setValue(cartItemList);
        return true;
    }
    public boolean minusItemToCart(Ingredient ingredient) {
        if (mutableCart.getValue() == null) {
            initCart();
        }
        List<CartItem> cartItemList = new ArrayList<>(mutableCart.getValue());
        for (CartItem cartItem: cartItemList) {
            if (cartItem.getIngredient().getIngredient_id()==ingredient.getIngredient_id()) {
                if (cartItem.getQuantity() <= 0) {
                    return false;
                }

                int index = cartItemList.indexOf(cartItem);
                cartItem.setQuantity(cartItem.getQuantity() - 1);
                cartItemList.set(index, cartItem);
                mutableCart.setValue(cartItemList);


                return true;
            }
        }
        return false;
    }

    public void removeItemFromCart(CartItem cartItem) {
        if (mutableCart.getValue() == null) {
            return;
        }
        List<CartItem> cartItemList = new ArrayList<>(mutableCart.getValue());
        cartItemList.remove(cartItem);
        mutableCart.setValue(cartItemList);
    }

    public  void changeQuantity(CartItem cartItem, int quantity) {
        if (mutableCart.getValue() == null) return;

        List<CartItem> cartItemList = new ArrayList<>(mutableCart.getValue());

        CartItem updatedItem = new CartItem(cartItem.getIngredient(), quantity);
        cartItemList.set(cartItemList.indexOf(cartItem), updatedItem);

        mutableCart.setValue(cartItemList);
    }


    public LiveData<Double> getTotalPrice() {
        if (mutableTotalPrice.getValue() == null) {
            mutableTotalPrice.setValue(0.0);
        }
        return mutableTotalPrice;
    }

}
