package no.hvl.dat108.oppg1;

/**
 * LeseRunnable
 */
public class LeseRunnable implements Runnable {

    private Person person;
    private int nr;

    public LeseRunnable(Person p, int nr) {
        this.person = p;
        this.nr = nr;
    }

    @Override
    public void run() {

        // versjon 1
        // String namn = person.getNamnSync();

        for (int i = 0; i < 50; i++) { //while(true)
            // versjon 2
            try {
                //hentar ut og skriv ut namnet
                System.out.println("Leser (" + nr + "): " + this.person.getNamn2());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        
    }

    
}