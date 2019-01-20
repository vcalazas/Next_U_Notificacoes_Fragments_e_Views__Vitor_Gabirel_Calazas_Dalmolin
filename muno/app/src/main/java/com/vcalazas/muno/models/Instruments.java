package com.vcalazas.muno.models;

import android.graphics.Bitmap;

import java.util.List;

public class Instruments {

    private int     id;
    private String  classI;
    private boolean favorite;
    private int   image;
    private String  name;

    public Instruments() {
    }

    public Instruments(int id, String classI, String name, boolean favorite, int image) {
        Instruments.this.id         = id;
        Instruments.this.classI     = classI;
        Instruments.this.favorite   = favorite;
        Instruments.this.image      = image;
        Instruments.this.name       = name;
    }

    public int getId() {
        return Instruments.this.id;
    }

    public void setId(int id) {
        Instruments.this.id = id;
    }

    public String getClassI() {
        return Instruments.this.classI;
    }

    public void setClassI(String classI) {
        Instruments.this.classI = classI;
    }

    public boolean isFavorite() {
        return Instruments.this.favorite;
    }

    public void setFavorite(boolean favorite) {
        Instruments.this.favorite = favorite;
    }

    public int getImage() {
        return Instruments.this.image;
    }

    public void setImages(int image) {
        Instruments.this.image = image;
    }

    public String getName() {
        return Instruments.this.name;
    }

    public void setName(String name) {
        Instruments.this.name = name;
    }
}
