package com.example.jonathan.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class actividadRaiz extends AppCompatActivity {
    EditText v1, v2;
    TextView resultado;
    Button calcular, info1, info2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_raiz);
        v1 =(EditText) findViewById(R.id.txtV1Raiz);
        v2 =(EditText) findViewById(R.id.txtV2Raiz);
        resultado = (TextView) findViewById(R.id.lblresultadoRaiz);
        info1 = (Button) findViewById(R.id.btnInfo1Raiz);
        info2 = (Button) findViewById(R.id.btnInfo2Raiz);
        calcular = (Button) findViewById(R.id.btnRaiz);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String caja1 = v1.getText().toString();
                String caja2 = v2.getText().toString();

                double n1 = Double.parseDouble(caja1);
                double n2 = Double.parseDouble(caja2);
                if(n2 ==0){
                    Toast.makeText(getApplicationContext(), "El radical debe ser MAYOR a 0", Toast.LENGTH_SHORT).show();
                }else {
                    double n = Math.pow(n1, 1 / n2);
                    resultado.setText(String.valueOf("radicando= " + n));
                }
            }
        });
        info1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"es el número del que se extrae la raíz, y se coloca debajo del signo radical",Toast.LENGTH_SHORT).show();
            }
        });
        info2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"es el número que sirve para indicar el grado de la raíz",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
