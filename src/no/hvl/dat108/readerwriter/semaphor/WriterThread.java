package no.hvl.dat108.readerwriter.semaphor;

import java.util.concurrent.Semaphore;

import no.hvl.dat108.readerwriter.Tall;

/**
 * Klasse for � definere skrive-prosess.
 * 
 * @author Atle Geitung
 */
public class WriterThread extends Thread {

    private Tall tall;
    private Semaphore writer;
    private Integer nr;

    /**
     * Lager en ny Reader.
     * 
     * @param tall delt ressurs som skal leses
     * @param writer
     */
    public WriterThread(Tall tall, Semaphore writer, Integer nr) {
        this.tall = tall;
        this.writer = writer;
        this.nr = nr;
    }

    @Override
    public void run() {
        while (true) {
            // vent p� � g� inn i kritisk region
            try {
                writer.acquire();
            } catch (InterruptedException e) {
            }

            // Skriver den delte ressursen
            tall.inkrement();
            System.out.println("Skriver (" + nr + "): " + tall);

            // forlater kritisk region
            writer.release();
            
            try {
                sleep(5);
            } catch (InterruptedException e) {
            }
        }
    }

}
