package com.example.jonathan.jonathantillaguangoex5.Adaptador;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.jonathan.jonathantillaguangoex5.Modelo.Wines;
import com.example.jonathan.jonathantillaguangoex5.R;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends BaseAdapter {

    private Context context;
    private List<Wines> listWine;

    public Adapter(Context context, List<Wines> listWine) {
        this.context = context;
        this.listWine = listWine;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<Wines> getListWine() {
        return listWine;
    }

    public void setListWine(List<Wines> listaWine) {
        this.listWine = listaWine;
    }

    @Override
    public int getCount() {
        return listWine.size();
    }

    @Override
    public Object getItem(int position) {
        return listWine.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
   public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView ==null)
        convertView = View.inflate(context, R.layout.display_wines,null);
        TextView cajaID = (TextView) convertView.findViewById(R.id.lblID);
        TextView cajaNombre = (TextView) convertView.findViewById(R.id.lblNombre);
        TextView cajaAño = (TextView) convertView.findViewById(R.id.lblAño);
        TextView cajaUvas = (TextView) convertView.findViewById(R.id.lblUvas);
        TextView cajaPais = (TextView) convertView.findViewById(R.id.lblPais);
        TextView cajaRegion = (TextView) convertView.findViewById(R.id.lblRegion);
        TextView cajaDescripcion = (TextView) convertView.findViewById(R.id.lblDescripcion);
        TextView cajaImagen = (TextView) convertView.findViewById(R.id.lblImagen);
        Wines wine = listWine.get(position);

        cajaID.setText(String.valueOf(wine.getId()));
        cajaNombre.setText(wine.getNombre());
        cajaAño.setText(String.valueOf(wine.getAño()));
        cajaUvas.setText(wine.getUvas());
        cajaPais.setText(wine.getPais());
        cajaRegion.setText(wine.getRegion());
        cajaDescripcion.setText(wine.getDescripcion());
        cajaImagen.setText(wine.getImagen());

        return convertView;
        }
}
