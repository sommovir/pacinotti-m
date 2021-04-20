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
public class Professore extends SchoolPerson {
    
    private String materia;

    public Professore() {
    }

    public Professore(String materia, String name, String surname, int hoursAtSchool, String code) {
        super(name, surname, hoursAtSchool, code);
        this.materia = materia;
    }


    
    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override
    public String getBaseCode() {
        return "P";
    }
    
    
    
    
    
    
}
