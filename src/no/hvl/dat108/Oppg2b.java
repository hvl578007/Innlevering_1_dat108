package no.hvl.dat108;

import java.util.function.BiFunction;

/**
 * Oppg2b
 */
public class Oppg2b {

    public static void main(String[] args) {
        
        //uttrykk som variablar
        BiFunction<Integer, Integer, Integer> summer = (a, b) -> a + b;
        BiFunction<Integer, Integer, Integer> storsteAv = Integer::max;
        BiFunction<Integer, Integer, Integer> avstand = (a, b) -> Math.abs(a-b);

        //i. Summen av 12 og 13
        int svar1 = beregn(12, 13, summer);
        System.out.println(svar1);

        //ii. Den største av -5 og 3
        int svar2 = beregn(-5, 3, storsteAv);
        System.out.println(svar2);

        //iii. Avstanden (absoluttverdien av differansen) mellom 54 og 45
        int svar3 = beregn(54, 45, avstand);
        System.out.println(svar3);
    }

    //beregn som tar inn ein BiFunction + 2 int-ar
    public static int beregn(int a, int b, BiFunction<Integer, Integer, Integer> biFk) {
        return biFk.apply(a, b);
    }

    // -- FERDIG --
}