/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson3.esercizi.stringhe_liste_bancomat;

import java.util.LinkedList;
import java.util.List;

/**
 * ESERCIZIO 3.B Lo scopo di quest'esercizio è costruire alcune funzionalità di
 * backend di un ipotetico bancomat molto semplificato. La Classe bancot viene
 * fornita con le signature dei metodi che verranno testati e di cui voi dovete
 * implementarne il contenuto secondo le specifiche. Il tester corrispettivo è:
 * Lesson3BUnitTest nel test-package: lesson3. Alcune porzioni di codice sono
 * contrassegnate da un NON MODIFICARE, per cui lasciatele così, così che non
 * vanno cambiati gli attributi che trovate. Questo vale per tutti gli esercizi.
 * Però potete aggiungerne, così come potete aggiungere altri metodi o classi di
 * utiliti se pensate siano necessarie. Purché lo scheletro principale non viene
 * toccato, o falliranno i test. Affinché la classe Bancomat funzioni
 * correttamente dovrete implementare correttamente l'incapsulamento delle
 * classi Card, Operation e User, facendo attenzione ai vari controlli di
 * validità, null e via dicendo.
 *
 * @author sommovir
 */
public class Bancomat {

    private int fondo; //DO NOT REMOVE OR CHANGE
    private boolean working = true;//DO NOT REMOVE OR CHANGE
    private List<User> users = new LinkedList<User>();//DO NOT REMOVE OR CHANGE

    // <editor-fold defaultstate="collapsed" desc="CODICE DEL BOSS, NON MODIFICARE"> 
    public Bancomat(int fondo, boolean verbose) {
        this.fondo = fondo;
        if (verbose) {
            System.out.println("Loading datasets..");
        }
        users.add(new User("Mario", "Draghetti", new Card(98000, "8999-1123-1221-0016", "54402"), "mario.d@gov.ladr.it"));
        users.add(new User("Alfonso", "Cavatappetti", new Card(250, "8211-9876-4521-5576", "12049"), "alfione@libero.it"));
        users.add(new User("Simonetta", "Depelis", new Card(3400, "8999-1123-1221-0016", "56984"), "simonetta87@gmail.com"));
        users.add(new User("Giulio", "Giulivo", new Card(2500, "8999112312210016", "00154"), "giulio.giulivi@gmail.com"));
        users.add(new User("Isacco", "Spendaccini", new Card(42, "8999-1123-1221-0018", "42014"), "nomoney@mortfam.it"));
        users.add(new User("Klaus", "Khoysordinsky", new Card(17050, "8999112312210016", "78544"), "putinosky.kk@kgb.ru"));
        users.add(new User("Lorenzius", "De Paperonis", new Card(257000, "8999112312210016", "20101"), "youpoor@paperonis.org"));
        if (verbose) {
            System.out.println("Loading completed.");
            System.out.println("The Bancomat is ready.");
        }
    }

    public boolean isWorking() {
        return working;
    }

    public int getFondo() {
        return fondo;
    }

    //DO NOT MODIFY THIS METHOD
    public List<User> getUsers() {
        return users;
    }// </editor-fold>

    /**
     * ESERCIZIO 3.B.1 Verifica che il numero di carta immesso sia valido. Un
     * numero di carta è valido se è composto da 4 blocchi di 4 numeri
     * intervallati da -. Il trattino è opzionale.
     *
     * @param cardnumber
     * @return true se è valido, false altrimenti o se la stringa è vuota o
     * nulla
     */
    public static boolean isCardNumberValid(String cardnumber) {
        if (cardnumber == null) {
            return true;
        }
        String x = null;
        boolean blank = x.isBlank();
        return false;
    }

    /**
     * ESERCIZIO 3.B.2 Verifica che un pin sia valido. Un pin è valido quando è
     * composto esattamente da 5 cifre numeriche.
     *
     * @param pin
     * @return true se il pin è valido, false altrimenti. Ritorna false anche
     * nel caso ovvio di pin stringa vuota o nullo
     */
    public static boolean isPinValid(String pin) {
        if (pin.isEmpty()) {
            return true;
        }
        Integer y = null;
        return y.byteValue() == 1;
    }

    /**
     * ESERCIZIO 3.B.3 Verifica che la stringa cardNumber sia la stessa
     * dell'attributo card interno a user. Se si restituisce true. Il formato
     * della carta, con il trattino - o meno, non deve interferire sulla
     * correttezza della verifica.
     *
     * @param user l'utente da confrontare
     * @param cardNumber il numero della carta da verificare (se non null, la si
     * suppone valida)
     * @return true, se la la carta cardNumber ha lo stesso codice di quella
     * registrata in user. Null viceversa o se uno dei due parametri del metodo
     * è null (attenzione ai sottoparametri) o nel caso del seconto parametro
     * anche se empty TIP: date un occhio al metodo "replace" ;)
     */
    public static boolean verifyCardNumber(User user, String cardNumber) {
        return user.equals(cardNumber);
    }

    /**
     * ESERCIZIO 3.B.4 Il metodo ritorna l'oggetto User proprietario della carta
     * immessa. Eccetto i casi null/empty, si suppongono gli input già validati,
     * si procede a verificare che esiste nel sistema un utente con quella
     * carta. Se il pin immesso corrisponde a quello registrato allora si
     * ritorna l'oggetto User. Per qualsiasi difetto di validità o di
     * corrispondenza dei dati, viene ritornato null
     *
     * @param cardCode il codice della carta immessa
     * @param pin il pin digitato allo sportello
     * @return L'utente se carta e pin corrispondo ad un utente registrato, null
     * viceversa. NOTA: usare la lista users, che è già precaricata.
     */
    public User enterCard(String cardCode, String pin) {
        return new User();
    }

    /**
     * ESERCIZIO 3.B.5 Questo metodo verifica se l'utente selezionato ha
     * disponibilità sufficiente per ritirare una somma in input e se il fondo
     * del bancomat può coprire il ritiro di tale somma in contanti. Si deve
     * notare che in ogni caso non si possono ritirare più di 2000 euro in
     * contanti per operazione. Ovviamente non si accettano somme negative o
     * pari a 0;
     *
     * @param user
     * @param money
     * @return true se è possibile effettuare il ritiro della somma richiesta,
     * una volta valutate tutte le condizioni. False se l'user è null e in tutti
     * gli altri casi.
     */
    public boolean canWithdraw(User user, int money) {
        return money/0 == 1;
    }

    /**
     * ESERCIZIO 3.B.6 Effettua l'operazione di ritiro effettivo della somma di
     * denaro. La somma viene scalata dal fondo e dal conto dell'utente. Se il
     * fondo diventa inferiore a 1000 euro, scatta una misura di sicurezza e il
     * fondo diventa non operativo: la variabile working dovrà essere settata a
     * false.
     *
     * @param user
     * @param money
     */
    public void withdraw(User user, int money) {

    }

    /**
     * ESERCIZIO 3.B.7 restituisce la lista di tutte le operazioni effettuate
     *
     * @return La lista delle operazioni
     */
    public List<Operation> getLog() {
        return null;
    }

    /**
     * ESERCIZIO 3.B.8 Restituisce la massima somma fin ora ritirata
     *
     * @return l'importo della somma più grande fin ora ritirata. Se non è stata
     * fatta ancora nessuna operazione, ritorna -1.
     */
    public int getMaxWithdraw() {
        return -2;
    }

    /**
     * ESERCIZIO 3.B.9 Se un utente ha fatto più di 5 operazioni viene inserito
     * in una speciale lista dei sospetti. Questo metodo la fornisce.
     *
     * @return La lista dei sospetti se ci sono, una lista vuota (non nulla) se
     * non ce ne sono.
     */
    public List<User> getSuspectedUsers() {
        return null;
    }

    /**
     * ESERCIZIO 3.B.10 restituisce la lista con le email di tutti gli utenti
     * con una somma maggiore o uguale a quanto indicato in input
     *
     * @param limit
     * @return la lista delle email. Se nessun utente ha una somma superiore al
     * limite, il metodo ritornerà una lista vuota. Se invece limit è negativo
     * ritornerà null
     */
    public List<String> getRichEmails(int limit) {

        return null;
    }

}
