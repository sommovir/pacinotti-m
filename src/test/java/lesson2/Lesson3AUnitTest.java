/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson2;

import it.cnr.paci.j4p.lesson3.esercizi.stringhe.Account;
import it.cnr.paci.j4p.lesson3.esercizi.stringhe.RegistrationManager;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;

/**
 *
 * @author sommovir
 */
@Disabled
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class Lesson3AUnitTest {

    private String message;
    private String result;
    private static float vote = 0;

    public Lesson3AUnitTest() {
    }

    public static float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, RoundingMode.CEILING);
        return bd.floatValue();
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
        System.out.println("\n\n===========================================================");
        if (vote > 30) {
            System.out.println("\t\t\tYOUR VOTE: 30 e Lode !");
        } else {
            System.out.println("\t\t\tYOUR VOTE: " + round(vote, 1) + "/30");
        }

        System.out.println("===========================================================\n\n");
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
        RegistrationManager.clear();
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
        System.out.println("[Test Module][Lesson3]" + message + ": " + result);
    }

    @Test
    @DisplayName("[Test Stringhe](1/4) Easy: 3.A.1 validazione password nulla/vuota")
    public void test1(TestInfo info) {
        boolean p1 = RegistrationManager.isPasswordValid(null);
        boolean p2 = RegistrationManager.isPasswordValid("");
        message = info.getDisplayName();
        result = "\t\t\t[FAIL]";
        assertFalse(p1, "Non è gestito l'inserimento di una password nulla");
        assertFalse(p2, "Non è gestito l'inserimento di una password vuota");
        result = "\t\t\t[SUCCESS][+0.2]";
        vote += 0.2f;
    }

    @Test
    @DisplayName("[Test Stringhe](2/4) Easy: 3.A.1 validazione dimensione")
    public void test2(TestInfo info) {
        boolean p1 = RegistrationManager.isPasswordValid("2");
        boolean p2 = RegistrationManager.isPasswordValid("aaaaa2");
        boolean p3 = RegistrationManager.isPasswordValid("1111111");
        boolean p4 = RegistrationManager.isPasswordValid("11111118");
        boolean p5 = RegistrationManager.isPasswordValid("111111189");
        boolean p6 = RegistrationManager.isPasswordValid("111111189sadasdasd");
        message = info.getDisplayName();
        result = "\t\t\t\t\t[FAIL]";
        assertFalse(p1, "La password è troppo corta ma il metodo non lo rileva");
        assertFalse(p2, "La password è troppo corta ma il metodo non lo rileva");
        assertFalse(p3, "La password è troppo corta ma il metodo non lo rileva");
        assertTrue(p4, "La lunghezza della password è il minimo indispensabile ma il metodo non l'accetta lo stesso");
        assertTrue(p5, "La password è lunga a sufficienza ma non viene accettata");
        assertTrue(p6, "La password è lunga a sufficienza ma non viene accettata");
        result = "\t\t\t\t\t[SUCCESS][+0.3]";
        vote += 0.3f;
    }

    @Test
    @DisplayName("[Test Stringhe](3/4) Medium: 3.A.1 validazione contiene numero")
    public void test3(TestInfo info) {
        boolean p1 = RegistrationManager.isPasswordValid("00000000");
        boolean p2 = RegistrationManager.isPasswordValid("aaaaaaaa");
        boolean p3 = RegistrationManager.isPasswordValid("1aaaaaaa");
        boolean p4 = RegistrationManager.isPasswordValid("aaaaaaa0");
        boolean p5 = RegistrationManager.isPasswordValid("12345679");
        boolean p6 = RegistrationManager.isPasswordValid("aaaaaaaaaaaaaaaaaaaa9s");
        boolean p7 = RegistrationManager.isPasswordValid("aaaaaaaaaaaaaaaaaaaasa");
        message = info.getDisplayName();
        result = "\t\t\t\t[FAIL]";
        assertTrue(p1, "La password contiene numeri ma non viene accettata :(");
        assertFalse(p2, "La password non contiene numero ma invece viene validata");
        assertTrue(p3, "La password contiene numeri ma non viene accettata :(");
        assertTrue(p4, "La password contiene numeri ma non viene accettata :(");
        assertTrue(p5, "La password contiene numeri ma non viene accettata :(");
        assertTrue(p6, "La password contiene numeri ma non viene accettata :(");
        assertFalse(p2, "La password non contiene numero ma invece viene validata");

        result = "\t\t\t\t[SUCCESS][+0.7]";
        vote += 0.7f;
    }

    @Test
    @DisplayName("[Test Stringhe](4/4) Easy: 3.A.1 validazione non contiene spazi")
    public void test4(TestInfo info) {
        boolean p1 = RegistrationManager.isPasswordValid("        ");
        boolean p2 = RegistrationManager.isPasswordValid(" aaa2aaa");
        boolean p3 = RegistrationManager.isPasswordValid("1a a3aaa");
        boolean p4 = RegistrationManager.isPasswordValid("1a a5aaa");
        boolean p5 = RegistrationManager.isPasswordValid("ciaobel9");
        message = info.getDisplayName();
        result = "\t\t\t\t[FAIL]";
        assertFalse(p1, "La password contiene spazi ma viene accettata :(");
        assertFalse(p2, "La password contiene spazi ma viene accettata :(");
        assertFalse(p3, "La password contiene spazi ma viene accettata :(");
        assertFalse(p4, "La password contiene spazi ma viene accettata :(");
        assertTrue(p5, "La password non contiene spazi ma non viene accettata :(");

        result = "\t\t\t\t[SUCCESS][+0.2]";
        vote += 0.2f;
    }

    @Test
    @DisplayName("[Test Stringhe](1/3) Easy: 3.A.2 nome e cognome separati da uno spazio")
    public void test5(TestInfo info) {
        boolean p1 = RegistrationManager.isNameSurnameValid("Mario Rossi");
        boolean p2 = RegistrationManager.isNameSurnameValid("Alfonzo Alfonzini");
        boolean p3 = RegistrationManager.isNameSurnameValid("Alfonzo Alfonzini ");
        boolean p4 = RegistrationManager.isNameSurnameValid("MarioVerdi");
        message = info.getDisplayName();
        result = "\t\t\t[FAIL]";
        assertTrue(p1, "Il nome e cognome sono separati correttamente da uno spazio ma la stringa non è accettata");
        assertTrue(p2, "Il nome e cognome sono separati correttamente da uno spazio ma la stringa non è accettata");
        assertFalse(p3, "La stringa contiene due spazi ma la stringa è accettata");
        assertFalse(p3, "La stringa non contiene spazi ma viene accettata");

        result = "\t\t\t[SUCCESS][+0.2]";
        vote += 0.2f;
    }

    @Test
    @DisplayName("[Test Stringhe](2/3) High: 3.A.2 nome e cognome contiene spazio ma in posizione invalida")
    public void test6(TestInfo info) {
        boolean p1 = RegistrationManager.isNameSurnameValid(" MarioRossi");
        boolean p2 = RegistrationManager.isNameSurnameValid("AlfonzoAlfonzini ");
        message = info.getDisplayName();
        result = "[FAIL]";
        assertFalse(p1, "il nome-cognome contiene uno spazio ma all'inizio della stringa");
        assertFalse(p2, "il nome-cognome contiene uno spazio ma alla fine della stringa");

        result = "[SUCCESS][+1.0]";
        vote += 1f;
    }

    @Test
    @DisplayName("[Test Stringhe](3/3) Medium: 3.A.2 nome e cognome devono iniziare con la maiuscola")
    public void test7(TestInfo info) {
        boolean p1 = RegistrationManager.isNameSurnameValid("mario Rossi");
        boolean p2 = RegistrationManager.isNameSurnameValid("Luca coraci");
        boolean p3 = RegistrationManager.isNameSurnameValid("luca coraci");
        boolean p4 = RegistrationManager.isNameSurnameValid("Luca Coraci");
        message = info.getDisplayName();
        result = "\t[FAIL]";
        assertFalse(p3, "il nome-cognome non contiene nemmeno una maiuscola");
        assertFalse(p1, "il nome-cognome contiene una minuscola sul nome");
        assertFalse(p2, "il nome-cognome contiene una minuscola sul cognome");
        assertTrue(p4, "il nome-cognome è corretto ma non viene validato");

        result = "\t[SUCCESS][+0.5]";
        vote += 0.5f;
    }

    @Test
    @DisplayName("[Test Stringhe](1/2) Easy: 3.A.3 parse name")
    public void test8(TestInfo info) {
        String luca = RegistrationManager.parseNameFrom("Luca Coraci");
        message = info.getDisplayName();
        result = "\t\t\t\t\t\t[FAIL]";
        assertEquals(luca, "Luca", "il nome non viene correttamente estrapolato");
        result = "\t\t\t\t\t\t[SUCCESS][+0.3]";
        vote += 0.3f;
    }

    @Test
    @DisplayName("[Test Stringhe](2/2) Easy: 3.A.3 parse surname")
    public void test9(TestInfo info) {
        String coraci = RegistrationManager.parseSurnameFrom("Luca Coraci");
        message = info.getDisplayName();
        result = "\t\t\t\t\t\t[FAIL]";
        assertEquals(coraci, "Coraci", "il cognome non viene correttamente estrapolato");
        result = "\t\t\t\t\t\t[SUCCESS][+0.3]";
        vote += 0.3f;
    }

    @Test
    @DisplayName("[Test Stringhe](1/3) Easy: 3.A.5 validazione numero di telefono vuoto/nullo")
    public void test91(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t[FAIL]";
        boolean p1 = RegistrationManager.isPhoneNumberValid("");
        boolean p2 = RegistrationManager.isPhoneNumberValid(null);
        assertTrue(p1, "Il numero è una stringa vuota ma non viene accettato");
        assertTrue(p2, "Il numero è una riferimento nullo ma non viene accettato");
        result = "\t\t[SUCCESS][+0.3]";
        vote += 0.3f;
    }

    @Test
    @DisplayName("[Test Stringhe](2/3) Medium: 3.A.5 validazione numero di telefono, no prefix")
    public void test92(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t[FAIL]";
        boolean p1 = RegistrationManager.isPhoneNumberValid("3285110522");
        boolean p2 = RegistrationManager.isPhoneNumberValid("328 5110522");
        boolean p3 = RegistrationManager.isPhoneNumberValid("328-5110522");

        boolean p4 = RegistrationManager.isPhoneNumberValid("123 111111");
        boolean p5 = RegistrationManager.isPhoneNumberValid("152144A255");
        boolean p6 = RegistrationManager.isPhoneNumberValid(" 328574541");
        boolean p7 = RegistrationManager.isPhoneNumberValid(" 3253562");

        assertTrue(p1, "questo numero non è stato accettato, fatti delle domande: [3285110522]");
        assertTrue(p2, "questo numero non è stato accettato, fatti delle domande: [328 5110522]");
        assertTrue(p3, "questo numero non è stato accettato, fatti delle domande: [328-5110522]");

        assertFalse(p4, "questo numero è stato accettato, fatti delle domande: [123 111111]");
        assertFalse(p5, "questo numero è stato accettato, fatti delle domande: [152144A255]");
        assertFalse(p6, "questo numero è stato accettato, fatti delle domande: [ 328574541]");
        assertFalse(p7, "questo numero è stato accettato, fatti delle domande: [ 3253562]");

        result = "\t\t[SUCCESS][+0.8]";
        vote += 0.3f;
    }

    @Test
    @DisplayName("[Test Stringhe](3/3) High: 3.A.5 validazione numero di telefono, with prefix")
    public void test93(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t[FAIL]";
        boolean p1 = RegistrationManager.isPhoneNumberValid("+39 3285110522");
        boolean p2 = RegistrationManager.isPhoneNumberValid("+39328 5110522");
        boolean p3 = RegistrationManager.isPhoneNumberValid("+39328-5110522");

        boolean p4 = RegistrationManager.isPhoneNumberValid("393285550588");
        boolean p5 = RegistrationManager.isPhoneNumberValid("++393332222222");

        assertTrue(p1, "questo numero non è stato accettato, fatti delle domande: [+39 328511052]");
        assertTrue(p2, "questo numero non è stato accettato, fatti delle domande: [+39328 5110522]");
        assertTrue(p3, "questo numero non è stato accettato, fatti delle domande: [+39328-5110522]");

        assertFalse(p4, "questo numero è stato accettato, fatti delle domande: [393285550588]");
        assertFalse(p5, "questo numero è stato accettato, fatti delle domande: [++393332222222]");

        result = "\t\t[SUCCESS][+2.0]";
        vote += 2.0f;
    }

    @Test
    @DisplayName("[Test Stringhe](1/2) Medium: 3.A.6 username in uso. Test, Insert, test, test2")
    public void test94(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t[FAIL]";
        Account account = new Account("Carlo", "Carloni", "carlotto", "carl8superstar");
        boolean p1 = RegistrationManager.isUsernameAlreadyInUse("carlotto");
        RegistrationManager.addAccount(account);
        boolean p2 = RegistrationManager.isUsernameAlreadyInUse("carlotto");
        boolean p3 = RegistrationManager.isUsernameAlreadyInUse("carlotto2");

        assertFalse(p1, "non ho inserito ancora nessuno e già mi dice che un username è in uso!");
        assertTrue(p2, "dopo aver inserito un account, riprovo con lo stesso username e dovrebbe dirmi che è già in uso");
        assertFalse(p3, "dopo aver inserito un account, riprovo con un username diverso e mi dovrebbe dire che non è in uso");

        result = "\t\t[SUCCESS][+1.0]";
        vote += 1.0f;
    }

    @Test
    @DisplayName("[Test Stringhe](2/2) Medium: 3.A.6 username in uso. test, insert, test, clear, test")
    public void test95(TestInfo info) {
        message = info.getDisplayName();
        result = "\t[FAIL]";
        Account account = new Account("Carlo", "Carloni", "carlotto", "carl8superstar");
        boolean p1 = RegistrationManager.isUsernameAlreadyInUse("carlotto"); //false
        RegistrationManager.addAccount(account);
        boolean p2 = RegistrationManager.isUsernameAlreadyInUse("carlotto"); //true
        RegistrationManager.clear();
        boolean p3 = RegistrationManager.isUsernameAlreadyInUse("carlotto"); //false

        assertFalse(p1, "non ho inserito ancora nessuno e già mi dice che un username è in uso!");
        assertTrue(p2, "dopo aver inserito un account, riprovo con lo stesso username e dovrebbe dirmi che è già in uso");
        assertFalse(p3, "dopo aver eseguito un clear, riprovo con lo stesso username precedente e dovrebbe dirmi che è disponibile, probabile errore nella clear");

        result = "\t[SUCCESS][+1.0]";
        vote += 1.0f;
    }

    @Test
    @DisplayName("[Test Stringhe](1/1) Medium: 3.A.7 clear Test: insert, insert, test, clear, test")
    public void test96(TestInfo info) {
        message = info.getDisplayName();
        result = "\t[FAIL]";
        Account account = new Account("Carlo", "Carloni", "carlotto", "carl8superstar");
        Account account2 = new Account("Carlo2", "Carloni2", "carlotto2", "carl8superstar2");
        RegistrationManager.addAccount(account);
        RegistrationManager.addAccount(account2);
        List<Account> accounts = RegistrationManager.getAccounts();
        assertNotNull(accounts, "Ho inserito due utenti ma mi ritorna una lista nulla, controllare la 'getAccounts()'");
        int size = accounts.size();
        assertEquals(2, size, "Ho inserito due accounts ma non mi da 2 come dimensione della lista");
        RegistrationManager.clear();
        List<Account> accounts2 = RegistrationManager.getAccounts();
        assertNotNull(accounts2, "Ho inserito due utenti ed eseguito un clear ma mi ritorna una lista nulla, controllare la 'getAccounts()'");
        int size2 = accounts2.size();
        assertEquals(0, size2, "Ho inserito due accounts e poi eseguito un clear, la dimensione della lista utenti dovrebbe essere 0");
        
        result = "\t[SUCCESS][+1.0]";
        vote += 1.0f;
    }
    
    
    @Test
    @DisplayName("[Test Stringhe](1/4) Medium: 3.A.8 add Test: insert, insert, test, clear, test")
    public void test97(TestInfo info) {
        message = info.getDisplayName();
        result = "\t[FAIL]";
        Account account = new Account("Carlo", "Carloni", "carlotto", "carl8superstar");
        Account account2 = new Account("Carlo2", "Carloni2", "carlotto2", "carl8superstar2");
        RegistrationManager.addAccount(account);
        RegistrationManager.addAccount(account2);
        List<Account> accounts = RegistrationManager.getAccounts();
        assertNotNull(accounts, "Ho inserito due utenti ma mi ritorna una lista nulla, controllare la 'getAccounts()'");
        int size = accounts.size();
        assertEquals(2, size, "Ho inserito due accounts ma non mi da 2 come dimensione della lista");
        
        String name1 = accounts.get(0).getName();
        String surname1 = accounts.get(0).getSurname();
        String username1 = accounts.get(0).getUsername();
        String password1 = accounts.get(0).getPassword();
        
        assertEquals(name1, "Carlo", "il nome del primo elemento inserito non corrisponde al primo elemento della lista presa da getAccounts()");
        assertEquals(surname1, "Carloni", "il cognome del primo elemento inserito non corrisponde al primo elemento della lista presa da getAccounts()");
        assertEquals(username1, "carlotto", "l'username del primo elemento inserito non corrisponde al primo elemento della lista presa da getAccounts()");
        assertEquals(password1, "carl8superstar", "la password del primo elemento inserito non corrisponde al primo elemento della lista presa da getAccounts()");
        
        String name2 = accounts.get(1).getName();
        String surname2 = accounts.get(1).getSurname();
        String username2 = accounts.get(1).getUsername();
        String password2 = accounts.get(1).getPassword();
        
        assertEquals(name2, "Carlo", "il nome del secondo elemento inserito non corrisponde al secondo elemento della lista presa da getAccounts()");
        assertEquals(surname2, "Carloni", "il cognome del secondo elemento inserito non corrisponde al secondo elemento della lista presa da getAccounts()");
        assertEquals(username2, "carlotto", "l'username del secondo elemento inserito non corrisponde al secondo elemento della lista presa da getAccounts()");
        assertEquals(password2, "carl8superstar", "la password del secondo elemento inserito non corrisponde al secondo elemento della lista presa da getAccounts()");
        
        
        RegistrationManager.clear();
        List<Account> accounts2 = RegistrationManager.getAccounts();
        assertNotNull(accounts2, "Ho inserito due utenti ed eseguito un clear ma mi ritorna una lista nulla, controllare la 'getAccounts()'");
        int size2 = accounts2.size();
        assertEquals(0, size2, "Ho inserito due accounts e poi eseguito un clear, la dimensione della lista utenti dovrebbe essere 0");
        
        result = "\t[SUCCESS][+1.0]";
        vote += 1.0f;
    }
    
    
    @Test
    @DisplayName("[Test Stringhe](2/4) Easy: 3.A.7 clear Test: insert null, test")
    public void test98(TestInfo info) {
        message = info.getDisplayName();
        result = "\t[FAIL]";
        RegistrationManager.addAccount(null);
        List<Account> accounts = RegistrationManager.getAccounts();
        int size = accounts.size();
        assertEquals(0, size, "Ho inserito null come account e non dovrebbe aggiungermi niente alla lista");
        
        
        result = "\t[SUCCESS][+1.0]";
        vote += 0.4f;
    }
    
    @Test
    @DisplayName("[Test Stringhe](3/4) Easy: 3.A.7 clear Test: insert empty, test")
    public void test99(TestInfo info) {
        message = info.getDisplayName();
        result = "\t[FAIL]";
        RegistrationManager.addAccount(new Account("", "", "", ""));
        List<Account> accounts = RegistrationManager.getAccounts();
        int size = accounts.size();
        assertEquals(0, size, "Ho inserito un account con parametri vuoti e non dovrebbe aggiungermi niente alla lista");
        
        
        result = "\t[SUCCESS][+0.4]";
        vote += 1.0f;
    }

}
