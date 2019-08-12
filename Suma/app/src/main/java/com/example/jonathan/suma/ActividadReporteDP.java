package com.example.jonathan.suma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActividadReporteDP extends AppCompatActivity {
    TextView textoNombre;
    TextView textoApellido;
    TextView textoCedula;
    TextView textoEdad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_reporte_dp);
        textoNombre = (TextView) findViewById(R.id.getNombreTxtV);
        textoApellido=(TextView) findViewById(R.id.getApellidoTxtV);
        textoCedula=(TextView) findViewById(R.id.getCedulaTxtV);
        textoEdad = (TextView) findViewById(R.id.getEdadTxtV);
        Bundle bundle = this.getIntent().getExtras();
        textoNombre.setText(bundle.getString("nombre"));
        textoApellido.setText(bundle.getString("apellido"));
        textoCedula.setText(bundle.getString("cedula"));
        textoEdad.setText(bundle.getString("edad"));

    }
}
