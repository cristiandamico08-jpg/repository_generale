import java.io.*;
import java.nio.file.*;

public class Scrittura {
    public Scrittura(){
        Path percorso = Paths.get("fileEsterni", "testo.txt");
        try {
            if (Files.notExists(percorso.getParent())) {
                Files.createDirectories(percorso.getParent());
            }
            String contenuto = "pappagallo";
            Files.writeString(percorso, contenuto, 
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING
            );
            System.out.println("Archiviazione completata!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Scrittura();
    }
}