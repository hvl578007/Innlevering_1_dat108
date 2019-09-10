package no.hvl.dat108;

/**
 * SkriveRunnable
 */
public class SkriveRunnable implements Runnable {

    private NamneListe liste;
    private Person person;
    private int nr;

    public SkriveRunnable(NamneListe liste, Person p, int nr) {
        this.liste = liste;
        this.person = p;
        this.nr = nr;
    }

    @Override
    public void run() {

        // versjon 1:
        // person.setNamn(namn);

        for (int i = 0; i < 50; i++) {

            String namn = liste.hent();

            // versjon 2
            try {
                person.setNamn2(namn);
                System.out.println("Skrivar (" + nr + "): " + namn);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    
}