/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson3.strutture.enums;

/**
 *
 * @author sommovir
 */
public enum DayOfWeek {

    MONDAY("Lunedì","Monday"),
    TUESDAY("Martedì","Tuesday"),
    WEDNESDAY("Mercoledì","Wednesday"),
    THURSDAY("Giovedì","Thursday"),
    FRIDAY("Venerdì","Friday"),
    SATURDAY("Sabato","Saturday"),
    SUNDAY("Domenica","Sunday");
    
    
    private DayOfWeek(String italianValue, String englishValue) {
        this.italianValue = italianValue;
        this.englishValue = englishValue;
    }

    public String getEnglishValue() {
        return englishValue;
    }

    public String getItalianValue() {
        return italianValue;
    }
    
    private String italianValue;
    private String englishValue;
    
}
