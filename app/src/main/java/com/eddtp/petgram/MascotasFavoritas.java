package com.eddtp.petgram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.eddtp.petgram.POJO.Mascota;
import com.eddtp.petgram.adapters.AdapterMascotasFavs;
import com.eddtp.petgram.adapters.AdapterMascotasMain;
import com.eddtp.petgram.presentador.IRecyclerViewFragmentPresenter;
import com.eddtp.petgram.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity implements IRvMascotasFavs {

    private ArrayList<Mascota> mascotasfavs;
    private RecyclerView rv_petsfavs;
    public IRecyclerViewFragmentPresenter presenter;
    private Toolbar action_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        action_bar = (Toolbar) findViewById(R.id.action_bar);
        if (action_bar != null){
            setSupportActionBar(action_bar);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        rv_petsfavs = (RecyclerView) findViewById(R.id.rv_petsfavs);
        presenter = new RecyclerViewFragmentPresenter(this, MascotasFavoritas.this);
    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }

    public ArrayList<Mascota> ordenarIniciarMascotasFavs(ArrayList<Mascota> mascotas){

        ArrayList<Mascota> listamascotasfavs = new ArrayList<Mascota>();

        for (int i = 1; i < mascotas.size(); i++){
            boolean agregado = false;
            for (int j = i; j > 0 && !agregado; j--){
                Mascota uno = mascotas.get(j);
                Mascota dos = mascotas.get(j - 1);
                int numeroUno = mascotas.get(j).getLikes();
                int numeroDos = mascotas.get(j - 1).getLikes();

                if (numeroUno > numeroDos){
                    mascotas.set(j, dos);
                    mascotas.set(j - 1, uno);
                }
                else
                    agregado = true;
            }
        }

        for(int l=0; l < 5; l++){
            listamascotasfavs.add(mascotas.get(l));
        }
        return listamascotasfavs;
    }

    @Override
    public void generarGridLayoutManager() {
        GridLayoutManager glm = new GridLayoutManager(this, 2);
        rv_petsfavs.setLayoutManager(glm);
    }

    @Override
    public AdapterMascotasFavs crearAdaptador(ArrayList<Mascota> mascotas) {
        mascotasfavs = ordenarIniciarMascotasFavs(mascotas);
        AdapterMascotasFavs adapterMascotasFavs = new AdapterMascotasFavs(mascotasfavs, this);
        return adapterMascotasFavs;
    }

    @Override
    public void inicializarAdaptadorFavsRV(AdapterMascotasFavs adaptador) {
        rv_petsfavs.setAdapter(adaptador);
    }
}