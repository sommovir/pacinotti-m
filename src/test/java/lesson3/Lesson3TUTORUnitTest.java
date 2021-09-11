/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson3;

import it.cnr.paci.j4p.lesson3.esercizi.stringhe.Account;
import it.cnr.paci.j4p.lesson3.esercizi.stringhe.RegistrationManager;
import it.cnr.paci.j4p.lesson3.esercizi.stringhe_basic.MilitaryOrder;
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
public class Lesson3TUTORUnitTest {

    private static final String INVALID = "INVALID";
    private String message;
    private String result;
    private static float vote = 0;

    public Lesson3TUTORUnitTest() {
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

    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
        System.out.println("[Test Module][L3 TUTOR]" + message + ": " + result);
    }

    @Test
    @DisplayName("[Test Incaps.](1/3) Easy: 3.TUTOR.0 cotruttore vuoto")
    public void test1(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t\t\t\t[MISERY]";
        MilitaryOrder o = new MilitaryOrder();
        assertEquals(INVALID, o.getCommander(), "Ho usato il costruttore vuoto ma il valore commander non risulta inizializzato");
        assertEquals(INVALID, o.getOrder(), "Ho usato il costruttore vuoto ma il valore order non risulta inizializzato");
        result = "\t\t\t\t\t[SUCCESS][+2]";
        vote += 2f;
    }

    @Test
    @DisplayName("[Test Incaps.](2/3) Easy: 3.TUTOR.0 cotruttore con argomenti (null,null) / empty")
    public void test2(TestInfo info) {
        message = info.getDisplayName();
        result = "\t[DISGRACE]";
        MilitaryOrder o = new MilitaryOrder(null, null);
        assertEquals(INVALID, o.getCommander(), "Ho usato il costruttore con argomenti, ho passato null a commander ma il getter non mi dice che è INVALID");
        assertEquals(INVALID, o.getOrder(), "Ho usato il costruttore con argomenti, ho passato null a order ma il getter non mi dice che è INVALID");
        MilitaryOrder o2 = new MilitaryOrder("", "");
        assertEquals(INVALID, o2.getCommander(), "Ho usato il costruttore con argomenti, ho passato -empty- a commander ma il getter non mi dice che è INVALID");
        assertEquals(INVALID, o2.getOrder(), "Ho usato il costruttore con argomenti, ho passato -empty- a order ma non mi il getter dice che è INVALID");
        result = "\t[SUCCESS][+2]";
        vote += 2f;
    }

    @Test
    @DisplayName("[Test Incaps.](3/3) Medium: 3.TUTOR.0 cotruttore con argomenti validi (ok,ok)")
    public void test3(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t[FAIL]";
        MilitaryOrder o = new MilitaryOrder("Ten. Strapponi", "8330hsijd9029dhNUC099nsadajsdja9");
        assertEquals("Ten. Strapponi", o.getCommander(), "Ho usato il costruttore con argomenti, ho passato valore valido [Ten. Strapponi] a commander ma mi dice che è INVALID");
        assertEquals("8330hsijd9029dhNUC099nsadajsdja9", o.getOrder(), "Ho usato il costruttore con argomenti, ho passato valore valido [8330hsijd9029dhNUC099nsadajsdja9] a order ma mi dice che è INVALID");

        MilitaryOrder o2 = new MilitaryOrder("Gen. Incellone", "NUCCUN5");
        assertEquals("Gen. Incellone", o2.getCommander(), "Ho usato il costruttore con argomenti, ho passato valore valido [Gen. Incellone] a commander ma mi dice che è INVALID");
        assertEquals("NUCCUN5", o2.getOrder(), "Ho usato il costruttore con argomenti, ho passato valore valido [NUCCUN5] a order ma mi dice che è INVALID");

        MilitaryOrder o3 = new MilitaryOrder("Gen. Spugnonodrov", "moravi NUC 1a");
        assertEquals("en. Spugnonodrov", o3.getCommander(), "Ho usato il costruttore con argomenti, ho passato valore valido [Gen. Spugnonodrov] a commander ma mi dice che è INVALID");
        assertEquals("moravi NUC 1a", o3.getOrder(), "Ho usato il costruttore con argomenti, ho passato valore valido [moravi NUC 1a] a order ma mi dice che è INVALID");
        result = "\t\t[SUCCESS][+6]";
        vote += 6f;
    }

    @Test
    @DisplayName("[Test Setters.](1/2) Easy: 3.TUTOR.0 setter nulli/vuoti")
    public void tes41(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t\t[FAIL]";
        MilitaryOrder o = new MilitaryOrder("Ten. Minchi", "sd892ujdasokdjNUC asiddajsidii");
        o.setOrder(null);
        o.setCommander(null);
        assertEquals(INVALID, o.getCommander(), "Ho usato il setter con argomento null ma il valore commander non risulta INVALID");
        assertEquals(INVALID, o.getOrder(), "Ho usato il setter con argomento null ma il valore order non risulta INVALID");

        MilitaryOrder o2 = new MilitaryOrder("Ten. Minchi", "sd892ujdasokdjNUC asiddajsidii");
        o2.setOrder("");
        o2.setCommander("");
        assertEquals(INVALID, o2.getCommander(), "Ho usato il setter passandogli una stringa vuota ma il valore commander non risulta INVALID");
        assertEquals(INVALID, o2.getOrder(), "Ho usato il setter passandogli unas tringa vuota ma il valore order non risulta INVALID");

        result = "\t\t\t[SUCCESS][+3]";
        vote += 3f;
    }

    @Test
    @DisplayName("[Test Setters.](2/2) Easy: 3.TUTOR.0 costruttore vuoto, setter validi")
    public void tes5(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t[FAIL]";
        MilitaryOrder o = new MilitaryOrder("", null);
        o.setOrder("8330hsijd9029dhNUC099nsadajsdja9");
        o.setCommander("Ten. Strapponi");
        assertEquals("Ten. Strapponi", o.getCommander(), "Ho usato il costruttore con argomenti invalidi, poi ho passato valore valido [Ten. Strapponi] a commander ma mi dice che è INVALID");
        assertEquals("8330hsijd9029dhNUC099nsadajsdja9", o.getOrder(), "Ho usato il costruttore con argomenti invalidi, poi ho passato valore valido [8330hsijd9029dhNUC099nsadajsdja9] a order ma mi dice che è INVALID");

        result = "\t\t[SUCCESS][+3]";
        vote += 3f;
    }

    @Test
    @DisplayName("[Test Invalids.](1/2) Medium: 3.TUTOR.0  - commander")
    public void tes6(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t\t\t[FAIL]";
        MilitaryOrder o = new MilitaryOrder("Gen. Pollo", null);
        MilitaryOrder o2 = new MilitaryOrder("Gen.Pollo", null);
        MilitaryOrder o3 = new MilitaryOrder("Gen. pollo", null);
        MilitaryOrder o4 = new MilitaryOrder("Genio. Pollo", null);
        MilitaryOrder o5 = new MilitaryOrder("Gen Pollo", null);
        MilitaryOrder o6 = new MilitaryOrder("Ten. Pollo", null);
        MilitaryOrder o7 = new MilitaryOrder("Ten. Pollo2", null);
        MilitaryOrder o8 = new MilitaryOrder("Asc. aPollo", null);
        MilitaryOrder o9 = new MilitaryOrder("ten. Pollo", null);

        assertEquals("Gen. Pollo", o.getCommander(), "Ho inserito un nome commander valido, e mi hai deluso dicendomi che è INVALID");
        assertEquals(INVALID, o2.getCommander(), "Ho inserito un nome commander invalido, e mi hai deluso non dicendomi che è INVALID");
        assertEquals(INVALID, o3.getCommander(), "Ho inserito un nome commander invalido, e mi hai deluso non dicendomi che è INVALID");
        assertEquals(INVALID, o4.getCommander(), "Ho inserito un nome commander invalido, e mi hai deluso non dicendomi che è INVALID");
        assertEquals(INVALID, o5.getCommander(), "Ho inserito un nome commander invalido, e mi hai deluso non dicendomi che è INVALID");
        assertEquals(INVALID, o6.getCommander(), "Ho inserito un nome commander invalido, e mi hai deluso non dicendomi che è INVALID");
        assertEquals(INVALID, o7.getCommander(), "Ho inserito un nome commander invalido, e mi hai deluso non dicendomi che è INVALID");
        assertEquals(INVALID, o8.getCommander(), "Ho inserito un nome commander invalido, e mi hai deluso non dicendomi che è INVALID");
        assertEquals(INVALID, o9.getCommander(), "Ho inserito un nome commander invalido, e mi hai deluso non dicendomi che è INVALID");

        result = "\t\t\t\t[SUCCESS][+6]";
        vote += 6f;
    }

    @Test
    @DisplayName("[Test Invalids.](2/2) HARD: 3.TUTOR.0  - commander")
    public void tes7(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t\t\t[FAIL]";
        MilitaryOrder o = new MilitaryOrder(null, ".");
        MilitaryOrder o2 = new MilitaryOrder(null, "8ashjdasd9asid");
        MilitaryOrder o3 = new MilitaryOrder(null, "NUC");
        MilitaryOrder o4 = new MilitaryOrder(null, "momomisajd999NUC12");
        MilitaryOrder o5 = new MilitaryOrder(null, "NUCNA");
        MilitaryOrder o6 = new MilitaryOrder(null, "NCNA");
        MilitaryOrder o7 = new MilitaryOrder(null, "nuca");
        MilitaryOrder o8 = new MilitaryOrder(null, "---3ueuhfajdf");

        assertEquals(INVALID, o.getCommander(), "Ho inserito un order invalido, e mi hai deluso non dicendomi che è INVALID");
        assertEquals(INVALID, o2.getCommander(), "Ho inserito un order invalido, e mi hai deluso non dicendomi che è INVALID");
        assertEquals(INVALID, o3.getCommander(), "Ho inserito un order invalido, e mi hai deluso non dicendomi che è INVALID");
        assertEquals(INVALID, o4.getCommander(), "Ho inserito un order invalido, e mi hai deluso non dicendomi che è INVALID");
        assertEquals(INVALID, o5.getCommander(), "Ho inserito un order invalido, e mi hai deluso non dicendomi che è INVALID");
        assertEquals(INVALID, o6.getCommander(), "Ho inserito un order invalido, e mi hai deluso non dicendomi che è INVALID");
        assertEquals(INVALID, o7.getCommander(), "Ho inserito un order invalido, e mi hai deluso non dicendomi che è INVALID");
        assertEquals(INVALID, o8.getCommander(), "Ho inserito un order invalido, e mi hai deluso non dicendomi che è INVALID");

        result = "\t\t\t\t[SUCCESS][+4]";
        vote += 4f;
    }

    @Test
    @DisplayName("[Test Methods](1/2) HARD: 3.TUTOR.3  - isLaunchOrder")
    public void tes8(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t\t\t[FAIL]";
        String launchCode = "alphaNUCaaaa";
        MilitaryOrder o = new MilitaryOrder(null, launchCode);
        boolean launchOrder = o.isLaunchOrder();

        String launchCode2 = "alphaNUC11a";
        MilitaryOrder o2 = new MilitaryOrder(null, launchCode2);
        boolean launchOrder2 = o2.isLaunchOrder();

        String launchCode3 = "8ausdajsndalkjhdsNUCm8a2";
        MilitaryOrder o3 = new MilitaryOrder(null, launchCode3);
        boolean launchOrder3 = o3.isLaunchOrder();

        String launchCode4 = "alphaNUC11111111111";
        MilitaryOrder o4 = new MilitaryOrder(null, launchCode4);
        boolean launchOrder4 = o4.isLaunchOrder();

        String launchCode5 = "alphaNUC001N";
        MilitaryOrder o5 = new MilitaryOrder(null, launchCode5);
        boolean launchOrder5 = o5.isLaunchOrder();

        assertTrue(launchOrder, "Ho inserito un codice di lancio: [" + launchCode + "] ma non è stato riconosciuto correttamente");
        assertTrue(launchOrder2, "Ho inserito un codice di lancio: [" + launchCode2 + "] ma non è stato riconosciuto correttamente");
        assertTrue(launchOrder3, "Ho inserito un codice di lancio: [" + launchCode3 + "] ma non è stato riconosciuto correttamente");
        assertFalse(launchOrder4, "Ho inserito un codice di ripristino: [" + launchCode4 + "] ma non è stato riconosciuto correttamente");
        assertFalse(launchOrder5, "Ho inserito un codice di ripristino: [" + launchCode5 + "] ma non è stato riconosciuto correttamente");

        result = "\t\t\t[SUCCESS][+3]";
        vote += 3f;
    }

    @Test
    @DisplayName("[Test Methods](2/2) EASY: 3.TUTOR.4  - isValid")
    public void tes9(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t\t\t\t[FAIL]";
        MilitaryOrder o = new MilitaryOrder(null, "aishdhACNUC29292");
        boolean valid = o.isValid();

        MilitaryOrder o2 = new MilitaryOrder("Gen. Pollastra", "aishdhACNUC29292");
        boolean valid2 = o2.isValid();

        MilitaryOrder o3 = new MilitaryOrder("Gen. Pollastra", "ahsudahsdadsasd");
        boolean valid3 = o3.isValid();

        MilitaryOrder o4 = new MilitaryOrder("Sen. Pollastra", "");
        boolean valid4 = o4.isValid();

        assertFalse(valid, "commander invalido, codice valido... ma mi hai detto che è valido");
        assertTrue(valid2, "commander valido, codice valido... ma mi hai detto che è invalido");
        assertFalse(valid3, "commander valido, codice invalido... ma mi hai detto che è valido");
        assertFalse(valid4, "commander invalido, codice invalido... ma mi hai detto che è valido");

        result = "\t\t\t\t\t[SUCCESS][+2]";
        vote += 2f;
    }

//    @Test
//    @DisplayName("[Test Incaps.](1/4) MEDIUM: 3.TUTOR.0 cotruttore con argomenti validi (ok,ok)")
//    public void test4(TestInfo info) {
//        message = info.getDisplayName();
//        result = "\t\t\t\t\t[DISGRACE]";
//        MilitaryOrder o = new MilitaryOrder("Ten. Strapponi", "8330hsijd9029dhNUC099nsadajsdja9");
//        assertEquals("Ten. Strapponi", o.getCommander(), "Ho usato il costruttore con argomenti, ho passato valore valido [Ten. Strapponi] a commander ma mi dice che è INVALID");
//        assertEquals("8330hsijd9029dhNUC099nsadajsdja9", o.getOrder(), "Ho usato il costruttore con argomenti, ho passato valore valido [8330hsijd9029dhNUC099nsadajsdja9] a order ma mi dice che è INVALID");
//       
//        MilitaryOrder o2 = new MilitaryOrder("Gen. Incellone", "NUCCUN5");
//        assertEquals("Ten. Strapponi", o2.getCommander(), "Ho usato il costruttore con argomenti, ho passato valore valido [Gen. Incellone] a commander ma mi dice che è INVALID");
//        assertEquals("NUCCUN5", o2.getOrder(), "Ho usato il costruttore con argomenti, ho passato valore valido [NUCCUN5] a order ma mi dice che è INVALID");
//       
//        MilitaryOrder o3 = new MilitaryOrder("Gen. Spugnonodrov", "moravi NUC 1a");
//        assertEquals("Gen. Spugnonodrov", o3.getCommander(), "Ho usato il costruttore con argomenti, ho passato valore valido [Gen. Spugnonodrov] a commander ma mi dice che è INVALID");
//        assertEquals("moravi NUC 1a", o3.getOrder(), "Ho usato il costruttore con argomenti, ho passato valore valido [moravi NUC 1a] a order ma mi dice che è INVALID");
//        result = "\t\t\t\t\t[SUCCESS][+2]";
//        vote += 2f;
//    }
}
