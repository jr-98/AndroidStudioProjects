package com.example.jonathan.suma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    EditText n1 , n2;
    Button sumabtn;
    TextView total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        n1 = (EditText) findViewById(R.id.n1txt);
        n2 = (EditText) findViewById(R.id.n2txt);
        sumabtn = (Button) findViewById(R.id.sumabtn);
        sumabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    EditText v1 = (EditText) findViewById(R.id.n1txt);
                    String caja1 = v1.getText().toString();

                    EditText v2 = (EditText) findViewById(R.id.n2txt);
                    String caja2 = v2.getText().toString();

                    int valor1 = Integer.parseInt(caja1);
                    int valor2 =Integer.parseInt(caja2);

                    int n = valor1 + valor2;
                    total = (TextView) findViewById(R.id.resultadotxtv);
                    total.setText(String.valueOf(n));
            }
        });

    }
}
