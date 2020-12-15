package com.example.whatsfordinner.Fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsfordinner.R;
import com.example.whatsfordinner.Adapter.FavoriteListAdapter;
import com.example.whatsfordinner.db.entity.Recipe;
import com.example.whatsfordinner.viewmodel.DatabaseViewModel;

import java.util.List;

//TODO::make some changes to the xml file so that the items that are
// displaying in the recyclerview look pretty and don't have as many gaps

public class FavoritesFragment extends Fragment {

    private DatabaseViewModel databaseViewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.favorite_recipes_display_activity, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        RecyclerView recyclerView = view.findViewById(R.id.favorite_recipes_recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        final FavoriteListAdapter adapter = new FavoriteListAdapter(getActivity());
        recyclerView.setAdapter(adapter);


        databaseViewModel = ViewModelProviders.of(this).get(DatabaseViewModel.class);
        databaseViewModel.getAllRecipes().observe(getViewLifecycleOwner(), new Observer<List<Recipe>>() {
            @Override
            public void onChanged(List<Recipe> recipes) {
               adapter.setRecipes(recipes);
            }
        });
    }
}
