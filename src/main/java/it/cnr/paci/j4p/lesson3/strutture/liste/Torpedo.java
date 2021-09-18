/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson3.strutture.liste;

/**
 *
 * @author sommovir
 */
public class Torpedo {
    
    private String name;
    private int range;
    private float shockFactor;

    public Torpedo() {
    }

    public Torpedo(String name, int range, float shockFactor) {
        this.name = name;
        this.range = range;
        this.shockFactor = shockFactor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public float getShockFactor() {
        return shockFactor;
    }

    public void setShockFactor(float shockFactor) {
        this.shockFactor = shockFactor;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(!(obj instanceof Torpedo)){
            return false;
        }
        if(this.name.equals(((Torpedo)obj).getName()) &&
                (this.range == (((Torpedo)obj).getRange()) && 
                (this.shockFactor == (((Torpedo)obj).shockFactor)))
                ){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
}
