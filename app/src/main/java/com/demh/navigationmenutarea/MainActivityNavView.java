package com.demh.navigationmenutarea;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

public class MainActivityNavView extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    NavigationView navView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_nav_view);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarNavView);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.iconmenu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navView = (NavigationView)findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuactionbar , menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        boolean fragmentTransaction = false;

        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.menu_opcion_1:
                fragment = new FragmeReciente();
                fragmentTransaction = true;
                break;
            case R.id.menu_opcion_2:
                fragment = new FragmentDestacados();
                fragmentTransaction = true;
                break;
            case R.id.menu_opcion_3:
                fragment = new FragmentSinconexion();
                fragmentTransaction = true;
                break;
            case R.id.menu_opcion_4:
                fragment = new FragmentoPapelera();
                fragmentTransaction = true;
                break;
            case R.id.menu_opcion_5:
                fragment = new FragmentSetting();
                fragmentTransaction = true;
                break;
            case R.id.menu_opcion_6:
                fragment = new FragmentHelp();
                fragmentTransaction = true;
                break;
        }

        if(fragmentTransaction) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, fragment)
                    .commit();

            menuItem.setChecked(true);
            getSupportActionBar().setTitle(menuItem.getTitle());
        }
        drawerLayout.closeDrawers();
        return false;
    }
}

