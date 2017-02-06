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
import com.lionsquare.movilia.model.Menu;

import java.util.List;

import static com.lionsquare.movilia.R.id.poster;

/**
 * Created by edgararana on 06/02/17.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.Vh> {

    private final LayoutInflater inflater;
    private Context context;
    private List<Menu> listmenu;
    private ClickListener clickListener;

    public MenuAdapter(Context context, List<Menu> listmenu) {

        inflater = LayoutInflater.from(context);
        this.context = context;
        this.listmenu = listmenu;

    }

    @Override
    public MenuAdapter.Vh onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_row, parent, false);

        return new MenuAdapter.Vh(view);
    }

    @Override
    public void onBindViewHolder(MenuAdapter.Vh holder, final int position) {
        Menu menu = listmenu.get(position);

        holder.title.setText(menu.getTitle());

        holder.main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (clickListener != null) {
                    clickListener.itemClicked(position);
                }

            }
        });

        try {
            Glide.with(context).load(menu.getImage()).diskCacheStrategy(DiskCacheStrategy.NONE).into(holder.poster);
        } catch (Exception e) {
            //Log.d(LOG_TAG, e.getMessage());
        }

    }


    @Override
    public int getItemCount() {
        return listmenu.size();
    }

    public interface ClickListener {

        void itemClicked(int position);

    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
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
