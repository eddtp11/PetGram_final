package com.eddtp.petgram.vista_fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eddtp.petgram.MascotasFavoritas;
import com.eddtp.petgram.POJO.Mascota;
import com.eddtp.petgram.R;
import com.eddtp.petgram.adapters.AdapterMascotasMain;
import com.eddtp.petgram.presentador.IRecyclerViewFragmentPresenter;
import com.eddtp.petgram.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class FragmentMascotasRV extends Fragment implements IRecyclerViewFragmentView {

    private ArrayList<Mascota> mascotas;
    private ArrayList<Mascota> mascotasFavs;
    private RecyclerView rv_main;
    private IRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.recyclerview_fragment_mascotas, container, false);
        rv_main = (RecyclerView) v.findViewById(R.id.rv_main);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        return v;
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
    }

    public void verMascotasActuales(AdapterMascotasMain adaptador){
        mascotasFavs = new ArrayList<Mascota>();
        mascotasFavs = adaptador.getListaMascotas();
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv_main.setLayoutManager(llm);
    }

    @Override
    public AdapterMascotasMain crearAdaptador(ArrayList<Mascota> mascotas) {
        AdapterMascotasMain adaptador = new AdapterMascotasMain(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(AdapterMascotasMain adaptador) {
        rv_main.setAdapter(adaptador);
        verMascotasActuales(adaptador);
    }
}
