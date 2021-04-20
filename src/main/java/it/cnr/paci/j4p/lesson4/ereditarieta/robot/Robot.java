/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson4.ereditarieta.robot;

/**
 *
 * @author sommovir
 */
public class Robot {

    private LanguageProcessor languageProcessor;

    public Robot(LanguageProcessor languageProcessor) {
        this.languageProcessor = languageProcessor;
    }
    
    public void setLanguageProcessor(LanguageProcessor languageProcessor) {
        this.languageProcessor = languageProcessor;
    }
    

    
    public String parla(Condition condition){
        
        return languageProcessor.parla(condition);
        
    }
    
}
