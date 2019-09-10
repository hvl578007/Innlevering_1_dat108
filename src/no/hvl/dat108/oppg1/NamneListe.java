package no.hvl.dat108.oppg1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * NamneListe
 */
public class NamneListe {

    private List<String> listeAvNamn = new ArrayList<>();

    public NamneListe() {
        listeAvNamn.addAll(Arrays.asList("Stian", "Renate", "Jonas", "Tara", "Asbjørn", "Rita", "Grønås"));
    }

    //synchronized hent metode slik at ingen henter samme namn på likt + blir lagt inn på nytt bakerst
    //kunne vel ha brukt ein collection som fungerer sånn menmen

    public synchronized String hent() {
        String namn = listeAvNamn.remove(0);
        listeAvNamn.add(namn);
        return namn;
    }

    public String hentUtanSync() {
        String namn = listeAvNamn.remove(0);
        listeAvNamn.add(namn);
        return namn;
    }

    @Override
    public String toString() {
        return listeAvNamn.toString();
    }
}