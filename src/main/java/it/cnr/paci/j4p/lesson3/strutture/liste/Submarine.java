/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson3.strutture.liste;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author sommovir
 */
public class Submarine {

    private String name;
    private SubmarinClass subclass;
    //lo standard vuole che si metta come nome variabile il plurale il tipo(generics) di lista che si sta costruendo
    private List<Torpedo> torpedos = new LinkedList<>();

    //non voglio che si crei un sottomarino col costruttore vuoto perché se no dovrei abilitare i setter che voglio disabilitati.
    //in questo modo forzo il programmatore ad usare solo il costruttore con gli argomenti e evito di aprire i setter.
//    public Submarine() {
//    }
    public Submarine(String name, SubmarinClass subclass) {
        this.name = name;
        this.subclass = subclass;
        switch (subclass) {
            case BARRACUDA: {
                Torpedo torpedo = new Torpedo("BarracudaTorpedo", 100, 1);
                for (int i = 0; i < 4; i++) {
                    this.torpedos.add(torpedo);
                }
                break;
            } //se non mettete le graffe all'interno del blocco case la variabile sotto "torpedo" ve la segnalerà come già inizializzata
            case COLLINS: {
                Torpedo torpedo = new Torpedo("CollinsTorpedo", 90, 1.3f);
                for (int i = 0; i < 6; i++) {
                    this.torpedos.add(torpedo);
                }
                break;
            }
            case GAL: {
                Torpedo torpedo = new Torpedo("CollinsTorpedo", 150, 1.5f);
                for (int i = 0; i < 2; i++) {
                    this.torpedos.add(torpedo);
                }
                break;
            }


        }
    }

    public float shot() {
        if (this.torpedos.isEmpty()) {
            return 0f;
        } else {
            //rimuove il primo della lista
            Torpedo firedTorpedo = this.torpedos.remove(0);
            return firedTorpedo.getShockFactor();
        }
    }

    public String getName() {
        return name;
    }

    //il nome è poco importante per cui lo lascio editabile. 
    public void setName(String name) {
        this.name = name;
    }

    public List<Torpedo> getTorpedos() {
        return torpedos;
    }

    // Non voglio che si possano settare numero e tipologie di siluri dall'esterno
//    public void setTorpedos(List<Torpedo> torpedos) {
//        this.torpedos = torpedos;
//    }
    //nemmeno qui voglio che venga cambiato in itinere la classe del sottomarino
//    public void setSubclass(SubmarinClass subclass) {
//        this.subclass = subclass;
//    }
}
