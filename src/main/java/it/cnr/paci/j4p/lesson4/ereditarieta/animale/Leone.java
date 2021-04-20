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
public class Leone extends Mammiferi{

    public Leone() {
        super("Leone");
    }
    
    

    @Override
    public boolean isAquatic() {
        return false;
    }

    @Override
    public boolean isLand() {
        return true;
    }

    @Override
    public boolean isFlying() {
        return false;
    }
    
    
    public void roar(){
        System.out.println("ROOOOOOOOOARRR");
    }
}
