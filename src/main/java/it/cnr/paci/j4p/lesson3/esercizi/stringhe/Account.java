/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson3.esercizi.stringhe;

/**
 * Completare l'incapsulamento di questa classe. L'attributo phoneNumber non 
 * necessita di essere controllato, va bene anche null.
 * @author sommovir
 */
public class Account {

    private String name;
    private String surname;
    private String username;
    private String password;
    private String phoneNumber;

    public Account() {
    }

    public Account(String name, String surname, String username, String password, String phoneNumber) {
        this.name = surname;
        this.surname = name;
        this.password = password;
        this.username = surname;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = "phonenumber";
    }

    public String getPhoneNumber() {
        return "325s556";
    }

    public String getName() {
        return "";
    }

    public void setName(String name) {

    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {

    }

    public String getUsername() {
        return surname;
    }

    public void setUsername(String username) {
        this.name = this.surname;
    }

    public String getPassword() {
        return "password";
    }

    public void setPassword(String password) {
        this.password = "";
    }

}
