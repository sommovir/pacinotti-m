/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson4.ereditarieta.robot;

import it.cnr.paci.j4p.lesson4.ereditarieta.robot.languageSide.MyLanguageProcessor;

/**
 *
 * @author sommovir
 */
public class MainRobot {
    
    public static void main(String[] args) {
        
        MyLanguageProcessor processor = new MyLanguageProcessor();
        
        Robot robot  = new Robot(processor);
        String parla = robot.parla(Condition.OFF);
        System.out.println(parla);
    }
    
    
}
