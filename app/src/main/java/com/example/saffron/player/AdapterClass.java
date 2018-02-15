package com.example.saffron.player;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by saffron on 2/15/2018.
 */

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ViewHolder> {

    List<Getter> list;
    private ItemClickListener clickListener;
    Context context;

    public AdapterClass(List<Getter> list, Context context) {
        this.list = list;

        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Getter g =  list.get(position);
        holder.t11.setText(g.getHeader());
        holder.t22.setText(g.getBanner());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder

    {
        private TextView t11,t22;


        public ViewHolder(View itemView) {
            super(itemView);

            t11 = (TextView) itemView.findViewById(R.id.t1);
            t22 = (TextView) itemView.findViewById(R.id.t2);


        }
}
}
