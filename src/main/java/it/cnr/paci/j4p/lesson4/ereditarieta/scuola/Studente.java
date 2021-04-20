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
public class Studente extends SchoolPerson {
    
    private String classe;

    public Studente() {
    }

    public Studente(String classe, String name, String surname, int hoursAtSchool, String code) {
        super(name, surname, hoursAtSchool, code);
        this.classe = classe;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    @Override
    public String getBaseCode() {
        return "S";
    }
    
    
    
    
    
    
}
