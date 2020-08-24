package com.eddtp.petgram.POJO;

import com.eddtp.petgram.R;

public class Mascota {

    private int ID;
    private int fotoMascota;
    private int iconlikeblank;
    private int iconlikefull;
    private String nombre;
    private int likes;
    private boolean estalike;

    public Mascota(int fotoMascota, String nombre, int likes) {
        this.fotoMascota = fotoMascota;
        this.nombre = nombre;
        this.likes = likes;
        this.iconlikeblank = R.drawable.icons8_huesolikes;
        this.iconlikefull = R.drawable.icons8_hueso2;
        this.estalike = false;
    }

    public Mascota() {

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getFotoMascota() {
        return fotoMascota;
    }

    public void setFotoMascota(int fotoMascota) {
        this.fotoMascota = fotoMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getIconlikeblank() {
        return iconlikeblank;
    }

    public void setIconlikeblank(int iconlikeblank) {
        this.iconlikeblank = iconlikeblank;
    }

    public boolean getEstaLike(){
        return estalike;
    }

    public void setEstalike(boolean estalike){
        this.estalike = estalike;
    }

    public int cambiarImagen(){
        return  (!estalike) ? R.drawable.icons8_huesolikes : R.drawable.icons8_huesolikes_rojo;
    }
}
