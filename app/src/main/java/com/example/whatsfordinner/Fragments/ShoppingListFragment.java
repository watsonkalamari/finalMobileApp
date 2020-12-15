package com.example.whatsfordinner.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsfordinner.Adapter.SearchListAdapter;
import com.example.whatsfordinner.Adapter.ShoppingListAdapter;
import com.example.whatsfordinner.R;
import com.example.whatsfordinner.db.entity.Ingredient;
import com.example.whatsfordinner.viewmodel.DatabaseViewModel;

import java.util.List;

public class ShoppingListFragment extends Fragment {

    private DatabaseViewModel databaseViewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shopping_list_page, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = view.findViewById(R.id.list_recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        final ShoppingListAdapter adapter = new ShoppingListAdapter(getActivity());
        recyclerView.setAdapter(adapter);

        databaseViewModel = ViewModelProviders.of(this).get(DatabaseViewModel.class);
        databaseViewModel.getUsersShoppingListIngredients().observe(getViewLifecycleOwner(), new Observer<List<Ingredient>>() {
            @Override
            public void onChanged(List<Ingredient> ingredients) {
                adapter.setShoppingList(ingredients);
            }
        });
    }
}