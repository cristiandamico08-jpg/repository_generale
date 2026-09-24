import java.util.Scanner;

import classi.*;

public class Main {

    private Scanner scanner = new Scanner(System.in);
    private String scelta = null;

    private CodaBanca coda = new CodaBanca();
    private String nome = null;
    private String cognome = null;
    private double saldo = 0;
    private double saldoTotale = 0;
    private double importo = 0;

    public Main(){
        try {
            
            do {
                System.out.println("\nMenu':");
                System.out.println("[1] Ingresso cliente");
                System.out.println("[2] Visualizza coda");
                System.out.println("[3] Servi cliente");
                System.out.println("[4] Statistica banca");
                System.out.println("[0] Esci dal programma");
                System.out.print("Scelta: ");
                scelta = scanner.nextLine();

                switch (scelta) {
                    case "0":
                        System.out.println("\n\n\nArrivederci...\n\n\n");
                        scanner.close();
                        System.exit(0);

                    case "1":
                        System.out.print("\n\nInserisci NOME cliente: ");
                        nome = scanner.nextLine();
                        System.out.print("Inserisci COGNOME cliente: ");
                        cognome = scanner.nextLine();
                        System.out.print("Inserisci SALDO cliente: ");
                        saldo = scanner.nextDouble();
                        scanner.nextLine();

                        coda.inserisci(nome, cognome, saldo);

                        break;

                    case "2":
                        System.out.println("\n" + coda.visualizza());
                        break;

                    case "3":
                        System.out.println("\n\n\nSportello Attivo:");
                        System.out.println(coda.stampaSaldoPrimo());
                        System.out.print(" [1] Versa\n [2] Preleva\nScelta: ");
                        scelta = scanner.nextLine();
                        switch (scelta) {
                            case "1":
                                System.out.print("\n\nInserisci importo: ");
                                importo = scanner.nextDouble();
                                scanner.nextLine();
                                saldoTotale += importo;
                                System.out.println("\nIl cliente lascia lo sportello con " + coda.versa(importo) + " euro\n\n");
                                coda.serviProssimo();
                                break;

                            case "2":
                                System.out.print("\n\nInserisci importo: ");
                                importo = scanner.nextDouble();
                                scanner.nextLine();
                                if (coda.preleva(importo) != 0) {
                                    saldoTotale -= importo;
                                    System.out.println("\nIl cliente lascia lo sportello con " + coda.preleva(importo) + " euro\n\n");
                                    System.out.println(coda.serviProssimo());
                                } else {
                                    System.out.println("\nNon hai abbastanza soldi.\nRiprova\n\n");
                                }
                                break;
                        
                            default:
                                System.out.println("<!> Tasto non valido, esco dal menu' <!>");
                        }
                        break;

                    case "4":
                        System.out.println(coda.visualizza() + "Denaro Transitato: " + saldoTotale);
                        break;
                
                    default:
                        System.out.println("\n\n<!> [" + scelta + "] non e' una scelta! <!>\n\n");
                }

            } while (true);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}