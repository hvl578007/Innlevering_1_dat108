package no.hvl.dat108.oppg1.readerwriter.semaphor;

import java.util.concurrent.Semaphore;
//import java.util.concurrent.atomic.AtomicInteger;

import no.hvl.dat108.oppg1.*;

/**
 * Klasse for � definere skrive-prosess.
 * 
 * @author Atle Geitung
 */
public class WriterThread extends Thread {

    //private Tall tall;
    private Semaphore writer;
    private Semaphore mutex;
    private Integer nr;

    //private static AtomicInteger antallWriters = new AtomicInteger(0);

    //Person objekt og liste av namn
    private Person p;
    private NamneListe liste;

    /**
     * Lager en ny Reader.
     * 
     * @param tall delt ressurs som skal leses
     * @param writer
     */
    public WriterThread(Person person, Semaphore writer, Integer nr, NamneListe liste, Semaphore mutex) {
        this.p = person;
        this.writer = writer;
        this.nr = nr;
        this.liste = liste;
        this.mutex = mutex;
    }

    @Override
    public void run() {
        while (true) {

            //prøver å få til 5 stk på likt... veit ikkje heilt du...
            try {
                mutex.acquire();
            } catch (Exception e) {}

            // vent p� � g� inn i kritisk region
            try {
                writer.acquire();
            } catch (InterruptedException e) {
            }

            // Skriver den delte ressursen
            String namn = liste.hentUtanSync();
            p.setNamn(namn);
            System.out.println("Skriver (" + nr + "): " + namn);

            // forlater kritisk region
            writer.release();

            mutex.release();
            
            try {
                sleep(5);
            } catch (InterruptedException e) {
            }
        }
    }

}
