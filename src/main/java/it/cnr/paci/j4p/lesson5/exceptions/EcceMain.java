/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Luca
 */
public class EcceMain {

    public static void main(String[] args) {

        try {
            System.out.println("istruzione1");
            int x = Calculator.divide(4, 0);
            System.out.println("istruzione 2: " + x);
        } catch (DivideByZeroException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

}
