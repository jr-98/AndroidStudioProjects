package com.example.jonathan.calculadora;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jonathan.calculadora.frgSuma.OnFragmentInteractionListener;

public class actividadPrincipal extends AppCompatActivity implements View.OnClickListener, frgFiboo.OnFragmentInteractionListener,OnFragmentInteractionListener {
    Button botonSuma,botonFibo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_principal);
        botonSuma = (Button) findViewById(R.id.btnFrgUno);
        botonFibo = (Button) findViewById(R.id.btnFrgDos);

        botonSuma.setOnClickListener(this);
        botonFibo.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnFrgUno:
                frgSuma fragmento1 = new frgSuma();
                FragmentTransaction transaccionUno = getSupportFragmentManager().beginTransaction();
                transaccionUno.replace(R.id.contenedor, fragmento1);
                transaccionUno.commit();
                break;
            case R.id.btnFrgDos:
                frgFiboo fragmento2 = new frgFiboo();
                FragmentTransaction transaccionDos = getSupportFragmentManager().beginTransaction();
                transaccionDos.replace(R.id.contenedor, fragmento2);
                transaccionDos.commit();
        }

    }

    @Override
    public void onFragmentInteraction(Uri uri) {


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater infalter = getMenuInflater();
        infalter.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.opcionSuma:
                intent = new Intent(actividadPrincipal.this,actividadSuma.class);
                startActivity(intent);
                break;
            case R.id.opcionResta:
                intent = new Intent(actividadPrincipal.this, actividadResta.class);
                startActivity(intent);
                break;
            case R.id.opcionMultiplicacion:
                intent = new Intent(actividadPrincipal.this, actividadMultiplicacion.class);
                startActivity(intent);
                break;
            case R.id.opcionDivicion:
                intent = new Intent(actividadPrincipal.this, actividadDivicion.class);
                startActivity(intent);
                break;
            case R.id.opcionPotencia:
                intent = new Intent(actividadPrincipal.this,actividadPotencia.class);
                startActivity(intent);
                break;
            case R.id.opcionRaiz:
                intent= new Intent(actividadPrincipal.this, actividadRaiz.class);
                startActivity(intent);
                break;
            case R.id.opcionSerieFibbo:
                Dialog dialogoFiboo = new Dialog(actividadPrincipal.this);
                dialogoFiboo.setContentView(R.layout.dlg_fiboo);
                //toamar el control de los componentes
                final EditText v1 = (EditText) dialogoFiboo.findViewById(R.id.txtFiboo);
                Button botonFibo = (Button) dialogoFiboo.findViewById(R.id.btnFiboo);
                final TextView serie = (TextView) dialogoFiboo.findViewById(R.id.lblResultaFiboo);
                //calcula de la serie
                botonFibo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String caja = v1.getText().toString();
                        int n = Integer.parseInt(caja);
                        int a=0,b=1,c;
                        String datos="";
                        datos = "Serie = "+ a+" - "+b + " - ";

                        for (int i= 2; i <= n; i++){
                            c = a + b;
                            datos += c+ " - ";
                            a=b;
                            b=c;
                        }
                        serie.setText(datos);
                    }
                });
                dialogoFiboo.show();
                break;
        }
        return true;
    }


}
