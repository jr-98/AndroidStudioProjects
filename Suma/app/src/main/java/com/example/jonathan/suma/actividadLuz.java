package com.example.jonathan.suma;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class actividadLuz extends AppCompatActivity implements SensorEventListener {
    TextView x;
    SensorManager manejador;
    Sensor luz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_luz);
        x = (TextView) findViewById(R.id.lblLuz);
        //obtener el servicio del sistema
        manejador = (SensorManager) getSystemService(SENSOR_SERVICE);
        luz = manejador.getDefaultSensor(Sensor.TYPE_LIGHT);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float valorX =event.values[0];
        x.setText(valorX + "");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        manejador.registerListener(this,luz, manejador.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onPause() {
        super.onPause();
        manejador.unregisterListener(this);
    }
}
