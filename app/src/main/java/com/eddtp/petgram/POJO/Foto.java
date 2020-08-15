package com.eddtp.petgram.POJO;

public class Foto {

    private int fotoPet;
    private String like;

    public Foto (int fotoPet, String like) {
        this.fotoPet = fotoPet;
        this.like = like;
    }

    public int getFotoPet() {
        return fotoPet;
    }

    public void setFotoPet(int fotoPet) {
        this.fotoPet = fotoPet;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }
}
