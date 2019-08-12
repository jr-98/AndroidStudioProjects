package com.example.jonathan.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class actividadSuma extends AppCompatActivity {
    EditText n1,n2;
    Button botonSuma;
    TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_suma);
        n1 = (EditText) findViewById(R.id.txtV1Suma);
        n2= (EditText) findViewById(R.id.txtV2Suma);
        resultado = (TextView) findViewById(R.id.resultadoSuma);
        botonSuma = (Button) findViewById(R.id.btnSumar);
        botonSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String caja1= n1.getText().toString();
                String caja2= n2.getText().toString();

                int valor1 = Integer.parseInt(caja1);
                int valor2 = Integer.parseInt(caja2);

                int n = valor1+valor2;

                resultado.setText(String.valueOf(n));
            }
        });

    }
}
