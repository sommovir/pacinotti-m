  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson3.esercizi.enums_parsing;

/**
 * ESERCIZIO 3.C.8
 * Completare la struttura dati includento una mini descrizione del comando
 * attraverso la tecnica del costruttore interno alla enum.
 * Di seguito le stringhe da includere
 * (non cambiarle, saranno oggetto di testing)
 * Escludete gli apici.
 * 
 * Per l'enum TABLE -> 'Comando per la generazione di tabelle'
 * Per l'enum QUIT -> 'Comando per l'uscita temporizzata dal programma'
 * Per l'enum SPEAK -> 'Comando per far sintetizzare del testo al programma'
 * Per l'enum UNKNOWN -> 'Comando sconosciuto'
 * @author sommovir
 */
public enum CommandType {
    
    TABLE,
    QUIT,
    SPEAK,
    UNKNOWN;
    
    
    public String description(){
        return "hai perso";
    }
    
}
