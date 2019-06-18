package com.example.pruebaap;

        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;

        import java.util.ArrayList;
        import java.util.List;

public class AdapterListView extends BaseAdapter {

    private static LayoutInflater inflater = null;

    Context contexto;
    String  [] nmItemsd;
    String  [] nmItemsh;
    String  [] nmItemsc;
    List<Integer> nmItemsf1;
    List<Integer> nmItemsf2;
    String [] sizelimit;

    public  AdapterListView(Context conexto, String[] nmItemsd, String[] nmItemsh, String[] nmItemsc, List<Integer> nmItemsf1, List<Integer> nmItemsf2, String[] sizelimit){
        this.contexto = conexto;
        this.nmItemsd = nmItemsd;
        this.nmItemsh = nmItemsh;
        this.nmItemsc = nmItemsc;
        this.nmItemsf1 = nmItemsf1;
        this.nmItemsf2 = nmItemsf2;
        this.sizelimit = sizelimit;

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
        bandera1.setImageResource(nmItemsf1.get(i));
        bandera2.setImageResource(nmItemsf2.get(i));

        return vista;
    }

    @Override
    public int getCount() {

        return sizelimit.length;
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