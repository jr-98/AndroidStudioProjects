package com.example.jonathan.coopertivamovil.interfaces;

import com.example.jonathan.coopertivamovil.Fragments.FrgCliente;
import com.example.jonathan.coopertivamovil.Fragments.FrgCuente_Cliente;
import com.example.jonathan.coopertivamovil.Fragments.FrgTransaccion;

public interface IFragments extends FrgCuente_Cliente.OnFragmentInteractionListener,
                                    FrgCliente.OnFragmentInteractionListener,
                                    FrgTransaccion.OnFragmentInteractionListener {
}
