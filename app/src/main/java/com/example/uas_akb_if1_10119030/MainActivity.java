package com.example.uas_akb_if1_10119030;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    AboutAppFragment aboutAppFragment = new AboutAppFragment();
    ProfileFragment profileFragment = new ProfileFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, profileFragment).commit();
                        return true;
                    case R.id.note:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                        return true;
                    case R.id.about:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, aboutAppFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }
}