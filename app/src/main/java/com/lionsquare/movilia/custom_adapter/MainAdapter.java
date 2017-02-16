package com.lionsquare.movilia.custom_adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.lionsquare.movilia.R;
import com.lionsquare.movilia.model.Celulares;

import java.util.List;


/**
 * Created by edgararana on 06/02/17.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.Vh> {


    private final LayoutInflater inflater;
    private Context context;
    private ClickListener clickListener;
    private List<Celulares> celularesList;

    public MainAdapter(Context context, List<Celulares> celularesList) {

        inflater = LayoutInflater.from(context);
        this.context = context;
        this.celularesList = celularesList;

    }


    @Override
    public Vh onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_row, parent, false);

        return new Vh(view);
    }

    @Override
    public void onBindViewHolder(Vh holder, final int position) {
        Celulares celulares = celularesList.get(position);
        String movie_title, poster;


        movie_title = celulares.getTitle();
        poster = celulares.getUrlImage();


        holder.title.setText(movie_title);
        holder.main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (clickListener != null) {
                    clickListener.itemClicked(position);
                }

            }
        });

        try {
            Glide.with(context).load(poster).diskCacheStrategy(DiskCacheStrategy.NONE).into(holder.poster);
        } catch (Exception e) {
            //Log.d(LOG_TAG, e.getMessage());
        }

    }


    @Override
    public int getItemCount() {
        return celularesList.size();
    }


    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }


    public interface ClickListener {

        void itemClicked(int position);

    }

    class Vh extends RecyclerView.ViewHolder {

        TextView title;
        ImageView poster;
        FrameLayout main;


        Vh(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            poster = (ImageView) itemView.findViewById(R.id.poster);
            main = (FrameLayout) itemView.findViewById(R.id.main);
        }
    }

}
