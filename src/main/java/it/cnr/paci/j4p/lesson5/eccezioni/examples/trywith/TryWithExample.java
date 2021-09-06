/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson5.eccezioni.examples.trywith;

/**
 *
 * @author Luca
 */
public class TryWithExample {
    
    public static void main(String[] args) {
        System.out.println("try with example");
        
        try( Connector c = new Connector()){
            c.connect();
            c.doSomething();
            
        }catch(Exception ex){
            
        }
    }
    
}
