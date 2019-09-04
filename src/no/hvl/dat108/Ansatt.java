package no.hvl.dat108;

/**
 * Ansatt
 */
public class Ansatt {

    private String fornamn;
    private String etternamn;
    private Kjonn kjonn;
    private String stilling;
    private int aarslonn;

    public Ansatt(String fornamn, String etternamn, Kjonn kjonn, String stilling, int aarslonn) {
        this.fornamn = fornamn;
        this.etternamn = etternamn;
        this.kjonn = kjonn;
        this.stilling = stilling;
        this.aarslonn = aarslonn;
    }

    public String getFornamn() {
        return fornamn;
    }

    public void setFornamn(String fornamn) {
        this.fornamn = fornamn;
    }

    public String getEtternamn() {
        return etternamn;
    }

    public void setEtternamn(String etternamn) {
        this.etternamn = etternamn;
    }

    public Kjonn getKjonn() {
        return kjonn;
    }

    public void setKjonn(Kjonn kjonn) {
        this.kjonn = kjonn;
    }

    public String getStilling() {
        return stilling;
    }

    public void setStilling(String stilling) {
        this.stilling = stilling;
    }

    public int getAarslonn() {
        return aarslonn;
    }

    public void setAarslonn(int aarslonn) {
        this.aarslonn = aarslonn;
    }

    @Override
    public String toString() {
        return "Ansatt [aarslonn=" + aarslonn + ", etternamn=" + etternamn + ", fornamn=" + fornamn + ", kjonn=" + kjonn
                + ", stilling=" + stilling + "]";
    }

    
    
}