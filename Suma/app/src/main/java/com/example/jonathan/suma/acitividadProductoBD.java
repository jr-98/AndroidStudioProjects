package com.example.jonathan.suma;

import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jonathan.suma.helpers.helperProductoBD;

public class acitividadProductoBD extends AppCompatActivity implements View.OnClickListener {
    EditText cajaNombre,cajaCod, cajaPrecio,cajaExist;
    Button botonGuardar,botonEliminar, botonBuscarT,botonModificar,botonEliminarCod,botonBuscarCod;
    TextView mostrar;
    helperProductoBD helperProductoBD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acitividad_producto_bd);
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
        helperProductoBD = new helperProductoBD(this,"dba",null,1);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnGuardarDB:
                helperProductoBD.guardar(cajaNombre.getText().toString(), cajaCod.getText().toString(),Double.parseDouble(cajaPrecio.getText().toString()),Integer.parseInt(cajaExist.getText().toString()));
                break;
            case R.id.btnBuscarTDB:
                mostrar.setText(helperProductoBD.getAll());
                break;
            case R.id.btnEliminarDB:
                helperProductoBD.eliminarTodos();
                break;
            case R.id.btnModificarDB:
                helperProductoBD.modificar(cajaNombre.getText().toString(), cajaCod.getText().toString(),Double.parseDouble(cajaPrecio.getText().toString()),Integer.parseInt(cajaExist.getText().toString()));
                break;
            case R.id.btnEliminarCodDB:
                helperProductoBD.eliminarCod(cajaCod.getText().toString());
                break;
            case R.id.btnBuscarCodDB:
                mostrar.setText(helperProductoBD.getCodigo(cajaCod.getText().toString()));
        }

    }
}
