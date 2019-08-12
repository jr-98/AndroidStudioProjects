package com.example.jonathan.gestionproductoa;

import android.app.Dialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jonathan.gestionproductoa.Adapter.AdapterProducto;
import com.example.jonathan.gestionproductoa.helper.helperProducto;
import com.example.jonathan.gestionproductoa.modelo.producto;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class actividadPrincipal extends AppCompatActivity implements AdapterView.OnItemClickListener{
    Button boton;

    ListView listViewProducto;
    producto producto;
    AdapterProducto productoAdapter;
    ArrayList<producto> productos;
    List<producto> listaProductos;
    helperProducto helperProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_principal);

        helperProducto = new helperProducto(this, "viewa", null, 1);
        //manipulacion de la lista (ListView)
        listViewProducto = (ListView) findViewById(R.id.listViewProducto);
        mostrarListView();
        listViewProducto.setOnItemClickListener(this);
        //fin ListView
        boton = (Button) findViewById(R.id.btnCrearProducto);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialogoProducto = new Dialog(actividadPrincipal.this);
                dialogoProducto.setContentView(R.layout.dlg_crear_producto);/////

                final EditText cajaNombre = (EditText) dialogoProducto.findViewById(R.id.txtNombre);
                final EditText cajaCod = (EditText) dialogoProducto.findViewById(R.id.txtCodigo);
                final EditText cajaPrecio = (EditText) dialogoProducto.findViewById(R.id.txtPrecio);
                final EditText cajaExist = (EditText) dialogoProducto.findViewById(R.id.txtPrecio);
                final Button botonGuardar = (Button) dialogoProducto.findViewById(R.id.btnCrear);

                botonGuardar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        producto p = new producto();
                        p.setNombre(cajaNombre.getText().toString());
                        p.setCodigo(cajaCod.getText().toString());
                        p.setPrecio(Double.parseDouble(cajaPrecio.getText().toString()));
                        p.setExistencia(Integer.parseInt(cajaExist.getText().toString()));
                        helperProducto.guardar(p);
                        dialogoProducto.hide();
                    }
                });
                dialogoProducto.show();
                mostrarListView();
            }
        });

    }
    private void mostrarListView() {
        productos = new ArrayList<producto>();
        producto = new producto();
        listaProductos = helperProducto.obtenerTodosProductos();
        for (int i = 0; i < listaProductos.size(); i++) {
            producto = listaProductos.get(i);
            productos.add(producto);
        }
        productoAdapter = new AdapterProducto(actividadPrincipal.this, productos);
        listViewProducto.setAdapter(productoAdapter);
        productoAdapter.notifyDataSetChanged();
    }
    /*private ArrayList<producto> Productos2(){
         productos = new ArrayList<producto>();
         listaProductos= helperProducto.obtenerTodosProductos();
         for (int i = 0 ; i<listaProductos.size(); i++){
             producto = listaProductos.get(i);
             productos.add(producto);
         }
         return productos;
    }*/

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Dialog dialog = new Dialog(actividadPrincipal.this);
                dialog.setContentView(R.layout.dlg_modificar);


                final EditText cajaNombreUpdate = (EditText)dialog.findViewById(R.id.txtNombreUpdate);
                final EditText cajaCodigoUpdate = (EditText)dialog.findViewById(R.id.txtCodigoUpdate);
                final EditText cajaPrecioUpdate = (EditText)dialog.findViewById(R.id.txtPrecioUpdate);
                final EditText cajaExistenciaUpdate = (EditText)dialog.findViewById(R.id.txtExistenciasUpdate);
                final Button editar = (Button) dialog.findViewById(R.id.btnUpdate);
                final Button eliminar = (Button) dialog.findViewById(R.id.btnDelete);

                cajaNombreUpdate.setText(productos.get(position).getNombre());
                cajaCodigoUpdate.setText(String.valueOf(productos.get(position).getCodigo()));
                cajaPrecioUpdate.setText(String.valueOf(productos.get(position).getPrecio()));
                cajaExistenciaUpdate.setText(String.valueOf(productos.get(position).getExistencia()));
                editar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        producto p = new producto();
                        p.setNombre(cajaNombreUpdate.getText().toString());
                        p.setPrecio(Double.parseDouble(cajaPrecioUpdate.getText().toString()));
                        p.setExistencia(Integer.parseInt(cajaExistenciaUpdate.getText().toString()));
                        helperProducto.modicar(p);
                        mostrarListView();
                        dialog.hide();
                    }
                });
                eliminar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        producto p = new producto();
                        p.setNombre(cajaNombreUpdate.getText().toString());
                        p.setPrecio(Double.parseDouble(cajaPrecioUpdate.getText().toString()));
                        p.setExistencia(Integer.parseInt(cajaExistenciaUpdate.getText().toString()));
                        helperProducto.eliminar(p);
                        mostrarListView();
                        dialog.hide();
                    }
                });

                dialog.show();
            }
}
