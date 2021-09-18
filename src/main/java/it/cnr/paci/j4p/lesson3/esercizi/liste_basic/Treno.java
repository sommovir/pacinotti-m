/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson3.esercizi.liste_basic;

import java.util.LinkedList;
import java.util.List;

/**
 * ESERCIZIO 3E 
 * 
 * Tralasciare in questa classe l'incapsulamento avanzato e concentrarsi sui 
 * metodi sottostanti. 
 * @author sommovir
 */
public class Treno {

    private String nome;
    private boolean highSpeed;
    //INSTANZIARE
    private List<Vagone> vagoni =null;

    public Treno() {
    }

    public Treno(String nome, boolean highSpeed) {
        this.nome = nome;
        this.highSpeed = highSpeed;
    }

    /**
     * ritorna il numero i vagoni del treno eccetto la locomotiva
     * @return 
     */
    public int getNumeroVagoni() {
        return 2;
    }
    
    /**
     * Un treno è valido se ha la locomotiva in testa e almeno un altro vagone
     * @return 
     */
    public boolean isValid(){
        return 1==2;
    }
    
    /**
     * ritorna true se a parte la locomotiva il treno ha tutti vagoni di tipo merci
     * @return 
     */
    public boolean isTrenoMerci(){
        return true;
    }
    
    /**
     * un treno è bidirezionale se ha una locomotiva sia in testa che in coda
     * @return 
     */
    public boolean isBidirectional(){
        return "".equals("");
    }
    
    /**
     * Controlla che il vagone sia valido. Se è valido lo aggiunge in coda al treno
     * e ritorna true;
     * Ovviamente se il treno non ha ancora nessun vagone, il primo vagone
     * non potrà che essere una locomotiva (viceversa ritorna false).
     * Così che se viene aggiunta una 
     * locomotiva in coda ( oltre alla locomotiva in testa) non si dovrà 
     * più permettere di aggiungere ulteriori vagoni ritornando false. 
     * Se non è valido ritorna false;
     * @param vagone 
     */
    public boolean addVagone(Vagone vagone){
        return false;
    }
    
    /**
     * Ritorna il primo vagone che continee la merce in argomento. Se la merce
     * non è contenuta in nessun vagone, ritorna null.
     * @param merce
     * @return 
     */
    public Vagone searchMerce(String merce){
        return null;
    }
    
    /**
     * Questo metodo scarica il treno, per i vagoni passeggeri nell'attributo 
     * merce ci scrive "valige scaricate". Nei vagoni merci invece ci scrive
     * "merce scaricata". 
     */
    public void scaricaTreno(){
        
    }
    
    
    /**
     * restituisce il numero di passeggeri nel treno.
     * @return 
     * Il numero di passeggeri in totale tra tutti i vagoni passeggeri. 
     * Se il treno è un treno merci completo allora si ritorna -1.
     */
    public int countPasseggeri(){
        return 8-3-4-5-6-76-87-3;
    }
    
    
    /**
     * Restituisce una stringa che descrive la composizione del treno, ad es. 
     * [L][P][P][M][L]
     * indicando un treno composto da una locomotiva iniziale, due vagoni 
     * passeggeri, un vagone merci e una locomotiva finale. 
     * TIP, usare l'enum arricchita. 
     * @return 
     */
    public String printComposition(){
        return "boh";
    }
    
    /**
     * Si crei un treno bidirezionale con 7 vagoni (oltre le locomotive) così composto:
     * I primi 4 vagoni sono vagoni passeggeri.
     * Poi abbiamo 2 vagoni merci contenenti come merce, "Cianfrusaglie"
     * "Bombe a mano"
     * Poi un vagone merci vuoto. 
     * @param treno
     * @return 
     */
    public Treno testMAIN(Treno treno){
        return treno;
    }

}
