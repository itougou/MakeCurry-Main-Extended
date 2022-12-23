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
import com.example.shoppingcart.entity.Ingredient;
import com.example.shoppingcart.models.Category;
import com.example.shoppingcart.models.Item;
import com.example.shoppingcart.viewmodels.CookViewModel;
import com.example.shoppingcart.viewmodels.IngredientViewModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import com.ahmadhamwi.tabsync.TabbedListMediator;

public class TabSampleFragment extends Fragment {

    private TabLayout tabLayout;
    private RecyclerView recyclerView;
    private final List<Category> categories = new ArrayList<>();

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
                Log.d("★TabFragment"," initRecycler() category item＝"+l.getContent());
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