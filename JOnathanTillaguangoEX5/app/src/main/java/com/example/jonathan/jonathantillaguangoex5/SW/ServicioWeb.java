package com.example.jonathan.jonathantillaguangoex5.SW;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ServicioWeb extends AsyncTask<String,Void,String> {
    public ServicioWeb() {
    }
    @Override
    protected String doInBackground(String... params) {
        String cadena = params[0];
        URL url = null;

        String retornar = "Imposible acceder";
        StringBuilder stringBuilder = new StringBuilder();
        //Establece la concexion lee el URl
        if (params[1] == "1") {
            try {
                url = new URL(cadena);
                HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
                int codigoRespuesta = conexion.getResponseCode();
                if (codigoRespuesta == HttpURLConnection.HTTP_OK) {
                    InputStream in = new BufferedInputStream(conexion.getInputStream());
                    BufferedReader lector = new BufferedReader(new InputStreamReader(in));
                    retornar = lector.readLine();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return retornar;
        }
        //Lee el munero de operacion
        if (params[1] == "2") {
            try {
                url = new URL(cadena);
                HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
                int codigoRespuesta = conexion.getResponseCode();
                if (codigoRespuesta == HttpURLConnection.HTTP_OK) {
                    InputStream in = new BufferedInputStream(conexion.getInputStream());
                    BufferedReader lector = new BufferedReader(new InputStreamReader(in));
                    retornar = lector.readLine();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return retornar;
        }
        return retornar;
    }
}
