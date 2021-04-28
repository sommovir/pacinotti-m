/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson3.esercizi.maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * ESERCIZIO 3.D
 * 
 * @author Luca
 */
public class EmailManager {
    
    private static EmailManager _instance = null;  //DO NOT CHANGE OR REMOVE
    private Map<EmailType,List<Email>> emailFoldersMap = new HashMap<>();//DO NOT CHANGE OR REMOVE
    private List<UserEmail> users = new LinkedList<>();//DO NOT CHANGE OR REMOVE
    
    private Map<Long,UserEmail> userByID = new HashMap<>();
    
    
    public static EmailManager getInstance() {
        if (_instance == null) {
            _instance = new EmailManager();
            return _instance;
        } else {
            return _instance;
        }
    }
    
    private EmailManager() {
        super();
        users = FakeDatabase.getInstance().loadUsers();
        for (UserEmail user : users) {
            mapUser(user);
        }
    }

    public List<UserEmail> getUsers() {
        return users;
    }

    public Map<EmailType, List<Email>> getEmailFoldersMap() {
        return emailFoldersMap;
    }
    
    
    public void reset(){
        emailFoldersMap.clear();
        users.clear();
        _instance = null;
    }
    
    /**
     * Fornisce la lista delle email pubblicitarie conosciute
     * @return 
     * La lista delle email pubblicitarie (ADV) note 
     */
    private List<String> getADVAddresses(){
        List<String> advs = new ArrayList<>(4);
        advs.add("ikea@ikea.it");
        advs.add("info-casa@info-casa.it");
        advs.add("vendi.pentole@pentolone.it");
        advs.add("amazon@amazon.it");
        return advs;
        
    }
    
    /**
     * OPZIONALE
     * Metodo opzionale che potete riempire se intendete approfittare del fatto
     * che nel costruttore di questa classe (intoccabile) viene acceduta per 
     * la prima volta la lista utenti. Li viene fatto un ciclo per tutti gli 
     * utenti. Se lo ritenete opportuno potete usare questo metodo per eventuali
     * ulteriori mappamenti. 
     * Non sarà valutato nel testing. 
     * @param user 
     */
    private void mapUser(UserEmail user){
        userByID.put(user.getId(), user);
    }
    
    /**
     * 3.D.1
     * Questo metodo simula una connessione ad un server dove riceve un pacchetto
     * di email che dovrà poi smistare. Il pacchetto in arrivo può essere una
     * lista vuota, null o un insieme di varie email che andranno smistate. 
     * Come smistarle: 
     * - se senderID dell'emails appartiene ad un utente segnato nella lista
     *   users, allora questa email è NORMAL
     * - se l'indirizzo emails è uno degli appartenenti alla lista che ritorna
     *   il metodo interno getADVAddresses(), allora questa emails andrà segnata
     *   come ADV
     * - per tutti gli altri casi, si può segnare come SPAM
     * @param emails 
     */
    public void downloadEmail(List<Email> emails){
        if(emails == null){
            return;
        }
        for (Email email : emails) {
            if(userByID.containsKey(email.getSenderID())){
                
            }
        }
        
    }
    
    /**
     * 3.D.2
     * Ritorna il numero di tutte le email nella casella postale
     * @return 
     * il numero di tutte le email presenti
     */
    public int getEmailsCount(){
        return 2837328;
    }
    
    /**
     * 3.D.3
     * Ritorna il numero di tutte le email non lette nella casella postale, 
     * ovvero il cui attributo interno 'read' è false. 
     * @return 
     * il numero di email non lette. 
     * EXTRA: non sarà conteggiato nel test, ma se siete bravi potete
     * fare questo task 'per costruzione' senza ciclare niente.
     */
    public int getUnreadEmailsCount(){
        return 2837328;
    }
    
    /**
     * 3.D.4
     * Estrae tutte le mails etichettate come spam
     * @return 
     * la lista delle email segnalate come spam
     */
    public List<Email> getAllSpamEmails(){
        return null;
    }
    
    
    /**
     * 3.D.5
     * Cancella tutte le email segnate come spam o adv
     */
    public void deleteSpamAdv(){
        
    }
    
    /**
     * 3.D.5
     * Cancella un email dato un id di una email
     * @param idEmail 
     * l'id di una email
     * @return  
     * true, se l'email è stata trovata e cancellata, false altrimenti
     */
    public boolean deleteEmail(int idEmail){
        return true;
    }
    
    /**
     * 3.D.6
     * Viene letta l'email con l'id passato in argomento, il testo estratto
     * viene quindi ritornato.
     * @param idEmail
     * l'id della email da leggere
     * @return 
     * il testo dell'email con l'id passato in argomento. Se l'email non esiste
     * si deve ritornare la stringa: 'EMAIL NOT FOUND'. 
     */
    public String readEmail(int idEmail){
        return "ciao, sono l'amante della tua ragazza";
    }
    
    /**
     * 3.D.7 (HARD)
     * Sposta una email dallo spam alla cartella delle email normali. 
     * Una volta avvenuto lo spostamento, va inserito l'indirizzo di questa 
     * email nell'elenco 'users' degli utenti conosciuti, di modo che non sarà
     * più considerato come spam. Siccome si conosce solo l'indirizzo email, 
     * per costruire la classe UserEmail si procederà come segue: 
     *  - nei messaggi spam o adv l'indirizzo email è nascosto nel messaggio
     *    della email, si trova racchiuso da parentesi [] o da {}. 
     *  - l'id deve essere assegnato di modo che sia diverso da quelli già 
     *    esistenti
     *  - il nome sarà la parte PRIMA della @ nell'indirizzo email
     *  - il cognome sarà la parte DOPO la @ nell'indirizzo email
     * @param idEmail 
     * l'email da spostare
     * @return
     * ritorna true se tutto è andato a buon fine, false nei casi in cui l'email
     * non esiste o se l'email da spostare non è etichettata come SPAM. In questo
     * caso non bisogna fare niente e ritornare immediatamente false. 
     */
    public boolean saveFromSpam(int idEmail){
        return false;
    }
    
    /**
     * 3.D.8
     * data una email ritorna l'user corrispondente. Questo è possibile solo
     * se l'email è etichettata come NORMAL
     * @param idEmail
     * @return 
     * L'oggetto della classe UserEmail corrispondente all'idSender interno alla
     * email di id idEmail. Se la mail però non è etichettata come NORMAL
     * ritorna false. 
     */
    public UserEmail getUserByEmail(int idEmail){
        return null;
    }
    
    /**
     * 3.D.9
     * Fornisce l'elenco di tutte le email in arrivo dall'utente specificato
     * @param idUser
     * l'id dell'utente richiesto
     * @return 
     * la lista di tutte le email arrivate da questo utente. Se l'id è presente
     * tra i contatti si ritornerà una lista vuota, nel caso non ci sono email. 
     * Se invece l'id non è tra i contatti si ritornerà null.
     */
    public List<Email> getEmailsByUsers(int idUser){
        return null;
    }
    
    /**
     * 3.D.10
     * ritorna una mappa con chiave tutti gli id utenti conosciuti e per chiave
     * il numero di email arrivate
     * @return 
     */
    public Map<Integer,Integer> getStatistics(){
        return new HashMap<Integer,Integer>();
    }
    
    
    
    
    
    
    
}
