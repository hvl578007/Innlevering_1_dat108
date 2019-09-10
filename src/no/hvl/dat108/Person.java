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

    //skal bruke med semaphor
    public void setNamnNormal(String namn) {
        this.namn.delete(0, this.namn.length());
        this.namn.append(namn);
    }

    //berre ein kan lese om gangen
    public synchronized String getNamnSync() {
        return namn.toString();
    }

    //v2 - personen må ha blitt lest for at ein kan skrive, og omvendt
    private boolean erLest;

    //ny setnamn som ventar på at objektet har blitt lest før ein skriv nytt namn
    public synchronized void setNamn2(String namn) throws InterruptedException {
        while(!erLest) {
            wait();
        }
        this.namn.delete(0, this.namn.length());
        this.namn.append(namn);
        this.erLest = false;
        notify();
    }

    //dei kan berre lese ein om gangen, om ein fjernar synchronized kan vel fleire komme inn før ein av dei set erLest til true
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