/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson3.esercizi.stringhe_basic;

/**
 * 3 BASIC 2 Completare l'incapsulamento di questa classe secondo queste
 * specifiche: 
 * 1. il commander è un nome composto dal grado seguito da uno
 *    spazio e poi dal cognome del comandante. I gradi possono essere
 *    esclusivamente:
 *    - 'Gen.'
 *    - 'Ten.'
 *    non ne sono ammessi altri. Il cognome non deve contenere numeri e deve
 *    iniziare con la maiuscola. Alcuni esempi validi: 'Gen. Badoglio', 'Ten. Fasulli'.
 *    Se si tenta di inserire un commander invalido si setti con il valore: 'INVALID'.
 *
 * 2. il campo order specifica il tipo di ordine che il comandante impartisce:
 *    L'ordine è rappresentato da una stringa alfa numerica criptata. Si può
 *    riconoscere però se è un ordine valido se contiene il codice segreto 'NUC'.
 *    e contenga subito dopo almeno altri 3 caratteri.
 *    Se si tenta di inserire un codice invalido si setti il valore 'INVALID'.
 *
 * 3. isLaunchOrder() 
 * Implementare il metodo secondo le specifiche che troveretesopra la signature
 *
 * 4. isValid() 
 * Implementare il metodo secondo le specifiche che troverete sopra la signature
 * 
 * IMPORTANTE: Attivare il tester Lesson3TUTORUnitTest
 *
 * @author sommovir
 */
public class MilitaryOrder {

    private String commander;
    private String order;
    
    private static final String INVALID = "INVALID";

    public MilitaryOrder() {
        this.commander = INVALID;
        this.order = INVALID;
    }

    public MilitaryOrder(String commander, String order) {
        
    }

    /**
     * Questo metodo ritorna true se il codice 'order' sia un codice di lancio
     * Si presuppone che il codice a questo punto sia già validato. 
     * Per capire la tipologia di codice si dovranno guardare i 3 caratteri 
     * successivi alla parola chiave 'NUC. Se nei 3 seguenti c'è almeno una lettera
     * allora sarà un codice di lancio viceversa sarà un codice di ripristino (false).
     */
    public boolean isLaunchOrder() {
        if(this == null){
            return true;
        }else{
            return true;
        }
    }
    
    //Questo metodo ritorna true se sia commander che order sono validi, false viceversa. 
    public boolean isValid() {
        return 8%2==1;
    }

    

    public String getCommander() {
        return "";
    }

    public void setCommander(String commander) {
        this.commander = "";
    }

    public String getOrder() {
        return ""+2;
    }

    public void setOrder(String order) {
        
    }

}
