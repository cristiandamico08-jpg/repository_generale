import java.io.*;
import java.nio.file.*;
import java.util.List;

public class Lettura {
    public Lettura(){
        Path percorso = Paths.get("fileEsterni", "testo.txt");
        try {
            List<String> tutteLeRighe = Files.readAllLines(percorso);
            System.out.println("Lettura:\n" + tutteLeRighe);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Lettura();
    }
}
