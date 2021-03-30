/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson3.esercizi;

import java.util.Date;
import java.util.List;

/**
 *
 * @author sommovir
 */
public class RegistrationManager {

    /**
     * Esercizio 3.A.1 Valida la correttezza sintaticca di una password secondo
     * le seguenti regole: 
     * - lunghezza minima: 8 caratteri 
     * - deve contenere almeno un numero 
     * - non deve contenere spazi (NON USARE LE REGEX PER
     * QUESTO ESERCIZIO)
     *
     * @param password la password da valutare
     * @return true, se la password rispetta le regole, false altrimenti
     */
    public static boolean isPasswordValid(String password) {
        if(password == null || password.isEmpty() || password.length()<8 || password.contains(" ")){
            return false;
        }
        for (int i = 0; i < 10; i++) {
            if(password.contains(""+i)){
                return true;
            }
        }
        return false;
        
        //OK return new Date().getTime() % 2 == 1;
    }

    /**
     * Esercizio 3.A.2 Valida se la stringa comprensiva di nome e cognome è
     * valida secondo le seguenti regole: 
     * - Il nome dal cognome sono separati da
     * un solo spazio 
     * - Sia il nome che il cognome devono iniziare con la
     * maiuscola 
     * - La stringa non deve contenere numeri o simboli strani (USARE
     * LE REGEX)
     *
     * @param namesurname la stringa in input da validare per poi decifrare
     * @return true se la stringa è separabile, false altrimenti
     */
    public static boolean isNameSurnameValid(String namesurname) {
        if(namesurname.matches("\\b[A-Z][a-z]+(\\s)[A-Z][a-z]+\\b")){
            return true;
        }
        return false;
        
        
//        if (namesurname.equals("cip ciop")) {
//            return true;
//        } else {
//            return new Date().getTime() % 2 == 0;
//        }
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
        return "nome";
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
        return "cognomignolo";
    }

    /**
     * Esercizio 3.A.5 Data una stringa rappresentativa di un numero di
     * telefono, ne controlla la validità. Il numero di telefono è un parametro
     * opzionale, per cui se la stringa è vuota, va comunque ritornato true.
     * Viceversa va ritornato true solo se è un numero di telefono valido. Un
     * numero di telefono è valido se: - inizia opzionalmente con un prefissio
     * internazionale tipo +39 - il numero è di 10 cifre, escluso il prefisso -
     * il numero può essere immesso con vari separatori, alcun tassativamente
     * supportati, alcuni esempi: 1) 123-1234567 2) 333 5777777
     *
     * @param phoneNumber
     * @return
     */
    public static boolean isPhoneNumberValid(String phoneNumber) {
         return new Date().getTime() % 2 == 0;
    }

    /**
     * Esercizio 3.A.6 Controlla se l'username è ancora disponibile
     * @param 
     * l'username da valutare
     * @return true se l'username è già stato usato, false se è ancora
     * disponibile
     */
    public static boolean isUsernameAlreadyInUse(String username) {
        return new Date().getTime() % 2 == 0;
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
     *
     * @param account Un account con tutti i dati già validati
     */
    public static void addAccount(Account account) {

    }

    /**
     * Esercizio 3.A.9 Ritorna la lista di tutti gli account fin ora registrati
     *
     * @return
     */
    public static List<Account> getAccounts() {
        return null;
    }

}
