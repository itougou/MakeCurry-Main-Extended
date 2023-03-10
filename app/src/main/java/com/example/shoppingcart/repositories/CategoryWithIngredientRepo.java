package com.example.shoppingcart.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.shoppingcart.dao.CategoryWithIngredientAndUnitDao;
import com.example.shoppingcart.dao.CategoryWithIngredientDao;
import com.example.shoppingcart.dao.IngredientAndCookIngredientXRefAndUnitDao;
import com.example.shoppingcart.database.CookRoom;
import com.example.shoppingcart.entity.CategoryWithIngredient;
import com.example.shoppingcart.entity.CategoryWithIngredient2;
import com.example.shoppingcart.entity.CategoryWithIngredientAndUnit;
import com.example.shoppingcart.entity.relation.IngredientAndCookIngredientXRefAndUnit;

import java.util.List;

//2022.12.23
public class CategoryWithIngredientRepo {

    private CategoryWithIngredientDao mCategoryWithIngredientDao;
    private CategoryWithIngredientAndUnitDao mCategoryWithIngredientAndUnitDao;
    private
    Application mAllIngredientAndCookIngredientXRefAndUnit;

    public CategoryWithIngredientRepo(Application application){
        CookRoom db = CookRoom.getDatabase(application);

        mCategoryWithIngredientDao = db.CategoryWithIngredientDao();
        mCategoryWithIngredientAndUnitDao = db.CategoryWithIngredientAndUnitDao();
    }

    public LiveData<List<CategoryWithIngredient>> getAllCategoryWithIngredient(){
        return mCategoryWithIngredientDao.findAll();
    }
    public LiveData<List<CategoryWithIngredient2>> getAllCategoryWithIngredient2(){
        return mCategoryWithIngredientDao.findAll2();
    }
    public LiveData<List<CategoryWithIngredientAndUnit>> getAllCategoryWithIngredientAndUnit(){
        return mCategoryWithIngredientAndUnitDao.findAll();
    }

}
