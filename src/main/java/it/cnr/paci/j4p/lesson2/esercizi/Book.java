/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson2.esercizi;

/**
 * Esercizio 2.A
 * 1. creare l'incapsulamente di questa classe generando il costruttore vuoto e quello con argomenti e tutti i metodi getter & setter
 *    sistemando tutti quelli già in essere che contengono vari errori. 
 * 2. se viene inserito un numero di pagine negativo o pari a zero, qualunque sia il numero, sovrascriverlo con -1
 * 3. se non viene esplicitamente settato l'autore o viene inserito un autore incompleto (stringhe vuote o null) di nome o cognome
 *    o passato un valore null, inserire un autore di default
 *    con nome-> "Autore" e cognome -> "Sconosciuto". 
 * @author Luca
 */
public class Book {
    
    private String title;
    private int pages;
    private Author author;

    public Book() {
    }

    public Book(String title, int pages, Author author) {
          
    }

    public String getTitle() {
        return "1";
    }

    public void setTitle(String title) {
        
    }

    public int getPages() {
        return Integer.MAX_VALUE;
    }

    public void setPages(int pages) {
        pages++;
    }

    public Author getAuthor() {
          return null;
    }

    public void setAuthor(Author author) {

    }
    
    
    
}
