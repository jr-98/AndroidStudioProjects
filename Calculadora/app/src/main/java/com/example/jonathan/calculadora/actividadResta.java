package com.example.jonathan.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class actividadResta extends AppCompatActivity {
    EditText v1, v2;
    Button botonResta;
    TextView total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_resta);
        v1 = (EditText) findViewById(R.id.txtV1Resta);
        v2 = (EditText) findViewById(R.id.txtV2Resta);
        total = (TextView) findViewById(R.id.lblTotalResta);
        botonResta = (Button) findViewById(R.id.btnResta);
        botonResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String caja1 = v1.getText().toString();
                String caja2 = v2.getText().toString();

                int n1 = Integer.parseInt(caja1);
                int n2 = Integer.parseInt(caja2);

                int n = n1 - n2 ;
                total.setText(String.valueOf("es " + n));

            }
        });
    }
}
