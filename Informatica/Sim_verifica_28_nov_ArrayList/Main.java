package repository_generale.Informatica.Sim_verifica_28_nov_ArrayList;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    private Scanner input = new Scanner(System.in);
    private final int dim = 3;
    private ArrayList<Articolo> panini = new ArrayList<Articolo>();
    private ArrayList<Articolo> bibite = new ArrayList<Articolo>();
    private int scelta;
    private double totale;
    private double arrotondamento;
    private Articolo temp = new Articolo(null, 0);

    public Main(){

        panini.add(0, new Articolo("Prosciutto e formaggio", 4.00));
        panini.add(1, new Articolo("Vegetariano", 3.50));
        panini.add(2, new Articolo("Tonno e pomodoro", 4.50));

        bibite.add(0, new Articolo("Acqua naturale 0.5L", 2.00));
        bibite.add(1, new Articolo("Bibita gassata 0.5L", 2.50));
        bibite.add(2, new Articolo("Succo di frutta 0.2L", 1.00));

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
                            if (panini.get(j).getPrezzo() > panini.get(j+1).getPrezzo()) {
                                temp = panini.get(j);
                                panini.set(j, panini.get(j+1));
                                panini.set(j+1, temp);
                            }
                        }
                    }
                    for (int i = 0; i < 3; i++) {
                        System.out.println((i + 1) + ". " + panini.get(i).getNome() + " - Prezzo: " + panini.get(i).getPrezzo() + " Euro - Prezzo con IVA: " + panini.get(i).calcolaPrezzoConIVA() + " Euro");
                    }

                    do {
                        System.out.println("\n\nSeleziona il numero del panino che vuoi comprare");
                        int scelta = input.nextInt();
                        if (scelta >= 1 && scelta <= dim) {
                            System.out.println("Hai comprato il panino: " + panini.get(scelta - 1).getNome() + " al prezzo di " + panini.get(scelta - 1).calcolaPrezzoConIVA() + " Euro (IVA inclusa)");
                            totale = totale + panini.get(scelta - 1).calcolaPrezzoConIVA();
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
                            if (bibite.get(j).getPrezzo() > bibite.get(j+1).getPrezzo()) {
                                temp = bibite.get(j);
                                bibite.set(j, bibite.get(j+1));
                                bibite.set(j+1, temp);
                            }
                        }
                    }
                    for (int i = 0; i < dim; i++) {
                        System.out.println((i + 1) + ". " + bibite.get(i).getNome() + " - Prezzo: " + bibite.get(i).getPrezzo() + " Euro - Prezzo con IVA: " + bibite.get(i).calcolaPrezzoConIVA() + " Euro");
                    }
                    do {
                        System.out.println("\n\nSeleziona il numero della bibita che vuoi comprare");
                        scelta = input.nextInt();
                        if (scelta >= 1 && scelta <= dim) {
                            System.out.println("Hai comprato la bibita: " + bibite.get(scelta - 1).getNome() + " al prezzo di " + bibite.get(scelta - 1).calcolaPrezzoConIVA() + " Euro (IVA inclusa)");
                            totale = totale + bibite.get(scelta - 1).calcolaPrezzoConIVA();
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

    public static void main(String[] args) {
        new Main();
    }
}