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
public class Lesson3DUnitTest {

    private String message;
    private String result;
    private static float vote = 0;

    public Lesson3DUnitTest() {
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
    public void test3D1_1(TestInfo info) {

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

   

}
