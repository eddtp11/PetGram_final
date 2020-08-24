package com.eddtp.petgram.database;

import android.content.ContentValues;
import android.content.Context;

import com.eddtp.petgram.POJO.Mascota;
import com.eddtp.petgram.R;

import java.text.ParseException;
import java.util.ArrayList;

public class ConstructorMascotas {

    private static boolean inicio = true;
    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos() throws ParseException {

        BaseDatos db = new BaseDatos(context);
        if(inicio){
            insertarMascotas(db);
            inicio = false;
        }
        return db.obtenerTodasLasMascotas();
    }

    public void insertarMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Blastoise");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.blastoise);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Blaziken");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.blaziken);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Empoleon");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.empoleon);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Garchomp");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.garchomp);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Glaceon");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.glaceon);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Greninja");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.greninja);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Krokodile");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.krookodile);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Lucario");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.lucario);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Pangoro");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.pangoro);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Staraptor");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.staraptor);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Talonflame");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.talonflame);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Toxicroak");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.toxicroak);

        db.insertarMascota(contentValues);
    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        db.insertarLikeMascota(mascota);
    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }
}
