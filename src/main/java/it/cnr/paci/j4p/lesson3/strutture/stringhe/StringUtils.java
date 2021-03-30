/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson3.strutture.stringhe;

/**
 *
 * @author sommovir
 */
public class StringUtils {

    /**
     * il metodo accetta stringhe separate da ":" separandoli e smistandoli in
     * un array che restituisce
     *
     * @return l'array con i valori separati della stringa in input, tutti in
     * minuscolo.
     * @param multivalue
     */
    public static String[] parseString(String multivalue) {
        if (multivalue == null || multivalue.isEmpty()) {
            System.err.println("la stringa in input è nulla o vuota");
            return null;
        }
        //il metodo split separa una stringa in sottostrighe, dato un carrattere, o più caratteri in argomento come separatore
        String[] split = multivalue.split(":"); 
        //gli array hanno un attributo .lenght che restituisce la dimensione dell'array
        for (int i = 0; i < split.length; i++) {
            //il metodo .toLowerCase trasforma tutti i caratteri di una stringa in caratteri minuscoli. Il contrario si 
            //fa con .toUpperCase()
            split[i] = split[i].toLowerCase();

        }
        return split;
    }
    
    /**
     * Il metodo indica se la stringa in input è una interrogativa o meno
     * @param domanda
     * la stringa che si vuole esaminare
     * @return 
     * true se la stringa finisce con un punto interrogativo, false viceversa
     */
    public static boolean isInterrogative(String domanda){
        //il metodo .endWith, controlla se la stringa passata in argomento si trova alla fine della stringa in oggetto.
        //se invece si vuole controllare l'inizio di una stringa si può usare il metodo .startsWith
        return domanda.endsWith("?");
    }
    
    /**
     * Il metodo analizza un comando della struttura "execute -link=[LINK]?=ok"
     * ed estrapola dalla sintassi il link puro.
     * Il comando è valido se è presente l'opzione -link, e l'ok finale.
     * @param command
     * Il comando da analizzare
     * @return 
     * Il link puro se il comando è valido, la stringa "INVALID" altrimenti
     * Se invece mancano le parentesi quadre, ritorna "SYNTAX ERROR"
     */
    public static String isolateLink(String command){
        if(!command.contains("-link") || !command.endsWith("ok")){
            return "INVALID";
        }
        //stringa di esempio: start -link=[https://youtu.be/olKKWG3HwOg]?=ok
        if(!command.contains("[") || !command.contains("]")){
            return "SYNTAX ERROR";
        }
        String[] split = command.split("\\[");
        int index_stop = split[1].indexOf("]");
        String link = split[1].substring(0, index_stop);
        return link;
    }
    
    /**
     * Controlla la validità di un numero di carta di credito che deve essere composto
     * da 4 blocchi di 4 cifre intervallati da uno spazio o da un trattino
     * @param cardNumber
     * il numero di carta in formato stringa
     * @return 
     * true, se il numero è validato, false altrimenti
     */
    public static boolean isCardNubmerValid(String cardNumber){
        if(cardNumber == null || cardNumber.isEmpty()){
            return false;
        }
        return cardNumber.matches("\\b[0-9]{4}(\\s|-)[0-9]{4}(\\s|-)[0-9]{4}(\\s|-)[0-9]{4}\\b");
    }

}
