package com.example.jonathan.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class actividadMultiplicacion extends AppCompatActivity {
    EditText v1, v2;
    Button botonMultiplicar;
    TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_multiplicacion);
        v1 =(EditText) findViewById(R.id.txtV1Multi);
        v2 =(EditText) findViewById(R.id.txtV2Multi);
        resultado = (TextView) findViewById(R.id.lblresultadoMulti);
        botonMultiplicar = (Button) findViewById(R.id.btnMulti);
        botonMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String caja1 = v1.getText().toString();
                String caja2 = v2.getText().toString();
                double n1 = Double.parseDouble(caja1);
                double n2 = Double.parseDouble(caja2);
                double n = n1 * n2;
                resultado.setText(String.valueOf("= "+ n));

            }
        });
    }
}
