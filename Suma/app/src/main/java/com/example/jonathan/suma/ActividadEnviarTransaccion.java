package com.example.jonathan.suma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActividadEnviarTransaccion extends AppCompatActivity {
    EditText cajaTexto;
    Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_enviar_transaccion);
        boton= (Button) findViewById(R.id.EnviarDatobtn);
        cajaTexto = (EditText) findViewById(R.id.Datotxt);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActividadEnviarTransaccion.this, ActividadRecibirDatos.class);
                //este es un objeto que almacena los datos que seran enviados a una otra actividad
                Bundle bundle = new Bundle();
                bundle.putString("dato",cajaTexto.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

    }
}
