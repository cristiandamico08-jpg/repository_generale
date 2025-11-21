/**
 * Classe principale che gestisce un semplice magazzino di prodotti.
 * Calcola e stampa informazioni come totale scorte,
 * prodotto con scorte maggiori/minori e numero di prodotti sotto una soglia.
 */
public class Main {

    /**
     * Metodo principale del programma.
     * Crea un array di oggetti Prodotti, stampa l'elenco e
     * calcola varie statistiche sulle scorte.
     *
     * @param args argomenti da linea di comando (non utilizzati)
     */
    public static void main(String[] args) {

        /** Dimensione fissa dell'array di prodotti */
        final int dim = 7;

        /** Array che rappresenta il magazzino */
        Prodotti[] magazzino = new Prodotti[dim];

        // Inizializzazione dei prodotti
        magazzino[0] = new Prodotti(12, "Pasta");
        magazzino[1] = new Prodotti(8, "Riso");
        magazzino[2] = new Prodotti(4, "Biscotti");
        magazzino[3] = new Prodotti(0, "Latte");
        magazzino[4] = new Prodotti(20, "Uova");
        magazzino[5] = new Prodotti(3, "Pane");
        magazzino[6] = new Prodotti(6, "Farina");

        /** Variabile per il totale delle scorte */
        int tot = 0;

        /** Quantità massima di scorte trovata */
        int mag = 0;

        /** Quantità minima di scorte trovata */
        int min = magazzino[0].getScorte();

        /** Numero di prodotti con meno di 5 pezzi */
        int nProd = 0;

        // Stampa dei prodotti presenti nel magazzino
        System.out.println("\nINDICE:     PRODOTTO:       SCORTE:\n");
        for (int i = 0; i < dim; i++) {
            System.out.println(" " + (i + 1) + " -         " 
                + magazzino[i].getProdotto() + "      " 
                + magazzino[i].getScorte());
        }

        // Calcolo del totale delle scorte
        for (int i = 0; i < dim; i++) {
            tot += magazzino[i].getScorte();
        }
        System.out.println("\n\nTotale delle scorte: " + tot);

        // Individuazione della quantità di scorte maggiore
        for (int i = 0; i < dim; i++) {
            if (magazzino[i].getScorte() > mag) {
                mag = magazzino[i].getScorte();
            }
        }

        // Stampa dei prodotti con scorte maggiori
        for (int i = 0; i < dim; i++) {
            if (magazzino[i].getScorte() == mag) {
                System.out.println(
                    "\n\nProdotto con la quantità di scorte maggiore: " 
                    + magazzino[i].getProdotto()
                );
            }
        }

        // Individuazione della quantità di scorte minore
        for (int i = 0; i < dim; i++) {
            if (magazzino[i].getScorte() < min) {
                min = magazzino[i].getScorte();
            }
        }

        // Stampa dei prodotti con scorte minori
        for (int i = 0; i < dim; i++) {
            if (magazzino[i].getScorte() == min) {
                System.out.print(
                    "\n\nProdotto con la quantità di scorte minore: " 
                    + magazzino[i].getProdotto()
                );
                if (min == 0) {
                    System.out.println(" (esaurito)");
                }
            }
        }

        // Conteggio dei prodotti con meno di 5 pezzi
        for (int i = 0; i < dim; i++) {
            if (magazzino[i].getScorte() < 5) {
                nProd++;
            }
        }
        System.out.println("\n\nNumero di prodotti con meno di 5 pezzi: " + nProd);

    }
}
