package com.example.jonathan.coopertivamovil.Fragments;

import android.app.Dialog;
import android.content.ClipData;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.jonathan.coopertivamovil.Adapter.AdapterCuenta;
import com.example.jonathan.coopertivamovil.Modelo.Cliente;
import com.example.jonathan.coopertivamovil.Modelo.Cuenta;
import com.example.jonathan.coopertivamovil.Modelo.Transaccion;
import com.example.jonathan.coopertivamovil.R;
import com.example.jonathan.coopertivamovil.SevicioWeb.ServicioWeb;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FrgCuente_Cliente.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FrgCuente_Cliente#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FrgCuente_Cliente extends Fragment implements AdapterView.OnItemClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
   // private static final Object AdapterView = ;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private Context GeneralContext = null;
    String urlTodos= "http://10.20.14.199:40906/CooperativaSW/ServicioRest/cuenta/todos";
    ListView listaTodos;
    List<Cuenta> listaCuenta;
    ArrayList<Transaccion> arrayTransaction;
    ArrayList<Cuenta> arrayCuenta;
    ServicioWeb servicioWeb;
    Cuenta cuentaItem;
    List<Cuenta> cuentasItem;

    ServicioWeb servicioWebCuenta;
    AdapterCuenta adapterCuenta;
    Cuenta cuenta;
    ArrayList<Cuenta> getCuenta;
    public FrgCuente_Cliente() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FrgCuente_Cliente.
     */
    // TODO: Rename and change types and number of parameters
    public static FrgCuente_Cliente newInstance(String param1, String param2) {
        FrgCuente_Cliente fragment = new FrgCuente_Cliente();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_frg_cuente__cliente,container,false);
    listaTodos = (ListView) view.findViewById(R.id.listarTodosFrg);
    //listaTodos.setOnItemClickListener(this);
    GeneralContext = this.getActivity();
    showListView();
    return view;
    }
    //Mostrar losta de clientes con sus datos del clenente
    private void showListView(){
            listaCuenta = new ArrayList<Cuenta>();
            servicioWeb = new ServicioWeb();
            servicioWeb.execute(urlTodos,"1");
            try {
                Log.e("yyyyyyyyyyyyyy", urlTodos);
                String cadena = servicioWeb.get();
                Log.e("XXXXXXXXXXXXXXXXXXXXX", cadena);
                //JSONObject jsonObject = new JSONObject(cadena);

                JSONArray respuesta = new JSONArray(cadena);
                Log.e("ZZZZZZZZZZZZZZZZZ", respuesta.length()+"");
                for(int i = 0; i < respuesta.length(); i++){
                    Cuenta cuenta = new Cuenta();
                    //cuenta
                    cuenta.setNumero(respuesta.getJSONObject(i).getString("numero"));
                    Log.e("aaaaaaaaaaaaaaaa", cuenta.getNumero());
                    cuenta.setTipoCuenta(respuesta.getJSONObject(i).getString("tipoCuenta"));
                    cuenta.setSaldo(Double.parseDouble(respuesta.getJSONObject(i).getString("saldo")));
                    cuenta.setCuentaId(Integer.parseInt(respuesta.getJSONObject(i).getString("cuentaId")));
                    cuenta.setEstado(respuesta.getJSONObject(i).getBoolean("estado"));
                    cuenta.setFechaApertura(respuesta.getJSONObject(i).getString("fechaApertura"));
                    Log.e("bbbbbbbbbbbbbbbb", cuenta.getNumero());
                    JSONObject clienteId = new JSONObject(respuesta.getJSONObject(i).getString("clienteId"));
                    Log.e("cccccccccccc", cuenta.getNumero());
                    cuenta.getCliente().setCedula(clienteId.getString("cedula"));
                    cuenta.getCliente().setNombres(clienteId.getString("nombres"));
                    cuenta.getCliente().setCorreo(clienteId.getString("correo"));
                    cuenta.getCliente().setDireccion(clienteId.getString("direccion"));
                    cuenta.getCliente().setClienteId(Integer.parseInt(clienteId.getString("clienteId")));
                    cuenta.getCliente().setApellidos(clienteId.getString("apellidos"));
                    cuenta.getCliente().setGenero(clienteId.getString("genero"));
                    cuenta.getCliente().setEstadoCivil(clienteId.getString("estadoCivil"));
                    cuenta.getCliente().setFechaNacimiento(clienteId.getString("fechaNacimiento"));
                    cuenta.getCliente().setTelefono(clienteId.getString("telefono"));
                    cuenta.getCliente().setCelular(clienteId.getString("celular"));
                    cuenta.getCliente().setEstado(clienteId.getBoolean("estado"));
                    Log.e("saliiiiiiiiiiiiiiiiiiiiiii", cuenta.getNumero());
                    listaCuenta.add(cuenta);

                }
                adapterCuenta = new AdapterCuenta(GeneralContext,(ArrayList<Cuenta>)listaCuenta);
                listaTodos.setAdapter(adapterCuenta);
                adapterCuenta.notifyDataSetChanged();

            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ///////
            /* = this.getActivity();
            final Dialog dlgMostrarCuenta = new Dialog(globalContext);
            dlgMostrarCuenta.setContentView(R.layout.dlg_cuenta);
            Item = new ArrayList<Cuenta>();
            Item = obtenerCuentasItem();
            Log.e("Entraa", "alumnos:" + Item.size());
            final EditText cajaNombre=(EditText)dlgMostrarCuenta.findViewById(R.id.txtCuentaClienteNom);
            cajaNombre.setText(String.valueOf(Item.get(position).getCliente().getNombres()));
            final EditText cajaCuentaNum=(EditText)dlgMostrarCuenta.findViewById(R.id.txtCuentaNum);
            cajaCuentaNum.setText(Item.get(position).getNumero());
            final EditText cajaSaldo=(EditText)dlgMostrarCuenta.findViewById(R.id.txtCuentaSal);
            cajaSaldo.setText(String.valueOf(Item.get(position).getSaldo()));
            final EditText cajaDeposito=(EditText)dlgMostrarCuenta.findViewById(R.id.txtMontoDeposito);
            final EditText cajaResponsable=(EditText)dlgMostrarCuenta.findViewById(R.id.txtResponsable);
            final EditText cajaDescripcion=(EditText)dlgMostrarCuenta.findViewById(R.id.txtDescripcion);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssZ", Locale.getDefault());
            Date date = new Date();
            String fecha = dateFormat.format(date);
            final String apellidos=String.valueOf(Item.get(position).getCliente().getApellidos());
            final String cedula=String.valueOf(Item.get(position).getCliente().getCedula());
            final String celular=String.valueOf(Item.get(position).getCliente().getCelular());
            final String clienteId=String.valueOf(Item.get(position).getCliente().getCliente_id());
            final String correo=String.valueOf(Item.get(position).getCliente().getCorreo());
            final String direccion=String.valueOf(Item.get(position).getCliente().getDireccion());
            final String estadoCliente=String.valueOf(Item.get(position).getCliente().isEstado());
            final String estadoCivil=String.valueOf(Item.get(position).getCliente().getEstadoCivil());
            final String fechaNacimiento=String.valueOf(Item.get(position).getCliente().getFechaNacimiento());
            final String genero=String.valueOf(Item.get(position).getCliente().getGenero());
            final String nombres=String.valueOf(Item.get(position).getCliente().getNombres());
            final String telefono=String.valueOf(Item.get(position).getCliente().getTelefono());
            final String cuentaId=String.valueOf(Item.get(position).getCuentaId());
            final String estadoCuenta=String.valueOf(Item.get(position).isEstado());
            final String fechaApertura=String.valueOf(Item.get(position).getFechaApertura());
            final String numero=String.valueOf(Item.get(position).getNumero());
            final String saldo=String.valueOf(Item.get(position).getSaldo());
            final String tipoCuenta=String.valueOf(Item.get(position).getTipoCuenta());
            final String fecha2=String.valueOf(fecha.toString());
            Button btnDeposito = (Button)dlgMostrarCuenta.findViewById(R.id.btnDeposito);
            Button btnRetiro = (Button)dlgMostrarCuenta.findViewById(R.id.btnRetiro);
            btnDeposito.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final String descripcion=cajaDescripcion.getText().toString();
                    final String responsable=cajaResponsable.getText().toString();
                    final String valor=cajaDeposito.getText().toString();
                    final String tipo="deposito";
                    final Double suma=Double.parseDouble(saldo)+Double.parseDouble(valor);
                    servicio = new ServicioWeb();
                    servicio.execute(transaccion,"7",apellidos,cedula,celular,
                            clienteId,correo,direccion,
                            estadoCliente,estadoCivil,fechaNacimiento,
                            genero,nombres,telefono,cuentaId,estadoCuenta,fechaApertura,numero,saldo,tipoCuenta,descripcion,fecha2,responsable,tipo,valor);
                    servicio2 = new ServicioWeb();
                    servicio2.execute(cuentaModificar,"8",apellidos,cedula,celular,
                            clienteId,correo,direccion,
                            estadoCliente,estadoCivil,fechaNacimiento,
                            genero,nombres,telefono,cuentaId,estadoCuenta,fechaApertura,numero,suma.toString(),tipoCuenta);
                    Toast.makeText(globalContext,"Se ha depositado con exito",Toast.LENGTH_SHORT).show();
                    mostrarListView();
                    dlgMostrarCuenta.hide();
                }
            });

            btnRetiro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final String descripcion=cajaDescripcion.getText().toString();
                    final String responsable=cajaResponsable.getText().toString();
                    final String valor=cajaDeposito.getText().toString();
                    final String tipo="retiro";
                    final Double suma=Double.parseDouble(saldo)-Double.parseDouble(valor);
                    if(suma>0){
                        servicio = new ServicioWeb();
                        servicio.execute(transaccion,"7",apellidos,cedula,celular,
                                clienteId,correo,direccion,
                                estadoCliente,estadoCivil,fechaNacimiento,
                                genero,nombres,telefono,cuentaId,estadoCuenta,fechaApertura,numero,saldo,tipoCuenta,descripcion,fecha2,responsable,tipo,valor);
                        servicio3 = new ServicioWeb();
                        servicio3.execute(cuentaModificar,"8",apellidos,cedula,celular,
                                clienteId,correo,direccion,
                                estadoCliente,estadoCivil,fechaNacimiento,
                                genero,nombres,telefono,cuentaId,estadoCuenta,fechaApertura,numero,suma.toString(),tipoCuenta);
                        Toast.makeText(globalContext,"Se ha retirado con exito",Toast.LENGTH_SHORT).show();
                        mostrarListView();
                    }else{
                        Toast.makeText(globalContext,"Lo sentimos el retiro supera el saldo",Toast.LENGTH_SHORT).show();
                        mostrarListView();
                    }
                    dlgMostrarCuenta.hide();
                }
            });
            dlgMostrarCuenta.show();*/
        }
        /*private ArrayList<Cuenta> obtenerCuentasItem(){
            cuentasA = new ArrayList<Cuenta>();
            cuentaOtro = new Cuenta();
            listaCuentasItem = obtenerCuentas();

            for(int i=0;i<listaCuentasItem.size();i++){
                cuentaOtro = listaCuentasItem.get(i);
                cuentasA.add(cuentaOtro);
            }return cuentasA;
        }*/
        /*public List<Cuenta> obtenerCuentas(){
            listaCuenta = new ArrayList<Cuenta>();
            servicio = new ServicioWeb();
            servicio.execute(consultar,"1");
            try {
                String cadena = servicio.get();
                //cadena=cadena+'"'+"}]";
                JSONArray respuesta=new JSONArray(cadena);
                for(int i = 0; i < respuesta.length(); i++){
                    Cuenta cuentaN = new Cuenta();
                    cuentaN.setNumero(respuesta.getJSONObject(i).getString("numero"));
                    cuentaN.setTipoCuenta(respuesta.getJSONObject(i).getString("tipoCuenta"));
                    cuentaN.setSaldo(Double.parseDouble(respuesta.getJSONObject(i).getString("saldo")));
                    cuentaN.setCuentaId(Integer.parseInt(respuesta.getJSONObject(i).getString("cuentaId")));
                    cuentaN.setEstado(respuesta.getJSONObject(i).getBoolean("estado"));
                    cuentaN.setFechaApertura(respuesta.getJSONObject(i).getString("fechaApertura"));

                    JSONObject clienteId = new JSONObject(respuesta.getJSONObject(i).getString("clienteId"));
                    cuentaN.getCliente().setCedula(clienteId.getString("cedula"));
                    cuentaN.getCliente().setNombres(clienteId.getString("nombres"));
                    cuentaN.getCliente().setCorreo(clienteId.getString("correo"));
                    cuentaN.getCliente().setDireccion(clienteId.getString("direccion"));
                    cuentaN.getCliente().setCliente_id(Integer.parseInt(clienteId.getString("clienteId")));
                    cuentaN.getCliente().setApellidos(clienteId.getString("apellidos"));
                    cuentaN.getCliente().setGenero(clienteId.getString("genero"));
                    cuentaN.getCliente().setEstadoCivil(clienteId.getString("estadoCivil"));
                    cuentaN.getCliente().setFechaNacimiento(clienteId.getString("fechaNacimiento"));
                    cuentaN.getCliente().setTelefono(clienteId.getString("telefono"));
                    cuentaN.getCliente().setCelular(clienteId.getString("celular"));
                    cuentaN.getCliente().setEstado(clienteId.getBoolean("estado"));

                    //String cadena2 = servicio2.get();
                    //JSONObject respuestaJson = new JSONObject(cadena2);
                    //String resultJson = respuestaJson.getString("clienteId");
                    //JSONArray lista = respuestaJson.getJSONArray("clienteId");
                    //cuentaN.getCliente().setCedula(lista.getJSONObject(i).getString("cedula"));

                    //cuentaN.setApellidos(respuesta.getJSONObject(i).getString("apellidos"));
                    //cuentaN.setGenero(respuesta.getJSONObject(i).getString("genero"));
                    //cuentaN.setEstadoCivil(respuesta.getJSONObject(i).getString("estadoCivil"));
                    //cuentaN.setFechaNacimiento(respuesta.getJSONObject(i).getString("fechaNacimiento"));
                    //cuentaN.setCorreo(respuesta.getJSONObject(i).getString("correo"));

                    listaCuenta.add(cuentaN);
                    //Log.e("++++++++++++++++", "alumnos:" + listaAlumnos.size());
                }

            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return listaCuenta;
        }
    }*/
    /*private ArrayList<Cuenta> obtenerCuentasItem(){
        getCuenta = new ArrayList<Cuenta>();
        cuentaItem = new Cuenta();
        cuentasItem = obtenerCuentas();

        for(int i=0;i<cuentasItem.size();i++){
            cuentaItem = cuentasItem.get(i);
            getCuenta.add(cuentaItem);
        }return getCuenta;
    }

    public List<Cuenta> obtenerCuentas(){
        listaCuenta = new ArrayList<Cuenta>();
        servicioWebCuenta = new ServicioWeb();
        servicioWebCuenta.execute(urlTodos,"1");
        try {
            String cadena = servicioWebCuenta.get();
            JSONArray respuesta=new JSONArray(cadena);
            for(int i = 0; i < respuesta.length(); i++){
                Cuenta cuentaN = new Cuenta();
                cuentaN.setNumero(respuesta.getJSONObject(i).getString("numero"));
                cuentaN.setTipoCuenta(respuesta.getJSONObject(i).getString("tipoCuenta"));
                cuentaN.setSaldo(Double.parseDouble(respuesta.getJSONObject(i).getString("saldo")));
                cuentaN.setCuentaId(Integer.parseInt(respuesta.getJSONObject(i).getString("cuentaId")));
                cuentaN.setEstado(respuesta.getJSONObject(i).getBoolean("estado"));
                cuentaN.setFechaApertura(respuesta.getJSONObject(i).getString("fechaApertura"));
                //Cliente
                JSONObject clienteId = new JSONObject(respuesta.getJSONObject(i).getString("clienteId"));
                cuentaN.getCliente().setCedula(clienteId.getString("cedula"));
                cuentaN.getCliente().setNombres(clienteId.getString("nombres"));
                cuentaN.getCliente().setCorreo(clienteId.getString("correo"));
                cuentaN.getCliente().setDireccion(clienteId.getString("direccion"));
                cuentaN.getCliente().setClienteId(Integer.parseInt(clienteId.getString("clienteId")));
                cuentaN.getCliente().setApellidos(clienteId.getString("apellidos"));
                cuentaN.getCliente().setGenero(clienteId.getString("genero"));
                cuentaN.getCliente().setEstadoCivil(clienteId.getString("estadoCivil"));
                cuentaN.getCliente().setFechaNacimiento(clienteId.getString("fechaNacimiento"));
                cuentaN.getCliente().setTelefono(clienteId.getString("telefono"));
                cuentaN.getCliente().setCelular(clienteId.getString("celular"));
                cuentaN.getCliente().setEstado(clienteId.getBoolean("estado"));
               listaCuenta.add(cuentaN);
                }

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return listaCuenta;
    }*/

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
