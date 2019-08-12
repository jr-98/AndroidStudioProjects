
package com.example.jonathan.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class actividadDivicion extends AppCompatActivity {
    EditText v1, v2;
    Button botonDividir;
    TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_divicion);
        v1 =(EditText) findViewById(R.id.txtV1Div);
        v2 =(EditText) findViewById(R.id.txtV2Div);
        resultado = (TextView) findViewById(R.id.lblresultadoDiv);
        botonDividir = (Button) findViewById(R.id.btnDiv);
        botonDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String caja1 = v1.getText().toString();
                String caja2 = v2.getText().toString();
                double n1 = Double.parseDouble(caja1);
                double n2 = Double.parseDouble(caja2);

                if (n2==0) {
                    Toast.makeText(getApplicationContext(), "EL valor del DIVISOR debe se mayor a 0",Toast.LENGTH_SHORT).show();
                }else {
                    double n = n1 / n2;
                    resultado.setText(String.valueOf(" = " + n));
                }
            }
        });
    }
}
