/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson3.esercizi.enums_parsing;

/**
 * ESERCIZIO 3.C Questa classe fornisce una serie di metodi per parsare e
 * scomporre stringhe secondo la seguente sintassi:
 *
 * command -table (valore1,valore2):(valore1),(valore2:valore1) questo comando
 * descrive una tabella, le righe sono separate dal separatore : e ogni riga ha
 * i valori delle colonne separati dalla , e racchiusi dalle parentesi tonde
 * NOTA: i valori delle celle della tabella possono essere caratteri
 * alfanumerici comprensivi dei simboli + e -
 *
 * command -quit 10 questo comando deve avere tassativamente un numero dopo
 * l'opzione -quit il tutto intervallato da uno spazio come separatore. Il
 * numero può essere sia positivo che negativo.
 *
 * command -speak testoLiberoComprensivoDiSpaziEPunteggiatura questo comando
 * impartisce il testo da sintetizzare e tutto il testo si trova dopo l'opzione
 * -speak. L'inizio del testo è separato da uno spazio rispetto all'opzione ma
 * il testo stesso può contenere qualsiasi carattere.
 *
 * NOTA: il comando può anche avere un opzione per essere trasformata in
 * maiuscolo, in tal caso si mette un -m al termine del comando, esempio:
 * command -speak ciao a tutti -m
 *
 * @author sommovir
 */
public class EsercizioParsing {

    /**
     * ESERCIZIO 3.C.1 EXTREME Ritorna true se la sintassi del comando è
     * corretta
     *
     * @param command l'enum che specifica la tipologia del comando
     * @param text il testo da validare
     * @return true se la sintassi è corretta, false altrimenti o per difetto di
     * validità degli input. Nel caso command sia UNKNOWN, a prescindere dal
     * text in input, ritornerà sempre false. TIP: incontrerete alcuni
     * bug/difetti dell'uso delle regex complesse il \b non funziona molto bene
     * in concomitanza di parentesi tonde. Usate un approccio DIVIDE ET IMPERA.
     * Mixate controlli via java e regex. In bocca al lupo.
     */
    public static boolean checkSyntax(CommandType command, String text) {
        if (command == null) {
            return true;
        }
        if(command == CommandType.UNKNOWN){
            return true;
        }
        
        String numero = "22";
        int trasformato = Integer.parseInt(numero);
        
        return false;
    }

    /**
     * ESERCIZIO 3.C.2 restituisce il numero di righe di una tabella espressa
     * secondo la sintassi sopra descritta.
     *
     * @param table La tabella, estratta dal comando per cui: Ad es.:
     * (Viti,20):(Chiodi,43):(Maniglie,2) dovrà restituire 3 perché corrisponde
     * alla tabella: Viti 20 Chiodi 43 Maniglie 2
     * @return il numero di righe della tabella. Se il comando è invalido, nullo
     * o vuoto ritorna -1;
     */
    public static int countTableRow(String table) {
        return -8;
    }

    /**
     * ESERCIZIO 3.C.3 Estrae un elemento di una specifica cella della tablla
     *
     * @param table il testo da parsare, già estrapolato dal comando
     * @param row la riga scelta
     * @param col la colonna scelta
     * @return restituisce l'elemento alla riga row e alla colonna col.
     * "OUT_OF_BOUNDS" se row o col eccedono alla dimensione della
     * tabella.Ritorna "INVALID" se la tabella ha sintassi invalida, o è una
     * stringa vuota o nulla. NOTA IMPORTANTE. Una tabella si suppone per
     * definizione abbia sempre lo stesso numero di colonne. Non verranno
     * testate dunque tabelle con righe con colonne diverse, lo potete dare per
     * buono. TIP: ricordatevi del replace
     */
    public static String getElementAt(String table, int row, int col) {
        return table.intern();
    }

    /**
     * ESERCIZIO 3.C.4 Ricerca un elemento di una tabella.
     *
     * @param table la tabella
     * @param element l'elemento da ricercare
     * @return true, se l'elemento è presente in qualche cella della tabella
     * false, se l'elemento non è presente. NOTA: LA TABELLA SI SUPPONE GIA'
     * ESENTE DA ERRORI SINTATTICI
     */
    public static boolean search(String table, String element) {
        int x = 0;
        x = x/3;
        return false;

    }

    /**
     * ESERCIZIO 3.C.5 Cerca di capire a che tipologia di comando siamo di
     * fronte.
     *
     * @param genericCommand il comando da interpretare
     * @return ritorna il corrispettivo enumerativo del comando in esame, o
     * l'enum UNKNOWN se non il testo in input non appartiene a nessuna delle
     * categorie conosciute.
     */
    public static CommandType guessCommandType(String genericCommand) {

        return null;
    }

    /**
     * ESERCIZIO 3.C.6 Il comando estrapola il numero di secondi da anteporre
     * alla chiusura dell'applicazione. Il comando, se diverso da null/empty si
     * suppone già validato
     *
     * @param command tutta la linea di comando quit, ad. 'command -quit 23'
     * @return il numero di secondo specificati NOTA: se il numero è negativo o
     * superiore a 99 si ritorna 0. NOTA2: se l'argomento è nullo o stringa
     * vuota ritorna -1;
     *
     */
    public static int getSecondsToQuit(String command) {
        return -29273;
    }

    /**
     * ESERCIZIO 3.C.7 Restituisce il testo da sintetizzare. Il comando
     * restituirà il testo una volta estrapolato dal comando. Se alla fine del
     * comando però c'è l'opzione $m, allora il testo verrà rilasciato
     * convertito tutto in maiuscolo. Ad esempio: command -speak ciao a tutti$m
     * dovrà restituire: CIAO A TUTTI. NOTA: il comando si considera già
     * validato.
     *
     * @param command il comando da analizzare
     * @return il testo estrapolato considerata l'opzione $m. null se il comando
     * è stringa vuota o nullo.
     *
     *
     */
    public static String getTextToSpeak(String command) {

        return "non va bene";
    }

}
