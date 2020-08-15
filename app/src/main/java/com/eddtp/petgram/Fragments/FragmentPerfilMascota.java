package com.eddtp.petgram.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eddtp.petgram.POJO.Foto;
import com.eddtp.petgram.R;
import com.eddtp.petgram.adapters.AdapterRVFragmentPerfil;

import java.util.ArrayList;

import static com.eddtp.petgram.R.menu.menu_fragment;

public class FragmentPerfilMascota extends Fragment {

    private ArrayList<Foto> fotos;
    private RecyclerView rv_fotospet;
    private int likes = 0;
    public AdapterRVFragmentPerfil adaptador;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        rv_fotospet = (RecyclerView) v.findViewById(R.id.rv_fotospet);
        setHasOptionsMenu(true);
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        rv_fotospet.setLayoutManager(glm);
        inicializarDatos();
        inicializarAdaptador();
        return v;
    }

    public void inicializarDatos() {

        fotos = new ArrayList<Foto>();
        for (int i =0; i <9; i++){
            likes += i;
            fotos.add(new Foto(R.drawable.blastoise, "" + likes));
        }
    }

    public void inicializarAdaptador(){
        adaptador = new AdapterRVFragmentPerfil (fotos, getActivity());
        rv_fotospet.setAdapter(adaptador);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(menu_fragment, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}
