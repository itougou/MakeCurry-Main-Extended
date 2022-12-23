package com.example.shoppingcart.database;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.shoppingcart.dao.CategoryWithIngredientDao;
import com.example.shoppingcart.dao.CookAndCookdetailDao;
import com.example.shoppingcart.dao.CookDao;
import com.example.shoppingcart.dao.IngWithXRefAndUnitAndStockDao;
import com.example.shoppingcart.dao.IngredientAndCookIngredientXRefAndUnitDao;
import com.example.shoppingcart.dao.IngredientAndStockAndUnitDao;
import com.example.shoppingcart.dao.CookWithIngredientAndUnitDao;
import com.example.shoppingcart.dao.IngredientDao;
import com.example.shoppingcart.dao.StockAndIngredientDao;
import com.example.shoppingcart.dao.StockDao;
import com.example.shoppingcart.dao.StockWithIngredientsAndUnitDao;
import com.example.shoppingcart.entity.CategoryWithIngredient;
import com.example.shoppingcart.entity.Cook;
import com.example.shoppingcart.entity.CookIngredientXRef;
import com.example.shoppingcart.entity.IngCategory;
import com.example.shoppingcart.entity.IngWithXRefAndUnitAndStock;
import com.example.shoppingcart.entity.Ingredient;
import com.example.shoppingcart.entity.Stock;
import com.example.shoppingcart.entity.StockWithIngredientsAndUnit;
import com.example.shoppingcart.entity.Unit;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {
                Cook.class,
                Ingredient.class,
                CookIngredientXRef.class,
                Stock.class,
                Unit.class,
                IngCategory.class
        },
        views = {
                StockWithIngredientsAndUnit.class,
                IngWithXRefAndUnitAndStock.class,
                CategoryWithIngredient.class    //2022.12.23
        },
        version = 2,


            autoMigrations = {
                @AutoMigration (from = 1, to = 2)
//                @AutoMigration (from = 2, to = 3)
//                @AutoMigration (from = 3, to = 4),
//                @AutoMigration (from = 4, to = 5),
//                @AutoMigration (from = 5, to = 6),
//                @AutoMigration (from = 6, to = 7)
//                @AutoMigration (from = 7, to = 8),
//                @AutoMigration(from = 8, to = 9)
        },
        exportSchema = true
)


public abstract class CookRoom extends RoomDatabase {

    public abstract CookDao CookDao();
    public abstract IngredientDao IngredientDao();
    public abstract StockDao StockDao();

    public abstract StockAndIngredientDao StockAndIngredientDao();
    public abstract CookAndCookdetailDao CookAndCookdetailDao();
    public abstract IngredientAndStockAndUnitDao IngredientAndStockAndUnitDao();
    public abstract CookWithIngredientAndUnitDao CookWithIngredientAndUnitDao();
    public abstract IngredientAndCookIngredientXRefAndUnitDao IngredientAndCookIngredientXRefAndUnitDao();
    public abstract IngWithXRefAndUnitAndStockDao IngWithXRefAndUnitAndStockDao();
    public abstract StockWithIngredientsAndUnitDao StockWithIngredientsAndUnitDao();
    //2022.12.23
    public abstract CategoryWithIngredientDao CategoryWithIngredientDao();

    // marking the instance as volatile to ensure atomic access to the variable
    private static volatile CookRoom INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static CookRoom getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (CookRoom.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), CookRoom.class, "MakeCurry.db")
                            .addCallback(sRoomDatabaseCallback).createFromAsset("MakeCurry5.db").build();

                }
            }
        }
        return INSTANCE;
    }
    private static Callback sRoomDatabaseCallback = new Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(() -> {

                Log.d("★RoomDatabase.Callback：","★");
            });
        }
    };

}