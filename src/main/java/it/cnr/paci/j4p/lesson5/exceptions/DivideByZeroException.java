/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Luca
 */
public class DivideByZeroException extends Exception{

    public DivideByZeroException() {
        super("Non puoi dividere per 0");
    }
    
    
    
}
