package com.lionsquare.movilia.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lionsquare.movilia.R;

/**
 * Created by edgararana on 05/02/17.
 */

public class MainFragment extends Fragment {
    TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        // TODO: 05/02/17 en los fragmentos para poder acceder alas vistas tienes que obtenerlo diercto del inflate
        /**
         *  view es la vista que hereda todas las vistas que se inflan en el xml
         *
         * **/
        textView = (TextView) view.findViewById(R.id.fm_txt_texto);
        textView.setText("este es el menu principal");
        return view;
    }
}
