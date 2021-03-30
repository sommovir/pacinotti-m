/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson3.strutture.mappe;

/**
 *
 * @author sommovir
 */
public class Contatto {
    private String numeroTelefono;
    private String nome;
    private String cognome;

    public Contatto() {
    }

    public Contatto(String numeroTelefono, String nome, String cognome) {
        this.numeroTelefono = numeroTelefono;
        this.nome = nome;
        this.cognome = cognome;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    
    
    
}
