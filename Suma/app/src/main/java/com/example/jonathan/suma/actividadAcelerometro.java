package com.example.jonathan.suma;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class actividadAcelerometro extends AppCompatActivity implements SensorEventListener {
    TextView x,y,z;
    SensorManager manejador;
    Sensor acelerometro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_acelerometro);
         x = (TextView) findViewById(R.id.lblXacelerometro);
         y = (TextView) findViewById(R.id.lblYacelerometro);
         z = (TextView) findViewById(R.id.lblZacelerometro);
        //Obtiene el servicio del sistema
        manejador = (SensorManager) getSystemService(SENSOR_SERVICE);
        //obtener el sensor
        acelerometro = manejador.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);


    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        //datos generados por los sensores
        float valorX = event.values[0];
        float valorY = event.values[1];
        float valorZ = event.values[2];

        x.setText(valorX+ " ");
        y.setText(valorY + " ");
        z.setText(valorZ + " ");




    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //cambia los parametros del sensor
    }

    @Override
    protected void onResume() {
        super.onResume();
        manejador.registerListener(this,acelerometro,manejador.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        manejador.unregisterListener(this);
    }
}
