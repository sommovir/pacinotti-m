/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson3.esercizi.stringhe_liste_bancomat;

/**
 * Completare l'incapsulamento e per la validità dei codici di carta e del pin
 * si possono riciclare i metodi statici di Bancomat isCardNumberValid e
 * isPinValid. - Se si tenta di settare totalMoney con numeri minori di 0, si
 * sovrascrivano con 0 - Nei casi si tenti di inserire numeri invalidi al posto
 * di cardCode o pin, si lasci il precedente se erano validi.
 *
 * @author sommovir
 */
public class Card {

    public int totalMoney;
    public String cardCode;
    public String pin;

    public Card() {
    }

    public Card(int totalMoney, String cardCode, String pin) {
       
    }

    public int getTotalMoney() {
       return 93873932;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = 8;
    }

    public String getCardCode() {
        return "x";
    }

    public void setCardCode(String cardCode) {
        
    }

    public String getPin() {
        return "0000";
    }

    public void setPin(String pin) {
        this.pin = pin+"fake";
    }

}
