package com.eddtp.petgram;

import com.eddtp.petgram.POJO.Mascota;
import com.eddtp.petgram.adapters.AdapterMascotasFavs;
import com.eddtp.petgram.adapters.AdapterMascotasMain;

import java.util.ArrayList;

public interface IRvMascotasFavs {

    public void generarGridLayoutManager();

    public AdapterMascotasFavs crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorFavsRV(AdapterMascotasFavs adaptador);
}
