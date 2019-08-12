package com.example.jonathan.quintoa;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActividadPrincipal extends Activity {

    Button boton;
    EditText caja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_principal);
        boton = (Button) findViewById(R.id.btnAceptar);
        caja =(EditText) findViewById(R.id.txtEntrada);
        // se genera un evento anonimo
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), caja.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
