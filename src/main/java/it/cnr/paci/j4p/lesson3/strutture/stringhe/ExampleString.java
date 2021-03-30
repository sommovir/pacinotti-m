/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson3.strutture.stringhe;

import it.cnr.paci.j4p.lesson3.strutture.stringhe.StringUtils;

/**
 *
 * @author sommovir
 */
public class ExampleString {
    
    public static void main(String[] args) {
        System.out.println("MAIN 3");
        
        System.out.println("\n===  STRINGHE ESEMPIO SPLIT ===");
        String prova = "ciao:Bello:COME:stai";
        String[] parseString = StringUtils.parseString(prova);
        for (String parola : parseString) {
            System.out.println("PAROLA: "+parola);
        }
        
        System.out.println("\n===  STRINGHE ESEMPIO ENDSWITH ===");
        String domanda = "Come ti chiami ?";
        String nondomanda = "Mi chiamo Alfonzo";
        boolean response1 = StringUtils.isInterrogative(domanda);
        System.out.println("La frase ["+domanda+"] è interrogativa ? "+response1);
        boolean response2 = StringUtils.isInterrogative(nondomanda);
        System.out.println("La frase ["+nondomanda+"] è interrogativa ? "+response2);
        
        System.out.println("\n===  STRINGHE ESEMPIO TROVA LINK ===");
        String command = "start -link=[https://youtu.be/olKKWG3HwOg]?=ok";
        String link = StringUtils.isolateLink(command);
        System.out.println("Il link è: "+link);
        
        
         System.out.println("\n===  STRINGHE ESEMPIO REGEX ===");
         
         String card1 = "8872-1231-3455-1111";
         String card2 = "8872 1231 3455 1111";
         String card3 = "8872 1231+3455 1111";
         
         System.out.println("La carta 1 è "+ (StringUtils.isCardNubmerValid(card1) ? "valida" : "invalida"));
         System.out.println("La carta 1 è "+ (StringUtils.isCardNubmerValid(card2) ? "valida" : "invalida"));
         System.out.println("La carta 1 è "+ (StringUtils.isCardNubmerValid(card3) ? "valida" : "invalida"));
         
         
    }
    
}
