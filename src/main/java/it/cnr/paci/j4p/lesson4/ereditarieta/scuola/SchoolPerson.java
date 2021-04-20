/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson4.ereditarieta.scuola;

/**
 *
 * @author sommovir
 */
public abstract class SchoolPerson {
    
    private String name;
    private String surname;
    private int hoursAtSchool;
    
    private String code;
    
    //P-123  codice per i professori
    //S-322  codice per gli studenti
    //B-444  codice per i bidelli
    

    public SchoolPerson() {
    }

    public SchoolPerson(String name, String surname, int hoursAtSchool, String code) {
        this.name = name;
        this.surname = surname;
        this.hoursAtSchool = hoursAtSchool;
        this.code = code;
    }


    
    public abstract String getBaseCode();
    
    
    public String getIdentificationCode(){
        return getBaseCode() +"-"+ this.code;
    }
    

    
    

    public int getHoursAtSchool() {
        return hoursAtSchool;
    }

    public void setHoursAtSchool(int hoursAtSchool) {
        this.hoursAtSchool = hoursAtSchool;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    
    
    
}
