/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson2.builder;

/**
 *
 * @author sommovir
 */
public class BuilderExample {
    
    public static void main(String[] args) {
        GamePG pg = GamePG.Builder.create()
                .name("Gino")
                .hp(33)
                .cdef(23)
                .pdef(31)
                .type("Soldier")
                .build();
        System.out.println("pg hp = "+pg.getHp());
    }
    
}
