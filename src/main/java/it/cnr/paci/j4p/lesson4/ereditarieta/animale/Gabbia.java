/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson4.ereditarieta.animale;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author sommovir
 */
public class Gabbia {
    
    private int number;
    private List<Animale> animali = new LinkedList<>();

    public Gabbia(int number) {
        this.number = number;
    }

    public List<Animale> getAnimali() {
        return animali;
    }
    
    

    public void addAnimale(Animale animale) {
        this.animali.add(animale);
    }
    
    
    public int getFlyingAnimals(){
        int sum = 0;
        for (Animale a : animali) {
            if(a.isFlying()){
                sum++;
            }
        }
        return sum;
    }
    
    
    
    
}
