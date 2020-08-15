package com.eddtp.petgram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.eddtp.petgram.Fragments.FragmentMascotasRV;
import com.eddtp.petgram.Fragments.FragmentPerfilMascota;
import com.eddtp.petgram.adapters.PageAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar action_bar;
    private TabLayout tablaymain;
    private ViewPager viewPagerMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        action_bar = (Toolbar) findViewById(R.id.action_bar);
        if (action_bar != null){
            setSupportActionBar(action_bar);
        }
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        tablaymain = (TabLayout) findViewById(R.id.tablaymain);
        viewPagerMain = (ViewPager) findViewById(R.id.viewPagerMain);

        setUpViewPager();
    }

    private ArrayList<Fragment> agregarFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new FragmentMascotasRV());
        fragments.add(new FragmentPerfilMascota());
        return fragments;
    }

    private void setUpViewPager(){
        viewPagerMain.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tablaymain.setupWithViewPager(viewPagerMain);
        tablaymain.getTabAt(0).setIcon(R.drawable.icons8_casa);
        tablaymain.getTabAt(1).setIcon(R.drawable.icons8_pet);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.acionContacto:
                irAContactos();
                break;

            case R.id.acionAcercade:
                irAcercaDe();
                break;

            case R.id.actionSalir:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void irAContactos(){
        Intent iContactos = new Intent(MainActivity.this, FormularioContacto.class);
        startActivity(iContactos);
    }

    public void irAcercaDe(){
        Intent iAcercaDe = new Intent(MainActivity.this, AcercaDe.class);
        startActivity(iAcercaDe);
    }
}