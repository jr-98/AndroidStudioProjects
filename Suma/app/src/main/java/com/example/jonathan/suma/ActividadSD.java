package com.example.jonathan.suma;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ActividadSD extends AppCompatActivity implements View.OnClickListener {
    EditText cajaProducto, cajaPrecio;
    Button botonEscribir, botonLeer;
    TextView datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_sd);

        datos = (TextView) findViewById(R.id.lblDatosSD);
        cajaProducto = (EditText) findViewById(R.id.txtProductoSD);
        cajaPrecio = (EditText) findViewById(R.id.txtPrecioSD);
        botonEscribir = (Button) findViewById(R.id.btnEscribirSD);
        botonLeer = (Button) findViewById(R.id.btnLeerSD);
        botonEscribir.setOnClickListener(this);
        botonLeer.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEscribirSD:
                File ruta = Environment.getExternalStorageDirectory();
                File file = new File(ruta, "archivo.txt");
                try {
                    OutputStreamWriter escritor = new OutputStreamWriter(new FileOutputStream(file));
                    escritor.write(cajaProducto.getText().toString()+", "+ cajaPrecio.getText().toString()+";");
                    escritor.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btnLeerSD:
                ruta = Environment.getExternalStorageDirectory();
                File archivo = new File(ruta.getAbsolutePath(),"archivo.txt");
                try {
                    BufferedReader lector = new BufferedReader(new InputStreamReader(new FileInputStream(archivo)));
                    datos.setText(lector.readLine());
                    lector.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
