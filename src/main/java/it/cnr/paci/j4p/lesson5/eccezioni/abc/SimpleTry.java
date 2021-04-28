/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson5.eccezioni.abc;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luca
 */
public class SimpleTry {
    
    public static void main(String[] args) {
        
        System.out.println("welcome");
        int d=0;
        try {
            d = Calcolatrice.getInstance().divide(10, 0);
        } catch (Exception ex) {
            Logger.getLogger(SimpleTry.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("risultato = "+d);
    }
    
}
