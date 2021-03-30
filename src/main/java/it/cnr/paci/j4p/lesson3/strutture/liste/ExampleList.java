/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson3.strutture.liste;

/**
 *
 * @author sommovir
 */
public class ExampleList {

    public static void main(String[] args) {
        Submarine sottomarino = new Submarine("Distruttore degli Oceani", SubmarinClass.COLLINS);

        for (int i = 1; i <= 10; i++) {
            float shot = sottomarino.shot();
            if (shot != 0f) {
                System.out.println("il danno per il siluro n. " + i + " è " + shot);
            }else{
                System.out.println("il sottomarino ha terminato i siluri");
            }
        }

        System.out.println("ciao");
    }
}
