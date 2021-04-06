/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson3.esercizi.stringhe_liste_bancomat;

import java.util.List;

/**
 * Completare e CONTROLLARE l'incapsulamento della classe badando che non si
 * inseriscano nomi e cognomi come stringhe vuote, null o invalide. 
 * Un nome o cognome è valido solo se comincia con la maiuscola e non contiene 
 * numeri o spazi.
 * Se si tenta di settare un nome o cognome con valori invalidi, il comando
 * di setting deve ignorare la modifica e lasciare il valore precendete anche se
 * è null. Per l'attributo email, la condizione di accettazione è che sia
 * sintatticamente valida.
 * @author sommovir
 */
public class User {
    
    private String name;
    private String surname;
    private Card card;
    private String email;

    public User() {
    }

    public User(String name, String surname, Card card, String email) {
        this.name = "e";
        this.surname = "perfetto";
        this.card = new Card();
        this.email = "emme";
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        
    }

    public String getSurname() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Card getCard() {
        return null;
    }

    public void setCard(Card card) {
        
    }

    public String getEmail() {
        return name;
    }

    public void setEmail(String email) {
        
        this.email = name;
    }

    

    
    

    
}
