package com.example.jonathan.unljonathantillaguango_conversor;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class actividadPrincipal extends AppCompatActivity {
    EditText cajaCelcius, cajaFar;
    SeekBar cel,far;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_principal);
        cajaCelcius = (EditText) findViewById(R.id.txtCelMain);
        cajaFar = (EditText) findViewById(R.id.txtFrgMain);


        //agregar un escuchador
        cajaCelcius.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                Log.i("Ingreso_calculo_F_a_C","Exitoso");
                float faren;
                faren=(1.8f)*Float.parseFloat(cajaCelcius.getText().toString())+32;
                cajaFar.setText(""+faren);
                Log.d("estado","Siiiiiiiiiiiiiiii");
                return false;
            }
        });
        cajaFar.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                Log.i("Ingreso_calculo_C_a_F","Exitoso");
                float celsius;
                celsius=(Float.parseFloat(cajaFar.getText().toString())-32)/(1.8f);
                cajaCelcius.setText(""+celsius);
                Log.d("estado","calculo realizado");
                return false;
            }
        });
    }
}
