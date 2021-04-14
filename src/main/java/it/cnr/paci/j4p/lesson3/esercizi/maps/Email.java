/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson3.esercizi.maps;

/**
 *
 * @author Luca
 */
public class Email {
    
    private String object;
    private String message;
    private long senderID;

    public Email() {
    }

    public Email(String object, String message, long senderID) {
        this.object = object;
        this.message = message;
        this.senderID = senderID;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getSenderID() {
        return senderID;
    }

    public void setSenderID(long senderID) {
        this.senderID = senderID;
    }
    
    
    
}
