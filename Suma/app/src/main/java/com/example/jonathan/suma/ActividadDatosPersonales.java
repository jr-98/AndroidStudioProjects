package com.example.jonathan.suma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActividadDatosPersonales extends AppCompatActivity {
    EditText cajaNombre;
    EditText cajaApellido;
    EditText cajaCedula;
    EditText cajaEdad;
    Button botonEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_datos_personales);
        cajaNombre= (EditText) findViewById(R.id.nombreEditT);
        cajaApellido= (EditText) findViewById(R.id.apellidoEditT);
        cajaCedula = (EditText) findViewById(R.id.cedulaEditT);
        cajaEdad = (EditText) findViewById(R.id.edadEditT);
        botonEnviar = (Button) findViewById(R.id.EviarDP);
        botonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActividadDatosPersonales.this,ActividadReporteDP.class);

                Bundle bundle = new Bundle();
                //recibe nombre
                bundle.putString("nombre",cajaNombre.getText().toString());
                //recibe apellido
                bundle.putString("apellido",cajaApellido.getText().toString());
                //recibe cedula
                bundle.putString("cedula", cajaCedula.getText().toString());
                //recibe edad
                bundle.putString("edad",cajaEdad.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }
}
