package com.lionsquare.movilia;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    TextView texto;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TODO: 02/02/17  se insatcias las vistas de los menus y el toolbar
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        // TODO: 02/02/17 metodos para inicializar los componetes de cada vista
        initToolbar();
        initDrawer();

        texto = (TextView) findViewById(R.id.textView);
        texto.setText("estamos en el menu principal");
    }

    /**
     * Initialize toolbar.
     */
    private void initToolbar() {
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.app_name);
    }


    /**
     * Initialize navigation drawer.
     */
    private void initDrawer() {
        // Set up the hamburger icon which will open/close nav drawer
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.dashboard_open_nav_drawer, R.string.dashboard_close_nav_drawer);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // Set up navigation drawer item clicks
        navigationView.setNavigationItemSelectedListener(this);
    }

    // TODO: 02/02/17 este metodo sirve para modificar los eventos del menu drawer
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        switch (item.getItemId()) {
            case R.id.nav_posts:
                //aqui se instacia un fragmento
                return true;
            case R.id.nav_collections:
                //aqui se instacia un fragmento
                return true;
            // TODO: Implement after bookmarks functionality is completed.

            default:
                return false;
        }
    }
}
