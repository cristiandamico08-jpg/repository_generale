import java.util.Scanner;

/**
 * La classe {@code NumeroMag} legge 10 numeri interi da input dell'utente
 * e determina quale sia il numero maggiore tra essi.
 */
public class NumeroMag {

    /**
     * Metodo principale che avvia l'esecuzione del programma.
     * Legge 10 numeri interi da tastiera e stampa il numero maggiore.
     *
     * @param args argomenti della riga di comando (non utilizzati)
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Array per memorizzare i 10 numeri inseriti dall'utente
        int[] voti = new int[10];

        // Variabile per tenere traccia del numero maggiore
        int mag = 0;

        System.out.print("\n");

        // Ciclo per leggere i numeri dall'utente
        for (int i = 0; i < voti.length; i++) {
            System.out.print("Insersci il " + (i + 1) + "^ numero: ");
            voti[i] = input.nextInt();

            // Aggiorna il numero maggiore se il numero corrente è più grande
            if (voti[i] > mag) {
                mag = voti[i];
            }
        }

        // Stampa il numero maggiore
        System.out.print("\nIl numero maggiore e' " + mag);

        // Chiude lo scanner
        input.close();
    }
}
