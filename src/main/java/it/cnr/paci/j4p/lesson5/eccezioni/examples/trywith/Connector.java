/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson5.eccezioni.examples.trywith;

/**
 *
 * @author Luca
 */
public class Connector implements AutoCloseable{

    public Connector() {
    }
    
    public void doSomething(){
        System.out.println("ciao");
    }
    
    public void connect(){
        System.out.println("connected");
    }
    
    public void disconnect(){
        System.out.println("disconnected");
    }

    @Override
    public void close() throws Exception {
        disconnect();
    }
    
}
