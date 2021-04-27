/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson5.eccezioni.example1.logic;

import it.cnr.paci.j4p.lesson5.eccezioni.example1.logic.db.FakeDatabase;
import it.cnr.paci.j4p.lesson5.eccezioni.example1.logic.db.User;

/**
 *
 * @author Luca
 */
public class BackendManager {
    
    private static BackendManager _instance = null;
    
    public static BackendManager getInstance() {
        if (_instance == null) {
            _instance = new BackendManager();
            return _instance;
        } else {
            return _instance;
        }
    }
    
    private BackendManager() {
        super();
    }
    
    
     public User login(String username, String password) {
        User userLogged = FakeDatabase.getInstance().login(username, password);
        return userLogged;
     }
    
}
