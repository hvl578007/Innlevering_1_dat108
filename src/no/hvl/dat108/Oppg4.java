package no.hvl.dat108;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Oppg4
 */
public class Oppg4 {

    public static void main(String[] args) {
        
        Ansatt a1 = new Ansatt("Stian", "Grønås", Kjonn.mann, "IT", 400000);
        Ansatt a2 = new Ansatt("Renate", "Grønås", Kjonn.kvinne, "Kjemikar", 450000);
        Ansatt a3 = new Ansatt("Jonas", "Grønås", Kjonn.mann, "e-sport", 600000);
        Ansatt a4 = new Ansatt("Tara", "Grønås", Kjonn.kvinne, "hund... og ein sjef", 800000);
        Ansatt a5 = new Ansatt("Ukjent", "Person", Kjonn.mann, "Mystisk", 250000);
        List<Ansatt> tilsette = Arrays.asList(a1, a2, a3, a4, a5);


        //a) Liste med kun etternamn
        List<String> etternamna = tilsette.stream()
            .map(Ansatt::getEtternamn)
            .collect(Collectors.toList());

        System.out.println("Etternamn");;
        skrivUtAlle(etternamna);


        //b) Tal på kvinner blant dei tilsette
        long talPaaKvinner = tilsette.stream()
            .filter(a -> a.getKjonn() == Kjonn.kvinne)
            .count();

        System.out.println("Tal på kvinner: " + talPaaKvinner);


        //c) Rekn ut gjen.snittlønn til kvinnene
        int gjnsnittLoenn = (int)tilsette.stream()
            .filter(a -> a.getKjonn() == Kjonn.kvinne)
            .mapToInt(Ansatt::getAarslonn)
            .average()
            .getAsDouble();

        System.out.println("Gjnsnittlønn til kvinnene: " + gjnsnittLoenn);


        //d) Gje alle sjefar (stillig inneheld sjef) ein lønnsaukning på 7% via streams direkte, forEach sluttar det, skal den lagrast i noko her?
        tilsette.stream()
        .filter(a -> a.getStilling().contains("sjef"))
        .forEach(a -> a.setAarslonn((int)(a.getAarslonn()*1.07)));

        System.out.println("Alle tilsette der sjefane har fått auke:");
        skrivUtAlle(tilsette);


        //e) Finn ut om det er nokon som tjene meir enn 800000
        boolean meirEnn800k = tilsette.stream()
        .anyMatch(a -> a.getAarslonn() > 800000);

        System.out.println("Er det ein som tjenar meir enn 800k? " + meirEnn800k);


        //f) Skriv ut alle dei tilsette med System.out.println() utan å bruke løkkje
        //sjå: skrivUtAlle()
        //tilsette.stream().forEach(System.out::println);


        //g) Finn og skriv ut den/dei tilsette som har lågast lønn
        //finne minstelønn først, og så filtrerer... ??
        int minsteLoenn = tilsette.stream()
            .min((t1, t2) -> t1.getAarslonn() - t2.getAarslonn())
            .get()
            .getAarslonn();
        List<Ansatt> tilsetteMedLiteLoenn = tilsette.stream()
            .filter(a -> a.getAarslonn() == minsteLoenn)
            .collect(Collectors.toList());

        System.out.println("Dei med den minste lønna -" + minsteLoenn + "- :");
        skrivUtAlle(tilsetteMedLiteLoenn);


        //h) Finn og skriv ut summen av alle heiltal i [1, 1000> som er deleleg med 3 eller 5
        IntStream straumAvHeiltal = IntStream.iterate(0, i -> i < 1000, i -> i+1);
        int sum = straumAvHeiltal.filter(i -> i % 5 == 0 || i % 3 == 0).sum();
        System.out.println("Sum av heiltal deleleg på 3 eller 5 og er frå 1-999: " + sum);
        
    }

    private static <T> void skrivUtAlle(List<T> liste) {
        liste.stream().forEach(System.out::println);
    }
}