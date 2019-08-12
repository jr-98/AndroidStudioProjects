package com.example.jonathan.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class actividadPotencia extends AppCompatActivity {
    EditText v1, v2;
    TextView resultado;
    Button caLcular, info1, info2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_potencia);
        v1 =(EditText) findViewById(R.id.txtV1Pot);
        v2 =(EditText) findViewById(R.id.txtV2Pot);
        resultado = (TextView) findViewById(R.id.lblresultadoPot);
        info1 = (Button) findViewById(R.id.btnInfo1Pot);
        info2 = (Button) findViewById(R.id.btnInfo2Pot);
        caLcular = (Button) findViewById(R.id.btnPot);
        caLcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String caja1 = v1.getText().toString();
                String caja2 = v2.getText().toString();
                double n1 = Double.parseDouble(caja1);
                double n2 = Double.parseDouble(caja2);
                double n = Math.pow(n1,n2);
                resultado.setText(String.valueOf(n));
            }

        });
        info1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Numero que se multiplica por si mismo, tantas veces como el exponente", Toast.LENGTH_SHORT).show();

            }
        });
        info2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Numero de veces que la base se multiplica por si misma", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
