package no.hvl.dat108.oppg1.readerwriter.semaphor;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

import no.hvl.dat108.oppg1.*;

/**
 * Klasse for � definere lese-prosess.
 * 
 * @author Atle Geitung
 */
public class ReaderThread extends Thread {

    //private Tall tall;
    private Semaphore mutex;
    private Semaphore writer;
    private static AtomicInteger antallReaders = new AtomicInteger(0);
    private Integer nr;

    //Person objekt
    private Person p;

    /**
     * Lager en ny Reader.
     * 
     * @param tall delt ressurs som skal leses
     * @param mutex
     * @param writer
     */
    public ReaderThread(Person person, Semaphore mutex, Semaphore writer, Integer nr) {
        this.p = person;
        this.mutex = mutex;
        this.writer = writer;
        this.nr = nr;
    }

    @Override
    public void run() {
        while (true) {
            // vent p� � g� inn i kritisk region
            try {
                mutex.acquire();
            } catch (InterruptedException e) {
            }

            // �k antall lesere i kritisk region
            // f�rste leser er inne i kritisk region
            // skrivere m� vente til alle lesere er ute av regionen
            if (antallReaders.incrementAndGet() == 1) {
                try {
                    writer.acquire();
                } catch (InterruptedException e) {
                }
            }

            // andre lesere kan g� inn i kritisk region
            mutex.release();

            // Leser den delte ressursen
            System.out.println("Leser   (" + nr + "): " + p);

            // venter p� � f� forlate regionen
            try {
                mutex.acquire();
            } catch (InterruptedException e) {
            }

            // ferdig med lesing
            // ingen lesere igjen i den kritiske regionen
            if (antallReaders.decrementAndGet() == 0) {
                // skriver kan utf�re sin kritiske region
                writer.release();
            }

            // leseren forlater regionen
            mutex.release();
            
            try {
                sleep(5);
            } catch (InterruptedException e) {
            }
        }
    }

}
