package com.lionsquare.movilia.fragments;

import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lionsquare.movilia.R;
import com.lionsquare.movilia.custom_adapter.MainAdapter;
import com.lionsquare.movilia.model.Celulares;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edgararana on 05/02/17.
 */

public class MainFragment extends Fragment implements MainAdapter.ClickListener {
    //a si se instacia las vista con el xml con ButterKnife

    RecyclerView recycler;
    MainAdapter mainAdapter;
    List<Celulares> celularesList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        recycler = (RecyclerView) view.findViewById(R.id.fm_rv_main);
        // TODO: 05/02/17 en los fragmentos para poder acceder alas vistas tienes que obtenerlo diercto del inflate
        /**
         *  view es la vista que hereda todas las vistas que se inflan en el xml
         *
         * **/

        // TODO: 06/02/17 se llena la lista para depues pasarla al adaptador
        celularesList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            celularesList.add(new Celulares("Titulo",
                    "http://screencrush.com/files/2015/02/avengers-2-poster-hi-res.jpg"));
        }

        // TODO: 06/02/17 se comprueba el tamaño de la pantalla si es tableta el grird aumentara los items vidisbles

        boolean tabletSize = getResources().getBoolean(R.bool.isTablet);
        if (tabletSize) {
            // TODO: 06/02/17 este if revisa si la tableta esta en modo portrait o lanscape
            /**
             * portrait cuando el telefono esta en modo vertical
             * lanscape el telefono esta horizontalo
             * **/
            if (getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                recycler.setHasFixedSize(true);
                recycler.setLayoutManager(new GridLayoutManager(getActivity(), 6));
            } else {
                recycler.setHasFixedSize(true);
                recycler.setLayoutManager(new GridLayoutManager(getActivity(), 8));
            }


        } else {

            if (getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {

                recycler.setHasFixedSize(true);
                recycler.setLayoutManager(new GridLayoutManager(getActivity(), 3));
            } else {

                recycler.setHasFixedSize(true);
                recycler.setLayoutManager(new GridLayoutManager(getActivity(), 5));
            }

        }
// TODO: 06/02/17 se da el contexto y la lista al adaptador para que se infle
        mainAdapter = new MainAdapter(getActivity(), celularesList);
        recycler.setAdapter(mainAdapter);
        mainAdapter.setClickListener(this);
        return view;
    }


    @Override
    public void itemClicked(int position) {

    }
}
