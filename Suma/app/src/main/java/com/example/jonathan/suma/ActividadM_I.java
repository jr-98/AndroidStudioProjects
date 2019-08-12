package com.example.jonathan.suma;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ActividadM_I extends AppCompatActivity implements View.OnClickListener {
    EditText cajaProducto, cajaPrecio;
    Button botonEscribir, botonLeer;
    TextView datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_m__i);
        datos =(TextView)findViewById(R.id.lblDatosMI);
        cajaProducto = (EditText) findViewById(R.id.txtProductoMI);
        cajaPrecio = (EditText) findViewById(R.id.txtPrecioMI);
        botonEscribir = (Button) findViewById(R.id.btnEscribirMI);
        botonLeer = (Button) findViewById(R.id.btnLeerMI);
        botonEscribir.setOnClickListener(this);
        botonLeer.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEscribirMI:
                try {
                    OutputStreamWriter escritor = new OutputStreamWriter(openFileOutput("archivoA.txt",Context.MODE_APPEND));
                    escritor.write(cajaProducto.getText().toString() +","+ cajaPrecio.getText().toString());
                    escritor.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btnLeerMI:
                try {
                    BufferedReader lector = new BufferedReader(new InputStreamReader(openFileInput("archivoA.txt")));
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
