package com.example.jonathan.proyectoorma;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jonathan.proyectoorma.modelo.producto;

import java.lang.reflect.Array;


public class actividadPrincipal extends AppCompatActivity implements View.OnClickListener {
    EditText cajaNombre,cajaCod, cajaPrecio,cajaExist;
    Button botonGuardar,botonEliminar, botonBuscarT,botonModificar,botonEliminarCod,botonBuscarCod;
    TextView mostrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_principal);
        cajaNombre = (EditText) findViewById(R.id.txtnombreDB);
        cajaCod = (EditText) findViewById(R.id.txtCodigoDB);
        cajaPrecio = (EditText) findViewById(R.id.txtPrecioDB);
        cajaExist = (EditText) findViewById(R.id.txtExistenciasDB);
        botonGuardar =(Button) findViewById(R.id.btnGuardarDB);
        botonEliminar =(Button) findViewById(R.id.btnEliminarDB);
        botonBuscarT =(Button) findViewById(R.id.btnBuscarTDB);
        botonModificar =(Button) findViewById(R.id.btnModificarDB);
        botonEliminarCod =(Button) findViewById(R.id.btnEliminarCodDB);
        botonBuscarCod =(Button) findViewById(R.id.btnBuscarCodDB);
        mostrar = (TextView) findViewById(R.id.lblDatosProductoDB);
        ////
        botonGuardar.setOnClickListener(this);
        botonEliminar.setOnClickListener(this);
        botonBuscarT.setOnClickListener(this);
        botonModificar.setOnClickListener(this);
        botonEliminarCod.setOnClickListener(this);
        botonBuscarCod.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnGuardarDB:
                final producto product = new producto();
                product.setNombre(cajaNombre.getText().toString());
                product.setCodigo(cajaCod.getText().toString());
                product.setPrecio(Double.parseDouble(cajaPrecio.getText().toString()));
                product.setExistencia(Integer.parseInt(cajaExist.getText().toString()));
                product.save();
                Toast.makeText(getApplicationContext(), "Los datos fueron guardados exitosasmente", Toast.LENGTH_LONG).show();
                clear();
                break;
            case R.id.btnBuscarTDB:
                producto productoBuscar = new producto();
                int mumeroProduct = productoBuscar.obtenerTodoProductos().size();
                mostrar.setText("Numero de producto \n" + mumeroProduct);
                Toast.makeText(getApplicationContext(), "Datos cargados!!!!", Toast.LENGTH_LONG).show();
                clear();
                break;
            case R.id.btnEliminarDB:
                producto productoEliminarT = new producto();
                productoEliminarT.deleteAll();
                Toast.makeText(getApplicationContext(), "Los datos fueron ELIMINADOS exitosasmente", Toast.LENGTH_LONG).show();

                clear();
                break;
            case R.id.btnModificarDB:
                Dialog editProducto = new Dialog(actividadPrincipal.this);
                editProducto.setContentView(R.layout.edit_dialog);
                final EditText cajaNombreDialog = (EditText) editProducto.findViewById(R.id.txtnombreDBDialog);
                final EditText cajaPrecioDialog = (EditText) editProducto.findViewById(R.id.txtPrecioDBDialog);
                final EditText cajaExistDialog = (EditText) editProducto.findViewById(R.id.txtExistenciasDBDialog);
                Button botonActualizar = (Button) editProducto.findViewById(R.id.btnActualizarDBDialog);
                Button botonCancelar = (Button) editProducto.findViewById(R.id.btnCancelarDBDialog);
                botonActualizar.setOnClickListener(new View.OnClickListener() {
                    @Override

                    public void onClick(View v) {
                        producto productoModificar = new producto();
                        productoModificar = productoModificar.updateRegister(cajaCod.getText().toString());
                        productoModificar.setNombre(cajaNombreDialog.getText().toString());
                        productoModificar.setPrecio(Double.parseDouble(cajaPrecioDialog.getText().toString()));
                        productoModificar.setExistencia(Integer.parseInt(cajaExistDialog.getText().toString()));
                        productoModificar.save();
                        String nombre = productoModificar.getNombre();
                        String cod= productoModificar.getCodigo();
                        Double pre = productoModificar.getPrecio();
                        Integer ext = productoModificar.getExistencia();
                        mostrar.setText("Nombre: "+nombre+"\tCodigo: "+cod+"\t precio: "+pre+"\t existencia: "+ext);
                        Toast.makeText(getApplicationContext(), "Los datos ACTUALIZADOS exitosasmente", Toast.LENGTH_LONG).show();
                        clear();

                    }

                });
                botonCancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(actividadPrincipal.this,actividadPrincipal.class);
                        startActivity(intent);
                    }
                });


                editProducto.show();

                break;
            case R.id.btnEliminarCodDB:
                producto productoDeleteCod= new producto();
                productoDeleteCod = productoDeleteCod.deleteSelected(cajaCod.getText().toString());
                productoDeleteCod.delete();
                Toast.makeText(getApplicationContext(),"El producto"+cajaNombre.getText().toString() +" fueron ardados exitosasmente",Toast.LENGTH_LONG).show();

                clear();
                break;
            case R.id.btnBuscarCodDB:
                producto productoBuscarCod = new producto();
                productoBuscarCod = productoBuscarCod.searchCod(cajaCod.getText().toString());
                //Para mostrar la los datos resultantes de la busqueda
                //los datos deben ser los mismos de los definidos en modificaciond e la DB
                String nombre = productoBuscarCod.getNombre();
                String cod= productoBuscarCod.getCodigo();
                Double pre = productoBuscarCod.getPrecio();
                Integer ext = productoBuscarCod.getExistencia();
                mostrar.setText("Nombre: "+nombre+"\tCodigo: "+cod+"\t precio: "+pre+"\t existencia: "+ext);
            break;
        }
    }
    public void clear(){
        cajaNombre.setText("");
        cajaCod.setText("");
        cajaPrecio.setText("");
        cajaExist.setText("");
    }
}
