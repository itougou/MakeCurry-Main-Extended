package com.example.shoppingcart.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shoppingcart.R;
import com.example.shoppingcart.adapters.CategoriesAdapter;
import com.example.shoppingcart.adapters.IngredientAdapter;
import com.example.shoppingcart.adapters.PlayersAdapter;
import com.example.shoppingcart.databinding.FragmentHomeBinding;
import com.example.shoppingcart.databinding.FragmentShopBinding;
import com.example.shoppingcart.databinding.FragmentTabSampleBinding;
import com.example.shoppingcart.entity.CategoryWithIngredient;
import com.example.shoppingcart.entity.CategoryWithIngredient2;
import com.example.shoppingcart.entity.CategoryWithIngredientAndUnit;
import com.example.shoppingcart.entity.Ingredient;
import com.example.shoppingcart.models.Category;
import com.example.shoppingcart.models.Item;
import com.example.shoppingcart.viewmodels.CookViewModel;
import com.example.shoppingcart.viewmodels.IngredientViewModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ahmadhamwi.tabsync.TabbedListMediator;

public class TabSampleFragment extends Fragment {

    private TabLayout tabLayout;
    private RecyclerView recyclerView;
    //private final List<Category> categories = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();

    private IngredientViewModel ingredientViewModel;

    FragmentTabSampleBinding fragmentTabSampleBinding;

    public TabSampleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ingredientViewModel = new ViewModelProvider(requireActivity()).get(IngredientViewModel.class);

        Log.d("★TabFragment"," onViewCreated()");

        //CategoryWithIngredientAndUnitデータを取り出し → リサイクラービューへセット
        ingredientViewModel.getAllCategoryWithIngredientAndUnit().observe(getViewLifecycleOwner(), new Observer<List<CategoryWithIngredientAndUnit>>() {
            @Override
            public void onChanged(List<CategoryWithIngredientAndUnit> categoryWithIngredientAndUnit) {

                initViews(view);

                categories = new ArrayList<>(); //カテゴリArrayListを初期化
                tabLayout.removeAllTabs();  //タブを初期化

                Log.d("★TabSampleFragment", "食材の件数：" +categoryWithIngredientAndUnit.size());

                //1つ目のカテゴリ名を取っておく
                String nowCategoryName = categoryWithIngredientAndUnit.get(0).getCategory_name();

                //1行名のデータを食材のArrayListの先頭に格納する処理
                int ingCount = 1;
                ArrayList<Item> ing_list = new ArrayList<>();
                ing_list.add( new Item( categoryWithIngredientAndUnit.get(0).getIng_name(),
                                        categoryWithIngredientAndUnit.get(0).getQuantity_sum(),
                                        categoryWithIngredientAndUnit.get(0).getUnit_name() )
                                        );

                Log.d("★TabSampleFragment", "カテゴリー：" + categoryWithIngredientAndUnit.get(0).getCategory_name());
                Log.d("★TabSampleFragment", "　食材：" + categoryWithIngredientAndUnit.get(0).getIng_name() + " 数："+categoryWithIngredientAndUnit.get(0).getQuantity_sum());

                Item[] ing_item_list;   //食材の配列（Item型配列）

                for( int i=1 ; i<categoryWithIngredientAndUnit.size(); i++ ){ //カテゴリーごとの情報（2件目以降）取り出し
                    CategoryWithIngredientAndUnit c_i_u = categoryWithIngredientAndUnit.get(i);

                    Log.d("★TabSampleFragment", "カテゴリー：" + c_i_u.getCategory_name());
                    Log.d("★TabSampleFragment", "　食材：" + c_i_u.getIng_name() + " 数："+c_i_u.getQuantity_sum());

                    if( nowCategoryName.equals( c_i_u.getCategory_name() ) ){   //前回のカテゴリ名と同じ場合
                        //食材ArrayListへ食材の情報を追加
                        ing_list.add( new Item( c_i_u.getIng_name(),c_i_u.getQuantity_sum(), c_i_u.getUnit_name() ) );
                        ingCount++; //そのカテゴリの食材数をカウントアップ
                    }else { //前回とカテゴリ名が異なる場合

                        ing_item_list = new Item[ingCount]; //食材の配列を生成
                        ing_list.toArray( ing_item_list ); //食材ArrayList→食材配列（Item型配列）へ変換

                        categories.add( new Category( nowCategoryName, ing_item_list ) );  //カテゴリーごとのインスタンス生成しテゴリArrayListへ格納

                        nowCategoryName = categoryWithIngredientAndUnit.get(i).getCategory_name();  //現在のカテゴリ名を取っておく
                        ingCount = 1; //当該カテゴリの食材の件数を1にする
                        ing_list = new ArrayList<>();   //食材ArrayList初期化

                        //食材ArrayListへ食材情報を1件追加
                        ing_list.add( new Item( c_i_u.getIng_name() ,c_i_u.getQuantity_sum(), c_i_u.getUnit_name() ) );
                    }
                }

                ing_item_list = new Item[ ingCount ]; //食材の配列生成
                ing_list.toArray( ing_item_list ); //食材ArrayList→食材配列変換

                categories.add( new Category( nowCategoryName, ing_item_list ) );  //最後のカテゴリーごとのインスタンス生成しArrayListへ格納

                initRecycler();
                initTabLayout();
                initMediator();
            }
        });
        /** 2022.12.30
        //カテゴリ（１）：食材（多）データを取り出し → リサイクラービューへセット
        ingredientViewModel.getAllCategoryWithIngredient2().observe(getViewLifecycleOwner(), new Observer<List<CategoryWithIngredient2>>() {
            @Override
            public void onChanged(List<CategoryWithIngredient2> categoryWithIngredient) {

                initViews(view);

                for( CategoryWithIngredient2 cat :categoryWithIngredient ){ //カテゴリーごとの情報取り出し

                    Log.d("★TabSampleFragment","カテゴリー："+cat.getCategory_name());

                    Item[] ing_list = new Item[cat.ingredients.size()]; //食材の配列生成

                    for( int i=0 ; i<cat.getIngredients().size() ; i++ ){   //食材の数分繰り返し
                        ing_list[i] = new Item(cat.ingredients.get(i).getIng_name());
                    }

                    categories.add( new Category( cat.getCategory_name(), ing_list ) );  //カテゴリーごとのインスタンス生成

                }
                initRecycler();
                initTabLayout();
                initMediator();
            }
        });
        **/
        // Inflate the layout for this fragment
        //2022.12.23
        //loadCategories();
//        initViews();
        //initRecycler();
//        initTabLayout();
//        initMediator();
        //recyclerView.setAdapter(new CategoriesAdapter(getContext(),categories));
        //recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        // 20022.12.23
        //recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        //recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        //fragmentTabSampleBinding = fragmentTabSampleBinding.inflate(inflater, container, false);

        View view = inflater.inflate(R.layout.fragment_tab_sample, container, false);
//        recyclerView = view.findViewById(R.id.recyclerView);
//        tabLayout = view.findViewById(R.id.tabLayout);
//        Log.d("★TabFragment"," onCreateView() inflater.inflate" );

        // Inflate the layout for this fragment
        //2022.12.23
//        loadCategories();
//        initViews();
//        initTabLayout();
//        initRecycler();
//        initMediator();

        // 20022.12.23
//        //recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
//        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        // 20022.12.23
        // return inflater.inflate(R.layout.fragment_tab_sample, container, false);
        return view;
        //return fragmentTabSampleBinding.getRoot();
    }

//    /* オリジナルのメソッドたちを定義*/
//    private void loadCategories(){
//
//
//        // Categoryインスタンスを追加していく
//        categories.add(new Category("category 1",
//                new Item("Item1-1"),
//                new Item("Item1-2"),
//                new Item("Item1-3"),
//                new Item("Item1-4"))
//        );
//        categories.add(new Category("category 2",
//                new Item("Item2-1"),
//                new Item("Item2-2"),
//                new Item("Item2-3"),
//                new Item("Item2-4"),
//                new Item("Item2-5"))
//        );
//        categories.add(new Category("category 3",
//                new Item("Item3-1"),
//                new Item("Item3-2"))
//        );
//        categories.add(new Category("category 4",
//                new Item("Item4-1"),
//                new Item("Item4-2"),
//                new Item("Item4-3"),
//                new Item("Item4-4"),
//                new Item("Item4-5"))
//        );
//    }

    // 2022.12.23
    // private void initViews(){
    private void initViews(View view){
        recyclerView = view.findViewById(R.id.recyclerView);
        tabLayout = view.findViewById(R.id.tabLayout);
    }
    private void initTabLayout(){
        for(Category category: categories){
            tabLayout.addTab(tabLayout.newTab().setText(category.getName()));
        }
    }
    private void initRecycler(){

        Log.d("★TabFragment"," initRecycler() categories.size()＝"+categories.size());
        for(Category c : categories){
            Log.d("★TabFragment"," initRecycler() categoryname＝"+c.getName());
            for(Item l : c.getListOfItems()){
                Log.d("★TabFragment"," initRecycler() category item＝"+l.getContent() +" getsuu:"+l.getSuu());
            }
        }

        //2022.12.23
        // recyclerView.setAdapter(new CategoriesAdapter(this,categories));
        recyclerView.setAdapter(new CategoriesAdapter(getContext(),categories));
    }
    private void initMediator(){
        // TabbedListMediatorの第３引数がList<Integer>なので定義
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < categories.size();i++){
            indices.add(i);
        }
        new TabbedListMediator(
                recyclerView,
                tabLayout,
                indices,
                false
        ).attach();
    }

}