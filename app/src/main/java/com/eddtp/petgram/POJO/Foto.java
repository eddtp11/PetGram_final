package com.eddtp.petgram.POJO;

public class Foto {

    private int fotoPet;
    private int like;

    public Foto (int fotoPet, int like) {
        this.fotoPet = fotoPet;
        this.like = like;
    }

    public int getFotoPet() {
        return fotoPet;
    }

    public void setFotoPet(int fotoPet) {
        this.fotoPet = fotoPet;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}