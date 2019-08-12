package com.example.jonathan.coopertivamovil.Adapter;

import android.view.View;


    import android.content.Context;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.BaseAdapter;
    import android.widget.TextView;
    import com.example.jonathan.coopertivamovil.Modelo.Cuenta;
import com.example.jonathan.coopertivamovil.R;


import java.util.List;
    public class AdapterCuenta extends BaseAdapter{
        private Context context;
        private List<Cuenta> listaCuenta;
        public AdapterCuenta(Context context, List<Cuenta> listaCuenta) {
            this.context = context;
            this.listaCuenta = listaCuenta;
        }


        public Context getContext() {
            return context;
        }

        public void setContext(Context context) {
            this.context = context;
        }

        public List<Cuenta> getListaCuenta() {
            return listaCuenta;
        }

        public void setListaCuenta(List<Cuenta> listaCuenta) {
            this.listaCuenta = listaCuenta;
        }

        @Override
        public int getCount() {
            return listaCuenta.size();
        }

        @Override
        public Object getItem(int position) {
            return listaCuenta.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null)

                convertView = View.inflate(context,R.layout.display_cuenta, null);
                     TextView txtNumeroCuenta = (TextView) convertView.findViewById(R.id.lblNumeroCuenta);
                     TextView txtNemeroCedula = (TextView) convertView.findViewById(R.id.lblCedulaClient);
                     TextView txtCuentaCorreo = (TextView) convertView.findViewById(R.id.lblFCorreoClient);
                     TextView txtCuentaNombre= (TextView) convertView.findViewById(R.id  .lblNombreClient);
                     TextView txtCuentaApellido= (TextView) convertView.findViewById(R.id.lblApellidoClient);
                     TextView txtCuentaGenero = (TextView) convertView.findViewById(R.id.lblGeneroCliente);
                     TextView txtCuentaTelefono = (TextView) convertView.findViewById(R.id.lblTelefonoClient);
                     TextView txtCunetaSaldo = (TextView) convertView.findViewById(R.id.lblSaldoClient);

            Cuenta cuenta=listaCuenta.get(position);

                    txtNumeroCuenta.setText(cuenta.getNumero());
                    txtNemeroCedula.setText(cuenta.getCliente().getCedula());
                    txtCuentaCorreo.setText(cuenta.getCliente().getCorreo());
                    txtCuentaNombre.setText(cuenta.getCliente().getNombres());
                    txtCuentaApellido.setText(cuenta.getCliente().getApellidos());
                    txtCuentaGenero.setText(cuenta.getCliente().getGenero());
                    txtCuentaTelefono.setText(cuenta.getCliente().getTelefono());
                    txtCunetaSaldo.setText(String.valueOf(cuenta.getSaldo()));
            return convertView;
        }
    }


