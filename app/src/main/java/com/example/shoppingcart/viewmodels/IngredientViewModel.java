package com.example.shoppingcart.viewmodels;

//import static com.example.shoppingcart.BR.stock;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.shoppingcart.dao.IngredientAndStockAndUnitDao;
import com.example.shoppingcart.entity.CategoryWithIngredient;
import com.example.shoppingcart.entity.CategoryWithIngredient2;
import com.example.shoppingcart.entity.CategoryWithIngredientAndUnit;
import com.example.shoppingcart.entity.Ingredient;
import com.example.shoppingcart.entity.relation.IngredientAndCookIngredientXRefAndUnit;
import com.example.shoppingcart.entity.relation.IngredientAndStock;
import com.example.shoppingcart.entity.Stock;
import com.example.shoppingcart.entity.relation.IngredientAndStockAndUnit;
import com.example.shoppingcart.entity.relation.IngredientAndUnit;
import com.example.shoppingcart.models.CartItem;

import com.example.shoppingcart.repositories.CartRepo;
import com.example.shoppingcart.repositories.CategoryWithIngredientRepo;
import com.example.shoppingcart.repositories.IngredientAndCookIngredientXRefAndUnitRepo;
import com.example.shoppingcart.repositories.ShopRepo;
import com.example.shoppingcart.repositories.StockRepo;

import java.util.List;

public class IngredientViewModel extends AndroidViewModel {

    private final LiveData<List<Ingredient>> mAllIngredient;
    //2022.12.23
    private final LiveData<List<CategoryWithIngredient>> mAllCategoryWithIngredient;    //結合表
    private final LiveData<List<CategoryWithIngredient2>> mAllCategoryWithIngredient2;  //1対多
    //private final LiveData<List<CategoryWithIngredientAndUnit>> mAllCategoryWithIngredientAndUnit;
    private final LiveData<List<IngredientAndUnit>> mAllIngredientAndUnit;  //1対1 List

    ShopRepo shopRepo;
    IngredientAndCookIngredientXRefAndUnitRepo ingredientAndCookIngredientXRefAndUnitRepo;
    CartRepo cartRepo = new CartRepo();
    StockRepo stockRepo;
    //2022.12.23
    CategoryWithIngredientRepo categoryWithIngredientRepo;

    public IngredientViewModel(@NonNull Application application) {
        super(application);
        this.shopRepo = new ShopRepo(application);
        this.stockRepo = new StockRepo(application);
        mAllIngredient = shopRepo.getmAllIngredients();
        //2022.12.23
        categoryWithIngredientRepo = new CategoryWithIngredientRepo(application);
        mAllCategoryWithIngredient = categoryWithIngredientRepo.getAllCategoryWithIngredient();
        mAllCategoryWithIngredient2 = categoryWithIngredientRepo.getAllCategoryWithIngredient2();
        //mAllCategoryWithIngredientAndUnit = categoryWithIngredientRepo.getAllCategoryWithIngredientAndUnit();
        mAllIngredientAndUnit = shopRepo.getIngredientAntUnit();
    }

    MutableLiveData<IngredientAndUnit> mutableIngredient = new MutableLiveData<>();

    public LiveData<List<Ingredient>> getIngredients() {
        return shopRepo.getIngredients();
    }

    public void setIngredient(IngredientAndUnit ingredient) {
        mutableIngredient.setValue(ingredient);
    }

    public LiveData<IngredientAndUnit> getIngredient() {
        return mutableIngredient;
    }

    public LiveData<List<Ingredient>> getAllIngredient() {
        return mAllIngredient;
    }

    //2022.12.23
    public LiveData<List<CategoryWithIngredient>> getAllCategoryWithIngredient() {
        return mAllCategoryWithIngredient;
    }
    public LiveData<List<CategoryWithIngredient2>> getAllCategoryWithIngredient2() {
        return mAllCategoryWithIngredient2;
    }
    public LiveData<List<CategoryWithIngredientAndUnit>> getAllCategoryWithIngredientAndUnit() {
        //return mAllCategoryWithIngredientAndUnit;
        return categoryWithIngredientRepo.getAllCategoryWithIngredientAndUnit();
    }
    public LiveData<List<IngredientAndUnit>> getAllIngredientAndUnit() {
        return mAllIngredientAndUnit;
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
    public int updateStock( IngredientAndUnit ingredient , String date, int suu ) {
        return this.stockRepo.updateStock(ingredient.getIngredient_id(), date, suu);
    }

    public long insertStock( Stock stock ){
        return this.stockRepo.insertStock( stock );
    }
    public int deleteStock(IngredientAndUnit ingredient , String date){
        return this.stockRepo.deleteStock( ingredient.getIngredient_id(), date );
    }

//    public LiveData<List<IngredientAndStockAndUnit>> getAllStockAndUnit() {return stockRepo.getAllStockAndUnit();}
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
