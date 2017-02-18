package com.lionsquare.movilia.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.widget.TextView;


import com.lionsquare.movilia.R;

import com.lionsquare.movilia.custom_adapter.MenuAdapter;
import com.lionsquare.movilia.fragments.MainFragment;

import com.lionsquare.movilia.model.Menu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MenuAdapter.ClickListener {

    TextView texto;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    RecyclerView recycler;
    MenuAdapter menuAdapter;
    List<Menu> menuList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TODO: 02/02/17  se insatcias las vistas de los menus y el toolbar
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        recycler = (RecyclerView) findViewById(R.id.ndh_tv_menu);
        // TODO: 02/02/17 metodos para inicializar los componetes de cada vista
        initToolbar();
        initDrawer();
        initFragment();

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

        menuList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            menuList.add(new Menu("Titulo",
                    R.mipmap.ic_launcher));
        }

        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new GridLayoutManager(this, 2));

        menuAdapter = new MenuAdapter(this, menuList);
        recycler.setAdapter(menuAdapter);
        menuAdapter.setClickListener(this);
    }

    /**
     * se inicia el fragmento
     **/

    void initFragment() {
        MainFragment mainFragment = new MainFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        manager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        ft.replace(R.id.frame_content, mainFragment);
        ft.commit();
    }


    @Override
    public void itemClicked(int position) {
    }
}
