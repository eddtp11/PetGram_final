package com.eddtp.petgram.vista_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eddtp.petgram.POJO.Foto;
import com.eddtp.petgram.POJO.Mascota;
import com.eddtp.petgram.R;
import com.eddtp.petgram.adapters.AdapterRVFragmentPerfil;
import com.eddtp.petgram.presentador.IRecyclerViewFragmentPresenter;
import com.eddtp.petgram.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class FragmentPerfilMascota extends Fragment implements IPerfilRvFragmentView{

    private RecyclerView rv_fotospet;
    private IRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        rv_fotospet = (RecyclerView) v.findViewById(R.id.rv_fotospet);
        presenter = new RecyclerViewFragmentPresenter((IPerfilRvFragmentView) this, getContext());
        return v;
    }

    @Override
    public void generarGridLayoutManager() {
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        rv_fotospet.setLayoutManager(glm);
    }

    @Override
    public AdapterRVFragmentPerfil crearAdaptadorPerfil(ArrayList<Foto> fotos) {
        AdapterRVFragmentPerfil adapterPerfil = new AdapterRVFragmentPerfil(fotos, getActivity());
        return  adapterPerfil;
    }

    @Override
    public void inicializarAdaptadorRvPerfil(AdapterRVFragmentPerfil adapterPerfil) {
        rv_fotospet.setAdapter(adapterPerfil);
    }
}
