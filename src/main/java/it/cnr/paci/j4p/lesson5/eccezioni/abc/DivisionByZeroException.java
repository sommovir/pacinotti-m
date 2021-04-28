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
public class DivisionByZeroException extends Exception{

    public DivisionByZeroException() {
        super("Do not divide by zero");
    }
    
    
    
}
