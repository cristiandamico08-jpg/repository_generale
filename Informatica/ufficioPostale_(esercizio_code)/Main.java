import java.util.Scanner;

import classi.*;

public class Main{

    private String scelta;
    private Scanner scanner = new Scanner(System.in);

    private String nome;
    private String cognome;
    private double importo;
    
    private Coda coda = new Coda();

    public Main(){
        do {
            
            System.out.println("\n\nMenu':");
            System.out.println("[1] Registra nuovo cliente");
            System.out.println("[2] Servi cliente");
            System.out.println("[3] Numero persone in coda");
            System.out.println("[4] Informazioni ultima persona in coda");
            System.out.println("[5] Incasso totale");
            System.out.println("[0] Esci dal programma");
            System.out.print("Scelta: ");
            scelta = scanner.nextLine();

            switch (scelta) {
                case "0":
                    System.out.println("\n\n\n\nArrivederci...");
                    System.exit(0);
                
                case "1":
                    System.out.print("\n\nInserisci nome: ");
                    nome = scanner.nextLine();

                    System.out.print("Inserisci cognome: ");
                    cognome = scanner.nextLine();

                    System.out.print("Inserisci importo: ");
                    importo = scanner.nextDouble();

                    coda.push(nome, cognome, importo);
                    System.out.println("Utente registrato!\n\n");

                    break;

                case "2":
                    System.out.println(coda.pop());
                    break;

                case "3":
                    System.out.println("\n\nCi sono " + coda.numeroPersone() + " persone in coda.");
                    System.out.println(coda.toString());
                    break;

                case "4":
                    System.out.println(coda.stampaUltimo());
                    break;

                case "5":
                    System.out.println("\n\nL'incasso totale e' di " + coda.getIncasso() + " euro\n");
                    break;

                default:
                    System.out.println("\n\n\"" + scelta + "\" non e' una scelta");
            }


        } while (true);
    }

    public static void main(String[] args) {
        new Main();
    }
}