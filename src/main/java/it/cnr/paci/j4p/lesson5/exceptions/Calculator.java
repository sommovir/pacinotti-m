/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import javax.swing.JOptionPane;

/**
 *
 * @author Luca
 */
public class Calculator {

    /**
     * 
     * @param a
     * @param b
     * @return
     * @throws DivideByZeroException 
     * questa eccezione viene lanciata nel caso b sia 0.
     */
    public static int divide(int a, int b) throws DivideByZeroException{
        try {
            return a / b;
        } catch (ArithmeticException ex) {
//            ex.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Non devi dividere per 0");
            throw new DivideByZeroException();
        }
    }

}
