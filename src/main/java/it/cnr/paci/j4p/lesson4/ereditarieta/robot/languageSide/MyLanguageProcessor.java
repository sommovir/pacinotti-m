/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson4.ereditarieta.robot.languageSide;

import it.cnr.paci.j4p.lesson4.ereditarieta.robot.Condition;
import it.cnr.paci.j4p.lesson4.ereditarieta.robot.LanguageProcessor;

/**
 *
 * @author sommovir
 */
public class MyLanguageProcessor extends LanguageProcessor{

    @Override
    public String parla(Condition condition) {
        if(condition == Condition.ON){
            return "Buongiorno";
        }
        if(condition == Condition.OFF){
            return "Buonanotte";
        }
        return "Non ho capito";
    }
    
}
