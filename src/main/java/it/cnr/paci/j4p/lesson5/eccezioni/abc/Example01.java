/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson5.eccezioni.abc;

/**
 *
 * @author sommovir
 */
public class Example01 {
    
    
    public static int divide(int a, int b){
        return a/b;
    }
    
    public static void main(String[] args) {
        
        System.out.println("Buongiorno");
        int c = divide(6, 0);
        System.out.println("c = "+c);
        System.out.println("Ora vi saluto");
        
        
    }
    
}
