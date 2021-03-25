/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p;

import it.cnr.paci.j4p.lesson2.esercizi.Book;
import it.cnr.paci.j4p.lesson2.incapsulamento.Soldier;
import it.cnr.paci.j4p.lesson2.incapsulamento.Weapon;

/**
 *
 * @author sommovir
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("ciao");
        
        //Lesson 2
        
        Weapon pistol = new Weapon(6, 2);
        Weapon gun = new Weapon(40, 4);
        
        Soldier poveroSoldato = new Soldier(20, "Ryan", pistol);
        Soldier bigGym = new Soldier(20, "Gym", gun);
        
        System.out.println("Ryan ["+poveroSoldato.getHp()+"]   VS   Gym["+bigGym.getHp()+"]");
        System.out.println("Turn 1: Ryan shots and hit Gym");
        poveroSoldato.fire(bigGym);
        System.out.println("Ryan ["+poveroSoldato.getHp()+"]   VS   Gym["+bigGym.getHp()+"]");
        System.out.println("Turn 2: Gym shots and hit Ryan");
        bigGym.fire(poveroSoldato);
        System.out.println("Ryan ["+poveroSoldato.getHp()+"]   VS   Gym["+bigGym.getHp()+"]");
        
        //======================================================================
        
        
        
    }
    
}
