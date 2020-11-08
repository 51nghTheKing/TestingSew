package Composition;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.SimpleTimeZone;

public class ToDoListe implements Serializable {
    private String name;
    private ToDoEintrag[] eintraege;

    public ToDoListe(String name) {
        this.name = name;
        this.eintraege = new ToDoEintrag[0];
    }

    /**
     * @param text
     */
    public void addEintrag(String text) {
        eintraege = Arrays.copyOf(eintraege, eintraege.length + 1);
        eintraege[eintraege.length - 1] = new ToDoEintrag(text);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append("\n");
        for (int i = 0; i < eintraege.length; i++) {
            sb.append(eintraege[i].getText()).append("\n");
        }
        return sb.toString();
    }


    public void speichern(String filename) throws IOException {
        //File f = new File(filename);
        //BufferedWriter outputStream = null;
        try { BufferedWriter outputStream = new BufferedWriter(new FileWriter(filename));
            for (int i = 0; i < eintraege.length; ++i) {
                outputStream.write(eintraege[i].getText());
                outputStream.write(System.lineSeparator());
            }
            //  } finally {
            //            if (outputStream != null)
            //                outputStream.close();
        }catch (IOException f){
            f.printStackTrace();
        }
    }

    /**
     * Mit PrintWriter und try-with-resources.
     *public void speichern(String filename) throws IOException {
     * try (PrintWriter outputStream = new PrintWriter(filename)) {
     * for (int i = 0; i < eintraege.length; ++i) {
     * outputStream.println(eintraege[i].getText());
     * }
     * }
     * }
     */

    public void laden(String filename) throws IOException {
        this.eintraege = new ToDoEintrag[0];
        try (BufferedReader inputStream = new BufferedReader(new FileReader(filename))) {
            String text;
            while ((text = inputStream.readLine()) != null) {
                addEintrag(text);
            }
        }
    }
    public static void main(String[] args) {
        ToDoListe t = new ToDoListe("Zuhause Bleiben");
        t.addEintrag("Fußball spielen");
        t.addEintrag("Lernen");

        try(BufferedWriter os = new BufferedWriter(new FileWriter("chauhan.txt"))){
            os.write(t.toString());
        }catch (IOException f){
            System.out.println(f.toString());
        }

        try(BufferedReader inputStream = new BufferedReader(new FileReader("chauhan.txt"))){
            String txt;
            while ((txt = inputStream.readLine()) != null) {
                System.out.println(txt);
            }
        }catch (IOException f){
            System.out.println(f.toString());
        }


        /**
        //Serialisierung
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("ToDo.obj"))) {
            outputStream.writeObject(t);
        } catch (IOException e) {
            System.err.println("Fehler beim Schreiben: " + e.toString());
        }
        //Deserialisierung
        //ToDoListe t = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new
                FileInputStream("ToDo.obj"))) {
            t = (ToDoListe) inputStream.readObject();
            System.out.println(t);
        } catch (IOException e) {
            System.err.println("Fehler beim Laden: " + e.toString());
        } catch (ClassNotFoundException e) {
            System.err.println("Fehler beim Laden: " + e.toString());
        }
       // Files.list(Paths.get("./src")).forEach(System.out::println);
        **/
    }
}