import java.util.Scanner;

import classi.*;

public class Main {

    private Scanner scanner = new Scanner(System.in);
    private String scelta = null;

    private Lista lista = new Lista();

    private String id = null;
    private String paziente = null;
    private String visita = null;
    private double prezzo = 0;

    public Main(){
        do {
            System.out.println("\nMenu:");
            System.out.println("[1] Nuova prenotazione");
            System.out.println("[2] Rimuovi prenotazione per ID");
            System.out.println("[3] Numero prenotazioni in lista");
            System.out.println("[4] Visualizza prossima prenotazione");
            System.out.println("[5] Stampa incasso totale");
            System.out.println("[6] Cerca paziente");
            System.out.println("[7] Conta visite per prezzo");
            System.out.println("[0] Esci dal programma");
            System.out.print("Scelta: ");
            scelta = scanner.nextLine();

            switch (scelta) {
                case "0":
                    System.out.println("\n\n\nArrivederci...\n");
                    System.exit(0);
                
                case "1":
                    System.out.print("\n\nInserisci l'ID della prenotazione: ");
                    id = scanner.nextLine();
                    System.out.print("Inserisci il NOME del PAZIENTE: ");
                    paziente = scanner.nextLine();
                    System.out.print("Inserisci la DESCRIZIONE della VISITA: ");
                    visita = scanner.nextLine();
                    System.out.print("Inserisci il PREZZO: ");
                    prezzo = scanner.nextDouble();
                    scanner.nextLine();

                    lista.push(id, paziente, visita, prezzo);
                    break;
                
                case "2":
                    System.out.print("\n\nInserisci l'ID della prenotazione: ");
                    id = scanner.nextLine();

                    System.out.println(lista.pop(id));
                    break;
                
                case "3":
                    lista.contaPrenotazioni();
                    break;
                
                case "4":
                    lista.stampaProssima();
                    break;
                
                case "5":
                    System.out.println("\n\nL'incasso totale e' di " + lista.getIncassoTotale() + " euro\n");
                    break;
                
                case "6":
                    System.out.print("\n\nInserisci il NOME del PAZIENTE: ");
                    paziente = scanner.nextLine();
                    lista.cercaPaziente(paziente);
                    break;
                
                case "7":
                    System.out.print("\n\nInserisci il PREZZO da controllare: ");
                    prezzo = scanner.nextDouble();
                    scanner.nextLine();
                    lista.contaVisiteCostose(prezzo);
                    break;

                default:
                    System.out.println("\n\n[" + scelta + "] non e' una scelta");
            }
        } while (true);
    }

    public static void main(String[] args) {
        new Main();
    }
}