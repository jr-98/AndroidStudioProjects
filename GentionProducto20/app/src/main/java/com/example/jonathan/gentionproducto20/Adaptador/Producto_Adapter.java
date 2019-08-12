package com.example.jonathan.gentionproducto20.Adaptador;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.jonathan.gentionproducto20.R;
import com.example.jonathan.gentionproducto20.model.Producto;

import java.util.ArrayList;

public class Producto_Adapter extends BaseAdapter {
    private Context context;
    private ArrayList<Producto> listaProductos;

    public Producto_Adapter(Context context, ArrayList<Producto> listaProductos) {
        this.context = context;
        this.listaProductos = listaProductos;
    }

    @Override
    public int getCount() {
        return listaProductos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaProductos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = View.inflate(context, R.layout.display_productos, null);

            TextView cajaCodigo = (TextView) convertView.findViewById(R.id.lblCodigo);
            TextView cajaNombre = (TextView) convertView.findViewById(R.id.lblNombre);
            TextView cajaPrecio = (TextView) convertView.findViewById(R.id.lblPrecio);
            TextView cajaStock = (TextView) convertView.findViewById(R.id.lblStock);

            Producto producto = listaProductos.get(position);

            cajaCodigo.setText(producto.getCodigo());
            cajaNombre.setText(producto.getNombre());
            cajaPrecio.setText(String.valueOf(producto.getPrecio()));
            cajaStock.setText(String.valueOf(producto.getStock()));

            return convertView;
    }

}
