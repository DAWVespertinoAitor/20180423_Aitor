/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

import java.util.List;

/**
 *
 * @author aitor
 */
public class Jugada {
    private int jugada;
    private List<Integer> numero;

    public Jugada() {
        this.jugada = jugada;
        this.numero = numero;
    }
    
    public Jugada(int jugada, List<Integer> numero) {
        this.jugada = jugada;
        this.numero = numero;
    }

    public List<Integer> getNumero() {
        return numero;
    }

    public void setNumero(List<Integer> numero) {
        this.numero = numero;
    }

    public int getJugada() {
        return jugada;
    }

    public void setJugada(int jugada) {
        this.jugada = jugada;
    }

    @Override
    public String toString() {
        return "Jugadas{" + "jugada=" + jugada + ", numero=" + numero + '}';
    }
    
    
    
}
