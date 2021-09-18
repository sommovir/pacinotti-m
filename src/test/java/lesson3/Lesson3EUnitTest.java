/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson3;

import it.cnr.paci.j4p.lesson3.esercizi.liste_basic.Treno;
import it.cnr.paci.j4p.lesson3.esercizi.liste_basic.Vagone;
import it.cnr.paci.j4p.lesson3.esercizi.liste_basic.VagoneType;
import it.cnr.paci.j4p.lesson3.esercizi.stringhe.RegistrationManager;
import java.math.BigDecimal;
import java.math.RoundingMode;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Disabled;

@Disabled
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class Lesson3EUnitTest {

    private String message;
    private String result;
    private static float vote = 0;
    private static final String INVALID = "INVALID";

    public Lesson3EUnitTest() {
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
            System.out.println("\t\t\tYOUR VOTE: 30 e Lode ! ");
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
    @DisplayName("[3.E.ENUM](1/1) Medium: Complex ENUM [build complex]")
    public void test3D1_1(TestInfo info) {

        message = info.getDisplayName();
        result = "\t\t\t\t[FAIL]";

        assertEquals("Questo vagone è una fantastica locomotiva", VagoneType.LOCOMOTIVA.getDescription(), "La descrizione di VagoneType.LOCOMOTIVA è sbagliata");
        assertEquals("Questo vagone contiene merci di scambio", VagoneType.MERCI.getDescription(), "La descrizione di VagoneType.LOCOMOTIVA è sbagliata");
        assertEquals("Questo vagone contiene persone di dubbia fiducia", VagoneType.PASSEGGERI.getDescription(), "La descrizione di VagoneType.LOCOMOTIVA è sbagliata");

        result = "\t\t\t\t[SUCCESS][+1.0]";
        vote += 1.0f;
    }

    @Test
    @DisplayName("[3.E.Vagone](1/1) Easy: Incapsulamento - costruttori [null/empty]")
    public void test3D1_2(TestInfo info) {

        message = info.getDisplayName();
        result = "\t\t\t\t[FAIL]";

        Vagone vagoneNullo = new Vagone();

        assertEquals(VagoneType.PASSEGGERI, vagoneNullo.getType(), "Ho usato il costruttore vuoto e il Type del vagone dovrebbe eessere Passeggeri");
        assertEquals("INVALID", vagoneNullo.getIdentificativo(), "Ho usato il costruttore vuoto e l'indentificativo dovrebbe essere INVALID");
        assertEquals("VUOTO", vagoneNullo.getMerce(), "Ho usato il costruttore vuoto e il campo merce dovrebbe essere VUOTO");

        Vagone vagoneNullo2 = new Vagone(null, null, null);

        assertEquals(VagoneType.PASSEGGERI, vagoneNullo2.getType(), "Ho usato il costruttore con args nulli e il Type del vagone dovrebbe eessere Passeggeri");
        assertEquals("INVALID", vagoneNullo2.getIdentificativo(), "Ho usato il costruttore con args nulli e l'indentificativo dovrebbe essere INVALID");
        assertEquals("VUOTO", vagoneNullo2.getMerce(), "Ho usato il costruttore con args nulli e il campo merce dovrebbe essere VUOTO");

        Vagone vagoneNullo3 = new Vagone(null, "", "");

        assertEquals("INVALID", vagoneNullo3.getIdentificativo(), "Ho usato il costruttore con args vuoti e l'indentificativo dovrebbe essere INVALID");
        assertEquals("VUOTO", vagoneNullo3.getMerce(), "Ho usato il costruttore con args vuoti e il campo merce dovrebbe essere VUOTO");

        result = "\t\t\t\t[SUCCESS][+2.0]";
        vote += 2.0f;
    }

    @Test
    @DisplayName("[3.E.Vagone](1/1) Easy: Incapsulamento - setters [valids]")
    public void test3D1_3(TestInfo info) {

        message = info.getDisplayName();
        result = "\t\t\t\t[FAIL]";

        Vagone vagoneNullo = new Vagone();
        vagoneNullo.setIdentificativo("13-AAG:GG-42");
        vagoneNullo.setMerce("Banane");
        vagoneNullo.setType(VagoneType.MERCI);

        assertEquals(VagoneType.MERCI, vagoneNullo.getType(), "avevo settato il vagone come vagone merci.. ma il getter mi da altro.");
        assertEquals("13-AAG:GG-42", vagoneNullo.getIdentificativo(), "Ho settato l'id dovrebbe essere 13-AAG:GG-42, il getter il da altro. Vergogna.");
        assertEquals("Banane", vagoneNullo.getMerce(), "Usando il setter ho settato Banane nel campo merce ma il getter mi da altro.");

        Vagone vagoneNullo2 = new Vagone(null, null, null);

        vagoneNullo2.setIdentificativo("13-AAG:GG-42");
        vagoneNullo2.setMerce("P1");
        vagoneNullo2.setType(VagoneType.PASSEGGERI);

        assertEquals(VagoneType.PASSEGGERI, vagoneNullo2.getType(), "avevo settato il vagone come vagone PASSEGGERI.. ma il getter mi da altro.");
        assertEquals("13-AAG:GG-42", vagoneNullo2.getIdentificativo(), "Ho settato l'id dovrebbe essere 13-AAG:GG-42, il getter il da altro. Vergogna.");
        assertEquals("P1", vagoneNullo2.getMerce(), "Usando il setter ho settato P1 nel campo merce ma il getter mi da altro.");

        result = "\t\t\t\t[SUCCESS][+2.0]";
        vote += 2.0f;
    }

    @Test
    @DisplayName("[3.E.Vagone](1/1) Easy: Incapsulamento - costruttore args [valids]")
    public void test3D1_4(TestInfo info) {

        message = info.getDisplayName();
        result = "\t\t\t\t[FAIL]";

        Vagone vagoneNullo2 = new Vagone(VagoneType.PASSEGGERI, "13-AAG:GG-42", "P10");

        assertEquals(VagoneType.PASSEGGERI, vagoneNullo2.getType(), "avevo settato il vagone come vagone PASSEGGERI.. ma il getter mi da altro.");
        assertEquals("13-AAG:GG-42", vagoneNullo2.getIdentificativo(), "Ho settato l'id dovrebbe essere 13-AAG:GG-42, il getter il da altro. Vergogna.");
        assertEquals("P10", vagoneNullo2.getMerce(), "Usando il setter ho settato P10 nel campo merce ma il getter mi da altro.");

        result = "\t\t\t\t[SUCCESS][+2.0]";
        vote += 2.0f;
    }

    @Test
    @DisplayName("[3.E.Vagone](1/1) Easy: Incapsulamento - costruttore args [invalids]")
    public void test3D1_5(TestInfo info) {

        message = info.getDisplayName();
        result = "\t\t\t\t[FAIL]";

        Vagone vagoneInvalido = new Vagone(VagoneType.PASSEGGERI, "13-AAG:GG-57", "P");

        assertEquals(VagoneType.PASSEGGERI, vagoneInvalido.getType(), "avevo settato il vagone come vagone PASSEGGERI.. ma il getter mi da altro.");
        assertEquals(INVALID, vagoneInvalido.getIdentificativo(), "Ho settato l'id con [13-AAG:GG-57] dovrebbe essere INVALID, il getter il da altro. Vergogna.");
        assertEquals(INVALID, vagoneInvalido.getMerce(), "Usando il setter ho settato P nel campo merce, dovrebbe darmi INVALID");

        Vagone vagoneInvalido2 = new Vagone(VagoneType.PASSEGGERI, "francafranchi", "10");

        assertEquals(VagoneType.PASSEGGERI, vagoneInvalido2.getType(), "avevo settato il vagone come vagone PASSEGGERI.. ma il getter mi da altro.");
        assertEquals(INVALID, vagoneInvalido2.getIdentificativo(), "Ho settato l'id con [francafranchi] dovrebbe essere INVALID, il getter il da altro. Vergogna.");
        assertEquals(INVALID, vagoneInvalido2.getMerce(), "Usando il setter ho settato 10  nel campo merce, dovrebbe darmi INVALID");

        Vagone vagoneInvalido3 = new Vagone(VagoneType.PASSEGGERI, "13-AAG:GGAAAAAAAAAAAAAA-57", "F9");

        assertEquals(VagoneType.PASSEGGERI, vagoneInvalido3.getType(), "avevo settato il vagone come vagone PASSEGGERI.. ma il getter mi da altro.");
        assertEquals(INVALID, vagoneInvalido3.getIdentificativo(), "Ho settato l'id con [13-AAG:GGAAAAAAAAAAAAAA-57] dovrebbe essere INVALID, il getter il da altro. Vergogna.");
        assertEquals(INVALID, vagoneInvalido3.getMerce(), "Usando il setter ho settato F9  nel campo merce, dovrebbe darmi INVALID");

        Vagone vagoneInvalido4 = new Vagone(VagoneType.PASSEGGERI, "13r-AAG:GGGG-44", "P010");

        assertEquals(VagoneType.PASSEGGERI, vagoneInvalido4.getType(), "avevo settato il vagone come vagone PASSEGGERI.. ma il getter mi da altro.");
        assertEquals(INVALID, vagoneInvalido4.getIdentificativo(), "Ho settato l'id con [13r-AAG:GGGG-44] dovrebbe essere INVALID, il getter il da altro. Vergogna.");
        assertEquals(INVALID, vagoneInvalido4.getMerce(), "Usando il setter ho settato P010  nel campo merce, dovrebbe darmi INVALID. AHAH fregato male");

        Vagone vagoneInvalido5 = new Vagone(VagoneType.PASSEGGERI, "13-AAG:GGGG-27", "Alfonso");

        assertEquals(VagoneType.PASSEGGERI, vagoneInvalido5.getType(), "avevo settato il vagone come vagone PASSEGGERI.. ma il getter mi da altro.");
        assertEquals(INVALID, vagoneInvalido5.getIdentificativo(), "Ho settato l'id con [13-AAG:GGGG-27] dovrebbe essere INVALID, il getter il da altro. Vergogna.");
        assertEquals(INVALID, vagoneInvalido5.getMerce(), "Usando il setter ho settato Alfonso  nel campo merce, dovrebbe darmi INVALID. AHAH fregato male");

        result = "\t\t\t\t[SUCCESS][+2.0]";
        vote += 2.0f;
    }

    @Test
    @DisplayName("[3.E.Treno](1/1) Easy: methods [getNumeroVagoni]")
    public void test3D1_6(TestInfo info) {

        message = info.getDisplayName();
        result = "\t\t\t\t[FAIL]";

        Treno treno = new Treno("ciuf", false);

        int numeroVagoni = treno.getNumeroVagoni();

        assertEquals(0, numeroVagoni, "Il treno è vuoto, il numero vagoni dovrebbe essere 0, invece è: " + numeroVagoni);

        Vagone vagone = new Vagone(VagoneType.LOCOMOTIVA, "12-09G:JJKHFI-56", "alfredo");
        treno.addVagone(vagone);

        numeroVagoni = treno.getNumeroVagoni();

        assertEquals(1, numeroVagoni, "Il treno ha solo la locomativo, il numero vagoni dovrebbe essere 1, invece è: " + numeroVagoni);

        Vagone vagone2 = new Vagone(VagoneType.MERCI, "12-09G:JJKHFI-55", "frutta e verdura");
        treno.addVagone(vagone2);

        numeroVagoni = treno.getNumeroVagoni();

        assertEquals(2, numeroVagoni, "Il treno ha una locomotiva e un vagone, il numero vagoni dovrebbe essere 2, invece è: " + numeroVagoni);

        result = "\t\t\t\t[SUCCESS][+2.0]";
        vote += 2.0f;
    }

    @Test
    @DisplayName("[3.E.Treno](1/1) Medium: methods [getNumeroVagoni/try force]")
    public void test3D1_7(TestInfo info) {

        message = info.getDisplayName();
        result = "\t\t\t\t[FAIL]";

        Treno treno = new Treno("ciuf", false);

        int numeroVagoni = treno.getNumeroVagoni();

        assertEquals(0, numeroVagoni, "Il treno è vuoto, il numero vagoni dovrebbe essere 0, invece è: " + numeroVagoni);

        Vagone vagone = new Vagone(VagoneType.LOCOMOTIVA, "12-09G:JJKHFI-56", "alfredo");
        treno.addVagone(vagone);

        numeroVagoni = treno.getNumeroVagoni();

        assertEquals(1, numeroVagoni, "Il treno ha solo la locomativo, il numero vagoni dovrebbe essere 1, invece è: " + numeroVagoni);

        Vagone vagone2 = new Vagone(VagoneType.MERCI, "12-09G:JJKHFI-55", "frutta e verdura");
        treno.addVagone(vagone2);

        numeroVagoni = treno.getNumeroVagoni();

        assertEquals(2, numeroVagoni, "Il treno ha una locomotiva e un vagone, il numero vagoni dovrebbe essere 2, invece è: " + numeroVagoni);

        Vagone vagone3 = new Vagone(VagoneType.LOCOMOTIVA, "12-09G:JJKHFI-43", "coda");
        treno.addVagone(vagone3);

        numeroVagoni = treno.getNumeroVagoni();

        assertEquals(3, numeroVagoni, "Il treno ha una locomotiva e un vagone e un altra locomotiva, il numero vagoni dovrebbe essere 3, invece è: " + numeroVagoni);
        
        
        Vagone vagone4 = new Vagone(VagoneType.LOCOMOTIVA, "12-09G:JJKHFI-43", "coda");
        treno.addVagone(vagone4);

        numeroVagoni = treno.getNumeroVagoni();

        assertEquals(3, numeroVagoni, "(ho provato a forzare il metodo add) Il treno ha una locomotiva e un vagone e un altra locomotiva, il numero vagoni dovrebbe essere 3, invece è: " + numeroVagoni);

        result = "\t\t\t\t[SUCCESS][+2.0]";
        vote += 2.0f;
    }
    
    
    @Test
    @DisplayName("[3.E.Treno](1/1) Medium: methods [isValid]")
    public void test3D1_8(TestInfo info) {

        message = info.getDisplayName();
        result = "\t\t\t\t[FAIL]";

        Treno treno = new Treno("ciuf", false);



        Vagone vagone = new Vagone(VagoneType.LOCOMOTIVA, "12-09G:JJKHFI-56", "alfredo");
        Vagone vagone2 = new Vagone(VagoneType.PASSEGGERI, "12-09G:JJKHFI-53", "P9");
        Vagone vagone3 = new Vagone(VagoneType.PASSEGGERI, "12-09G:JJKHFI-52", "P34");
        Vagone vagone4 = new Vagone(VagoneType.LOCOMOTIVA, "12-09G:JJKHFI-51", "alfredo");
        
        treno.addVagone(vagone);
        treno.addVagone(vagone2);
        treno.addVagone(vagone3);
        treno.addVagone(vagone4);
       
        boolean valid = treno.isValid();
        assertTrue(valid,"Il treno è valido invece mi hai detto: "+valid);
        
        
        
        Treno treno2 = new Treno("ciuf", false);



        Vagone vagone5 = new Vagone(VagoneType.LOCOMOTIVA, "12-09G:JJKHFI-56", "alfredo");
        Vagone vagone6 = new Vagone(VagoneType.PASSEGGERI, "12-09G:JJKHFI-53", "P9");
        
        treno2.addVagone(vagone5);
        treno2.addVagone(vagone6);
       
        boolean valid2 = treno2.isValid();
        assertTrue(valid2,"Il treno [LOCOMOTIVA, PASSEGGERI] è valido invece mi hai detto: "+valid);
        
        
        Treno treno3 = new Treno("ciuf", false);
        treno3.addVagone(vagone5);
        boolean valid4 = treno3.isValid();
        assertFalse(valid4,"Il treno [LOCOMOTIVA] NON è valido invece mi hai detto: "+valid);
        


        result = "\t\t\t\t[SUCCESS][+2.0]";
        vote += 2.0f;
    }

    
    
    @Test
    @DisplayName("[3.E.Treno](1/1) Medium: methods [isTrenoMerci]")
    public void test3D1_9(TestInfo info) {

        message = info.getDisplayName();
        result = "\t\t\t\t[FAIL]";

        Treno treno = new Treno("ciuf", false);



        Vagone vagone = new Vagone(VagoneType.LOCOMOTIVA, "12-09G:JJKHFI-56", "alfredo");
        Vagone vagone2 = new Vagone(VagoneType.PASSEGGERI, "12-09G:JJKHFI-53", "P9");
        Vagone vagone3 = new Vagone(VagoneType.PASSEGGERI, "12-09G:JJKHFI-52", "P34");
        Vagone vagone4 = new Vagone(VagoneType.LOCOMOTIVA, "12-09G:JJKHFI-51", "alfredo");
        
        treno.addVagone(vagone);
        treno.addVagone(vagone2);
        treno.addVagone(vagone3);
        treno.addVagone(vagone4);
       
        boolean valid = treno.isTrenoMerci();
        assertFalse(valid,"Il treno non è un treno merci invece mi hai detto: "+valid);
        
        
        
        Treno treno2 = new Treno("ciuf", false);



        Vagone vagone5 = new Vagone(VagoneType.LOCOMOTIVA, "12-09G:JJKHFI-56", "alfredo");
        Vagone vagone6 = new Vagone(VagoneType.MERCI, "12-09G:JJKHFI-53", "Carne");
        Vagone vagone61 = new Vagone(VagoneType.MERCI, "12-09G:JJKHFI-53", "Pollo secco");
        Vagone vagone62 = new Vagone(VagoneType.MERCI, "12-09G:JJKHFI-53", "Animali morti");
        
        treno2.addVagone(vagone5);
        treno2.addVagone(vagone6);
        treno2.addVagone(vagone61);
        treno2.addVagone(vagone62);
       
        boolean valid2 = treno2.isValid();
        assertTrue(valid2,"Il treno è un treno passeggeri invece mi hai detto: "+valid);
        


        result = "\t\t\t\t[SUCCESS][+2.0]";
        vote += 2.0f;
    }
}
