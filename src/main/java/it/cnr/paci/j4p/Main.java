/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p;

import it.cnr.paci.j4p.lesson2.incapsulamento.Persona;

/**
 *
 * @author sommovir
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("ciao");
        
        //Lesson 2
        
        Persona luca = new Persona("Luca", "Coraci",36);
        Persona nicola = new Persona("Nicola", "Francario",17);
        
        System.out.println("Luca ha cognome: "+luca.getCognome());
        System.out.println("Nicola ha cognome: "+nicola.getCognome());
        
        //======================================================================
        
        
        
    }
    
}
