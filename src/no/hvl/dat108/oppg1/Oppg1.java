﻿package no.hvl.dat108.oppg1;

/**
 * Oppg1
 */
public class Oppg1 {

    public static void main(String[] args) throws InterruptedException {

        //liste med namn, er synchronized:
        NamneListe liste = new NamneListe();
        StringBuffer s = new StringBuffer(liste.hent());
        Person p = new Person(s);

        Thread skrive1 = new Thread(new SkriveRunnable(liste, p, 1));
        Thread skrive2 = new Thread(new SkriveRunnable(liste, p, 2));
        Thread skrive3 = new Thread(new SkriveRunnable(liste, p, 3));
        Thread skrive4 = new Thread(new SkriveRunnable(liste, p, 4));
        Thread skrive5 = new Thread(new SkriveRunnable(liste, p, 5));
    
        Thread lese1 = new Thread(new LeseRunnable(p, 1));
        Thread lese2 = new Thread(new LeseRunnable(p, 2));
        Thread lese3 = new Thread(new LeseRunnable(p, 3));
        Thread lese4 = new Thread(new LeseRunnable(p, 4));
        Thread lese5 = new Thread(new LeseRunnable(p, 5));

        //min versjon - med wait og notify (i Person klassen) og synchronized.
        //dei kan berre lese/skrive ein om gongen her då. Ikkje heilt som i oppgåveteksten då men "nesten"?
        //er også ein v1 kommentert vekk i Person/Runnable klassane, berre synchronized her
        
        //alternativ - modifisert lærar sin kode med Semaphor - sjå i readerwriter mappa/package 

        //lese: hente namn og skrive ut til system.out.println

        //skrive: hente neste namn frå ein tabell av namn og sette nytt namn på personen.
        lese1.start();
        lese2.start();
        lese3.start();
        lese4.start();
        lese5.start();

        skrive1.start();
        skrive2.start();
        skrive3.start();
        skrive4.start();
        skrive5.start();
        
    }
}