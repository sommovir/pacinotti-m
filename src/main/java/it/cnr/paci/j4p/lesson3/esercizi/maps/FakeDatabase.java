/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson3.esercizi.maps;

import java.util.LinkedList;
import java.util.List;

/**
 * DO NOT CHANGE OR REMOVE
 *
 * @author sommovir
 */
public class FakeDatabase {

    private static FakeDatabase _instance = null;
    private static int idEmailGenerator = 1;

    public static FakeDatabase getInstance() {
        if (_instance == null) {
            _instance = new FakeDatabase();
            return _instance;
        } else {
            return _instance;
        }
    }

    private FakeDatabase() {
        super();
    }

    public List<UserEmail> loadUsers() {
        List<UserEmail> users = new LinkedList<>();

        UserEmail ue1 = new UserEmail(1, "Alfredo", "Pinchi", "alfio@gmail.com");
        UserEmail ue2 = new UserEmail(2, "Mario", "Genovesi", "mga122@gmail.com");
        UserEmail ue3 = new UserEmail(3, "Paolo", "Villaggetti", "paolo_viggi@libero.it");
        UserEmail ue4 = new UserEmail(4, "Giulia", "Bonazzi", "tranvi88@gmail.com");
        UserEmail ue5 = new UserEmail(5, "Carlo", "De Simone", "car9@hotmail.com");
        UserEmail ue6 = new UserEmail(6, "Cinzia", "Simonelli", "arcinzia@yahoo.com");
        UserEmail ue7 = new UserEmail(7, "Paola", "Mastroianni", "paola.mastrota@gmail.com");
        UserEmail ue8 = new UserEmail(8, "Luciano", "Paperotti", "lupape@gmail.com");
        UserEmail ue9 = new UserEmail(9, "Jessica", "Manzo", "jessica.mazoni@gmail.com");
        UserEmail ue10 = new UserEmail(10, "Fabio", "Crisafulli", "facri@gmail.com");
        UserEmail ue11 = new UserEmail(11, "Valentina", "Verdi", "vale.verdi@libero.it");
        UserEmail ue12 = new UserEmail(12, "Giulia", "De Cesare", "giuda@gmail.com");

        users.add(ue1);
        users.add(ue7);
        users.add(ue2);
        users.add(ue8);
        users.add(ue3);
        users.add(ue9);
        users.add(ue4);
        users.add(ue10);
        users.add(ue5);
        users.add(ue11);
        users.add(ue6);
        users.add(ue12);

        return users;
    }

    public List<Email> flushSingleNormal() {
        List<Email> emails = new LinkedList<>();
        Email email = new Email("aa", "aaa", EmailManager.getInstance().getUsers().get(0).getId(), idEmailGenerator);
        idEmailGenerator++;
        return emails;
    }
    
    public List<Email> flushSingleADV() {
        List<Email> emails = new LinkedList<>();
        Email email = new Email("aa", "se vuoi le mie pentole scrivi a [vendi.pentole@pentolone.it] Tanti saluti", -3, idEmailGenerator);
        idEmailGenerator++;
        return emails;
    }
    
    public List<Email> flushSingleSpam() {
        List<Email> emails = new LinkedList<>();
        Email email = new Email("ciao", "166", 8612, idEmailGenerator);
        idEmailGenerator++;
        return emails;
    }

}
