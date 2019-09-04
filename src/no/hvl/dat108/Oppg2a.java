package no.hvl.dat108;

import java.util.Arrays;
import java.util.List;

/**
 * Oppg2a
 */
public class Oppg2a {

    public static void main(String[] args) {
        
        List<String> lista = Arrays.asList("10", "1", "20", "110", "21", "12");

        //gjer om kvar streng til int og så trekk dei frå kvarandre
        lista.sort( (s1, s2) -> Integer.parseInt(s1) - Integer.parseInt(s2));
        
        //stream for å enkelt skrive ut alle
        lista.stream().forEach(System.out::println);

        // -- FERDIG --
    }
}