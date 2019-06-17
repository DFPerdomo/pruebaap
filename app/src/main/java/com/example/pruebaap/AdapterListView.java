package com.example.pruebaap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterListView extends BaseAdapter {

    private static LayoutInflater inflater = null;

    Context contexto;
    String  [] nmItemsd;
    String  [] nmItemsh;
    String  [] nmItemsc;
    int [] nmItemsFlags1;
    int [] nmItemsFlags2;

    public  AdapterListView(Context conexto, String nmItemsd[], String nmItemsh[], String nmItemsc[], int [] nmItemsFlags1, int [] nmItemsFlags2){
        this.contexto = conexto;
        this.nmItemsd = nmItemsd;
        this.nmItemsh = nmItemsh;
        this.nmItemsc = nmItemsc;
        this.nmItemsFlags1 = nmItemsFlags1;
        this.nmItemsFlags2 = nmItemsFlags2;

        inflater = (LayoutInflater)conexto.getSystemService(conexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        final View vista = inflater.inflate(R.layout.nmlist_item,null);

        TextView fecha = (TextView) vista.findViewById(R.id.date);
        TextView ciudad = (TextView) vista.findViewById(R.id.city);
        TextView hora = (TextView) vista.findViewById(R.id.hour);
        ImageView bandera1 = (ImageView) vista.findViewById(R.id.flag1);
        ImageView bandera2 = (ImageView) vista.findViewById(R.id.flag2);

        fecha.setText(nmItemsd[i]);
        ciudad.setText(nmItemsh[i]);
        hora.setText(nmItemsc[i]);
        bandera1.setImageResource(nmItemsFlags1[i]);
        bandera2.setImageResource(nmItemsFlags2[i]);

        return vista;
    }

    @Override
    public int getCount() {

        return nmItemsFlags1.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}