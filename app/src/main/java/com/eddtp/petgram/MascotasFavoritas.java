package com.eddtp.petgram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.eddtp.petgram.POJO.Mascota;
import com.eddtp.petgram.adapters.AdapterMascotasFavs;
import com.eddtp.petgram.adapters.AdapterMascotasMain;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {

    private ArrayList<String> nombres;
    private ArrayList<String> numeros;
    private ArrayList<Integer> fotos;
    private ArrayList<Mascota> mascotasfavs;
    private RecyclerView rv_petsfavs;
    public AdapterMascotasFavs adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        Toolbar action_bar = (Toolbar) findViewById(R.id.action_bar);
        setSupportActionBar(action_bar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        rv_petsfavs = (RecyclerView) findViewById(R.id.rv_petsfavs);
        GridLayoutManager glm = new GridLayoutManager(this, 2);

        rv_petsfavs.setLayoutManager(glm);
        recibirDatos();
        inicializarAdaptador();
    }

    public void inicializarAdaptador(){
        adaptador = new AdapterMascotasFavs(mascotasfavs, this);
        rv_petsfavs.setAdapter(adaptador);
    }

    public void recibirDatos(){

        mascotasfavs = new ArrayList<Mascota>();

        fotos = (ArrayList<Integer>) getIntent().getIntegerArrayListExtra(getResources().getString(R.string.pfoto));
        nombres = (ArrayList<String>) getIntent().getStringArrayListExtra(getResources().getString(R.string.pnombre));
        numeros = (ArrayList<String>) getIntent().getStringArrayListExtra(getResources().getString(R.string.plikes));

        for (int i = 0; i<fotos.size(); i++){
            mascotasfavs.add(new Mascota(fotos.get(i), nombres.get(i), numeros.get(i)));
        }
    }
}