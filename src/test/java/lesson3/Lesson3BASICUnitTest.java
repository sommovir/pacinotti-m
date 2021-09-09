/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson3;

import it.cnr.paci.j4p.lesson3.esercizi.stringhe.Account;
import it.cnr.paci.j4p.lesson3.esercizi.stringhe.RegistrationManager;
import it.cnr.paci.j4p.lesson3.esercizi.stringhe_basic.Personcina;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assumptions;
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
public class Lesson3BASICUnitTest {

    private static final String NO_NAME = "NO_NAME";
    private static final String NO_SURNAME = "NO_SURNAME";
    private String message;
    private String result;
    private static float vote = 0;

    public Lesson3BASICUnitTest() {
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
        System.out.println("[Test Module][L3 BASIC]" + message + ": " + result);
    }

    @Test
    @DisplayName("[Test Incaps.](1/4) Easy: 3.BASIC.0 cotruttore vuoto")
    public void test1(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t\t\t\t[MISERY]";
        Personcina p = new Personcina();
        assertEquals(NO_NAME, p.getName(),"Ho usato il costruttore vuoto ma il valore name non risulta inizializzato");
        assertEquals(NO_SURNAME, p.getSurname(),"Ho usato il costruttore vuoto ma il valore name non risulta inizializzato");
        result = "\t\t\t\t\t[SUCCESS][+2]";
        vote += 2f;
    }
    
    @Test
    @DisplayName("[Test Incaps.](2/4) Easy: 3.BASIC.0 cotruttore con arg., valori validi")
    public void test2(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t\t[DISGRACE]";
        Personcina p = new Personcina("Luca", "Coraci", 0, "200");
        assertEquals("Luca", p.getName(),"Ho usato il costruttore con argomenti ma il valore name non corrisponde");
        assertEquals("Coraci", p.getSurname(),"Ho usato il costruttore con argomenti ma il valore surname non corrisponde");
        assertEquals(0,p.getDayOfWork(), "Ho usato il costruttore con argomenti ma il valore dayOfWork non corrisponde");
        result = "\t\t\t[SUCCESS][+2]";
        vote += 2f;
    }
    
    @Test
    @DisplayName("[Test Incaps.](3/4) Easy: 3.BASIC.0 cotruttore con arg., valori invalidi(no maiuscole)")
    public void test3(TestInfo info) {
        message = info.getDisplayName();
        result = "\t[FAIL]";
        Personcina p = new Personcina("luca", "coraci", 0, "200");
        assertEquals(NO_NAME, p.getName(),"Ho usato il costruttore inserendo un nome con la minuscola ma non mi compare il valore di default");
        assertEquals(NO_SURNAME, p.getSurname(),"Ho usato il costruttore inserendo un cognome con la minuscola ma non mi compare il valore di default");
        assertEquals(0,p.getDayOfWork(), "Ho usato il costruttore con argomenti ma il valore dayOfWork non corrisponde");
        result = "\t[SUCCESS][+4]";
        vote += 4f;
    }
    
    @Test
    @DisplayName("[Test Incaps.](4/4) Easy: 3.BASIC.0 cotruttore con arg., valori invalidi(null/empty)")
    public void test4(TestInfo info) {
        message = info.getDisplayName();
        result = "\t[FAIL]";
        Personcina p = new Personcina(null, null, 0, "200");
        assertEquals(NO_NAME, p.getName(),"Ho usato il costruttore inserendo un nome nullo ma non mi compare il valore di default");
        assertEquals(NO_SURNAME, p.getSurname(),"Ho usato il costruttore inserendo un cognome nullo ma non mi compare il valore di default");
        assertEquals(0,p.getDayOfWork(), "Ho usato il costruttore con argomenti ma il valore dayOfWork non corrisponde");
        Personcina p2 = new Personcina("", "", 0, "200");
        assertEquals(NO_NAME, p2.getName(),"Ho usato il costruttore inserendo un nome vuoto ma non mi compare il valore di default");
        assertEquals(NO_SURNAME, p2.getSurname(),"Ho usato il costruttore inserendo un cognome vuoto ma non mi compare il valore di default");
        assertEquals(0,p2.getDayOfWork(), "Ho usato il costruttore con argomenti ma il valore dayOfWork non corrisponde");
        result = "\t[SUCCESS][+4]";
        vote += 4f;
    }
    
    @Test
    @DisplayName("[Test Methods](1/3) Medium: 3.BASIC.1 isPostaPayValid(), invalid postapay")
    public void test5(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t[SKIPPED] (getPostapay dont work)";
        String postapay = "";
        Personcina p = new Personcina(null, null, 0, postapay);
        Assumptions.assumeTrue(p.getPostapay().equals(postapay));
        
        postapay = null;
        Personcina p2 = new Personcina(null, null, 0, postapay);
        Assumptions.assumeTrue(p2.getPostapay().equals(postapay));
        
        postapay = "1-2-3-4";
        Personcina p3 = new Personcina(null, null, 0, postapay);
        Assumptions.assumeTrue(p3.getPostapay().equals(postapay));
        
        postapay = "1222-1111-2222-";
        Personcina p4 = new Personcina(null, null, 0, postapay);
        Assumptions.assumeTrue(p4.getPostapay().equals(postapay));
        
        postapay = "3333-2222-1111-111A";
        Personcina p5 = new Personcina(null, null, 0, postapay);
        Assumptions.assumeTrue(p5.getPostapay().equals(postapay));
        
        postapay = "2222 -2222-1111-3333";
        Personcina p6 = new Personcina(null, null, 0, postapay);
        Assumptions.assumeTrue(p6.getPostapay().equals(postapay));
        
        postapay = "1111222233334444";
        Personcina p7 = new Personcina(null, null, 0, postapay);
        Assumptions.assumeTrue(p7.getPostapay().equals(postapay));
        
        result = "\t\t[FAIL]";
        
        
        
        assertFalse(p.isPostaPayValid(),"Ho inserito il codice: "+p.getPostapay()+" e mi doveva dire che NON e' valido.. ");
        assertFalse(p2.isPostaPayValid(),"Ho inserito il codice: "+p.getPostapay()+" e mi doveva dire che NON e' valido.. ");
        assertFalse(p3.isPostaPayValid(),"Ho inserito il codice: "+p.getPostapay()+" e mi doveva dire che NON e' valido.. ");
        assertFalse(p4.isPostaPayValid(),"Ho inserito il codice: "+p.getPostapay()+" e mi doveva dire che NON e' valido.. ");
        assertFalse(p5.isPostaPayValid(),"Ho inserito il codice: "+p.getPostapay()+" e mi doveva dire che NON e' valido.. ");
        assertFalse(p6.isPostaPayValid(),"Ho inserito il codice: "+p.getPostapay()+" e mi doveva dire che NON e' valido.. ");
        assertFalse(p7.isPostaPayValid(),"Ho inserito il codice: "+p.getPostapay()+" e mi doveva dire che NON e' valido.. ");
        
        

        result = "\t\t[SUCCESS][+8]";
        vote += 8f;
    }
    
    @Test
    @DisplayName("[Test Methods](2/3) Medium: 3.BASIC.1 isPostaPayValid(), valid postapay")
    public void test6(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t[SKIPPED] (getPostapay dont work)";
        String postapay = "";
        
        
        postapay = "1222-1111-2222-1121";
        Personcina p = new Personcina(null, null, 0, postapay);
        Assumptions.assumeTrue(p.getPostapay().equals(postapay));
        
        postapay = "0010-3089-8542-9876";
        Personcina p1 = new Personcina(null, null, 0, postapay);
        Assumptions.assumeTrue(p1.getPostapay().equals(postapay));
        
        
        result = "\t\t[FAIL]";
        
        
        
        assertTrue(p.isPostaPayValid(),"Ho inserito il codice: "+p.getPostapay()+" e mi doveva dire che NON e' valido.. ");
        assertTrue(p1.isPostaPayValid(),"Ho inserito il codice: "+p.getPostapay()+" e mi doveva dire che NON e' valido.. ");
        
        

        result = "\t\t[SUCCESS][+6]";
        vote += 6f;
    }
    
    @Test
    @DisplayName("[Test Methods](3/3) Medium: 3.BASIC.2 needsToBePayed")
    public void test7(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t\t\t\t[SKIPPED] (getPostapay dont work)";
        String postapay = "";
        
        
        postapay = "1222-1111-2222-1121";
        Personcina p = new Personcina(null, null, 40, postapay);
        Assumptions.assumeTrue(p.getPostapay().equals(postapay));
        
        postapay = "0010-3089-8542-9876";
        Personcina p1 = new Personcina(null, null, 5, postapay);
        Assumptions.assumeTrue(p1.getPostapay().equals(postapay));
        
        postapay = "0010-3089-8542-9826";
        Personcina p2 = new Personcina(null, null, 20, postapay);
        Assumptions.assumeTrue(p2.getPostapay().equals(postapay));
        
        postapay = "0010-3089-8542-98232";
        Personcina p3 = new Personcina(null, null, 23, postapay);
        Assumptions.assumeTrue(p3.getPostapay().equals(postapay));
        
        
        result = "\t\t\t\t\t[FAIL]";
        
        
        
        assertTrue(p.needsToBePayed(),"Ho inserito il codice: "+p.getPostapay()+" e ci sono "+p.getDayOfWork()+" day of work e mi doveva ritornare true");
        assertFalse(p1.needsToBePayed(),"Ho inserito il codice: "+p1.getPostapay()+" e ci sono "+p1.getDayOfWork()+" day of work e mi doveva ritornare false");
        assertTrue(p2.needsToBePayed(),"Ho inserito il codice: "+p2.getPostapay()+" e ci sono "+p2.getDayOfWork()+" day of work e mi doveva ritornare true");
        assertFalse(p3.needsToBePayed(),"Ho inserito il codice: "+p3.getPostapay()+" e ci sono "+p3.getDayOfWork()+" day of work e mi doveva ritornare false");
        
        
        

        result = "\t\t\t\t\t[SUCCESS][+5]";
        vote += 5f;
    }

   
    

}
