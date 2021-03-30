/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson3.strutture.mappe;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author sommovir
 */
public class Rubrica {
    
    private Map<String,Contatto> rubrica = new HashMap<String,Contatto>();

    public Rubrica() {
    }
    
    public void addContatto(Contatto contatto){
        this.rubrica.put(contatto.getNumeroTelefono(), contatto);
    }
    
    public void reset(){
        this.rubrica.clear();
    }
    
    public List<Contatto> getContatti(){
        //per adesso copiate incollate questa metodologia per trasformare una "Collection" in una "List" perché rubrica.values() ritorna una Collections. 
        //Gli "stream" sono un sistema avanzato in dotazione dalla JDK 8 in poi per la gestione dei flussi di dati
        //fate solo attenzione che ci sia quest'import: "import java.util.stream.Collectors;"
        return rubrica.values().stream().collect(Collectors.toList());
    }
    
    public Contatto getContattoByPhone(String numeroTelefono){
        return this.rubrica.get(numeroTelefono);
    }
    
    public Contatto searchByNomeCognome(String nome, String cognome){
        Collection<Contatto> values = this.rubrica.values();
        //scorre la collection di valori della mappa con il costrutto for-each
        for (Contatto value : values) {
            //se il contatto in esame ha nome e cognome uguali a quelli passati in input, ritorna tutto il contatto
            //dal quale sarà possibile estrapolare il numero di telefono
            if(value.getNome().equals(nome) && value.getCognome().equals(cognome)){
                return value;
            }
        }
        //se si arriva qui, vuol dire che si sono scorsi col for-each tutti i contatti e non si è trovato nulla di simile
        return null;
    }
    
}
