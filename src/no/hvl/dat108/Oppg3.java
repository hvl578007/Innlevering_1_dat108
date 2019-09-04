package no.hvl.dat108;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Oppg3
 */
public class Oppg3 {

    public static void main(String[] args) {
        Ansatt a1 = new Ansatt("Stian", "Grønås", Kjonn.mann, "IT", 400000);
        Ansatt a2 = new Ansatt("Renate", "Grønås", Kjonn.kvinne, "Kjemikar", 450000);
        Ansatt a3 = new Ansatt("Jonas", "Grønås", Kjonn.mann, "e-sport", 600000);
        Ansatt a4 = new Ansatt("Tara", "Grønås", Kjonn.kvinne, "hund...", 1000);
        Ansatt a5 = new Ansatt("Ukjent", "Person", Kjonn.mann, "Mystisk", 250000);
        List<Ansatt> tilsette = Arrays.asList(a1, a2, a3, a4, a5);

        //i. Eit fast kronetillegg - 5000 kr tester eg med
        Function<Ansatt, Integer> fastKr5k = a -> a.getAarslonn() + 5000;

        //ii. Eit fast prosenttillegg - 5%
        Function<Ansatt, Integer> fastProsent5 = a -> (int)(a.getAarslonn() * 1.05);

        //iii. Eit fast kronetillegg viss ein har låg lønn, 10000 om ein ligg under 300000?
        //anna måte???
        Function<Ansatt, Integer> fastKrLagLonn = a -> {
            if(a.getAarslonn() < 300000) return a.getAarslonn()+10000;
            else return a.getAarslonn();
        };

        //iv. Eit fast prosenttillegg viss du er mann
        //anna måte???
        Function<Ansatt, Integer> fastProsentMann = a -> {
            if(a.getKjonn() == Kjonn.mann) return (int)(a.getAarslonn()*1.10);
            else return a.getAarslonn();
        };

        System.out.println("Før lønnsoppgjer:");
        skrivUtAlle(tilsette);


        //tester - i.
        //lonnsoppgjor(tilsette, fastKr5k);

        //tester - ii.
        //lonnsoppgjor(tilsette, fastProsent5);

        //tester - iii.
        //lonnsoppgjor(tilsette, fastKrLagLonn);

        //tester - iv.
        lonnsoppgjor(tilsette, fastProsentMann);


        System.out.println("Etter lønnsoppgjer");
        skrivUtAlle(tilsette);
    }

    //kan jo leggje til ein til parameter her, som vil filtrere ut dei som det ikkje skal oppdaterast på ??? - Eit "Predicate". Og evt ein int med verdi (prosent/kr???)
    private static void lonnsoppgjor(List<Ansatt> tilsette, Function<Ansatt, Integer> f) {
        tilsette.stream().forEach(a -> a.setAarslonn(f.apply(a)));
    }

    private static void skrivUtAlle(List<Ansatt> tilsette) {
        tilsette.stream().forEach(System.out::println);
    }
}