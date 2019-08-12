package com.example.jonathan.gentionproducto20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.jonathan.gentionproducto20.Adaptador.Producto_Adapter;
import com.example.jonathan.gentionproducto20.helper.HelperProducto;
import com.example.jonathan.gentionproducto20.model.Producto;

import java.util.ArrayList;
import java.util.List;

public class ActividadVentas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_ventas);
    }
}
