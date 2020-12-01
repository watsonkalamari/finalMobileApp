package com.example.whatsfordinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    private static final int NUM_PAGES = 4;

    private static final int HOME_FRAGMENT_IDX = 0;
    private static final int SEARCH_FRAGMENT_IDX = 1;
    private static final int FAVORITES_FRAGMENT_IDX = 2;
    private static final int SHOPPINGLIST_FRAGMENT_IDX = 3;

    private ViewPager2 viewPager;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

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
    }

}