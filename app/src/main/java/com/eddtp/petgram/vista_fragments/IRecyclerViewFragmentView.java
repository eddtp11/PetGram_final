package com.eddtp.petgram.vista_fragments;

import com.eddtp.petgram.POJO.Mascota;
import com.eddtp.petgram.adapters.AdapterMascotasMain;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public AdapterMascotasMain crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(AdapterMascotasMain adaptador);
}
