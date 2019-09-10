package no.hvl.dat108.readerwriter;

/**
 * Lager en tall-klasse ettersom Integer ikke kan brukes her.
 * 
 * @author Atle Geitung
 */
public class Tall {
    
    private int verdi;

    public Tall(int verdi) {
        this.verdi = verdi;
    }

    synchronized public int inkrement() {
        verdi++;
        return verdi;
    }

    @Override
    public String toString() {
        return "" + verdi;
    }
}
