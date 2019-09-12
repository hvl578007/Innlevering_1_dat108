package no.hvl.dat108.oppg1.readerwriter.semaphor;

import java.util.concurrent.Semaphore;

import no.hvl.dat108.oppg1.NamneListe;
import no.hvl.dat108.oppg1.Person;


/**
 * Eksempel p� synkronisering. Benytter eksempelet "Readers-Writer".
 * 
 * @author Atle Geitung
 */
public class Main {

    private final static int WRITERS = 5;
    private final static int READERS = 5;

    //private static Tall tall = new Tall(0);

    //Person objekt og liste av namn
    private static NamneListe liste = new NamneListe();
    private static Person person = new Person(new StringBuffer(liste.hent()));


    private static Semaphore mutex = new Semaphore(1); // Mutex
    private static Semaphore mutexWriter = new Semaphore(1);
    private static Semaphore writer = new Semaphore(WRITERS);

    /**
     * Hide the constructor.
     */
    private Main() {
    }

    /**
     * Applikasjonen.
     * 
     * @param args not used
     */
    public static void main(String[] args) {

        //var litt vanskeleg å forstå Semaphorer og slikt...
        //det "fungerer" med 5 skrivarar nå? dei skriv ikkje over kvarandre nå så...

        Thread[] readerThread = new ReaderThread[READERS];
        Thread[] writerThread = new WriterThread[WRITERS];

        for (int i = 0; i < WRITERS; i++) {
            writerThread[i] = new WriterThread(person, writer, i, liste, mutexWriter);
            writerThread[i].start();
        }

        for (int i = 0; i < READERS; i++) {
            readerThread[i] = new ReaderThread(person, mutex, writer, i);
            readerThread[i].start();
        }

    }

}
