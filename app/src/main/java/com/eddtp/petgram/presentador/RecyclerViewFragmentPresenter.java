package com.eddtp.petgram.presentador;

import android.content.Context;

import com.eddtp.petgram.IRvMascotasFavs;
import com.eddtp.petgram.POJO.Foto;
import com.eddtp.petgram.POJO.Mascota;
import com.eddtp.petgram.R;
import com.eddtp.petgram.database.ConstructorMascotas;
import com.eddtp.petgram.vista_fragments.IPerfilRvFragmentView;
import com.eddtp.petgram.vista_fragments.IRecyclerViewFragmentView;

import java.text.ParseException;
import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private IPerfilRvFragmentView iPerfilRvFragmentView;
    private IRvMascotasFavs iRvMascotasFavs;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;
    private ArrayList<Foto> fotos;
    private int likes = 0;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerMascotasBD();
        mostrarMascotasRV();
    }

    public RecyclerViewFragmentPresenter(IPerfilRvFragmentView iPerfilRvFragmentView, Context context) {
        this.iPerfilRvFragmentView = iPerfilRvFragmentView;
        this.context = context;
        inicializarDatos();
        mostrarMascotasRVPerfil();
    }

    public RecyclerViewFragmentPresenter(IRvMascotasFavs iRvMascotasFavs, Context context) {
        this.iRvMascotasFavs = iRvMascotasFavs;
        this.context = context;
        obtenerMascotasBD();
        mostrarMascotasFavsRV();
    }

    @Override
    public void obtenerMascotasBD() {
        constructorMascotas = new ConstructorMascotas(context);
        try{
            mascotas = constructorMascotas.obtenerDatos();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void inicializarDatos() {

        fotos = new ArrayList<Foto>();
        for (int i =0; i <9; i++){
            likes += i;
            fotos.add(new Foto(R.drawable.blastoise, likes));
        }
    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }

    public void mostrarMascotasRVPerfil() {
        iPerfilRvFragmentView.inicializarAdaptadorRvPerfil(iPerfilRvFragmentView.crearAdaptadorPerfil(fotos));
        iPerfilRvFragmentView.generarGridLayoutManager();
    }

    public void mostrarMascotasFavsRV() {
        iRvMascotasFavs.inicializarAdaptadorFavsRV(iRvMascotasFavs.crearAdaptador(mascotas));
        iRvMascotasFavs.generarGridLayoutManager();
    }
}
