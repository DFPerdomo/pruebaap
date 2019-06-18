package com.example.pruebaap;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterReciclerView extends RecyclerView.Adapter {
    private  ArrayList<MItem> mlistItem;
    private Context context;

    public AdapterReciclerView(Context context, ArrayList<MItem> mlistItem) {
        this.context = context;
        this.mlistItem = mlistItem;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View contentView = LayoutInflater.from(context).inflate(R.layout.mlist_item, null);
            return new Holder(contentView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        MItem item = mlistItem.get(i);
        Holder Holder = (Holder) viewHolder;
        Holder.bandera12.setImageResource(item.getFlag12());
        Holder.bandera22.setImageResource(item.getFlag22());
        Holder.fecha.setText((item.getDate()));
        Holder.marcador.setText(item.getScore());
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return mlistItem.size();
    }

    public static class Holder extends RecyclerView.ViewHolder{
        TextView marcador;
        TextView fecha ;
        ImageView bandera12 ;
        ImageView bandera22 ;

        public Holder(@NonNull View itemView) {
            super(itemView);

            marcador = itemView.findViewById(R.id.score);
            fecha = itemView.findViewById(R.id.date2);
            bandera12 = itemView.findViewById(R.id.flag12);
            bandera22 = itemView.findViewById(R.id.flag22);

        }
    }

}
