package com.example.jonathan.suma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActividadRecibirDatos extends AppCompatActivity {
    TextView texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_recibir_datos);
        texto = (TextView)findViewById(R.id.lblParametro);
        Bundle bundle = this.getIntent().getExtras();
        texto.setText(bundle.getString("dato"));

    }
}
