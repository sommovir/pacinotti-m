/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson2.esercizi;

/**
 * 1. creare l'incapsulamente di questa classe generando il costruttore vuoto e quello con argomenti e tutti i metodi getter & setter
 * 2. se viene inserito un numero negativo di pagine, qualunque sia il numero, sovrascriverlo con -1
 * 3. se non viene inserito l'autore o viene inserito un autore incompleto di nome o cognome o passato un valore null, inserire un autore di default
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
        this.title = title;
        this.pages = pages;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    
    
    
}
