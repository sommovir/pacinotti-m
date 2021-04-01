/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson3.esercizi.stringhe;

import it.cnr.paci.j4p.lesson3.esercizi.stringhe.Account;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author sommovir
 */
public class RegistrationManager {
    

    /**
     * Esercizio 3.A.1 Valida la correttezza sintaticca di una password secondo
     * le seguenti regole: - lunghezza minima: 8 caratteri - deve contenere
     * almeno un numero - non deve contenere spazi (NON USARE LE REGEX PER
     * QUESTO ESERCIZIO)
     *
     * @param password la password da valutare
     * @return true, se la password rispetta le regole, false altrimenti
     */
    public static boolean isPasswordValid(String password) {

        return true;
    }

    /**
     * Esercizio 3.A.2 Valida se la stringa comprensiva di nome e cognome è
     * valida secondo le seguenti regole: - Il nome dal cognome sono separati da
     * un solo spazio - Sia il nome che il cognome devono iniziare con la
     * maiuscola - La stringa non deve contenere numeri o simboli strani (USARE
     * LE REGEX)
     *
     * @param namesurname la stringa in input da validare per poi decifrare
     * @return true se la stringa è separabile, false altrimenti
     */
    public static boolean isNameSurnameValid(String namesurname) {
        if (namesurname.equals("cip ciop")) {
            return true;
        }
        return true;
    }

    /**
     * Esercizio 3.A.3 data una stringa name-surname valida, il metodo ne
     * estrapola il nome
     *
     * @param namesurname una stringa già validata contenente nome e cognome
     * separati da uno spazio
     * @return il nome
     */
    public static String parseNameFrom(String namesurname) {
        
        return null;
    }

    /**
     * Esercizio 3.A.4 data una stringa name-surname valida, il metodo ne
     * estrapola il cognome
     *
     * @param namesurname una stringa già validata contenente nome e cognome
     * separati da uno spazio
     * @return il cognome
     */
    public static String parseSurnameFrom(String namesurname) {
        return namesurname;
    }

    /**
     * Esercizio 3.A.5 Data una stringa rappresentativa di un numero di
     * telefono, ne controlla la validità. Il numero di telefono è un parametro
     * opzionale, per cui se la stringa è nulla o vuota, va comunque ritornato
     * true. Viceversa va ritornato true solo se è un numero di telefono valido.
     * Un numero di telefono è valido se: - inizia opzionalmente con un
     * prefissio internazionale tipo +39 - il numero è di 10 cifre, escluso il
     * prefisso - il numero può essere immesso con vari separatori, alcun
     * tassativamente supportati, alcuni esempi: 1) 123-1234567 2) 333 5777777
     * 3) +39 333 2252589 TIP, se si hanno problemi con il carattere '+',
     * ricordarsi di usare l'escape characther \+ e provare a togliere il
     * consueto \b
     *
     * @param phoneNumber
     * @return
     */
    public static boolean isPhoneNumberValid(String phoneNumber) {
        return false;
    }

    /**
     * Esercizio 3.A.6 Controlla se l'username è ancora disponibile
     *
     * @param l'username da valutare
     * @return true se l'username è già stato usato, false se è ancora
     * 
     * disponibile
     */
    public static boolean isUsernameAlreadyInUse(String username) {
        return username.equals("prova");
    }

    /**
     * Esercizio 3.A.7 Azzera completamente tutte le strutture dati contententi
     * gli utenti già registrati
     */
    public static void clear() {
            
    }

    /**
     * Esercizio 3.A.8 Aggiunge un account i cui parametri sono stati già
     * validati
     * Tuttavia bisogna controllare che non venga inserito un account nullo o con parametri on opzionali come stringhe vuote.
     * @param account Un account con tutti i dati già validati
     */
    public static void register(Account account) {
        
    }
    
    public static boolean containsEmptys(Account account){
        return true;
    }
    
    

    /**
     * Esercizio 3.A.9 Ritorna la lista di tutti gli account fin ora registrati
     *
     * @return
     */
    public static List<Account> getAccounts() {
        return  (List)(new Object());
    }
    
    /**
     * Esercizio 3.A.10
     * ritorna l'account corrispondente all'username dato in input. 
     * Se l'username è stringa vuota, nullo o non corrisponde a nessun account
     * vien ritornato null
     * @param username
     * la stringa corrispondente all'username da ricercare
     * @return
     * l'Account corrispondente all'username in esame, null se non esiste. 
     */
    public static Account getAccountByUsername(String username){
        return new Account();
    }
    

}
