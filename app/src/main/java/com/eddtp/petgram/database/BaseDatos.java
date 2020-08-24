package com.eddtp.petgram.database;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.eddtp.petgram.POJO.Foto;
import com.eddtp.petgram.POJO.Mascota;
import com.eddtp.petgram.R;

import java.text.ParseException;
import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBD.DATABASE_NAME, null, ConstantesBD.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBD.TABLE_PETS + "(" +
                                         ConstantesBD.TABLE_PETS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                         ConstantesBD.TABLE_PETS_NOMBRE + " TEXT, " +
                                         ConstantesBD.TABLE_PETS_NUMERO_LIKES + " INTEGER, " +
                                         ConstantesBD.TABLE_PETS_FOTO   + " INTEGER, " +
                                         ConstantesBD.TABLE_PETS_BTN    + " INTEGER" +
                                         ");";
        db.execSQL(queryCrearTablaMascota);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBD.TABLE_PETS);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas() throws ParseException {
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBD.TABLE_PETS + " ;";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setID(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setLikes(registros.getInt(2));
            mascotaActual.setFotoMascota(registros.getInt(3));
            mascotaActual.setIconlikeblank(registros.getInt(4));

            mascotas.add(mascotaActual);
        }
        db.close();
        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBD.TABLE_PETS, null, contentValues);
        db.close();
    }

    public void insertarLikeMascota(Mascota mascota){

        int numlikes = 0;
        mascota.setLikes(mascota.getLikes() + 1);
        numlikes = mascota.getLikes();
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("UPDATE " + ConstantesBD.TABLE_PETS +
                " SET " + ConstantesBD.TABLE_PETS_NUMERO_LIKES + " = " + String.valueOf(numlikes) +
                " WHERE " + ConstantesBD.TABLE_PETS_ID + " = " + String.valueOf(mascota.getID()) + " ;"
        );
        db.close();
    }

    public int obtenerLikesMascota(Mascota mascota){
        int likes = 0;

        String query = "SELECT " + ConstantesBD.TABLE_PETS_NUMERO_LIKES +
                " FROM " + ConstantesBD.TABLE_PETS +
                " WHERE " + ConstantesBD.TABLE_PETS_ID + "=" + mascota.getID() + " ;";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();

        return likes;
    }
}
