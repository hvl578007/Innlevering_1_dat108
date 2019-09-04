package no.hvl.dat108;

import java.util.Arrays;
import java.util.List;

/**
 * Oppg1
 */
public class Oppg1 {

    public static void main(String[] args) {

        //"copy-paste liste" med namn:
        List<String> listeAvNamn = Arrays.asList("Stian", "Renate", "Jonas", "Tara", "Asbjørn", "Rita", "Grønås");
        
        Thread skrive1 = new Thread(SkriveRunnable::new);
        Thread skrive2 = new Thread(SkriveRunnable::new);
        Thread skrive3 = new Thread(SkriveRunnable::new);
        Thread skrive4 = new Thread(SkriveRunnable::new);
        Thread skrive5 = new Thread(SkriveRunnable::new);
    
        Thread lese1 = new Thread(LeseRunnable::new);
        Thread lese2 = new Thread(LeseRunnable::new);
        Thread lese3 = new Thread(LeseRunnable::new);
        Thread lese4 = new Thread(LeseRunnable::new);
        Thread lese5 = new Thread(LeseRunnable::new);

        //lese: hente namn og skrive ut til system.out.println

        //skrive: hente neste namn frå ein tabell av namn og sette nytt namn på personen.
        //sidan det skal vere ein "sirkulær tabell" må ein leggje til namnet på nytt (bakerst) eller noko...?????

        // vanskeleg å gjere dette når ein såvidt har lært noko ... !!!!!!

    }
}