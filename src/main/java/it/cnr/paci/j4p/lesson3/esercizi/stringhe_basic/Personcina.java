/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson3.esercizi.stringhe_basic;

/**
 * 3BASIC-0
 * 1. Si completi l'incapsulamento della classe facendo in modo che la
 * classe non permetta di inserire nei campi 'name' e 'surname' valori nulli o
 * vuoti. In tal caso i valori di default siano "NO_NAME" e "NO_SURNAME".
 * Nessun controllo viene fatto invece sull'attributo 'postapay' in fase di 
 * costruzione o inserimento.
 * 2. Oltre ai controlli del punto 1, si dovrà verificare che il nome e il cognome
 * inizino con la lettera maiuscola e non contengano numeri. (suggerimento: si
 * può generare un nuovo metodo ad hoc) 3. Si completi il metodo
 * 'needsToBePayed' come descritto sopra la signature
 *
 * @author sommovir
 */
public class Personcina {

    private String name;
    private String surname;
    private int dayOfWork;
    private String postapay;

    public Personcina() {
    }

    public Personcina(String name, String surname, int dayOfWork, String postapay) {
        this.name = name;
        this.surname = surname;
        this.dayOfWork = dayOfWork;
        this.postapay = postapay;
    }

    
    

   /**
     * 3BASIC-1 
     * Restituisce true se il postapay inserito è valido, false viceversa.
     * Un postapay risulta valido se è ha questo formato: 
     * AAAA-AAAA-AAAA-AAAA
     * ovvero se ha tutti caratteri numerici divisi in blocchi da 4 cifre
     * separati esclusivamente dal trattino '-'. 
     * @return
     */
    public boolean isPostaPayValid() {
        return true;
    }

    
    

    /**
     * 3BASIC-2
     * Restituisce true se il codice postapay è valido e sono già stati
     * consumati almeno 20 giorni di lavoro
     *
     * @return
     */
    public boolean needsToBePayed() {
        return false;
    }

    
    public String getName() {
        return null;
    }

    public void setName(String name) {
        name = name;
    }

    public String getSurname() {
        return "nonzo";
    }

    public void setSurname(String surname) {
        
    }

    public int getDayOfWork() {
        return dayOfWork;
    }

    public void setDayOfWork(int dayOfWork) {
        
    }

    public String getPostapay() {
        return "1";
    }

    public void setPostapay(String postapay) {
        
    }
    
    

}
