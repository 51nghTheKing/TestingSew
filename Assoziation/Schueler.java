package Assoziation;
public class Schueler {
    private String name;
    private Adresse wohnsitz;

    /**
     * @param name
     * @param wohnsitz
     */
    public Schueler(String name, Adresse wohnsitz) {
        if (wohnsitz == null) {
            throw new IllegalArgumentException("Fuer wohnsitz muss ein Wert angegeben werden!");
        }
        this.name = name;
        this.wohnsitz = wohnsitz;
    }
}