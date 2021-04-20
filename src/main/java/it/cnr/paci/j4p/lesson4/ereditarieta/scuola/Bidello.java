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
public class Bidello extends SchoolPerson{
    
    private String mansione;

    public Bidello() {
    }

    public Bidello(String mansione, String name, String surname, int hoursAtSchool, String code) {
        super(name, surname, hoursAtSchool, code);
        this.mansione = mansione;
    }
    
    public String getMansione() {
        return mansione;
    }

    public void setMansione(String mansione) {
        this.mansione = mansione;
    }

    @Override
    public String getBaseCode() {
        return "B";
    }
    
   
    
}
