package com.example.petstarea3;

import java.io.Serializable;

public class Lista2  {

    public Lista2 (){

    }


    //private int imag2;


    public int getImag3() {
        return imag3;
    }

    public void setImag3(int imag3) {
        this.imag3 = imag3;
    }

    public String getContador() {
        return contador;
    }

    public void setContador(String contador) {
        this.contador = contador;
    }

    public Lista2(String contador, int imag3) {
        this.contador = contador;
        this.imag3 = imag3;
    }

    private String contador;
    private int imag3;

}
