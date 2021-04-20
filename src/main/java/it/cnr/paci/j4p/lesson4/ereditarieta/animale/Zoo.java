/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson4.ereditarieta.animale;

import java.util.List;

/**
 *
 * @author sommovir
 */
public class Zoo {

    Gabbia gabbia1 = new Gabbia(1);
    
    public Zoo() {
        gabbia1.addAnimale(new Anaconda());
        gabbia1.addAnimale(new Anaconda());
        gabbia1.addAnimale(new Leone());
    }
    
    
    public void ruggisciLeoni(Gabbia gabbia){
        
        List<Animale> animali = gabbia.getAnimali();
        
        for (Animale animale : animali) {
            if(animale instanceof Leone){
                ((Leone)animale).roar();
            }
        }
        
    }
    
    public int countMammiferi(Gabbia gabbia){
        
        List<Animale> animali = gabbia.getAnimali();
        
        int c = 0;
        
        for (Animale a : animali) {
            if(a instanceof Mammiferi){
                c++;
            }
        }
        
        return c;
        
    }
    
    
    
}
