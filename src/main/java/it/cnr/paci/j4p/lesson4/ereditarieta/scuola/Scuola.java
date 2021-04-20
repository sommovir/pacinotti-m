/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson4.ereditarieta.scuola;

import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author sommovir
 */
public class Scuola {
    
    private static List<SchoolPerson> personale = new LinkedList<>();
    
    public static int sumOreTotaliStudenti(List<SchoolPerson> personale){
        int sum = 0;
        for (SchoolPerson p : personale) {
            if(p instanceof Studente){
                sum+=p.getHoursAtSchool();
            }
        }
        return sum;
    }
    
    public static void stampaClasse(List<SchoolPerson> personale){
        for (SchoolPerson p : personale) {
            if(p instanceof Studente){
                Studente s = (Studente)p; //CAST di p a Studente
                System.out.println("Lo studente "+p.getName()+" è nella "+s.getClasse());
            }
        }
    }
    
    public static void main(String[] args) {
        
        Studente franca = new Studente("3AI", "Nicola", "Francario",32,"111");
        Studente balze = new Studente("3BI", "Matteo", "Balzerani",32,"112");
        Studente spiri = new Studente("4BI", "Luca", "Spirito",32,"113");
        
        Professore fiore = new Professore("Informatica", "Fiorella", "Fiore",18,"876");
        
        Bidello bidello = new Bidello("CS", "Elisabetta", "Elisabettini", 36,"554");
        
        personale.add(franca);
        personale.add(balze);
        personale.add(spiri);
        personale.add(fiore);
        personale.add(bidello);
        
        for (SchoolPerson p : personale) {
            System.out.println("Personale: "+p.getName());
        }
        
        int sum = sumOreTotaliStudenti(personale);
        
        System.out.println("somma: "+sum);
        
        System.out.println("-----");
        
        stampaClasse(personale);
        
        System.out.println("----------------------------------");
        
        for (SchoolPerson p : personale) {
            System.out.println("CODICE: "+p.getIdentificationCode());
        }
        
        
    }
    
}
