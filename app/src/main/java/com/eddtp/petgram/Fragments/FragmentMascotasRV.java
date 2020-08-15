package com.eddtp.petgram.Fragments;

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

import com.eddtp.petgram.MainActivity;
import com.eddtp.petgram.MascotasFavoritas;
import com.eddtp.petgram.POJO.Mascota;
import com.eddtp.petgram.R;
import com.eddtp.petgram.adapters.AdapterMascotasMain;

import java.util.ArrayList;

import static com.eddtp.petgram.R.menu.menu_fragment;
import static com.eddtp.petgram.R.menu.menu_opciones;

public class FragmentMascotasRV extends Fragment {

    private ArrayList<Mascota> mascotas;
    private ArrayList<Mascota> mascotasFavs;
    private ArrayList<String> nombres;
    private ArrayList<String> numeros;
    private ArrayList<Integer> fotos;
    private RecyclerView rv_main;
    private int likes = 0;
    public AdapterMascotasMain adaptador;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.recyclerview_fragment_mascotas, container, false);
        setHasOptionsMenu(true);
        rv_main = (RecyclerView) v.findViewById(R.id.rv_main);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rv_main.setLayoutManager(llm);
        inicializarDatosMascotas();
        inicializarAdaptador();
        return v;
    }

    public void inicializarDatosMascotas() {

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.blastoise, "Blastoise", String.format("%d", likes)));
        mascotas.add(new Mascota(R.drawable.blaziken, "Blaziken", String.format("%d", likes)));
        mascotas.add(new Mascota(R.drawable.staraptor, "Staraptor", String.format("%d", likes)));
        mascotas.add(new Mascota(R.drawable.greninja, "Greninja", String.format("%d", likes)));
        mascotas.add(new Mascota(R.drawable.garchomp, "Garchomp", String.format("%d", likes)));
        mascotas.add(new Mascota(R.drawable.glaceon, "Glaceon", String.format("%d", likes)));
        mascotas.add(new Mascota(R.drawable.empoleon, "Empoleon", String.format("%d", likes)));
        mascotas.add(new Mascota(R.drawable.krookodile, "Krokodile", String.format("%d", likes)));
        mascotas.add((new Mascota(R.drawable.toxicroak, "Toxicroak", String.format("%d", likes))));
        mascotas.add(new Mascota(R.drawable.talonflame, "Talonflame", String.format("%d", likes)));
        mascotas.add(new Mascota(R.drawable.lucario, "Lucario", String.format("%d", likes)));
        mascotas.add(new Mascota(R.drawable.pangoro, "Pangoro", String.format("%d", likes)));
    }

    public void inicializarAdaptador(){
        adaptador = new AdapterMascotasMain(mascotas, getActivity());
        rv_main.setAdapter(adaptador);
    }

    public void irAMascotasFavoritas(){

        mascotasFavs = new ArrayList<Mascota>();
        ordenarPorLikes();

        if(mascotas.size() > 0){
            for(Mascota m: mascotas){
                boolean like = m.getEstaLike();
                if(like == true) mascotasFavs.add(m);
            }
        }
        if(mascotasFavs.size() > 0){
            Intent intent = new Intent(getActivity(), MascotasFavoritas.class);
            convertirArrayFotos(mascotasFavs);
            convertirArrayNombres(mascotasFavs);
            convertirArrayNumeros(mascotasFavs);
            intent.putIntegerArrayListExtra(getResources().getString(R.string.pfoto), fotos);
            intent.putStringArrayListExtra(getResources().getString(R.string.pnombre), nombres);
            intent.putStringArrayListExtra(getResources().getString(R.string.plikes), numeros);
            startActivity(intent);
        }
        else {
            Toast.makeText(getActivity(), "No tiene mascotas favoritas", Toast.LENGTH_SHORT).show();
        }
    }

    public ArrayList<String> convertirArrayNombres(ArrayList<Mascota> mascotas){
        nombres = new ArrayList<String>();
        for (Mascota i: mascotas
        ) {
            nombres.add(i.getNombre());
        }
        return nombres;
    }

    public ArrayList<String> convertirArrayNumeros(ArrayList<Mascota> mascotas){
        numeros = new ArrayList<String>();
        for (Mascota i: mascotas
        ) {
            numeros.add(i.getLikes());
        }
        return numeros;
    }

    public ArrayList<Integer> convertirArrayFotos(ArrayList<Mascota> mascotas){
        fotos = new ArrayList<Integer>();
        for (Mascota i: mascotas
        ) {
            fotos.add(i.getFotoMascota());
        }
        return fotos;
    }

    public void ordenarPorLikes(){
        for (int i = 1; i < mascotas.size(); i++){
            boolean agregado = false;
            for (int j = i; j > 0 && !agregado; j--){
                Mascota uno = mascotas.get(j);
                Mascota dos = mascotas.get(j - 1);

                int numeroUno = Integer.parseInt(mascotas.get(j).getLikes());
                int numeroDos = Integer.parseInt(mascotas.get(j - 1).getLikes());

                if (numeroUno > numeroDos){
                    mascotas.set(j, dos);
                    mascotas.set(j - 1, uno);
                }
                else
                    agregado = true;
            }
        }
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(menu_fragment, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.acionFavoritos){
            irAMascotasFavoritas();
        }
        return super.onOptionsItemSelected(item);
    }
}
