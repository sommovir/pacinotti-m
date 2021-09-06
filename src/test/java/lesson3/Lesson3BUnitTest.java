/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson3;

import it.cnr.paci.j4p.lesson3.esercizi.stringhe.RegistrationManager;
import it.cnr.paci.j4p.lesson3.esercizi.stringhe_liste_bancomat.Bancomat;
import it.cnr.paci.j4p.lesson3.esercizi.stringhe_liste_bancomat.Card;
import it.cnr.paci.j4p.lesson3.esercizi.stringhe_liste_bancomat.Operation;
import it.cnr.paci.j4p.lesson3.esercizi.stringhe_liste_bancomat.User;
import static java.lang.Thread.sleep;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.StampedLock;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;

@Disabled
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class Lesson3BUnitTest {

    private String message;
    private String result;
    private static float vote = 0;

    public Lesson3BUnitTest() {
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
    @DisplayName("[3.B.1](1/3) Easy: isCardNumberValid [null/empty/short/long]")
    public void test0(TestInfo info) {

        message = info.getDisplayName();
        result = "\t\t\t\t[FAIL]";

        boolean cardNumberValid = Bancomat.isCardNumberValid("");
        boolean cardNumberValid2 = Bancomat.isCardNumberValid(null);
        boolean cardNumberValid3 = Bancomat.isCardNumberValid("1");
        boolean cardNumberValid4 = Bancomat.isCardNumberValid("11111111111111111111111111111111111111111111");

        assertFalse(cardNumberValid, "Invocato isCardNumberValid con stringa vuota e mi restituisce true. Tutto ciò è insopportabile");
        assertFalse(cardNumberValid2, "Invocato isCardNumberValid con null e mi restituisce true. Tutto ciò è insopportabile");
        assertFalse(cardNumberValid3, "Invocato isCardNumberValid con una stringa troppo corta e mi restituisce true. Tutto ciò è insopportabile");
        assertFalse(cardNumberValid4, "Invocato isCardNumberValid con una stringa troppo lunga e mi restituisce true. Tutto ciò è insopportabile");

        result = "\t\t\t\t[SUCCESS][+0.5]";
        vote += 0.5f;
    }

    @Test
    @DisplayName("[3.B.1](2/3) Medium: isCardNumberValid [valid codes]")
    public void test01(TestInfo info) {

        message = info.getDisplayName();
        result = "\t\t\t\t\t[FAIL]";

        boolean cardNumberValid = Bancomat.isCardNumberValid("1234-4978-9645-0048");
        boolean cardNumberValid2 = Bancomat.isCardNumberValid("1234945836548579");

        assertTrue(cardNumberValid, "Invocato isCardNumberValid con un codice valido[1234-4978-9645-0048] e mi restituisce false. Tutto ciò è insopportabile");
        assertTrue(cardNumberValid2, "Invocato isCardNumberValid con un codice valido[1234945836548579] e mi restituisce false. Tutto ciò è insopportabile");

        result = "\t\t\t\t\t[SUCCESS][+0.8]";
        vote += 0.8f;
    }

    @Test
    @DisplayName("[3.B.1](3/3) Medium: isCardNumberValid [invalid codes]")
    public void test012(TestInfo info) {

        message = info.getDisplayName();
        result = "\t\t\t\t\t[FAIL]";

        boolean cardNumberValid = Bancomat.isCardNumberValid("1234-4978-9645-004");
        boolean cardNumberValid2 = Bancomat.isCardNumberValid("111122223333 444");
        boolean cardNumberValid3 = Bancomat.isCardNumberValid("1111222A33332444");
        boolean cardNumberValid4 = Bancomat.isCardNumberValid("1111-222A-3333-2444");
        boolean cardNumberValid5 = Bancomat.isCardNumberValid("                ");

        assertFalse(cardNumberValid, "Invocato isCardNumberValid con un codice invalido[1234-4978-9645-004] e mi restituisce true.");
        assertFalse(cardNumberValid2, "Invocato isCardNumberValid con un codice invalido[111122223333 444] e mi restituisce true.");
        assertFalse(cardNumberValid3, "Invocato isCardNumberValid con un codice invalido[1111222A33332444] e mi restituisce true.");
        assertFalse(cardNumberValid4, "Invocato isCardNumberValid con un codice invalido[1111-222A-3333-2444] e mi restituisce true.");
        assertFalse(cardNumberValid5, "Invocato isCardNumberValid con un codice invalido[                ] e mi restituisce true.");

        result = "\t\t\t\t\t[SUCCESS][+1.5]";
        vote += 1.8f;
    }

    @Test
    @DisplayName("[3.B.2](1/3) Easy: isPinValid [null/empty/short/long]")
    public void test02(TestInfo info) {

        message = info.getDisplayName();
        result = "\t\t\t\t\t[FAIL]";

        boolean pinvalid = Bancomat.isPinValid("");
        boolean pinvalid2 = Bancomat.isPinValid(null);
        boolean pinvalid3 = Bancomat.isPinValid("1");
        boolean pinvalid4 = Bancomat.isPinValid("11111111111111111111111111111111111111111111");

        assertFalse(pinvalid, "Invocato isPinValid con stringa vuota e mi restituisce true. Tutto ciò è insopportabile");
        assertFalse(pinvalid2, "Invocato isPinValid con null e mi restituisce true. Tutto ciò è insopportabile");
        assertFalse(pinvalid3, "Invocato isPinValid con una stringa troppo corta e mi restituisce true. Tutto ciò è insopportabile");
        assertFalse(pinvalid4, "Invocato isPinValid con una stringa troppo lunga e mi restituisce true. Tutto ciò è insopportabile");

        result = "\t\t\t\t\t[SUCCESS][+0.5]";
        vote += 0.5f;
    }

    @Test
    @DisplayName("[3.B.2](2/3) Medium: isPinValid [valid codes]")
    public void test021(TestInfo info) {

        message = info.getDisplayName();
        result = "\t\t\t\t\t\t[FAIL]";

        boolean pinValid = Bancomat.isPinValid("12345");
        boolean pinValid2 = Bancomat.isPinValid("67890");

        assertTrue(pinValid, "Invocato isPinValid con un codice valido[12345] e mi restituisce false. Tutto ciò è insopportabile");
        assertTrue(pinValid2, "Invocato isPinValid con un codice valido[67890] e mi restituisce false. Tutto ciò è insopportabile");

        result = "\t\t\t\t\t\t[SUCCESS][+0.6]";
        vote += 0.6f;
    }

    @Test
    @DisplayName("[3.B.2](3/3) Medium: isPinValid [invalid codes]")
    public void test022(TestInfo info) {

        message = info.getDisplayName();
        result = "\t\t\t\t\t\t[FAIL]";

        boolean pinValid = Bancomat.isPinValid("1234A");
        boolean pinValid2 = Bancomat.isPinValid("a1234");
        boolean pinValid3 = Bancomat.isPinValid("     ");

        assertFalse(pinValid, "Invocato isPinValid con un codice valido [12345] e mi restituisce true. Tutto ciò è insopportabile");
        assertFalse(pinValid2, "Invocato isPinValid con un codice valido [67890] e mi restituisce true. Tutto ciò è insopportabile");
        assertFalse(pinValid3, "Invocato isPinValid con un codice valido [     ] e mi restituisce true. Tutto ciò è insopportabile");

        result = "\t\t\t\t\t\t[SUCCESS][+1.1]";
        vote += 1.1f;
    }

    @Test
    @DisplayName("[3.B.3](1/2) Easy: verifyCardNumber invalid inputs [null/empty input]")
    public void test031(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t\t[FAIL]";

        boolean veri = Bancomat.verifyCardNumber(new User("Luca", "Surn", new Card(12, "1111222233334444", "12345"), "a@b.it"), null);
        boolean veri1 = Bancomat.verifyCardNumber(new User("Luca", "Surn", new Card(12, "1111222233334444", "12345"), "a@b.it"), "");
        boolean veri2 = Bancomat.verifyCardNumber(null, "1111222233336555");
        boolean veri3 = Bancomat.verifyCardNumber(new User("Luca", "Surn", null, "aaa@bsds.it"), "1111-2222-4444-7777");

        assertFalse(veri, "il secondo argomento è null, mi aspetto che ritorni false");
        assertFalse(veri1, "il secondo argomento è empty, mi aspetto che ritorni false");
        assertFalse(veri2, "il primo argomento è null, mi aspetto che ritorni false");
        assertFalse(veri3, "il primo argomento non è null ma ha l'attribugo card, null. Deve ritornare false");

        result = "\t\t\t[SUCCESS][+1.4]";
        vote += 1.4f;
    }

    @Test
    @DisplayName("[3.B.3](2/2) High: verifyCardNumber valid inputs [correct/wrong]")
    public void test032(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t\t[FAIL]";

        boolean veri = Bancomat.verifyCardNumber(new User("Luca", "Surn", new Card(12, "1111222233334444", "12345"), "a@b.it"), "1111222233334444");
        boolean veri1 = Bancomat.verifyCardNumber(new User("Luca", "Surn", new Card(12, "1111222233334444", "12345"), "a@b.it"), "1111-2222-3333-4444");
        boolean veri2 = Bancomat.verifyCardNumber(new User("Luca", "Surn", new Card(12, "1111222233334444", "12345"), "a@b.it"), "1111222233334440");
        boolean veri3 = Bancomat.verifyCardNumber(new User("Luca", "Surn", new Card(12, "1111222233334444", "12345"), "a@b.it"), "1111-2222-3333-4440");

        assertTrue(veri, "i due codici di carta sono identici ma non vengono riconosciuti come tali");
        assertFalse(veri2, "i due codici sono differenti ma sono stati riconosciuti come uguali");
        assertFalse(veri3, "i due codici sono differenti ma sono stati riconosciuti come uguali");
        assertTrue(veri1, "nel primo caso il codice carta è espresso senza '-', nel secondo con il '-'. I codici sono tuttavia identici ma non sono stati riconosciuti");

        result = "\t\t\t[SUCCESS][+2.5]";
        vote += 2.5f;
    }

    @Test
    @DisplayName("[3.B.4](1/3) Easy: enterCard, invalid input [null/empty]")
    public void test041(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t\t\t[FAIL]";
        Bancomat bancomat = new Bancomat(3000, false);
        User enterCard = bancomat.enterCard(null, "00154");
        User enterCard1 = bancomat.enterCard("", "00154");
        User enterCard2 = bancomat.enterCard("8999112312210016", null);
        User enterCard3 = bancomat.enterCard("8999112312210016", "");

        assertNull(enterCard, "cardcode null, mi aspetto restituisca null");
        assertNull(enterCard1, "cardcode empty, mi aspetto restituisca null");
        assertNull(enterCard2, "pin null, mi aspetto restituisca null");
        assertNull(enterCard3, "pin empty, mi aspetto restituisca null");

        result = "\t\t\t\t[SUCCESS][+0.5]";
        vote += 0.5f;
    }

    //8999112312210016", "00154
    @Test
    @DisplayName("[3.B.4](2/3) Medium: enterCard, valid input [correct]")
    public void test042(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t\t\t\t[FAIL]";
        Bancomat bancomat = new Bancomat(3000, false);
        User giulio = bancomat.enterCard("8999112312210016", "00154");
        User isacco = bancomat.enterCard("8999-1123-1221-0018", "42014");

        assertNotNull(giulio, "Ho immesso cardcode e pin, corretti di Giulio Giulivo ma il metodo mi ritorna null");
        assertEquals(giulio.getSurname(), "Giulivo", "Ho immesso cardcode e pin, corretti di Giulio Giulivo, ma alcuni parametri non combaciano");
        assertNotNull(isacco, "Ho immesso cardcode e pin, corretti di Isacco Spendaccini ma il metodo mi ritorna null");
        assertEquals(isacco.getCard().getTotalMoney(), 42, "Ho immesso cardcode e pin, corretti di Isacco Spendaccini, ma alcuni parametri non combaciano");
        result = "\t\t\t\t\t[SUCCESS][+0.5]";
        vote += 0.5f;
    }

    @Test
    @DisplayName("[3.B.4](3/3) Hard: enterCard, valid input [incorrect]")
    public void test043(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t\t\t\t[FAIL]";
        Bancomat bancomat = new Bancomat(3000, false);
        User giulio = bancomat.enterCard("8999112312210016", "00153");
        User isacco = bancomat.enterCard("8999-1123-1221-0018", "42013");

        assertNull(giulio, "Ho immesso cardcode di Giulio Giulivo ma pin errato. Il metodo dovrebbe ritornare null");
        assertNull(isacco, "Ho immesso cardcode di Isacco Spendaccini ma pin errato. Il metodo dovrebbe ritornare null");
        result = "\t\t\t\t\t[SUCCESS][+1.0]";
        vote += 1.0f;
    }

    @Test
    @DisplayName("[3.B.5](1/2) Easy: canWithdraw, invalid input [0/negative/user null]")
    public void test051(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t\t[FAIL]";
        Bancomat bancomat = new Bancomat(3000, false);
        User alfonso = bancomat.getUsers().get(1);

        boolean cw1 = bancomat.canWithdraw(null, 100);
        boolean cw2 = bancomat.canWithdraw(alfonso, -50);
        boolean cw3 = bancomat.canWithdraw(alfonso, 0);

        assertFalse(cw1, "User null, non può ritirare");
        assertFalse(cw2, "Somma negativa, non può ritirare");
        assertFalse(cw3, "Somma pari a zero, non può ritirare");
        result = "\t\t\t[SUCCESS][+0.4]";
        vote += 0.4f;
    }

    @Test
    @DisplayName("[3.B.5](2/2) Medium: canWithdraw, valid input [<>fund, <>personal, <>2k]")
    public void test052(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t[FAIL]";
        Bancomat bancomat = new Bancomat(3000, false);
        User draghi = bancomat.getUsers().get(0); //98k
        User alfonso = bancomat.getUsers().get(1); //250

        boolean cw1 = bancomat.canWithdraw(draghi, 1000); //true
        boolean cw2 = bancomat.canWithdraw(draghi, 2500); //false

        boolean cw4 = bancomat.canWithdraw(alfonso, 50);  //true
        boolean cw5 = bancomat.canWithdraw(alfonso, 500); //false

        Bancomat bancomat2 = new Bancomat(1000, false);
        User draghi2 = bancomat2.getUsers().get(0); //98k
        boolean cw6 = bancomat2.canWithdraw(draghi2, 1200); //false

        assertTrue(cw1, "User con 98k e bancomat con 3k di fondo, richiesti 1000, dovrebbe poter ritirare");
        assertFalse(cw2, "User con 98k e bancomat con 3k di fondo, richiesti 2500, non dovrebbe poter ritirare, richiesta somma > 2k");

        assertTrue(cw4, "User con 250 e bancomat con 3k di fondo, richiesti 50, dovrebbe poter ritirare");
        assertFalse(cw5, "User con 250 e bancomat con 3k di fondo, richiesti 500, non dovrebbe poter ritirare, richiesta somma più grande di quanto si possiede");
        assertFalse(cw6, "User con 98k e bancomat con 1k di fondo, richiesti 1200, non dovrebbe poter ritirare perché richiesta una somma maggiore del fondo");
        result = "\t\t[SUCCESS][+2.3]";
        vote += 2.3f;
    }

    @Test
    @DisplayName("[3.B.6](1/1) Medium: withdraw, different tests")
    public void test061(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t\t\t\t\t[FAIL]";
        Bancomat bancomat = new Bancomat(3000, false);
        User draghetti = bancomat.getUsers().get(0); //98k
        User alfonso = bancomat.getUsers().get(1); //250

        bancomat.withdraw(alfonso, 40);
        assertTrue(bancomat.isWorking(),"il bancomat dovrebbe essere setato working, perché il fondo è superiore a  1000€");
        assertEquals(alfonso.getCard().getTotalMoney(), 210, "Ho ritirato 40 € da un conto di 250 €, dovrei avere sul conto 210.. e invece no");
        bancomat.withdraw(alfonso, 100);
        assertEquals(alfonso.getCard().getTotalMoney(), 110, "Ho ritirato 100 € da un conto di 210 €, dovrei avere sul conto 110.. e invece no");
        assertEquals(bancomat.getFondo(), 2860, "Ho ritirato 110+40 € dal fondo bancomat di 3000 €, dovrei avere sul fondo 2860.. e invece no");

        bancomat.withdraw(draghetti, 1900);
        assertEquals(draghetti.getCard().getTotalMoney(), 96100, "Ho ritirato 1900 € da un conto di 98000 €, dovrei avere sul conto 96100 €.. e invece no");
        assertEquals(bancomat.getFondo(), 960, "Ho ritirato 960 € dal fondo bancomat di 2860 €, dovrei avere sul fondo 960.. e invece no");
        assertFalse(bancomat.isWorking(),"il bancomat dovrebbe essere setato not working, perché il fondo è sceso sotto 1000€");

        result = "\t\t\t\t\t\t[SUCCESS][+2.4]";
        vote += 2.4f;
    }
    
    
    @Test
    @DisplayName("[3.B.7](1/1) Medium: getLog, different withdraws, then getLog")
    public void test071(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t\t\t[FAIL]";
        Bancomat bancomat = new Bancomat(3000, false);
        User draghetti = bancomat.getUsers().get(0); //98k
        User alfonso = bancomat.getUsers().get(1); //250

        bancomat.withdraw(alfonso, 40);
        assertTrue(bancomat.isWorking(),"il bancomat dovrebbe essere setato working, perché il fondo è superiore a  1000€");
        assertEquals(alfonso.getCard().getTotalMoney(), 210, "Ho ritirato 40 € da un conto di 250 €, dovrei avere sul conto 210.. e invece no");
        bancomat.withdraw(alfonso, 100);
        assertEquals(alfonso.getCard().getTotalMoney(), 110, "Ho ritirato 100 € da un conto di 210 €, dovrei avere sul conto 110.. e invece no");
        assertEquals(bancomat.getFondo(), 2860, "Ho ritirato 110+40 € dal fondo bancomat di 3000 €, dovrei avere sul fondo 2860.. e invece no");

        bancomat.withdraw(draghetti, 1900);
        assertEquals(draghetti.getCard().getTotalMoney(), 96100, "Ho ritirato 1900 € da un conto di 98000 €, dovrei avere sul conto 96100 €.. e invece no");
        assertEquals(bancomat.getFondo(), 960, "Ho ritirato 960 € dal fondo bancomat di 2860 €, dovrei avere sul fondo 960.. e invece no");
        assertFalse(bancomat.isWorking(),"il bancomat dovrebbe essere setato not working, perché il fondo è sceso sotto 1000€");
        
        List<Operation> log = bancomat.getLog();
        
        assertNotNull(log,"Ho eseguito 3 operazioni ma getLog() mi restituisce una lista nulla");
        int size = log.size();
        assertEquals(size, 3,"Ho fatto 3 operazioni ma il log non ha 3 elementi");
        Operation firstWithdraw  = log.get(0);
        Operation secondWithdraw = log.get(1);
        Operation thirdWithdraw  = log.get(2);
        assertEquals(firstWithdraw.getUser().getEmail(),alfonso.getEmail(),"La prima operazione non trova corrispondenza (email user differente)");
        assertEquals(firstWithdraw.getAmount(),40, "La prima operazione non trova corrispondenza nell'importo");
        
        assertEquals(secondWithdraw.getUser().getName(),alfonso.getName(),"La seconda operazione non trova corrispondenza (nome user differente)");
        assertEquals(secondWithdraw.getAmount(),100, "La seconda operazione non trova corrispondenza nell'importo");
        
        assertEquals(thirdWithdraw.getUser().getSurname(),draghetti.getSurname(),"La terza operazione non trova corrispondenza (cognome user differente)");
        assertEquals(thirdWithdraw.getAmount(),1900, "La terza operazione non trova corrispondenza nell'importo");

        result = "\t\t\t\t[SUCCESS][+2.0]";
        vote += 2.0f;
    }
    
    @Test
    @DisplayName("[3.B.8](1/1) Medium: getMaxWithdraw, different withdraws, test")
    public void test081(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t\t\t[FAIL]";
        Bancomat bancomat = new Bancomat(3000, false);
        User draghetti = bancomat.getUsers().get(0); //98k
        User alfonso = bancomat.getUsers().get(1); //250

        int maxWithdraw1 = bancomat.getMaxWithdraw();
        assertEquals(maxWithdraw1,-1, "Non ho fatto ancora nessuna operazione e mi aspetto il valore -1");
        
        bancomat.withdraw(alfonso, 40);
        bancomat.withdraw(alfonso, 100);
        bancomat.withdraw(draghetti, 1900);
        bancomat.withdraw(draghetti, 100);
        bancomat.withdraw(draghetti, 100);
        bancomat.withdraw(draghetti, 1901);
        bancomat.withdraw(draghetti, 1900);
        
        int maxWithdraw2 = bancomat.getMaxWithdraw();
        assertEquals(maxWithdraw2,1901, "Ho fatto varie operazioni ma l'importo che mi hai restituito non è corretto");

        result = "\t\t\t\t[SUCCESS][+1.7]";
        vote += 1.7f;
    }
    
    @Test
    @DisplayName("[3.B.9](1/1) Hard: getSuspectedUsers, different withdraws, test")
    public void test091(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t\t\t[FAIL]";
        Bancomat bancomat = new Bancomat(30000, false);
        User draghetti = bancomat.getUsers().get(0); //98k
        User alfonso = bancomat.getUsers().get(1); //250
        User simonetta = bancomat.getUsers().get(3); //3400
        List<User> suspectedUsers = bancomat.getSuspectedUsers();
        assertNotNull(suspectedUsers,"non ho fatto operazioni ma mi aspetto una lista vuota, non nulla");
        assertEquals(suspectedUsers.size(), 0,  "non ho fatto operazioni ma mi aspetto una lista vuota, perché ci sono elementi dentro ?");
        
        bancomat.withdraw(alfonso, 40);
        bancomat.withdraw(alfonso, 100);
        bancomat.withdraw(draghetti, 1900);
        bancomat.withdraw(draghetti, 100);
        bancomat.withdraw(draghetti, 100);
        bancomat.withdraw(draghetti, 1901);
        bancomat.withdraw(draghetti, 1900);
        bancomat.withdraw(simonetta, 250);
        bancomat.withdraw(simonetta, 10);
        bancomat.withdraw(draghetti, 12);
        bancomat.withdraw(draghetti, 12);
        bancomat.withdraw(draghetti, 12);
        bancomat.withdraw(draghetti, 12);
        bancomat.withdraw(simonetta, 100);
        bancomat.withdraw(simonetta, 200);
        bancomat.withdraw(simonetta, 5);
        bancomat.withdraw(simonetta, 100);
        bancomat.withdraw(alfonso, 10);
        
        suspectedUsers = bancomat.getSuspectedUsers();
        assertEquals(suspectedUsers.size(), 2,  "ho fatto molte operazioni e mi aspetto 2 sospetti e invece.. mi hai deluso anche sta volta");
        
        String sospettati = suspectedUsers.get(0).getName()+suspectedUsers.get(1).getName();
        
        assertTrue(sospettati.contains(simonetta.getName()), "Simonetta ha fatto ben 6 operazioni ma non risulta tra i sospetti.");
        assertTrue(sospettati.contains(draghetti.getName()), "Mario ha fatto ben 9 operazioni ma non risulta tra i sospetti.");
        assertFalse(sospettati.contains(alfonso.getName()), "Alfonso ha fatto solo 3 operazioni ma risulta tra i sospetti.");

        result = "\t\t\t\t[SUCCESS][+3.0]";
        vote += 3.0f;
    }
    
    @Test
    @DisplayName("[3.B.10](1/2) Easy: getRichEmails, [limit negativo, nessuno trovato]")
    public void test0919(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t\t[FAIL]";
        Bancomat bancomat = new Bancomat(30000, false);
        List<String> richEmails = bancomat.getRichEmails(-2930);
        
        assertNull(richEmails,"Ho immesso un limite negativo, e come da definizione, mi aspetto una lista nulla");
        richEmails = bancomat.getRichEmails(257000);
        int shouldbezero = richEmails.size();
        
        assertEquals(shouldbezero, 0,"Non ci dovrebbe essere nessuno con somma superiore a 257k, attenzione allo strettamente maggiore");
      

        result = "\t\t\t[SUCCESS][+1.0]";
        vote += 1.0f;
    }
    
    @Test
    @DisplayName("[3.B.10](2/2) Medium: getRichEmails, limite intermedio, 2 ricchi")
    public void test09192(TestInfo info) {
        message = info.getDisplayName();
        result = "\t\t\t[FAIL]";
        Bancomat bancomat = new Bancomat(30000, false);
        List<String> richEmails = bancomat.getRichEmails(50000);
        
        assertNotNull(richEmails,"Ho immesso un limite di 50k, e come da definizione, non mi aspetto una lista nulla");
        int shouldbezTwo = richEmails.size();
        
        assertEquals(shouldbezTwo, 2,"Con 50k di limite, ci dovrebbero essere 2 user con disponibilità superiore.");
        
        String emails = richEmails.get(0) + richEmails.get(1);
        
        assertTrue(emails.contains("mario.d@gov.ladr.it"),"L'utente Mario Draghetti dovrebbe essere incluso nella lista, perché ha più di 50k. ");
        assertTrue(emails.contains("youpoor@paperonis.org"),"L'utente Lorenzius De Paperonis dovrebbe essere incluso nella lista, perché ha ben più di 50k. ");
      

        result = "\t\t\t[SUCCESS][+2.0]";
        vote += 1.0f;
    }
    
    
    
    

    @Test
    @DisplayName("[3.B.Card](1/1) Easy: validità cardcode costruttore/setters [null/empty]")
    public void test0999999999(TestInfo info) {

        message = info.getDisplayName();
        result = "\t\t[FAIL]";
        Card card = new Card(3000, null, null);
        assertNull(card.getCardCode(), "Ho costruito una Card con cardnumber null e non lo ritrovo null");
        Card card1 = new Card();
        card1.setCardCode(null);
        assertNull(card.getCardCode(), "Ho costruito una Card con costruttore vuote e poi assegnato null a cardnumber e non lo ritrovo null");
        Card card2 = new Card(3000, "", "");
        assertNull(card2.getCardCode(), "Ho costruito una Card con cardnumber stringa vuota e non lo ritrovo null");
        Card card3 = new Card();
        card1.setCardCode("");
        assertNull(card3.getCardCode(), "Ho costruito una Card con costruttore vuote e poi assegnato una stringa vuota a cardnumber e non lo ritrovo null");

        result = "\t\t[SUCCESS][+0.2]";
        vote += 0.2f;
    }

    @Test
    @DisplayName("[3.B.Card](1/6) Easy: check incapsulamento(costruttore),valori validi")
    public void test1(TestInfo info) {
        Card card = new Card(3000, "0000111122223333", "12345");
        message = info.getDisplayName();
        result = "\t\t\t[FAIL]";
        assertEquals(card.getTotalMoney(), 3000, "Ho inserito un totalMoney valido (3000) nel costruttore ma non riesco a riprenderlo via get.");
        assertEquals(card.getCardCode(), "0000111122223333", "Ho inserito un cardCode valido (0000111122223333) nel costruttore ma non riesco a riprenderlo via get.");
        assertEquals(card.getPin(), "12345", "Ho inserito un pin valido (12345) nel costruttore ma non riesco a riprenderlo via get.");
        result = "\t\t\t[SUCCESS][+0.2]";
        vote += 0.2f;
    }

    @Test
    @DisplayName("[3.B.Card](2/6) Easy: check incapsulamento(setters) valori validi")
    public void test2(TestInfo info) {
        Card card = new Card();
        //Card card = new Card(3000, "0000111122223333", "12345");
        card.setCardCode("0000111122223333");
        card.setTotalMoney(3000);
        card.setPin("11111");
        message = info.getDisplayName();
        result = "\t\t\t[FAIL]";
        assertEquals(card.getTotalMoney(), 3000, "Ho inserito un totalMoney valido (3000) tramite i setters ma non riesco a riprenderlo via get.");
        assertEquals(card.getCardCode(), "0000111122223333", "Ho inserito un cardCode valido (0000111122223333) tramite i setters ma non riesco a riprenderlo via get.");
        assertEquals(card.getPin(), "11111", "Ho inserito un pin valido (11111) tramite i setters ma non riesco a riprenderlo via get.");
        result = "\t\t\t[SUCCESS][+0.2]";
        vote += 0.2f;
    }

    @Test
    @DisplayName("[3.B.Card](3/6) Easy: check incapsulamento(costruttore),valori invalidi (1)")
    public void test3(TestInfo info) {
        Card card = new Card(-3000, "0000111122223333LL", "DRAGONBALL");
        message = info.getDisplayName();
        result = "\t\t[FAIL]";
        assertEquals(card.getTotalMoney(), 0, "Ho inserito un totalMoney invalido (-3000) e mi aspettavo fosse salvato come 0");
        assertEquals(card.getCardCode(), null, "Ho inserito un cardCode invalido (0000111122223333LL) nel costruttore e mi aspettavo fosse salvato come null");
        assertEquals(card.getPin(), null, "Ho inserito un pin invalido (DRAGONBALL) nel costruttore e mi aspettavo fosse salvato come null.");
        result = "\t\t[SUCCESS][+0.2]";
        vote += 0.2f;
    }

    @Test
    @DisplayName("[3.B.Card](4/6) Easy: check incapsulamento(setters) valori invalidi (2)")
    public void test4(TestInfo info) {
        Card card = new Card();
        //Card card = new Card(3000, "0000111122223333", "12345");
        card.setCardCode("0000111122223333LL");
        card.setTotalMoney(-52);
        card.setPin("DRAGONBALL");
        message = info.getDisplayName();
        result = "\t\t\t[FAIL]";
        assertEquals(card.getTotalMoney(), 0, "Ho inserito un totalMoney invalido (-52) e mi aspettavo fosse salvato come 0");
        assertEquals(card.getCardCode(), null, "Ho inserito un cardCode invalido (0000111122223333LL) nel costruttore e mi aspettavo fosse salvato come null");
        assertEquals(card.getPin(), null, "Ho inserito un pin invalido (DRAGONBALL) nel costruttore e mi aspettavo fosse salvato come null.");
        result = "\t\t\t[SUCCESS][+0.3]";
        vote += 0.3f;
    }

    @Test
    @DisplayName("[3.B.Card](5/6) Easy: check incapsulamento(setters) valori validi")
    public void test5(TestInfo info) {
        Card card = new Card();
        //Card card = new Card(3000, "0000111122223333", "12345");
        card.setCardCode("0000111122223333");
        card.setTotalMoney(1200);
        card.setPin("58745");
        message = info.getDisplayName();
        result = "\t\t\t[FAIL]";
        assertEquals(card.getTotalMoney(), 1200, "Ho inserito un totalMoney valido (1200) e mi aspettavo fosse salvato come 1200");
        assertEquals(card.getCardCode(), "0000111122223333", "Ho inserito un cardCode valido (0000111122223333) nel costruttore e mi aspettavo fosse salvato come 0000111122223333");
        assertEquals(card.getPin(), "58745", "Ho inserito un pin valido (58745) nel costruttore e mi aspettavo fosse salvato come 58745.");
        result = "\t\t\t[SUCCESS][+0.2]";
        vote += 0.2f;
    }

    @Test
    @DisplayName("[3.B.Card](6/6) Medium: check incapsulamento(setters) valori invalidi e poi validi")
    public void test6(TestInfo info) {
        Card card = new Card();
        //Card card = new Card(3000, "0000111122223333", "12345");
        card.setCardCode("0000111122223333");
        card.setTotalMoney(1200);
        card.setPin("12345");

        card.setCardCode("LEONEMARINO");
        card.setTotalMoney(-5);
        card.setPin("1");

        message = info.getDisplayName();
        result = "\t[FAIL]";
        assertEquals(card.getTotalMoney(), 1200, "Ho inserito un totalMoney valido (1200) e poi ho provato a settarlo a -5 e mi aspettavo sarebbe rimasto il valore 1200");
        assertEquals(card.getCardCode(), "0000111122223333", "Ho inserito un cardCode valido (0000111122223333) e poi uno invalido (LEONEMARINO) e mi aspettavo sarebbe rimasto il precedente");
        assertEquals(card.getPin(), "12345", "Ho settato un pin valido e poi uno invalido e non mi ritrovo il pin valido");

        card.setCardCode("9999-1111-2222-3333");
        card.setTotalMoney(5000);
        card.setPin("15536");

        assertEquals(card.getTotalMoney(), 5000, "Ho aggiornato il totalMoney con un nuovo valore valido e non si è aggiornato");
        assertEquals(card.getCardCode(), "9999-1111-2222-3333", "Ho aggiornato il cardCode con un nuovo valore valido (9999-1111-2222-3333) e non si è aggiornato");
        assertEquals(card.getPin(), "15536", "Ho aggiornato il pin con un nuovo valore valido e non si è aggiornato");

        result = "\t[SUCCESS][+0.4]";
        vote += 0.4f;
    }

    @Test
    @DisplayName("[3.B.User](1/7) Easy: check incapsulamento(costruttore),valori validi")
    public void test7(TestInfo info) {
        User user = new User("Luca", "Luchini", new Card(300, "1111-2222-3333-4444", "12345"), "luca.luchi@gmail.com");
        message = info.getDisplayName();
        result = "\t\t\t[FAIL]";
        assertEquals(user.getName(), "Luca", "Ho inserito un nome valido (Luca) nel costruttore ma non riesco a riprenderlo via get.");
        assertEquals(user.getSurname(), "Luchini", "Ho inserito un cognome valido (Luchini) nel costruttore ma non riesco a riprenderlo via get.");
        assertEquals(user.getEmail(), "luca.luchi@gmail.com", "Ho inserito una email valida (luca.luchi@gmail.com) nel costruttore ma non riesco a riprenderla via get.");
        assertNotNull(user.getCard(), "Ho inserito una Card valida nel costruttore ma è null dal metodo getter");
        assertEquals(user.getCard().getCardCode(), "1111-2222-3333-4444", "Il codice della carta che ho inserito nel costruttore non è lo stesso che mi viene restituito dai vari getters");
        result = "\t\t\t[SUCCESS][+0.2]";
        vote += 0.2f;
    }

    @Test
    @DisplayName("[3.B.User](2/7) Easy: check incapsulamento(setters) valori validi")
    public void test8(TestInfo info) {
        User user = new User();
        //Card card = new Card(3000, "0000111122223333", "12345");

        user.setCard(new Card(300, "1111222233334444", "12345"));
        user.setEmail("ciao@libero.it");
        user.setName("Mario");
        user.setSurname("Mariolini");
        message = info.getDisplayName();
        result = "\t\t\t[FAIL]";
        assertEquals(user.getName(), "Mario", "Ho inserito un nome valido (Mario) via setter ma non riesco a riprenderlo via get.");
        assertEquals(user.getSurname(), "Mariolini", "Ho inserito un cognome valido (Mariolini) via setter ma non riesco a riprenderlo via get.");
        assertEquals(user.getEmail(), "ciao@libero.it", "Ho inserito una email valida (ciao@libero.it) nel setter ma non riesco a riprenderla via get.");
        assertNotNull(user.getCard(), "Ho inserito una Card valida nel setter ma è null dal metodo getter");
        assertEquals(user.getCard().getCardCode(), "1111222233334444", "Il codice della carta che ho inserito nel setter non è lo stesso che mi viene restituito dai vari getters");
        result = "\t\t\t[SUCCESS][+0.2]";
        vote += 0.2f;
    }

    @Test
    @DisplayName("[3.B.User](3/7) Easy: check incapsulamento(costruttore),valori invalidi (1)")
    public void test9(TestInfo info) {
        User user = new User("", "", new Card(300, "1111-2222-3333-4444", "12345"), "");
        message = info.getDisplayName();
        result = "\t\t[FAIL]";
        assertNull(user.getName(), "Ho inserito una stringa vuota nel costruttore per l'attributo nome, dal getter però, il nome non è null");
        assertNull(user.getSurname(), "Ho inserito una stringa vuota nel costruttore per l'attributo nome, dal getter però, il nome non è null");
        assertNull(user.getEmail(), "Ho inserito una stringa vuota nel costruttore per l'attributo nome, dal getter però, il nome non è null");
        result = "\t\t[SUCCESS][+0.2]";
        vote += 0.2f;
    }

    @Test
    @DisplayName("[3.B.User](4/7) Medium: check incapsulamento(costruttore),valori invalidi (2)")
    public void test91(TestInfo info) {
        User user = new User("Luca ", " Rossi", new Card(300, "1111-2222-3333-4444", "12345"), "ciao@libero.it");
        User user2 = new User("luca", "rossi", new Card(300, "1111-2222-3333-4444", "12345"), "ciao@libero.it");
        User user3 = new User("Luca2", "Rossi2", new Card(300, "1111-2222-3333-4444", "12345"), "ciao@libero.it");
        User user4 = new User(" ", " ", new Card(300, "1111-2222-3333-4444", "12345"), "ciao@libero.it");
        User user5 = new User("Lu7ca", "Ro4si", new Card(300, "1111-2222-3333-4444", "12345"), "ciao@libero.it");

        message = info.getDisplayName();
        result = "\t\t[FAIL]";
        assertNull(user.getName(), "Ho inserito una stringa invalida (Luca ) nel costruttore per l'attributo name, dal getter però, il nome non è null");
        assertNull(user2.getName(), "Ho inserito una stringa invalida (luca) nel costruttore per l'attributo name, dal getter però, il nome non è null");
        assertNull(user3.getName(), "Ho inserito una stringa invalida (Luca2) nel costruttore per l'attributo name, dal getter però, il nome non è null");
        assertNull(user4.getName(), "Ho inserito una stringa invalida ( ) nel costruttore per l'attributo name, dal getter però, il nome non è null");
        assertNull(user5.getName(), "Ho inserito una stringa invalida (Lu7ca) nel costruttore per l'attributo name, dal getter però, il nome non è null");

        assertNull(user.getSurname(), "Ho inserito una stringa invalida ( Rossi) nel costruttore per l'attributo surname, dal getter però, il surname non è null");
        assertNull(user2.getSurname(), "Ho inserito una stringa invalida (rossi) nel costruttore per l'attributo surname, dal getter però, il surname non è null");
        assertNull(user3.getSurname(), "Ho inserito una stringa invalida (Rossi2) nel costruttore per l'attributo surname, dal getter però, il surname non è null");
        assertNull(user4.getSurname(), "Ho inserito una stringa invalida ( ) nel costruttore per l'attributo surname, dal getter però, il surname non è null");
        assertNull(user5.getSurname(), "Ho inserito una stringa invalida (Ro4si) nel costruttore per l'attributo surname, dal getter però, il surname non è null");

        result = "\t\t[SUCCESS][+0.6]";
        vote += 0.6f;
    }

    @Test
    @DisplayName("[3.B.User](5/7) Medium: check incapsulamento(costruttore),valori invalidi (3)")
    public void test92(TestInfo info) {
        User user = new User("Luca", "Rossi", new Card(300, "1111-2222-3333-4444", "12345"), "ciao@liberoit");
        User user2 = new User("Luca", "Rossi", new Card(300, "1111-2222-3333-4444", "12345"), "@libero.it");
        User user3 = new User("Luca", "Rossi", new Card(300, "1111-2222-3333-4444", "12345"), "ciao@.it");
        User user4 = new User("Luca", "Rossi", new Card(300, "1111-2222-3333-4444", "12345"), "ciaolibero.it");
        User user5 = new User("Luca", "Rossi", new Card(300, "1111-2222-3333-4444", "12345"), " ");
        User user6 = new User("Luca", "Rossi", new Card(300, "1111-2222-3333-4444", "12345"), "m@amici.it ");

        message = info.getDisplayName();
        result = "\t\t[FAIL]";
        assertNull(user.getEmail(), "Ho inserito una stringa invalida (ciao@liberoit) nel costruttore per l'attributo email, dal getter però, il email non è null");
        assertNull(user2.getEmail(), "Ho inserito una stringa invalida (@libero.it) nel costruttore per l'attributo email, dal getter però, il email non è null");
        assertNull(user3.getEmail(), "Ho inserito una stringa invalida (ciao@.it) nel costruttore per l'attributo email, dal getter però, il email non è null");
        assertNull(user4.getEmail(), "Ho inserito una stringa invalida (ciaolibero.it) nel costruttore per l'attributo email, dal getter però, il email non è null");
        assertNull(user5.getEmail(), "Ho inserito una stringa invalida ( ) nel costruttore per l'attributo email, dal getter però, il email non è null");
        assertNull(user6.getEmail(), "Ho inserito una stringa invalida (m@amici.it ) nel costruttore per l'attributo email, dal getter però, il email non è null");

        result = "\t\t[SUCCESS][+1.0]";
        vote += 1.0f;
    }

    @Test
    @DisplayName("[3.B.User](6/7) Medium: check incapsulamento(setters),valori invalidi (2)")
    public void test93(TestInfo info) {
        User user = new User("Luca", "Rossi", new Card(300, "1111-2222-3333-4444", "12345"), "ciao@libero.it");

        message = info.getDisplayName();
        result = "\t\t[FAIL]";

        user.setName("luca");
        assertEquals(user.getName(),
                "Luca", "Dopo aver costruito un oggetto di User correttamente ne altero l'attributo -nome- con un valore invalido (luca), ma non mi ritorna il valore precedente");
        user.setName(" ");
        assertEquals(user.getName(),
                "Luca", "Dopo aver costruito un oggetto di User correttamente ne altero l'attributo -nome- con un valore invalido ( ), ma non mi ritorna il valore precedente");
        user.setName(" Luca");
        assertEquals(user.getName(),
                "Luca", "Dopo aver costruito un oggetto di User correttamente ne altero l'attributo -nome- con un valore invalido ( Luca), ma non mi ritorna il valore precedente");
        user.setName("L22uca");
        assertEquals(user.getName(),
                "Luca", "Dopo aver costruito un oggetto di User correttamente ne altero l'attributo -nome- con un valore invalido (L22uca), ma non mi ritorna il valore precedente");
        user.setName("");
        assertEquals(user.getName(),
                "Luca", "Dopo aver costruito un oggetto di User correttamente ne altero l'attributo -nome- con un valore invalido (), ma non mi ritorna il valore precedente");

        user.setSurname("cornacchia");
        assertEquals(user.getSurname(),
                "Rossi", "Dopo aver costruito un oggetto di User correttamente ne altero l'attributo -surname- con un valore invalido (cornacchia), ma non mi ritorna il valore precedente");
        user.setSurname(" ");
        assertEquals(user.getSurname(),
                "Rossi", "Dopo aver costruito un oggetto di User correttamente ne altero l'attributo -surname- con un valore invalido ( ), ma non mi ritorna il valore precedente");
        user.setSurname(" Rossi");
        assertEquals(user.getSurname(),
                "Rossi", "Dopo aver costruito un oggetto di User correttamente ne altero l'attributo -surname- con un valore invalido ( Rossi), ma non mi ritorna il valore precedente");
        user.setSurname("Ross1");
        assertEquals(user.getSurname(),
                "Rossi", "Dopo aver costruito un oggetto di User correttamente ne altero l'attributo -surname- con un valore invalido (Ross1), ma non mi ritorna il valore precedente");
        user.setSurname("");
        assertEquals(user.getSurname(),
                "Rossi", "Dopo aver costruito un oggetto di User correttamente ne altero l'attributo -surname- con un valore invalido (), ma non mi ritorna il valore precedente");

        result = "\t\t[SUCCESS][+0.6]";
        vote += 0.6f;
    }

    @Test
    @DisplayName("[3.B.User](7/7) Medium: check incapsulamento(setters),valori invalidi (3)")
    public void test94(TestInfo info) {
        User user = new User("Luca", "Rossi", new Card(300, "1111-2222-3333-4444", "12345"), "ciao@libero.it");

        message = info.getDisplayName();
        result = "\t\t[FAIL]";

        user.setEmail("ciao");
        assertEquals(user.getEmail(),
                "ciao@libero.it", "Dopo aver costruito un oggetto di User correttamente ne altero l'attributo -email- con un valore invalido (ciao), ma non mi ritorna il valore precedente");
        user.setEmail(" ");
        assertEquals(user.getEmail(),
                "ciao@libero.it", "Dopo aver costruito un oggetto di User correttamente ne altero l'attributo -email- con un valore invalido ( ), ma non mi ritorna il valore precedente");
        user.setEmail(" luca@luchini.it");
        assertEquals(user.getEmail(),
                "ciao@libero.it", "Dopo aver costruito un oggetto di User correttamente ne altero l'attributo -email- con un valore invalido (  luca@luchini.it), ma non mi ritorna il valore precedente");
        user.setEmail("luca.it");
        assertEquals(user.getEmail(),
                "ciao@libero.it", "Dopo aver costruito un oggetto di User correttamente ne altero l'attributo -email- con un valore invalido (luca.it), ma non mi ritorna il valore precedente");
        user.setEmail("");
        assertEquals(user.getEmail(),
                "ciao@libero.it", "Dopo aver costruito un oggetto di User correttamente ne altero l'attributo -email- con un valore invalido (), ma non mi ritorna il valore precedente");
        user.setEmail("alfonzecchi@gmail-it");
        assertEquals(user.getEmail(),
                "ciao@libero.it", "Dopo aver costruito un oggetto di User correttamente ne altero l'attributo -email- con un valore invalido (alfonzecchi@gmail-it), ma non mi ritorna il valore precedente");

        result = "\t\t[SUCCESS][+0.6]";
        vote += 0.6f;
    }

}
