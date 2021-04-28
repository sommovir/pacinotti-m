/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson5.eccezioni.abc;

/**
 *
 * @author Luca
 */
public class Calcolatrice {
    
    private static Calcolatrice _instance = null;
    
    public static Calcolatrice getInstance() {
        if (_instance == null) {
            _instance = new Calcolatrice();
            return _instance;
        } else {
            return _instance;
        }
    }
    
    private Calcolatrice() {
        super();
    }
    
    
    public int divide(int a, int b) throws Exception{
        if(b == 0){
            throw new Exception("dividing by zero is not allowed");
        }
        return a/b;
    }
    
}
