package com.eddtp.petgram.vista_fragments;

import com.eddtp.petgram.POJO.Foto;
import com.eddtp.petgram.POJO.Mascota;
import com.eddtp.petgram.adapters.AdapterRVFragmentPerfil;

import java.util.ArrayList;

public interface IPerfilRvFragmentView {

    public void generarGridLayoutManager();

    public AdapterRVFragmentPerfil crearAdaptadorPerfil(ArrayList<Foto> fotos);

    public void inicializarAdaptadorRvPerfil (AdapterRVFragmentPerfil adapterPerfil);
}
