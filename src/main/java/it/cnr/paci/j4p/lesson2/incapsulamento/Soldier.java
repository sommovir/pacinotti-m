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
public class Soldier {
    
 
    private int hp;
    private String name;
    private Weapon weapon;

    public Soldier() {
    }

    public Soldier(int hp, String name, Weapon weapon) {
        this.hp = hp;
        this.name = name;
        this.weapon = weapon;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    
    public void fire(Soldier enemy){
        if(this.weapon.getAmmo() < 0){
            System.out.println("no ammo");
            return;
        }
        int damage = this.weapon.getDamage();
        enemy.setHp(enemy.getHp() - damage);
    }
    
    public boolean isAlive(){
        return this.getHp() > 0 ? true : false;
    }
}
