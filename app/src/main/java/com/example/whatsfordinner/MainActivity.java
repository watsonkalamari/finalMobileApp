package com.example.whatsfordinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;


import com.example.whatsfordinner.Fragments.FavoritesFragment;
import com.example.whatsfordinner.Fragments.HomeFragment;
import com.example.whatsfordinner.Fragments.SearchFragment;
import com.example.whatsfordinner.Fragments.ShoppingListFragment;
import com.example.whatsfordinner.db.AppDatabase;
import com.example.whatsfordinner.db.entity.Recipe;
import com.example.whatsfordinner.viewmodel.DatabaseViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int NUM_PAGES = 4;

    private static final int HOME_FRAGMENT_IDX = 0;
    private static final int SEARCH_FRAGMENT_IDX = 1;
    private static final int FAVORITES_FRAGMENT_IDX = 2;
    private static final int SHOPPINGLIST_FRAGMENT_IDX = 3;

    private ViewPager2 viewPager;
    private FragmentStateAdapter pageAdapter;
    private BottomNavigationView bottomNavigationView;

    private DatabaseViewModel databaseViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.pager);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        pageAdapter = new ScreenSlidePagerAdapter(this);
        viewPager.setAdapter(pageAdapter);

        databaseViewModel = ViewModelProviders.of(this).get(DatabaseViewModel.class);
        databaseViewModel.getAllRecipes().observe(this, new Observer<List<Recipe>>() {
            @Override
            public void onChanged(List<Recipe> recipes) {
                //TODO::update RecyclerView
                Toast.makeText(MainActivity.this, "onchanged", Toast.LENGTH_SHORT).show();
            }
        });


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home_button:
                        viewPager.setCurrentItem(HOME_FRAGMENT_IDX);
                        return true;
                    case R.id.search_button:
                        viewPager.setCurrentItem(SEARCH_FRAGMENT_IDX, true);
                        return true;
                    case R.id.favorites_button:
                        viewPager.setCurrentItem(FAVORITES_FRAGMENT_IDX, true);
                        return true;
                    case R.id.shopping_list_button:
                        viewPager.setCurrentItem(SHOPPINGLIST_FRAGMENT_IDX, true);
                        return true;
                    default:
                        return false;
                }
            }
        });

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                MenuItem selectedItem = bottomNavigationView.getMenu().getItem(position);
                bottomNavigationView.setSelectedItemId(selectedItem.getItemId());
            }
        });
    }

    private class ScreenSlidePagerAdapter extends FragmentStateAdapter {
        public ScreenSlidePagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }


        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case HOME_FRAGMENT_IDX:
                    return new HomeFragment();
                case SEARCH_FRAGMENT_IDX:
                    return new SearchFragment();
                case FAVORITES_FRAGMENT_IDX:
                    return new FavoritesFragment();
                case SHOPPINGLIST_FRAGMENT_IDX:
                    return new ShoppingListFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }
}

