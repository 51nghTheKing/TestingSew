package ArrayCopy;
import java.time.LocalDate;
import java.util.Arrays;
public class Jahrgang {
    private String kuerzel;
    private int schulstufe;
    private LocalDate[] schularbeitsTermine;
    private static int maxSchueler = 30;
    public Jahrgang(String kuerzel, int schulstufe) {
        if (kuerzel == null) {
            throw new IllegalArgumentException(
                    "Fuer kuerzel muss ein Wert angegeben werden!");
        }
        this.kuerzel = kuerzel;
        this.schulstufe = schulstufe;
        this.schularbeitsTermine = new LocalDate[0];
    }
    public String erstelleTerminliste() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < schularbeitsTermine.length; i++) {
            sb.append(schularbeitsTermine[i].toString());
            sb.append("\n");
        }
        return sb.toString();
    }
    public void addSchularbeitstermin(LocalDate termin) {
        schularbeitsTermine = Arrays.copyOf(schularbeitsTermine,
                schularbeitsTermine.length + 1);
        schularbeitsTermine[schularbeitsTermine.length - 1] =
                termin;
    }
}
