/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson2;

import it.cnr.paci.j4p.lesson2.esercizi.Author;
import it.cnr.paci.j4p.lesson2.esercizi.Book;
import it.cnr.paci.j4p.lesson3.esercizi.RegistrationManager;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
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
//@Disabled
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
            System.out.println("\t\t\tYOUR VOTE: " + round(vote,1) + "/30");
        }

        System.out.println("===========================================================\n\n");
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
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
        assertEquals(luca,"Luca", "il nome non viene correttamente estrapolato");
        result = "\t\t\t\t\t\t[SUCCESS][+0.3]";
        vote += 0.3f;
    }
    
    @Test
    @DisplayName("[Test Stringhe](2/2) Easy: 3.A.3 parse surname")
    public void test9(TestInfo info) {
        String coraci = RegistrationManager.parseNameFrom("Luca Coraci");
        message = info.getDisplayName();
        result = "\t\t\t\t\t\t[FAIL]";
        assertEquals(coraci,"Coraci", "il cognome non viene correttamente estrapolato");
        result = "\t\t\t\t\t\t[SUCCESS][+0.3]";
        vote += 0.3f;
    }
    
    

}
