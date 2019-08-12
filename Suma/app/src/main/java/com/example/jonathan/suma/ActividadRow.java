package com.example.jonathan.suma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ActividadRow extends AppCompatActivity {
    TextView datos;
    Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_row);
        datos =(TextView) findViewById(R.id.lblDatosROW);
        boton = (Button) findViewById(R.id.btnLeerROW);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputStream input = getResources().openRawResource(R.raw.archivo_raw);
                BufferedReader lector = new BufferedReader(new InputStreamReader(input));
                try {
                    datos.setText(lector.readLine());
                    lector.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
