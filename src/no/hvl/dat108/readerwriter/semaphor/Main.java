package no.hvl.dat108.readerwriter.semaphor;

import java.util.concurrent.Semaphore;

import no.hvl.dat108.readerwriter.Tall;

/**
 * Eksempel p� synkronisering. Benytter eksempelet "Readers-Writer".
 * 
 * @author Atle Geitung
 */
public class Main {

    private final static int WRITERS = 5;
    private final static int READERS = 5;

    private static Tall tall = new Tall(0);
    private static Semaphore mutex = new Semaphore(1); // Mutex
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

        Thread[] readerThread = new ReaderThread[READERS];
        Thread[] writerThread = new WriterThread[WRITERS];

        for (int i = 0; i < WRITERS; i++) {
            writerThread[i] = new WriterThread(tall, writer, i);
            writerThread[i].start();
        }

        for (int i = 0; i < READERS; i++) {
            readerThread[i] = new ReaderThread(tall, mutex, writer, i);
            readerThread[i].start();
        }

    }

}
