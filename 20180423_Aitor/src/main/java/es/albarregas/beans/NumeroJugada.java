/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

/**
 *
 * @author aitor
 */
public class NumeroJugada {
    private int numero;
    private int heridos;
    private int muertos;

    public NumeroJugada() {
        this.numero = numero;
        this.heridos = heridos;
        this.muertos = muertos;
    }
    
    public NumeroJugada(int numero, int heridos, int muertos) {
        this.numero = numero;
        this.heridos = heridos;
        this.muertos = muertos;
    }

    public int getMuertos() {
        return muertos;
    }

    public void setMuertos(int muertos) {
        this.muertos = muertos;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getHeridos() {
        return heridos;
    }

    public void setHeridos(int heridos) {
        this.heridos = heridos;
    }
    
    
}
