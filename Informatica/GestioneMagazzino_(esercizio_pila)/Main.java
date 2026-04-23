import java.util.Scanner;

import classi.*;

public class Main {

    private Scanner scanner = new Scanner(System.in);
    private String scelta = null;

    private String codice = null;
    private String descrizione = null;
    private double peso = 0;

    private Pila pila = new Pila();

    public Main(){
        do {
            System.out.println("Menu'");
            System.out.println("[1] Registra nuovo pacco");
            System.out.println("[2] Rimuovi pacco in cima alla lista");
            System.out.println("[3] Conta pacchi");
            System.out.println("[4] Dati primo pacco");
            System.out.println("[5] Peso totale merci spedite");
            System.out.println("[6] Cerca un pacco");
            System.out.println("[7] Conta pacchi pesanti");
            System.out.println("[0] Esci dal programma");
            System.out.print("Scelta: ");
            scelta = scanner.nextLine();
            switch (scelta) {
                case "0":
                    System.out.println("\n\n\nArrivederci...\n\n");
                    scanner.close();
                    System.exit(0);

                case "1":
                    System.out.print("\n\nInsersci il CODICE del pacco: ");
                    codice = scanner.nextLine();

                    System.out.print("Inserisci la DESCRIZIONE del pacco: ");
                    descrizione = scanner.nextLine();

                    System.out.print("Insersci il PESO del pacco: ");
                    peso = scanner.nextDouble();
                    scanner.nextLine();

                    pila.push(codice, descrizione, peso);
                    
                    System.out.println("\nPacco inserito con successo!\n");

                    break;

                case "2":
                    System.out.println(pila.pop());
                    break;

                case "3":
                    System.out.println("\n\nSono presenti " + pila.contaPacchi() + " pacchi\n");
                    break;

                case "4":
                    System.out.println(pila.stampaTop());
                    break;
                
                case "5":
                    System.out.println("\n\nIl peso totale e' di " + pila.getPesoTotale() + " Kg\n\n");
                    break;

                case "6":
                    System.out.print("\n\nInsersci il CODICE del pacco: ");
                    codice = scanner.nextLine();
                    System.out.println(pila.cercaPacco(codice) + "\n\n");
                    break;

                case "7":
                    System.out.print("\n\nInserisci il PESO di soglia: ");
                    peso = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println(pila.contaPacchiPesanti(peso) + "\n\n");
                    break;
            
                default:
                    System.out.println("\n\n[" + scelta + "] Non e' una scelta!\n");
            }
        } while (true);
    }

    public static void main(String[] args) {
        new Main();
    }
}