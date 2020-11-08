package ArrayCopy;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Jahrgang j = new Jahrgang("3AHIT", 3);
        j.addSchularbeitstermin(LocalDate.of(2019, 11, 11));
        j.addSchularbeitstermin(LocalDate.of(2019, 12, 23));
        j.addSchularbeitstermin(LocalDate.of(2020, 1, 13));
        System.out.println(j.erstelleTerminliste());
    }
}