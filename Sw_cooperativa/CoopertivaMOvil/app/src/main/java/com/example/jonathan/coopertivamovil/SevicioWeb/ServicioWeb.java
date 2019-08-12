package com.example.jonathan.coopertivamovil.SevicioWeb;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ServicioWeb extends AsyncTask<String,Void,String> {
        public String devolucion ="";
        public ServicioWeb() {
        }
        @Override
        protected String doInBackground(String... params) {
            //Inicializacion de variables
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
           // return retornar;

            //Guarda la transaccion
            if (params[1] == "3") {
                try {
                    url = new URL(cadena);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    DataOutputStream printout;
                    DataInputStream input;
                    url = new URL(cadena);
                    urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setDoInput(true);
                    urlConnection.setDoOutput(true);
                    urlConnection.setUseCaches(false);
                    urlConnection.setRequestMethod("POST");
                    urlConnection.setRequestProperty("Content-Type", "application/json");
                    urlConnection.setRequestProperty("Accept", "application/json");
                    urlConnection.connect();
                    //Creo el Objeto JSON
                    String jsonString = "{'cuentaId':{'clienteId':{'apellidos':'" +params[2]+
                            "','cedula':'" +params[3]+
                            "','celular':'" +params[4]+
                            "','clienteId':" +params[5]+
                            ",'correo':'"+params[6] +
                            "','direccion':'"+params[7]+
                            "','estado':" +params[8]+
                            ",'estadoCivil':'"+params[9]+
                            "','fechaNacimiento':'"+params[10]+
                            "','genero':'"+params[11]+
                            "','nombres':'"+params[12]+
                            "','telefono':'"+params[13]+
                            "'}," +
                            "'cuentaId':"+params[14]+
                            ",'estado':"+params[15]+
                            ",'fechaApertura':'"+params[16]+
                            "','numero':'"+params[17]+
                            "','saldo':"+params[18]+
                            ",'tipoCuenta':'"+params[19]+
                            "'}," +
                            "'descripcion':'" +params[20]+
                            "','fecha':'"+"2019-03-04T06:56:56.834-05:00"+
                            "','responsable':'"+params[22]+
                            "','tipo':'"+params[23]+
                            "','valor':" +params[24]+
                            "}";
                    JSONObject jsonObjectT = null;
                    try {
                        jsonObjectT = new JSONObject(jsonString);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    // Envio los parámetros post.
                    OutputStream os = urlConnection.getOutputStream();
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(os, "UTF-8"));
                    writer.write(jsonObjectT.toString());
                    writer.flush();
                    writer.close();
                    int respuesta = urlConnection.getResponseCode();
                    StringBuilder result = new StringBuilder();
                    if (respuesta == HttpURLConnection.HTTP_OK) {
                        String line;
                        BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                        while ((line = br.readLine()) != null) {
                            result.append(line);
                            //response+=line;
                        }
                        retornar = "Transaccion Exitosa!!!!!";
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
    protected void onPostExecute(String s) {
        devolucion = s;

    }
}
