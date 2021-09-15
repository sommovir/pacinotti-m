/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson3;

import it.cnr.paci.j4p.lesson3.esercizi.enums_parsing.CommandType;
import it.cnr.paci.j4p.lesson3.esercizi.enums_parsing.EsercizioParsing;
import it.cnr.paci.j4p.lesson3.esercizi.stringhe.RegistrationManager;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Disabled;

@Disabled
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class Lesson3CUnitTest {

    private String message;
    private String result;
    private static float vote = 0;

    public Lesson3CUnitTest() {
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
    @DisplayName("[3.C.1](1/5) Easy: checkSyntax [null/empty]")
    public void test3C1_1(TestInfo info) {

        message = info.getDisplayName();
        result = "\t\t\t\t[FAIL]";

        boolean checkSyntax = EsercizioParsing.checkSyntax(null, "command -quit 10");
        boolean checkSyntax1 = EsercizioParsing.checkSyntax(CommandType.QUIT, null);
        boolean checkSyntax2 = EsercizioParsing.checkSyntax(CommandType.QUIT, "");

        assertFalse(checkSyntax, "Ho passato null come CommandType, mi aspetto che mi restituisca false");
        assertFalse(checkSyntax1, "Ho passato null come stringa da valutare, mi aspetto che mi restituisca false");
        assertFalse(checkSyntax2, "Ho passato una stringa vuota come stringa da valutare, mi aspetto che mi restituisca false");

        result = "\t\t\t\t[SUCCESS][+1.0]";
        vote += 1.0f;
    }

    @Test
    @DisplayName("[3.C.1](2/5) Easy: checkSyntax [CommandType.UNKNOWN]")
    public void test3C1_2(TestInfo info) {

        message = info.getDisplayName();
        result = "\t\t\t[FAIL]";

        boolean checkSyntax = EsercizioParsing.checkSyntax(CommandType.UNKNOWN, "command -quit 10");
        boolean checkSyntax1 = EsercizioParsing.checkSyntax(CommandType.UNKNOWN, "");
        boolean checkSyntax2 = EsercizioParsing.checkSyntax(CommandType.UNKNOWN, "sdfsfs");

        assertFalse(checkSyntax, "Sto controllando un CommandType di tipo UNKNOWN e mi deve ritornare false");
        assertFalse(checkSyntax1, "Sto controllando un CommandType di tipo UNKNOWN e mi deve ritornare false");
        assertFalse(checkSyntax2, "Sto controllando un CommandType di tipo UNKNOWN e mi deve ritornare false");

        result = "\t\t\t[SUCCESS][+1.0]";
        vote += 1.0f;
    }

    @Test
    @DisplayName("[3.C.1](3/5) Medium: checkSyntax [CommandType.QUIT]")
    public void test3C1_3(TestInfo info) {

        message = info.getDisplayName();
        result = "\t\t\t[FAIL]";

        boolean checkSyntax = EsercizioParsing.checkSyntax(CommandType.QUIT, "command -quit 10"); //ok
        boolean checkSyntax0 = EsercizioParsing.checkSyntax(CommandType.QUIT, "command -quit 150");//ok
        boolean checkSyntax1 = EsercizioParsing.checkSyntax(CommandType.QUIT, "");
        boolean checkSyntax2 = EsercizioParsing.checkSyntax(CommandType.QUIT, "-quit 10");
        boolean checkSyntax3 = EsercizioParsing.checkSyntax(CommandType.QUIT, "command-quit 10");
        boolean checkSyntax4 = EsercizioParsing.checkSyntax(CommandType.QUIT, "command -quit10");
        boolean checkSyntax5 = EsercizioParsing.checkSyntax(CommandType.QUIT, "command -quit ac");
        boolean checkSyntax6 = EsercizioParsing.checkSyntax(CommandType.QUIT, "command -quit -12"); //ok
        boolean checkSyntax7 = EsercizioParsing.checkSyntax(CommandType.QUIT, "command -quit 4B");
        boolean checkSyntax8 = EsercizioParsing.checkSyntax(CommandType.QUIT, "command -speak ciao");

        assertTrue(checkSyntax, "Command QUIT, testando con: [command -quit 10] e dovrebbe dirmi che è valido.. e invece..");
        assertTrue(checkSyntax0, "Command QUIT, testando con: [command -quit 150] e dovrebbe dirmi che è valido.. e invece..");
        assertFalse(checkSyntax1, "Command QUIT, testando con: [] e dovrebbe dirmi che non è valido.. e invece..");
        assertFalse(checkSyntax2, "Command QUIT, testando con: [-quit 10] e dovrebbe dirmi che non è valido.. e invece..");
        assertFalse(checkSyntax3, "Command QUIT, testando con: [command-quit 10] e dovrebbe dirmi che non è valido.. e invece..");
        assertFalse(checkSyntax4, "Command QUIT, testando con: [command -quit10] e dovrebbe dirmi che non è valido.. e invece..");
        assertFalse(checkSyntax5, "Command QUIT, testando con: [command -quit ac] e dovrebbe dirmi che non è valido.. e invece..");
        assertTrue(checkSyntax6, "Command QUIT, testando con: [command -quit -12] e dovrebbe dirmi che è valido.. e invece..");
        assertFalse(checkSyntax7, "Command QUIT, testando con: [command -quit 4B] e dovrebbe dirmi che non è valido.. e invece..");
        assertFalse(checkSyntax8, "Command QUIT, testando con: [command -quit ciao] e dovrebbe dirmi che non è valido.. e invece..");

        result = "\t\t\t[SUCCESS][+2.0]";
        vote += 2.0f;
    }

    @Test
    @DisplayName("[3.C.1](4/5) Medium: checkSyntax [CommandType.SPEAK]")
    public void test3C1_4(TestInfo info) {

        message = info.getDisplayName();
        result = "\t\t\t[FAIL]";

        boolean checkSyntax = EsercizioParsing.checkSyntax(CommandType.SPEAK, "command -speak ciao"); //ok
        boolean checkSyntax0 = EsercizioParsing.checkSyntax(CommandType.SPEAK, "command -speak ciao a tutti"); //ok
        boolean checkSyntax1 = EsercizioParsing.checkSyntax(CommandType.SPEAK, "command -speak come va stasera ?"); //ok
        boolean checkSyntax2 = EsercizioParsing.checkSyntax(CommandType.SPEAK, "command -speak secondo te 3-2 fa 1 ?"); //ok

        boolean checkSyntax3 = EsercizioParsing.checkSyntax(CommandType.SPEAK, "command -speakciao"); //not
        boolean checkSyntax4 = EsercizioParsing.checkSyntax(CommandType.SPEAK, "comm -speak ciao"); //not
        boolean checkSyntax5 = EsercizioParsing.checkSyntax(CommandType.SPEAK, "sadjasiodjasd"); //not
        boolean checkSyntax6 = EsercizioParsing.checkSyntax(CommandType.SPEAK, "command speak ciao"); //not
        boolean checkSyntax7 = EsercizioParsing.checkSyntax(CommandType.SPEAK, "command -s ciao a te"); //not

        assertTrue(checkSyntax, "Command SPEAK, testando con: [command -speak ciao] e dovrebbe dirmi che è valido.. purtroppo non è così.");
        assertTrue(checkSyntax0, "Command SPEAK, testando con: [command -speak ciao a tutti] e dovrebbe dirmi che è valido.. purtroppo non è così.");
        assertTrue(checkSyntax1, "Command SPEAK, testando con: [command -speak come va stasera ?] e dovrebbe dirmi che è valido.. purtroppo non è così.");
        assertTrue(checkSyntax2, "Command SPEAK, testando con: [command -speak secondo te 3-2 fa 1 ?] e dovrebbe dirmi che è valido.. purtroppo non è così.");

        assertFalse(checkSyntax3, "Command SPEAK, testando con: [command -speakciao] e dovrebbe dirmi che NON è valido.. ma la vede valida.");
        assertFalse(checkSyntax4, "Command SPEAK, testando con: [comm -speak ciao] e dovrebbe dirmi che NON è valido.. ma la vede valida.");
        assertFalse(checkSyntax5, "Command SPEAK, testando con: [sadjasiodjasd] e dovrebbe dirmi che NON è valido.. ma la vede valida.");
        assertFalse(checkSyntax6, "Command SPEAK, testando con: [command speak ciao] e dovrebbe dirmi che NON è valido.. ma la vede valida.");
        assertFalse(checkSyntax7, "Command SPEAK, testando con: [command -s ciao a te] e dovrebbe dirmi che NON è valido.. ma la vede valida.");

        result = "\t\t\t[SUCCESS][+2.0]";
        vote += 2.0f;
    }

    @Test
    @DisplayName("[3.C.1](5/5) EXTREME: checkSyntax [CommandType.TABLE]")
    public void test3C1_5(TestInfo info) {

        message = info.getDisplayName();
        result = "\t\t\t[FAIL]\n------------------------------------------------------------------------------------------------------------------------";

        boolean checkSyntax = EsercizioParsing.checkSyntax(CommandType.TABLE, "command -table (Viti,20):(Chiodi,43):(Maniglie,2)"); //ok
        boolean checkSyntax0 = EsercizioParsing.checkSyntax(CommandType.TABLE, "command -table (Amici,+1):(Temperatura,-3)"); //ok
        boolean checkSyntax1 = EsercizioParsing.checkSyntax(CommandType.TABLE, "command -table (Amici,0)"); //ok
        boolean checkSyntax1bis = EsercizioParsing.checkSyntax(CommandType.TABLE, "command -table (Amici,0):(A,B)"); //ok
        boolean checkSyntax1tris = EsercizioParsing.checkSyntax(CommandType.TABLE, "command -table (Amici)"); //ok
        boolean checkSyntax1quater = EsercizioParsing.checkSyntax(CommandType.TABLE, "command -table (Amici,0,ciao):(A,B,C)"); //ok

        boolean checkSyntax3 = EsercizioParsing.checkSyntax(CommandType.TABLE, "command -speak ciao"); //not
        boolean checkSyntax4 = EsercizioParsing.checkSyntax(CommandType.TABLE, "command -quit 10"); //not
        boolean checkSyntax5 = EsercizioParsing.checkSyntax(CommandType.TABLE, "command -table(Amici,0):(Temperatura,-3)"); //not
        boolean checkSyntax6 = EsercizioParsing.checkSyntax(CommandType.TABLE, "command -table (Amici,0):Temperatura,-3)"); //not
        boolean checkSyntax7 = EsercizioParsing.checkSyntax(CommandType.TABLE, "command -table (Amici,0):(Temperatura,-3"); //not
        boolean checkSyntax8 = EsercizioParsing.checkSyntax(CommandType.TABLE, "command-table (Amici,0):(Temperatura,-3"); //not
        boolean checkSyntax9 = EsercizioParsing.checkSyntax(CommandType.TABLE, "command -table Amici,0):(Temperatura,-3)"); //not

        assertTrue(checkSyntax, "Command TABLE, testando con: [command -table (Viti,20):(Chiodi,43):(Maniglie,2)] e dovrebbe dirmi che è valido.. purtroppo non è così.");
        assertTrue(checkSyntax0, "Command TABLE, testando con: [command -table (Amici,+1):(Temperatura,-3)] e dovrebbe dirmi che è valido.. purtroppo non è così.");
        assertTrue(checkSyntax1, "Command TABLE, testando con: [command -table (Amici,0)] e dovrebbe dirmi che è valido.. purtroppo non è così.");
        assertTrue(checkSyntax1bis, "Command TABLE, testando con: [command -table (Amici,0):(A,B)] e dovrebbe dirmi che è valido.. purtroppo non è così.");
        assertTrue(checkSyntax1tris, "Command TABLE, testando con: [command -table (Amici)] e dovrebbe dirmi che è valido.. purtroppo non è così.");
        assertTrue(checkSyntax1quater, "Command TABLE, testando con: [command -table (Amici,0,ciao):(A,B,C)] e dovrebbe dirmi che è valido.. purtroppo non è così.");

        assertFalse(checkSyntax3, "Command TABLE, testando con: [command -speak ciao] e dovrebbe dirmi che NON è valido.. ma la vede valida.");
        assertFalse(checkSyntax4, "Command TABLE, testando con: [command -quit 10] e dovrebbe dirmi che NON è valido.. ma la vede valida.");
        assertFalse(checkSyntax5, "Command TABLE, testando con: [command -tableAmici,0)(Temperatura,-3)] e dovrebbe dirmi che NON è valido.. ma la vede valida.");
        assertFalse(checkSyntax6, "Command TABLE, testando con: [command -table (Amici,0):Temperatura,-3)] e dovrebbe dirmi che NON è valido.. ma la vede valida.");
        assertFalse(checkSyntax7, "Command TABLE, testando con: [command -table (Amici,0):(Temperatura,-3] e dovrebbe dirmi che NON è valido.. ma la vede valida.");
        assertFalse(checkSyntax8, "Command TABLE, testando con: [command-table (Amici,0):(Temperatura,-3] e dovrebbe dirmi che NON è valido.. ma la vede valida.");
        assertFalse(checkSyntax9, "Command TABLE, testando con: [command -table Amici,0):(Temperatura,-3)] e dovrebbe dirmi che NON è valido.. ma la vede valida.");

        result = "\t\t\t[SUCCESS][+3.0]\n------------------------------------------------------------------------------------------------------------------------";
        vote += 3.0f;
    }

    @Test
    @DisplayName("[3.C.2](1/2) Medium: countTableRow [null/empty/invalid]")
    public void test3C2_1(TestInfo info) {

        message = info.getDisplayName();
        result = "\t\t\t[FAIL]";

        int res1 = EsercizioParsing.countTableRow(null);
        int res2 = EsercizioParsing.countTableRow("");
        int res3 = EsercizioParsing.countTableRow("(Viti,20):(Chiodi,43):(Maniglie,2");
        int res4 = EsercizioParsing.countTableRow("ciao:si,no");
        int res5 = EsercizioParsing.countTableRow("(Viti,20):Chiodi,43):(Maniglie,2)");
        assertEquals(res1, -1, "Ho passato a countTableRow come argomento: [null] e non mi restituisce -1");
        assertEquals(res2, -1, "Ho passato a countTableRow come argomento: [] e non mi restituisce -1");
        assertEquals(res3, -1, "Ho passato a countTableRow come argomento: [(Viti,20):(Chiodi,43):(Maniglie,2] e non mi restituisce -1");
        assertEquals(res4, -1, "Ho passato a countTableRow come argomento: [ciao:si,no] e non mi restituisce -1");
        assertEquals(res5, -1, "Ho passato a countTableRow come argomento: [(Viti,20):Chiodi,43):(Maniglie,2)] e non mi restituisce -1");

        result = "\t\t\t[SUCCESS][+1.5]";
        vote += 1.5f;
    }

    @Test
    @DisplayName("[3.C.2](2/2) Medium: countTableRow [1 row, 2 rows, 4 rows]")
    public void test3C2_2(TestInfo info) {

        message = info.getDisplayName();
        result = "\t\t[FAIL]\n------------------------------------------------------------------------------------------------------------------------";

        int res1 = EsercizioParsing.countTableRow("(Riga,Righetti)"); //3
        int res2 = EsercizioParsing.countTableRow("(Viti,20):(Chiodi,100000)"); //3
        int res3 = EsercizioParsing.countTableRow("(Viti,20):(Chiodi,43):(Maniglie,2):(Trapani,Zero)"); //3

        assertEquals(res1, 1, "Ho passato a countTableRow come argomento: [(Riga,Righetti)] e dovrebbe restituirmi [1]");
        assertEquals(res2, 2, "Ho passato a countTableRow come argomento: [(Viti,20):(Chiodi,100000)] e dovrebbe restituirmi [2]");
        assertEquals(res3, 4, "Ho passato a countTableRow come argomento: [(Viti,20):(Chiodi,43):(Maniglie,2):(Trapani,Zero)] e dovrebbe restituirmi [4]");

        result = "\t\t[SUCCESS][+1.5]\n------------------------------------------------------------------------------------------------------------------------";
        vote += 1.5f;
    }

    @Test
    @DisplayName("[3.C.3](1/3) Easy: getElementAt [null/empty/invalid]")
    public void test3C3_1(TestInfo info) {

        message = info.getDisplayName();
        result = "\t\t\t[FAIL]";

        String res1 = EsercizioParsing.getElementAt(null, 1, 1);
        String res2 = EsercizioParsing.getElementAt("", 1, 1);
        String res3 = EsercizioParsing.getElementAt("(Viti,20):(Chiodi,43):(Maniglie,2", 1, 1);
        String res4 = EsercizioParsing.getElementAt("ciao:si,no", 1, 1);
        String res5 = EsercizioParsing.getElementAt("(Viti,20):Chiodi,43):(Maniglie,2)", 0, 0);

        assertEquals(res1, "INVALID", "Ho passato a getElementAt come argomento: [null] e non mi restituisce INVALID");
        assertEquals(res2, "INVALID", "Ho passato a getElementAt come argomento: [] e non mi restituisce INVALID");
        assertEquals(res3, "INVALID", "Ho passato a getElementAt come argomento: [(Viti,20):(Chiodi,43):(Maniglie,2] e non mi restituisce INVALID");
        assertEquals(res4, "INVALID", "Ho passato a getElementAt come argomento: [ciao:si,no] e non mi restituisce INVALID");
        assertEquals(res5, "INVALID", "Ho passato a getElementAt come argomento: [(Viti,20):Chiodi,43):(Maniglie,2)] e non mi restituisce INVALID");

        result = "\t\t\t[SUCCESS][+1.5]";
        vote += 1.5f;
    }

    @Test
    @DisplayName("[3.C.3](2/3) Medium: getElementAt [out of bounds]")
    public void test3C3_2(TestInfo info) {

        message = info.getDisplayName();
        result = "\t\t\t[FAIL]";

        String res1 = EsercizioParsing.getElementAt("(Viti,20):(Chiodi,43):(Maniglie,2)", -1, 0);
        String res2 = EsercizioParsing.getElementAt("(Viti,20):(Chiodi,43):(Maniglie,2)", 1, 4);
        String res3 = EsercizioParsing.getElementAt("(Viti,20):(Chiodi,43):(Maniglie,2)", 1, 2);
        String res4 = EsercizioParsing.getElementAt("(Viti,20):(Chiodi,43):(Maniglie,2)", 7, 1);
        String res5 = EsercizioParsing.getElementAt("(Viti,20):(Chiodi,43):(Maniglie,2)", 3, 1);
        String res6 = EsercizioParsing.getElementAt("(Viti,20):(Chiodi,43):(Maniglie,2)", 1, -1);

        assertEquals(res1, "OUT_OF_BOUNDS", "Ho passato a getElementAt come argomento una tabella 3x2, e r,c: [-1,0] e non mi restituisce OUT_OF_BOUNDS");
        assertEquals(res2, "OUT_OF_BOUNDS", "Ho passato a getElementAt come argomento una tabella 3x2, e r,c: [1,4] e non mi restituisce OUT_OF_BOUNDS");
        assertEquals(res3, "OUT_OF_BOUNDS", "Ho passato a getElementAt come argomento una tabella 3x2, e r,c: [1,2] e non mi restituisce OUT_OF_BOUNDS");
        assertEquals(res4, "OUT_OF_BOUNDS", "Ho passato a getElementAt come argomento una tabella 3x2, e r,c: [7,1] e non mi restituisce OUT_OF_BOUNDS");
        assertEquals(res5, "OUT_OF_BOUNDS", "Ho passato a getElementAt come argomento una tabella 3x2, e r,c: [3,1] e non mi restituisce OUT_OF_BOUNDS");
        assertEquals(res6, "OUT_OF_BOUNDS", "Ho passato a getElementAt come argomento una tabella 3x2, e r,c: [1,-1] e non mi restituisce OUT_OF_BOUNDS");
        result = "\t\t\t[SUCCESS][+2.0]";
        vote += 2.0f;
    }

    @Test
    @DisplayName("[3.C.3](3/3) Hard: getElementAt [valid index in a 3x2 table]")
    public void test3C3_3(TestInfo info) {

        message = info.getDisplayName();
        result = "\t\t[FAIL]\n------------------------------------------------------------------------------------------------------------------------";
        //      0       1  
        // 0  Viti      20
        // 1  Chiodi    43
        // 2  Maniglie  2

        String res1 = EsercizioParsing.getElementAt("(Viti,20):(Chiodi,43):(Maniglie,2)", 0, 0);  //Viti
        String res2 = EsercizioParsing.getElementAt("(Viti,20):(Chiodi,43):(Maniglie,2)", 0, 1);  //20
        String res3 = EsercizioParsing.getElementAt("(Viti,20):(Chiodi,43):(Maniglie,2)", 1, 1);  //43
        String res4 = EsercizioParsing.getElementAt("(Viti,20):(Chiodi,43):(Maniglie,2)", 2, 0);  //Maniglie
        String res5 = EsercizioParsing.getElementAt("(Viti,20):(Chiodi,43):(Maniglie,2)", 2, 1);  //2 

        assertEquals(res1, "Viti", "Ho passato a getElementAt come argomento la tabella[(Viti,20):(Chiodi,43):(Maniglie,2)], e r,c: [0,0] e non mi restituisce [Viti]");
        assertEquals(res2, "20", "Ho passato a getElementAt come argomento la tabella[(Viti,20):(Chiodi,43):(Maniglie,2)], e r,c: [0,0] e non mi restituisce [20]");
        assertEquals(res3, "43", "Ho passato a getElementAt come argomento la tabella[(Viti,20):(Chiodi,43):(Maniglie,2)], e r,c: [0,0] e non mi restituisce [43]");
        assertEquals(res4, "Maniglie", "Ho passato a getElementAt come argomento la tabella[(Viti,20):(Chiodi,43):(Maniglie,2)], e r,c: [0,0] e non mi restituisce [Maniglie]");
        assertEquals(res5, "2", "Ho passato a getElementAt come argomento la tabella[(Viti,20):(Chiodi,43):(Maniglie,2)], e r,c: [0,0] e non mi restituisce [2]");

        result = "\t\t[SUCCESS][+4.0]\n------------------------------------------------------------------------------------------------------------------------";
        vote += 4.0f;
    }

    @Test
    @DisplayName("[3.C.4](1/1) Hard: search [several tests]")
    public void test3C4_1(TestInfo info) {

        message = info.getDisplayName();
        result = "\t\t\t\t[FAIL]\n------------------------------------------------------------------------------------------------------------------------";
        //      0       1  
        // 0  Viti      20
        // 1  Chiodi    43
        // 2  Maniglie  2
        boolean search = EsercizioParsing.search("(Viti,20):(Chiodi,43):(Maniglie,2)", "Viti"); //true
        boolean search2 = EsercizioParsing.search("(Viti,20):(Chiodi,43):(Maniglie,2)", "20"); //true
        boolean search3 = EsercizioParsing.search("(Viti,20):(Chiodi,43):(Maniglie,2)", "Chiodi"); //true
        boolean search4 = EsercizioParsing.search("(Viti,20):(Chiodi,43):(Maniglie,2)", "2"); //true

        boolean search5 = EsercizioParsing.search("(Viti,20):(Chiodi,43):(Maniglie,2)", "Manigli"); //false
        boolean search6 = EsercizioParsing.search("(Viti,20):(Chiodi,43):(Maniglie,2)", "3"); //false
        boolean search7 = EsercizioParsing.search("(Viti,20):(Chiodi,43):(Maniglie,2)", ""); //false
        boolean search8 = EsercizioParsing.search("(Viti,20):(Chiodi,43):(Maniglie,2)", "asdasd"); //false

        assertTrue(search, "Nella tabella [(Viti,20):(Chiodi,43):(Maniglie,2)] ho cercato [Viti] e dovrebbe dirmi che c'è");
        assertTrue(search2, "Nella tabella [(Viti,20):(Chiodi,43):(Maniglie,2)] ho cercato [20] e dovrebbe dirmi che c'è");
        assertTrue(search3, "Nella tabella [(Viti,20):(Chiodi,43):(Maniglie,2)] ho cercato [Chiodi] e dovrebbe dirmi che c'è");
        assertTrue(search4, "Nella tabella [(Viti,20):(Chiodi,43):(Maniglie,2)] ho cercato [2] e dovrebbe dirmi che c'è");

        assertFalse(search5, "Nella tabella [(Viti,20):(Chiodi,43):(Maniglie,2)] ho cercato [Manigli] e dovrebbe dirmi che NON c'è");
        assertFalse(search6, "Nella tabella [(Viti,20):(Chiodi,43):(Maniglie,2)] ho cercato [3] e dovrebbe dirmi che NON c'è");
        assertFalse(search7, "Nella tabella [(Viti,20):(Chiodi,43):(Maniglie,2)] ho cercato [] e dovrebbe dirmi che NON c'è");
        assertFalse(search8, "Nella tabella [(Viti,20):(Chiodi,43):(Maniglie,2)] ho cercato [asdasd] e dovrebbe dirmi che NON c'è");

        result = "\t\t\t\t[SUCCESS][+3.0]\n------------------------------------------------------------------------------------------------------------------------";
        vote += 3.0f;
    }

    @Test
    @DisplayName("[3.C.5](1/2) Easy: guessCommandType [null/empty]")
    public void test3C5_1(TestInfo info) {

        message = info.getDisplayName();
        result = "\t\t\t[FAIL]";

        CommandType guess = EsercizioParsing.guessCommandType("");
        CommandType guess1 = EsercizioParsing.guessCommandType(null);

        assertEquals(guess, CommandType.UNKNOWN, "inserito parametro vuoto, mi aspettavo CommandType.UNKNOWN");
        assertEquals(guess1, CommandType.UNKNOWN, "inserito parametro nullo, mi aspettavo CommandType.UNKNOWN");

        result = "\t\t\t[SUCCESS][+0.5]";

        vote += 0.5f;
    }

    @Test
    @DisplayName("[3.C.5](2/2) Medium: guessCommandType [null/empty]")
    public void test3C5_2(TestInfo info) {

        message = info.getDisplayName();
        result = "\t\t\t[FAIL]\n------------------------------------------------------------------------------------------------------------------------";

        CommandType guess = EsercizioParsing.guessCommandType("command -speak ciao");
        CommandType guess2 = EsercizioParsing.guessCommandType("command -speakko ciao");
        CommandType guess3 = EsercizioParsing.guessCommandType("command speak ciao si");
        CommandType guess4 = EsercizioParsing.guessCommandType("-speak ciao");

        CommandType guess5 = EsercizioParsing.guessCommandType("command -quit 10");
        CommandType guess6 = EsercizioParsing.guessCommandType("command -quit AB");
        CommandType guess7 = EsercizioParsing.guessCommandType("command quit");

        CommandType guess8 = EsercizioParsing.guessCommandType("command -table (Amici,0):(Temperatura,-3)");
        CommandType guess9 = EsercizioParsing.guessCommandType("command (Amici,0):(Temperatura,-3)");
        CommandType guess10 = EsercizioParsing.guessCommandType("command -table Amici,0):(Temperatura,-3)");
        CommandType guess11 = EsercizioParsing.guessCommandType("kkas aosduasd -tata- a isajda");

        assertTrue(guess == CommandType.SPEAK, "Ho inserito un comando valido di speak ma non è stato riconosciuto");
        assertTrue(guess2 == CommandType.SPEAK || guess2 == CommandType.UNKNOWN, "Ho inserito un comando non valido ma simile a uno di speak ma non è stato etichettato né SPEAK né UNKNOWN");
        assertTrue(guess3 == CommandType.SPEAK || guess3 == CommandType.UNKNOWN, "Ho inserito un comando non valido ma simile a uno di speak ma non è stato etichettato né SPEAK né UNKNOWN");
        assertTrue(guess4 == CommandType.SPEAK || guess4 == CommandType.UNKNOWN, "Ho inserito un comando non valido ma simile a uno di speak ma non è stato etichettato né SPEAK né UNKNOWN");

        assertTrue(guess5 == CommandType.QUIT || guess5 == CommandType.UNKNOWN, "Ho inserito un comando valido di QUIT ma non è stato riconosciuto");
        assertTrue(guess6 == CommandType.QUIT || guess6 == CommandType.UNKNOWN, "Ho inserito un comando non valido ma simile a uno di quit ma non è stato etichettato né QUIT né UNKNOWN");
        assertTrue(guess7 == CommandType.QUIT || guess7 == CommandType.UNKNOWN, "Ho inserito un comando non valido ma simile a uno di quit ma non è stato etichettato né QUIT né UNKNOWN");

        assertTrue(guess8 == CommandType.TABLE, "Ho inserito un comando valido di TABLE ma non è stato riconosciuto");
        assertTrue(guess9 == CommandType.UNKNOWN, "Ho inserito un comando troppo differente da un comando conosciuto, dovrebbe essere marcato UNKNOWN");
        assertTrue(guess10 == CommandType.TABLE || guess10 == CommandType.UNKNOWN, "Ho inserito un comando non valido ma simile a uno di table ma non è stato etichettato né TABLE né UNKNOWN");
        assertTrue(guess11 == CommandType.UNKNOWN, "Ho inserito un comando casuale, dovrebbe essere marcato UNKNOWN");
        result = "\t\t\t[SUCCESS][+1.5]\n------------------------------------------------------------------------------------------------------------------------";
        vote += 1.5f;
    }

    @Test
    @DisplayName("[3.C.6](1/2) Easy: getSecondsToQuit [null/empty]")
    public void test3C6_1(TestInfo info) {

        message = info.getDisplayName();
        result = "\t\t\t[FAIL]";

        int secondsToQuit = EsercizioParsing.getSecondsToQuit("");
        int secondsToQuit1 = EsercizioParsing.getSecondsToQuit(null);

        assertEquals(secondsToQuit,  -1, "inserito parametro vuoto, mi aspettavo -1");
        assertEquals(secondsToQuit1, -1, "inserito parametro nullo, mi aspettavo -1");

        result = "\t\t\t[SUCCESS][+0.5]";

        vote += 0.5f;
    }
    
    @Test
    @DisplayName("[3.C.6](2/2) Easy: getSecondsToQuit [positive/negative/too big]")
    public void test3C6_2(TestInfo info) {

        message = info.getDisplayName();
        result = "\t\t[FAIL]\n------------------------------------------------------------------------------------------------------------------------";

        int secondsToQuit  = EsercizioParsing.getSecondsToQuit("command -quit 1");
        int secondsToQuit1 = EsercizioParsing.getSecondsToQuit("command -quit 53");
        int secondsToQuit2 = EsercizioParsing.getSecondsToQuit("command -quit -23");
        int secondsToQuit3 = EsercizioParsing.getSecondsToQuit("command -quit 180");
        int secondsToQuit4 = EsercizioParsing.getSecondsToQuit("command -quit 100");
        

        assertEquals(secondsToQuit,  1, "inserito parametro [command -quit 1], mi aspettavo [1]");
        assertEquals(secondsToQuit1,  53, "inserito parametro [command -quit 53], mi aspettavo [53]");
        assertEquals(secondsToQuit2,  0, "inserito parametro [command -quit -23], mi aspettavo [0]");
        assertEquals(secondsToQuit3,  0, "inserito parametro [command -quit 180], mi aspettavo [0]");
        assertEquals(secondsToQuit4,  0, "inserito parametro [command -quit 100], mi aspettavo [0]");
        

        result = "\t\t[SUCCESS][+1.0]\n------------------------------------------------------------------------------------------------------------------------";

        vote += 1.0f;
    }
    
//    getTextToSpeak
    
    @Test
    @DisplayName("[3.C.7](1/2) Easy: getTextToSpeak [null/empty]")
    public void test3C7_1(TestInfo info) {

        message = info.getDisplayName();
        result = "\t\t\t\t[FAIL]";

        String textToSpeak = EsercizioParsing.getTextToSpeak("");
        String textToSpeak1 = EsercizioParsing.getTextToSpeak(null);

        assertNull(textToSpeak1,"inserito parametro vuoto, mi aspettavo null");
        assertNull(textToSpeak1,"inserito parametro nullo, mi aspettavo null");

        result = "\t\t\t\t[SUCCESS][+0.5]";

        vote += 0.5f;
    }
    
    @Test
    @DisplayName("[3.C.7](2/2) Medium: getTextToSpeak [several samples/$m]")
    public void test3C7_2(TestInfo info) {

        message = info.getDisplayName();
        result = "\t\t[FAIL]\n------------------------------------------------------------------------------------------------------------------------";

        String textToSpeak = EsercizioParsing.getTextToSpeak("command -speak ciao");
        String textToSpeak1 = EsercizioParsing.getTextToSpeak("command -speak speak with me");
        String textToSpeak2 = EsercizioParsing.getTextToSpeak("command -speak Ciao a tutti, quanto fa 3-2?");
        String textToSpeak3 = EsercizioParsing.getTextToSpeak("command -speak PROVA maiuscolo$m");
        String textToSpeak4 = EsercizioParsing.getTextToSpeak("command -speak prova minuscolo$ m");
        String textToSpeak5 = EsercizioParsing.getTextToSpeak("command -speak bravo sei stato bravo$m");
        

        assertEquals(textToSpeak ,"ciao","comando [command -speak ciao], mi aspettavo il testo [ciao]");
        assertEquals(textToSpeak1,"speak with me","comando [command -speak speak with me], mi aspettavo il testo [speak with me]");
        assertEquals(textToSpeak2,"Ciao a tutti, quanto fa 3-2?","comando [command -speak Ciao a tutti, quanto fa 3-2?], mi aspettavo il testo [Ciao a tutti, quanto fa 3-2?]");
        assertEquals(textToSpeak3,"PROVA MAIUSCOLO","comando [command -speak prova maiuscolo$m], mi aspettavo il testo [PROVA MAIUSCOLO]");
        assertEquals(textToSpeak4,"prova minuscolo$ m","comando [command -speak prova minuscolo$ m], mi aspettavo il testo [prova minuscolo$ m]");
        assertEquals(textToSpeak5,"BRAVO SEI STATO BRAVO","comando [command -speak bravo sei stato bravo$m], mi aspettavo il testo [BRAVO SEI STATO BRAVO]");


        result = "\t\t[SUCCESS][+2.0]\n------------------------------------------------------------------------------------------------------------------------";

        vote += 2.0f;
    }
    
    @Test
    @DisplayName("[3.C.8](1/1) Medium: check advanced enum ")
    public void test3C8_1(TestInfo info) {

        message = info.getDisplayName();
        result = "\t\t\t\t[FAIL]\n------------------------------------------------------------------------------------------------------------------------";


        String quit_sesc = CommandType.QUIT.description();
        String speak_sesc = CommandType.SPEAK.description();
        String table_sesc = CommandType.TABLE.description();
        String unknown_sesc = CommandType.UNKNOWN.description();
        
        

        assertEquals("Comando per l'uscita temporizzata dal programma" ,quit_sesc,"la descrizione non corrisponde per l'enum QUIT");
        assertEquals("Comando per far sintetizzare del testo al programma",speak_sesc,"la descrizione non corrisponde per l'enum SPEAK");
        assertEquals("Comando per la generazione di tabelle",table_sesc,"la descrizione non corrisponde per l'enum TABLE");
        assertEquals("Comando sconosciuto",unknown_sesc,"la descrizione non corrisponde per l'enum UNKNOWN");

        result = "\t\t\t\t[SUCCESS][+2.0]\n------------------------------------------------------------------------------------------------------------------------";

        vote += 2.0f;
    }

}
