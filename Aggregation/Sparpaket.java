package Aggregation;

import java.util.Arrays;
public class Sparpaket {
    private double nachlass;
    private Produkt[] inhalt;

    /**
     * @param nachlass
     * @param p
     */
    public Sparpaket(double nachlass, Produkt p) {
        if (p == null) {
            throw new IllegalArgumentException("Fuer p muss ein Wert angegeben werden!");
        }
        this.nachlass = nachlass;
        inhalt = new Produkt[1];
        inhalt[0] = p;
    }

    public void add(Produkt produkt) {
        inhalt = Arrays.copyOf(inhalt, inhalt.length + 1);
        inhalt[inhalt.length - 1] = produkt;
    }
}