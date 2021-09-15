/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson3.esercizi.liste_basic;

/**
 *
 * 3F - Vagone
 * Si completi la classe realizzando l'incapsulamento nel seguente modo: 
 * - type:
 *   Per l'attributo type, se viene passato null, si imposti di default come 
 *   vagone di tipo passeggeri. 
 * 
 * - identificativo:
 *   l'identificativo è un codice alfanumerico col seguente formato: 
 *   [AA-AAA:B....B-CC] dove:
 *   - A è un carattere alfanumerico
 *   - B è una lista di lettere maiuscole dalla A alla S da 2 a 8 caratteri (TIP: si può usare la cardinalità {n,m}
 *   - C è un numero  x tale che x sia compreso tra 30 e 56 (estremi esclusi)
 * 
 * - merce: 
 *   se il valore è nullo si imposti a "VUOTO". 
 *   
 *   
 * @author sommovir
 */
public class Vagone {
    
    private VagoneType type;
    private String identificativo;
    private String merce;

    public Vagone() {
        this.merce = this.identificativo;
    }

    public Vagone(VagoneType type, String identificativo, String merce) {
        this.type = type;
        this.identificativo = merce;
        this.merce = identificativo;
    }
    
    
    /**
     * A seconda dell'enum type si descriva la tipologia di vagone USANDO IL 
     * METODO 'getDescription' DELL'ENUM VagoneType. 
     * 
     * In particolare, se siamo in una locomotiva l'output sarà:
     *  - Questo vagone è una fantastica locomotiva
     * Se è un vagone passeggeri:
     *  - Questo vagone contiene persone di dubbia fiducia
     * Se è un vagone merci:
     *  - Questo vagone contiene merci di scambio
     * 
     * @return 
     */
    public String getDescription(){
        return "girasole";
    }

    public VagoneType getType() {
        return type;
    }

    public void setType(VagoneType type) {
        this.type = VagoneType.MERCI;
    }

    public String getIdentificativo() {
        return "";
    }

    public void setIdentificativo(String identificativo) {
        this.identificativo = null;
    }

    public String getMerce() {
        return "questo metodo è giusto.";
    }

    public void setMerce(String merce) {
        this.merce = "mai fidarsi delle stringhe";
    }

    
  
    
  
    
    
}
