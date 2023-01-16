package com.example.shoppingcart.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.shoppingcart.adapters.CookAdapter;
import com.example.shoppingcart.adapters.CookDetailAdapter;
import com.example.shoppingcart.entity.Cook;
import com.example.shoppingcart.entity.IngWithXRefAndUnitAndStock;
import com.example.shoppingcart.entity.relation.IngredientAndCookIngredientXRefAndUnit;
import com.example.shoppingcart.viewmodels.CookViewModel;
import com.example.shoppingcart.databinding.FragmentCookDetailBinding;

import java.util.List;

public class CookDetailFragment extends Fragment implements CookDetailAdapter.CookDetailInterface  {

    FragmentCookDetailBinding fragmentCookDetailBinding;
    CookViewModel cookViewModel;
    CookDetailAdapter cookDetailAdapter;
    CookAdapter cookAdapter;


    public CookDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentCookDetailBinding = FragmentCookDetailBinding.inflate(inflater, container, false);
        return fragmentCookDetailBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cookViewModel = new ViewModelProvider(requireActivity()).get(CookViewModel.class);

        cookDetailAdapter = new CookDetailAdapter(this);
//        cookAdapter = new CookAdapter(CookAdapter.CookInterface);
        fragmentCookDetailBinding.setCookViewModel(cookViewModel);
        fragmentCookDetailBinding.CookIngList.setAdapter(cookDetailAdapter);


//2023.1.16
// cookViewModel.findByCookId(1).observe(getViewLifecycleOwner(), new Observer<List<IngWithXRefAndUnitAndStock>>() {
//            @Override
//            public void onChanged(List<IngWithXRefAndUnitAndStock> ingWithXRefAndUnitAndStocks) {
//                for (IngWithXRefAndUnitAndStock i:ingWithXRefAndUnitAndStocks){
//                    Log.i("★CookDetailFragment","ing_name:"+i.getIng_name() + " nuit:" + i.getUnit_name());
//                }
//
//                cookDetailAdapter.submitList(ingWithXRefAndUnitAndStocks);
//            }
//        });

        fragmentCookDetailBinding.setCookViewModel(cookViewModel);

        //2023.1.16　↓
        fragmentCookDetailBinding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //　アイテムが選択された時
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               String spn = fragmentCookDetailBinding.spinner.getSelectedItem().toString();
               //Log.d("★CookDetailFragment","Spnner value:"+spn );
               cookViewModel.findByCookId(1).observe(getViewLifecycleOwner(), new Observer<List<IngWithXRefAndUnitAndStock>>() {
                   @Override
                   public void onChanged(List<IngWithXRefAndUnitAndStock> ingWithXRefAndUnitAndStocks) {
                       for (IngWithXRefAndUnitAndStock i:ingWithXRefAndUnitAndStocks){
                           Log.i("★CookDetailFragment","setOnItemSelectedListener→onChange ing_name:"+i.getIng_name() + " "+i.getSt_quantity()+" nuit:" + i.getUnit_name());
                           int require_quantity =  i.getXref_quantity()*Integer.parseInt(spn);
                           if( require_quantity > i.getSt_quantity() ){
                               Toast.makeText(getActivity(), "足りない食材があります！", Toast.LENGTH_SHORT).show();
                               Log.d("★CookDetailFragment","足りないものあり！");
                           }
                           i.setXref_quantity( i.getXref_quantity() * Integer.parseInt(spn)  );
                       }

                       cookDetailAdapter.submitList(ingWithXRefAndUnitAndStocks);
                   }
               });
           }
            //2023.1.16　↑

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


    @Override
    public void onItemClick( IngWithXRefAndUnitAndStock ingWithXRefAndUnitAndStock){

    }

}
