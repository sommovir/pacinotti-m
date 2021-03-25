/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson2.incapsulamento;

/**
 *
 * @author sommovir
 */
public class Weapon {
   
    private int ammo;
    private int damage;

    public Weapon() {
    }

    public Weapon(int ammo, int damage) {
        this.ammo = ammo;
        this.damage = damage;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    
    
    
    
}
