package com.example.nadya.posyandu;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.MenuItem;

public class BerandaTenagaMedis extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda_tenaga_medis);

        loadFragment(new HomeFragment());

        BottomNavigationView bottomNavigationView = findViewById(R.id.bn_beranda);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, fragment).commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem ) {
        Fragment fragment=null;
        switch (menuItem.getItemId()) {
            case R.id.profil_menu:
                fragment= new ProfilFragment();
                break;
            case R.id.posyandu_menu:
                fragment= new PosyanduFragment();
                break;
            case R.id.home_menu:
                fragment= new HomeFragment();
                break;
        }
        return loadFragment(fragment);
    }
}
