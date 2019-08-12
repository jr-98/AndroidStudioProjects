package com.example.jonathan.tillaguango_examen3;

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
import android.widget.Toast;

public class actividadPrincipal extends AppCompatActivity implements View.OnClickListener,frgNota.OnFragmentInteractionListener{
    Button notas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_principal);
        notas =(Button) findViewById(R.id.btnFragmento);
        notas.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        frgNota fragmento1 = new frgNota();
        FragmentTransaction transaccionUno= getSupportFragmentManager().beginTransaction();
        transaccionUno.replace(R.id.contenedor,fragmento1);
        transaccionUno.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.opcionCalcular:
                Dialog dialogoPromedio = new Dialog(actividadPrincipal.this);
                dialogoPromedio.setContentView(R.layout.dlg_promedio);
                final EditText nota1=(EditText) dialogoPromedio.findViewById(R.id.txtDialogNota1);
                final EditText nota2=(EditText) dialogoPromedio.findViewById(R.id.txtDialogNota2);
                final EditText nota3=(EditText) dialogoPromedio.findViewById(R.id.txtDialogNota3);
                final TextView resultado=(TextView) dialogoPromedio.findViewById(R.id.lblDialogResultado);
                Button promedio=(Button) dialogoPromedio.findViewById(R.id.btnDialogCalcularP);
                promedio.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String caja1 = nota1.getText().toString();
                        String caja2 = nota2.getText().toString();
                        String caja3 = nota3.getText().toString();

                        double n1 = Double.parseDouble(caja1);
                        double n2 = Double.parseDouble(caja2);
                        double n3 = Double.parseDouble(caja3);

                        double n = (n1+n2+n3)/3;
                        resultado.setText(String.valueOf(n));
                        if(n<5){
                            Toast.makeText(getApplicationContext(), "REPROBADO  "+n, Toast.LENGTH_SHORT).show();
                        }if(n>=5 & n<7){
                            Toast.makeText(getApplicationContext(), "SUSPENSO  "+n, Toast.LENGTH_SHORT).show();
                        }else if(n>=7 & n<=10){
                            Toast.makeText(getApplicationContext(), "APROBADO  "+n, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dialogoPromedio.show();
                break;
        }
        return true;
    }
}
