/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson3.esercizi.stringhe_liste_bancomat;

/**
 * //QUESTA CLASSE E' OK. NON VERRA' STRESSATO L'INCAPSULAMENTO OLTRE LO STANDARD
 * @author sommovir
 */
public class Operation {
    
    public int amount;
    public User user;

    public Operation() {
    }

    public Operation(int amount, User user) {
        this.amount = amount;
        this.user = user;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

  
    
    
}
