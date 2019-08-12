package com.example.jonathan.gentionproducto20;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.jonathan.gentionproducto20.Adaptador.Producto_Adapter;
import com.example.jonathan.gentionproducto20.helper.HelperProducto;
import com.example.jonathan.gentionproducto20.model.Producto;

import java.util.ArrayList;
import java.util.List;

public class ActividadPrincipal extends AppCompatActivity implements AdapterView.OnItemClickListener {
    Button botonCrear;
    ListView listView;
    HelperProducto helperProducto;
    Producto producto;
    ArrayList<Producto> productos;
    ArrayList<Producto> productosObtenidos;
    List<Producto> listaProductos;
    Producto_Adapter producto_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_principal);
        getSupportActionBar().setTitle("Home");

        helperProducto = new HelperProducto(this, "dbProdu", null, 1);
        listView = (ListView) findViewById(R.id.listaPrincipal);
        mostrarListView();
        listView.setOnItemClickListener(this);
        botonCrear = (Button) findViewById(R.id.btnCrear);
        botonCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialogCrear = new Dialog(ActividadPrincipal.this);
                dialogCrear.setContentView(R.layout.dlg_crear);
                dialogCrear.setTitle("Crear Nuevo Producto");

                final EditText cajaCodigo = (EditText) dialogCrear.findViewById(R.id.txtCodigo);
                final EditText cajaNombre = (EditText) dialogCrear.findViewById(R.id.txtNombre);
                final EditText cajaPrecio = (EditText) dialogCrear.findViewById(R.id.txtPrecio);
                final EditText cajaStock = (EditText) dialogCrear.findViewById(R.id.txtStock);
                Button botonGuardar = (Button) dialogCrear.findViewById(R.id.btnGuardar);
                botonGuardar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Producto p = new Producto();
                        p.setCodigo(cajaCodigo.getText().toString());
                        p.setNombre(cajaNombre.getText().toString());
                        p.setPrecio(Double.parseDouble(cajaPrecio.getText().toString()));
                        p.setStock(Integer.parseInt(cajaStock.getText().toString()));
                        helperProducto.crear(p);
                        mostrarListView();
                        dialogCrear.hide();
                    }
                });
                dialogCrear.show();
            }
        });
    }

        private void mostrarListView () {
            productos = new ArrayList<Producto>();
            listaProductos = helperProducto.mostrar();

            for (int i = 0; i < listaProductos.size(); i++) {
                producto = listaProductos.get(i);
                productos.add(producto);
            }
            producto_adapter = new Producto_Adapter(ActividadPrincipal.this, productos);
            listView.setAdapter(producto_adapter);
            producto_adapter.notifyDataSetChanged();
        }

        @Override
        public void onItemClick (AdapterView < ? > parent, View view,int position, long id){
            final Dialog dialogProcesos = new Dialog(ActividadPrincipal.this);
            dialogProcesos.setContentView(R.layout.dlg_procesos);
            dialogProcesos.setTitle("Gestina tus productos");

            productosObtenidos = obtenerProductos();
            final EditText cajaCodigoPro = (EditText) dialogProcesos.findViewById(R.id.txtCodigoUpdate);
            final EditText cajaNombrePro = (EditText) dialogProcesos.findViewById(R.id.txtNombreUpdate);
            final EditText cajaPrecioPro = (EditText) dialogProcesos.findViewById(R.id.txtPrecioUpdate);
            final EditText cajaStockPro = (EditText) dialogProcesos.findViewById(R.id.txtStockUpdate);
            Button botonEditar = (Button) dialogProcesos.findViewById(R.id.btnUpdate);
            Button botonEliminar = (Button) dialogProcesos.findViewById(R.id.btnDelete);

            cajaCodigoPro.setText(productosObtenidos.get(position).getCodigo());
            cajaNombrePro.setText(productosObtenidos.get(position).getNombre());
            cajaPrecioPro.setText(String.valueOf(productosObtenidos.get(position).getPrecio()));
            cajaStockPro.setText(String.valueOf(productosObtenidos.get(position).getStock()));

            botonEditar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Producto p = new Producto();
                    p.setCodigo(cajaCodigoPro.getText().toString());
                    p.setNombre(cajaNombrePro.getText().toString());
                    p.setPrecio(Double.parseDouble(cajaPrecioPro.getText().toString()));
                    p.setStock(Integer.parseInt(cajaStockPro.getText().toString()));
                    helperProducto.modificar(p);
                    mostrarListView();
                    dialogProcesos.hide();
                }
            });
            botonEliminar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Producto p = new Producto();
                    p.setCodigo(cajaCodigoPro.getText().toString());
                    p.setNombre(cajaNombrePro.getText().toString());
                    p.setPrecio(Double.parseDouble(cajaPrecioPro.getText().toString()));
                    p.setStock(Integer.parseInt(cajaStockPro.getText().toString()));
                    helperProducto.eliminar(p);
                    mostrarListView();
                    dialogProcesos.hide();
                }
            });
            dialogProcesos.show();
        }
        public ArrayList<Producto> obtenerProductos(){
            productos = new ArrayList<Producto>();
            listaProductos = helperProducto.mostrar();
            for(int i = 0; i <listaProductos.size();i++){
                producto = listaProductos.get(i);
                productos.add(producto);

            }
            return productos;
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.opcionVentas:
                intent = new Intent(ActividadPrincipal.this,ActividadVentas.class);
                startActivity(intent);
                break;
        }
        return true;
    }
}

