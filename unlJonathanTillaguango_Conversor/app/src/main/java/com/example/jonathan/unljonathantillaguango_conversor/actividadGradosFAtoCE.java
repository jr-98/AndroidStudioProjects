package com.example.jonathan.unljonathantillaguango_conversor;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class actividadGradosFAtoCE extends AppCompatActivity implements View.OnClickListener, FrgCelcius.OnFragmentInteractionListener,FrgFeren.OnFragmentInteractionListener {
    Button cel, far;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_grados_fato_ce);
        cel= (Button) findViewById(R.id.btnConvertidor);
        far = (Button) findViewById(R.id.btnFahrenheit);
        cel.setOnClickListener(this);
        far.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnConvertidor:
                FrgCelcius fragmento1 = new FrgCelcius();
                FragmentTransaction transaccionUno = getSupportFragmentManager().beginTransaction();
                transaccionUno.replace(R.id.contenedor, fragmento1);
                transaccionUno.commit();
                break;
            case R.id.btnFahrenheit:
                FrgFeren fragmentoFaren= new FrgFeren();
                FragmentTransaction transacionFaren = getSupportFragmentManager().beginTransaction();
                transacionFaren.replace(R.id.contenedor,fragmentoFaren);
                transacionFaren.commit();
                break;
        }

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
