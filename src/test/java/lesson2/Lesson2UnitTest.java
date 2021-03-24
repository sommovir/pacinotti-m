/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson2;

import it.cnr.paci.j4p.lesson2.esercizi.Author;
import it.cnr.paci.j4p.lesson2.esercizi.Book;
import it.cnr.paci.j4p.lesson2.incapsulamento.Persona;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

/**
 *
 * @author sommovir
 */
//@Disabled
public class Lesson2UnitTest {
    private String message;
    private String result;
    private static int vote = 0;
    
    public Lesson2UnitTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
        System.out.println("\n\n\n===========================================================");
        System.out.println("\t\t\tYOUR VOTE: "+vote+"/30");
        System.out.println("===========================================================\n\n\n");
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
        System.out.println("[Test Module][Lesson2]" + message + ": "+result);
    }
    
    @Test
    @DisplayName("[Test incapsulamento] Easy mode: correct parameters filling (1/4)")
    public void test1(TestInfo info){
        Author author = new Author("George", "Orwell");
        Book book = new Book("1984", 312, author);
        message = info.getDisplayName();
        result = "\t[FAIL]";
        assertEquals(312, book.getPages(),"Probabile problema di passaggio di parametri [pages] nel costruttore");
        result = "\t[SUCCESS]";
        vote+=1;
        
    }
    
    @Test
    @DisplayName("[Test incapsulamento] Easy mode: correct parameters filling (2/4)")
    public void test2(TestInfo info){
        message = info.getDisplayName();
        result = "\t[FAIL]";
        Author author = new Author("George", "Orwell");
        Book book = new Book("1984", 312, author);
        assertEquals("1984", book.getTitle(),"Probabile problema di passaggio di parametri [title] nel costruttore");
        result = "\t[SUCCESS]";
        vote+=1;
    }
    
    @Test
    @DisplayName("[Test incapsulamento] Easy mode: correct parameters filling (3/4)")
    public void test3(TestInfo info){
        message = info.getDisplayName();
        result = "\t[FAIL]";
        Author author = new Author("George", "Orwell");
        Book book = new Book("1984", 312, author);
        assertEquals("George", book.getAuthor().getName(),"Probabile problema di passaggio di parametri [author name] nel costruttore");
        result = "\t[SUCCESS]";
        vote+=1;
    }
    
    @Test
    @DisplayName("[Test incapsulamento] Easy mode: correct parameters filling (4/4)")
    public void test4(TestInfo info){
        message = info.getDisplayName();
        result = "\t[FAIL]";
        Author author = new Author("George", "Orwell");
        Book book = new Book("1984", 312, author);
        assertEquals("Orwell", book.getAuthor().getSurname(),"Probabile problema di passaggio di parametri [author surname] nel costruttore");
        result = "\t[SUCCESS]";
        vote+=1;
    }
    
    
    @Test
    @DisplayName("[Test incapsulamento] Easy mode: getters & setters (1/4)")
    public void test5(TestInfo info){
        message = info.getDisplayName();
        result = "\t[FAIL]";
        Author author = new Author("George", "Orwell");
        Book book = new Book("1984", 312, author);
        author.setName("Osvaldo");
        assertEquals("Osvaldo", book.getAuthor().getName(),"Probabile problema i getter/setter nella classe Author ");
        result = "\t\t[SUCCESS]";
        vote+=1;
    }
    
    @Test
    @DisplayName("[Test incapsulamento] Easy mode: getters & setters (2/4)")
    public void test6(TestInfo info){
        message = info.getDisplayName();
        result = "\t[FAIL]";
        Author author = new Author("George", "Orwell");
        Book book = new Book("1984", 312, author);
        book.setTitle("Il signore delle mosche");
        assertEquals("Il signore delle mosche", book.getTitle(),"Probabile problema i getter/setter nella classe Book (title) ");
        result = "\t\t[SUCCESS]";
        vote+=1;
    }
    
    @Test
    @DisplayName("[Test incapsulamento] Easy mode: getters & setters (3/4)")
    public void test7(TestInfo info){
        message = info.getDisplayName();
        result = "\t[FAIL]";
        Author author = new Author("George", "Orwell");
        Book book = new Book("1984", 312, author);
        book.setPages(100);
        assertEquals(100, book.getPages(),"Probabile problema i getter/setter nella classe Book (pages) ");
        result = "\t\t[SUCCESS]";
        vote+=1;
    }
    @Test
    @DisplayName("[Test incapsulamento] Easy mode: getters & setters (4/4)")
    public void test8(TestInfo info){
        message = info.getDisplayName();
        result = "\t[FAIL]";
        Author author = new Author("George", "Orwell");
        Book book = new Book("1984", 312, author);
        Author author2 = new Author("Mario", "Rossi");
        book.setAuthor(author2);
        assertEquals(book.getAuthor().getName(), "Mario","Probabile problema i getter/setter nella classi Book/Author");

        result = "\t\t[SUCCESS]";
        vote+=1;
    }

}
