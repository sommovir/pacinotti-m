/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson4.ereditarieta.animale;

/**
 *
 * @author sommovir
 */
public class Balena extends Mammiferi{
    
    private int weight;

    public Balena(int weight) {
        super("Balena");
        this.weight = weight;
    }
    
    @Override
    public boolean isAquatic() {
        return true;
    }

    @Override
    public boolean isLand() {
        return false;
    }

    @Override
    public boolean isFlying() {
        return false;
    }
    
}
