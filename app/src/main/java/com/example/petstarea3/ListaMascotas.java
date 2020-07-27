package com.example.petstarea3;

import java.io.Serializable;

public class ListaMascotas implements Serializable {

    public ListaMascotas (){

    }


    public ListaMascotas(String nombre, int imagenn, String contadorLike) {
        this.nombre = nombre;
        this.imagenn = imagenn;
        this.contadorLike = contadorLike;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagenn() {
        return imagenn;
    }

    public void setImagenn(int imagenn) {
        this.imagenn = imagenn;
    }

    public String getContadorLike() {
        return contadorLike;
    }

    public void setContadorLike(String contadorLike) {
        this.contadorLike = contadorLike;
    }

    private String nombre;
    private int imagenn;
    private String contadorLike;

}
