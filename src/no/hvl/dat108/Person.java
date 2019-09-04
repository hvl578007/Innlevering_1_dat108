package no.hvl.dat108;

/**
 * Person
 */
public class Person {

    private StringBuffer namn;

    public Person() {
        this(null);
    }

    public Person(StringBuffer namn) {
        this.namn = namn;
    }

    //usikker om ein skal bruke dette, kanskje berre getNamn? IDK
    /**
     * @param namn the namn to set
     */
    public void setNamn(StringBuffer namn) {
        this.namn = namn;
    }

    /**
     * @return the namn
     */
    public StringBuffer getNamn() {
        return namn;
    }
}