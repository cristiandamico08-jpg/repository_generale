package repository_generale.Informatica.Sim_verifica_28_nov;
import java.util.Scanner;

/**
 * Classe Main che rappresenta un semplice sistema di ordinazione di panini e bibite.
 * Utilizza array per gestire gli articoli disponibili e calcola il totale dell'ordine.
 * 
 * @author Cristian Dylan D'Amico
 */

public class Main {

    /** Scanner per l'input dell'utente */
    private Scanner input = new Scanner(System.in);

    /** Dimensione massima delle liste di articoli */
    private final int dim = 3;

    /** Liste di articoli: panini e bibite */
    private Articolo[] panini = new Articolo[dim];
    private Articolo[] bibite = new Articolo[dim];

    /** Variabili per la scelta dell'utente e il calcolo del totale */
    private int scelta;
    private double totale;
    private double arrotondamento;

    /** Variabile temporanea per il bubble sort */
    private Articolo temp = new Articolo(null, 0);

    /** 
     * Costruttore con all'interno l'esercizio svolto
     */
    public Main(){

        panini[0] = new Articolo("Prosciutto cotto", 2.50);
        panini[1] = new Articolo("Salame", 3.00);
        panini[2] = new Articolo("Cotoletta", 2.00);

        bibite[0] = new Articolo("Acqua", 1.00);
        bibite[1] = new Articolo("Coca cola", 1.50);
        bibite[2] = new Articolo("Fanta", 1.50);

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Visualizza panini e compra");
            System.out.println("2. Visualizza bibite e compra");
            System.out.println("3. Visualizza scontrino ed esci");
            System.out.print("Scegli un'opzione: ");
            scelta = input.nextInt();
            switch (scelta) {
                case 1:

                    System.out.println("\nElenco Panini:");
                    for (int i = 0; i < dim-1; i++) {
                        for (int j = 0; j < dim-1; j++) {
                            if (panini[j].getPrezzo() > panini[j+1].getPrezzo()) {
                                temp = panini[j];
                                panini[j] = panini[j+1];
                                panini[j+1] = temp;
                            }
                        }
                    }
                    for (int i = 0; i < 3; i++) {
                        System.out.println((i + 1) + ". " + panini[i].getNome() + " - Prezzo: " + panini[i].getPrezzo() + " Euro - Prezzo con IVA: " + panini[i].calcolaPrezzoConIVA() + " Euro");
                    }

                    do {
                        System.out.println("\n\nSeleziona il numero del panino che vuoi comprare");
                        int scelta = input.nextInt();
                        if (scelta >= 1 && scelta <= dim) {
                            System.out.println("Hai comprato il panino: " + panini[scelta - 1].getNome() + " al prezzo di " + panini[scelta - 1].calcolaPrezzoConIVA() + " Euro (IVA inclusa)");
                            totale = totale + panini[scelta - 1].calcolaPrezzoConIVA();
                            arrotondamento = Math.round(totale * 100.0) / 100.0;
                            totale = arrotondamento;
                            break;
                        } else {
                            System.out.println("\n\n\nScelta non valida, riprova.");
                        }
                    } while (true);

                    break;

                case 2:

                    System.out.println("\nElenco Bibite:");
                    for (int i = 0; i < dim-1; i++) {
                        for (int j = 0; j < dim-1; j++) {
                            if (panini[j].getPrezzo() > panini[j+1].getPrezzo()) {
                                temp = panini[j];
                                panini[j] = panini[j+1];
                                panini[j+1] = temp;
                            }
                        }
                    }
                    for (int i = 0; i < dim; i++) {
                        System.out.println((i + 1) + ". " + bibite[i].getNome() + " - Prezzo: " + bibite[i].getPrezzo() + " Euro - Prezzo con IVA: " + bibite[i].calcolaPrezzoConIVA() + " Euro");
                    }
                    do {
                        System.out.println("\n\nSeleziona il numero della bibita che vuoi comprare");
                        scelta = input.nextInt();
                        if (scelta >= 1 && scelta <= dim) {
                            System.out.println("Hai comprato la bibita: " + bibite[scelta - 1].getNome() + " al prezzo di " + bibite[scelta - 1].calcolaPrezzoConIVA() + " Euro (IVA inclusa)");
                            totale = totale + bibite[scelta - 1].calcolaPrezzoConIVA();
                            arrotondamento = Math.round(totale * 100.0) / 100.0;
                            totale = arrotondamento;
                            break;
                        } else {
                            System.out.println("\n\n\nScelta non valida, riprova.");
                        }
                    } while (true);

                    break;

                case 3:
                    System.out.println("\nIl totale del tuo scontrino è di: " + totale + " euro");
                    return;

                default:
                    System.out.println("\n\n\n"  + scelta + " non è un'opzione valida.");
                    break;
            }
        } while (true);
    }

    /**
     * Metodo principale per avviare l'applicazione.
     * 
     * @param args
     */
    public static void main(String[] args) {
        new Main();
    }
}