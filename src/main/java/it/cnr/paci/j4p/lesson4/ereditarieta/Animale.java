/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson4.ereditarieta;

/**
 *
 * @author sommovir
 */
public abstract class Animale {
    
    private String nome;

    public Animale() {
    }

    public Animale(String nome) {
        this.nome = nome;
    }
    
    public abstract boolean isAquatic();
    
    public abstract boolean isLand();
    
    public abstract boolean isFlying();
    
}
