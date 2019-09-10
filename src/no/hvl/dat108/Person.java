package no.hvl.dat108;

/**
 * Person
 */
public class Person {

    private StringBuffer namn;

    public Person(StringBuffer namn) {
        this.namn = namn;
        this.erLest = false;
    }

    //v1 - dei kan berre skrive ein om gangen, men alle kan lese uansett...

    public synchronized void setNamn(String namn) {
        this.namn.delete(0, this.namn.length());
        this.namn.append(namn);
    }

    public String getNamn() {
        return namn.toString();
    }

    //berre ein kan lese om gangen
    public synchronized String getNamnSync() {
        return namn.toString();
    }

    //v2 - personen må ha blitt lest for at ein kan skrive, og omvendt
    private boolean erLest;

    public synchronized void setNamn2(String namn) throws InterruptedException {
        while(!erLest) {
            wait();
        }
        this.namn.delete(0, this.namn.length());
        this.namn.append(namn);
        this.erLest = false;
        notify();
    }

    public synchronized String getNamn2() throws InterruptedException {
        while(erLest) {
            wait();
        }
        this.erLest = true;
        notify();
        return this.namn.toString();
    }

    @Override
    public String toString() {
        return namn.toString();
    }
}