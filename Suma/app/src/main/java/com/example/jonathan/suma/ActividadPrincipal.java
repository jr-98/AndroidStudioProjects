package com.example.jonathan.suma;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
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

import static android.widget.Toast.LENGTH_LONG;
import static com.example.jonathan.suma.FrgUno.*;

public class ActividadPrincipal extends AppCompatActivity implements View.OnClickListener, FrgUno.OnFragmentInteractionListener, FrgDos.OnFragmentInteractionListener {
    Button botonFrgUno, botonFrgDos,DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // en esta clase se toma el control de los componenstes gráficos
        setContentView(R.layout.activity_actividad_principal);
        botonFrgUno = (Button) findViewById(R.id.btnFrgUno);
        botonFrgDos = (Button) findViewById(R.id.btnFrgDos);
        DB = (Button) findViewById(R.id.btnDBMain);



        botonFrgUno.setOnClickListener(this);
        botonFrgDos.setOnClickListener(this);
        DB.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnFrgUno:
                FrgUno fragmentoUno = new FrgUno();
                FragmentTransaction transaccionUNo = getSupportFragmentManager().beginTransaction();
                transaccionUNo.replace(R.id.contenedor, fragmentoUno);
                transaccionUNo.commit();
                break;
            case R.id.btnFrgDos:
                FrgDos fragmentoDos = new FrgDos();
                FragmentTransaction transaccionDos = getSupportFragmentManager().beginTransaction();
                transaccionDos.replace(R.id.contenedor,fragmentoDos);
                transaccionDos.commit();
            case R.id.btnDBMain:
                Intent intent = new Intent(ActividadPrincipal.this, acitividadProductoBD.class);
                startActivity(intent);
                break;

        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.opcionParametro:
                intent = new Intent(ActividadPrincipal.this, ActividadEnviarTransaccion.class);
                startActivity(intent);
                break;
            case R.id.opcionEnviarDatos:
                intent = new Intent(ActividadPrincipal.this, ActividadDatosPersonales.class);
                startActivity(intent);
                break;
            case R.id.opcionLogin:
                Dialog dialogoLogin = new Dialog(ActividadPrincipal.this);
                dialogoLogin.setContentView(R.layout.dlg_login);
                //tomor el contro de los componentes


                final EditText cajaUsuario = (EditText) dialogoLogin.findViewById(R.id.txtUsuario);
                EditText cajaClave = (EditText) dialogoLogin.findViewById(R.id.txtClave);
                Button botonAceptar = (Button) dialogoLogin.findViewById(R.id.btnLogin);
                //findViewById= sola las actividades
                //view.findViewById= fragmentos
                //dialog.findViewById = para tomar el control de los dialogos.

                botonAceptar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(ActividadPrincipal.this, cajaUsuario.getText().toString(),Toast.LENGTH_LONG).show();
                    }
                });
                dialogoLogin.show();
                break;
            case R.id.opcionRegistrar:
                Dialog dialogoRegistrar = new Dialog(ActividadPrincipal.this);
                dialogoRegistrar.setContentView(R.layout.dlg_registrar);
                break;
            case R.id.opcionAcelerometro:
                intent = new Intent(ActividadPrincipal.this, actividadAcelerometro.class);
                startActivity(intent);
                break;
            case R.id.opcionLuz:
                intent = new Intent(ActividadPrincipal.this, actividadLuz.class);
                startActivity(intent);
                break;
            case R.id.opcionVibracion:
                intent = new Intent(ActividadPrincipal.this, ActividadVibrar.class);
                startActivity(intent);
                break;
            case R.id.opcionMI:
                intent= new Intent(ActividadPrincipal.this, ActividadM_I.class);
                startActivity(intent);
                break;
                case R.id.opcionROW:
                    intent = new Intent(ActividadPrincipal.this, ActividadRow.class);
                    startActivity(intent);
                    break;
            case R.id.opcionSD:
                intent =new Intent(ActividadPrincipal.this,ActividadSD.class);
                startActivity(intent);
                break;
                   }
        return true;
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
