package com.example.jonathan.coopertivamovil.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.jonathan.coopertivamovil.Modelo.Cuenta;
import com.example.jonathan.coopertivamovil.Modelo.Transaccion;
import com.example.jonathan.coopertivamovil.R;

import java.util.List;

public class AdapterTransaccion extends BaseAdapter {
    private Context context;
    private List<Transaccion> listaTransacciones;

    public AdapterTransaccion(Context context,List<Transaccion> listaTransacciones){
        this.context =context;
        this.listaTransacciones = listaTransacciones;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    public void setListaTransacciones(List<Transaccion> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }

    @Override
    public int getCount() {
        return listaTransacciones.size();
    }

    @Override
    public Object getItem(int position) {
        return listaTransacciones.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = View.inflate(context,R.layout.display_transaccion,null);
        }
        return null;
    }
}
