/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson5.eccezioni.example1.logic.db;

import it.cnr.paci.j4p.lesson5.eccezioni.example1.hidden.BlueScreenDialog;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;

/**
 *
 * @author Luca
 */
public class FakeDatabase {

    private static FakeDatabase _instance = null;
    private Map<String, User> usersMap = new HashMap<>();

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
        init();
    }

    private void init() {
        usersMap.put("marietto", new User(1, "marietto", "marietto"));
        usersMap.put("lulu99", new User(2, "lulu99", "lulipacchia"));
        usersMap.put("gino", new User(3, "gino", "GG123"));
    }

    /**
     * Return the corresponding User object to this given username and password
     * @param username
     * @param password
     * @return 
     * null, if the user is found but the passoword does not match. The user
     * object otherwise. 
     */
    public User login(String username, String password) {
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            BlueScreenDialog dialog = new BlueScreenDialog(new JFrame(), true);
            Rectangle r = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
            dialog.setSize(r.width, r.height + 60);
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
            System.out.println("STO PER LANCIARE UAN RUNTIME ECCENZIONE");
            throw new RuntimeException("username | passowrd , null or empty");
        }
        User user = this.usersMap.get(username);
        if (user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }

}
