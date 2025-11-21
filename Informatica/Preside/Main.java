import java.util.Scanner;

/**
 * La classe {@code Main} rappresenta un programma per gestire informazioni sugli studenti,
 * permettendo di visualizzare gli studenti, calcolare la media dei voti e trovare lo studente con il voto più alto.
 */
public class Main {

    /**
     * Scanner per leggere input da tastiera.
     */
    public Scanner input = new Scanner(System.in);

    /**
     * Dimensione dell'array di studenti.
     */
    public final int dim = 5;

    /**
     * Costruttore della classe {@code Main}.
     * Inizializza l'array di studenti, gestisce il menù e le operazioni su di essi.
     */
    public Main() {

        // Creazione array di studenti con i rispettivi voti
        Preside[] studente = new Preside[dim];
        studente[0] = new Preside("Cippo Cioppo", "4FI", 6.25);
        studente[1] = new Preside("Micaela Sessa", "4AL", 10);
        studente[2] = new Preside("Gargamella", "1CI", 5.75);
        studente[3] = new Preside("Andreoni", "4GI", 2.05);
        studente[4] = new Preside("Zoe", "2BL", 8);

        int scelta;
        double somma = 0;
        double media = 0;
        double arrotondamento = 0;
        double mag = 0;

        // Ciclo del menù principale
        do {
            System.out.print("\n\n\n---Menu'---\n 1 - Stampa tutti gli studenti \n 2 - Calcolare e mostrare la media dei voti di tutta la scuola \n 3 - Trovare e mostrare lo studente con il voto più alto, indicando anche la classe \n 4 - Chiudi il programma \n\n Scelta: ");
            scelta = input.nextInt();

            switch (scelta) {

                // Stampa degli studenti
                case 1:
                    System.out.println("\nNOME:               CLASSE:       VOTO:\n");
                    for (int i = 0; i < dim; i++) {
                        System.out.println(studente[i].getNomi() + "         " + studente[i].getClassi() + "            " + studente[i].getVoti());
                    }
                    break;

                // Calcolo della media dei voti
                case 2:
                    somma = 0; // Reset somma per evitare accumulo errato
                    for (int i = 0; i < dim; i++) {
                        somma = somma + studente[i].getVoti();
                    }
                    media = somma / dim;
                    arrotondamento = (double) Math.round(media * 100) / 100;
                    System.out.println("\nLa media dei voti della scuola e': " + arrotondamento);
                    break;

                // Ricerca dello studente con il voto più alto
                case 3:
                    mag = 0; // Reset del massimo
                    for (int i = 0; i < dim; i++) {
                        if (studente[i].getVoti() > mag) {
                            mag = studente[i].getVoti();
                        }
                    }
                    for (int i = 0; i < dim; i++) {
                        if (studente[i].getVoti() == mag) {
                            System.out.println("\nLo studente con il voto piu' alto e': " + studente[i].getNomi() + "\nFrequenta la classe: " + studente[i].getClassi());
                        }
                    }
                    break;

                // Uscita dal programma
                case 4:
                    System.exit(0);
                    break;

                // Gestione input non valido
                default:
                    System.out.println(scelta + " non è una scelta!\n\n");
                    break;
            }
        } while (true);
    }

    /**
     * Metodo principale che avvia il programma creando un'istanza di {@code Main}.
     *
     * @param args argomenti della riga di comando (non utilizzati)
     */
    public static void main(String[] args) {
        new Main();
    }
}
