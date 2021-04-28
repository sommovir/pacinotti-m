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
    private long id;
    private boolean read=false;

    public Email() {
    }

    public Email(String object, String message, long senderID, long id) {
        this.object = object;
        this.message = message;
        this.senderID = senderID;
        this.id = id;
    }

    public boolean isRead() {
        return read;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    /**
     * Quando viene estratto il contenuto di un messaggio, si considera letta
     * l'email e la variabile read dovrà essere settata a true. 
     * @return 
     */
    public String getMessage() {
        this.read = true;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

   
    
    
}
