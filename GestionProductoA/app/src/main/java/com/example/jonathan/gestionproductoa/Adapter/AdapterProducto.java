package com.example.jonathan.gestionproductoa.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.jonathan.gestionproductoa.R;
import com.example.jonathan.gestionproductoa.modelo.producto;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdapterProducto extends BaseAdapter {
    private Context context;
    private ArrayList<producto> ListaProducto;

    public AdapterProducto(Context context, ArrayList<producto> listaProducto) {
        this.context = context;
        ListaProducto = listaProducto;
    }

    @Override
    public int getCount() {
        return ListaProducto.size();
    }

    @Override
    public Object getItem(int position) {
        return ListaProducto.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
            convertView = View.inflate(context,R.layout.display_producto,null);
        TextView textNombre= (TextView) convertView.findViewById(R.id.lblNombre);
        TextView textCodigo = (TextView) convertView.findViewById(R.id.lblCodigo);
        TextView txtPrecio=(TextView) convertView.findViewById(R.id.lblPrecio);
        TextView txtExistencias = (TextView) convertView.findViewById(R.id.lblExistencia);

        producto producto = ListaProducto.get(position);
        textNombre.setText(producto.getNombre());
        textCodigo.setText(producto.getCodigo());
        txtPrecio.setText(String.valueOf(producto.getPrecio()));
        txtExistencias.setText(String.valueOf(producto.getExistencia()));

        return convertView;
    }
    public Context getContext(){
        return context;
    }
    public void  setContext(Context contexto){
        this.context=contexto;
    }
    public void setListaProducto(ArrayList<producto> listaProducto){
        this.ListaProducto = listaProducto;
    }
}
