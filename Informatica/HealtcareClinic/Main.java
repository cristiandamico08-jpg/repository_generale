import java.io.*;
import java.util.Scanner;

import classi.*;
import eccezioni.OspedalePienoException;
import gestione.*;

public class Main {
    
    private Scanner scanner = new Scanner(System.in);
    private String scelta;
    private OspedaleManager manager = new OspedaleManager();

    public Main(){

        String percorso = "gestione/registro_ospedale.txt";
        BufferedWriter bufferedWriter = null;
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(percorso));
            String linea;
            while((linea = bufferedReader.readLine()) != null){
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Errore: " + e.getMessage());
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException ex) {
                System.out.println("Errore: " + ex.getMessage());
            }
        }
        
        do {
            System.out.println("\n\n[1] Aggiungi paziente ordinario\n[2] Aggiungi paziente day hospital\n[3] Visualizza LOG\n[0] Esci");
            System.out.print("\nScelta: ");
            scelta = scanner.nextLine();
            scanner.nextLine();
            switch (scelta) {
                case "0":
                    System.out.println("\n\n\nUscita in corso...");
                    System.exit(0);

                case "1":
                    RicoveroOrdinario paziente = new RicoveroOrdinario(null, 0, 100);

                    System.out.print("\n\n\nInserisci nome: ");
                    String nome = scanner.nextLine();
                    scanner.nextLine();
                    paziente.setNome(nome);

                    System.out.print("Inserisci codice cartella: ");
                    int codiceCartella = scanner.nextInt();
                    scanner.nextLine();
                    paziente.setCodiceCartella(codiceCartella);

                    System.out.print("Inserisci numero giorni di permanenza: ");
                    int numeroGiorni = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Inserisci se ha il pasto personalizzato [true/false]: ");
                    boolean pastoPersonalizzato = scanner.nextBoolean();
                    scanner.nextLine();

                    paziente.calcolaCostoRicovero(pastoPersonalizzato, numeroGiorni);
                    try {
                        manager.aggiungiPaziente(paziente);
                        try {
                            bufferedWriter = new BufferedWriter(new FileWriter(percorso, true));
                            bufferedWriter.write(" - " + paziente.getNome() + " " + paziente.getCodiceCartella() + " " + paziente.getTariffaBase() + " euro (Paziente Ordinario)");
                            bufferedWriter.newLine();
                        } catch (IOException e) {
                            System.out.println("Errore: " + e.getMessage());
                        } finally {
                            try {
                                if (bufferedWriter != null) {
                                    bufferedWriter.close();
                                }
                            } catch (IOException ex) {
                                System.out.println("Errore: " + ex.getMessage());
                            }
                        }
                    } catch (OspedalePienoException exc) {
                        System.out.println("Errore: " + exc.getMessage());
                    }

                    break;

                case "2":

                    RicoveroDayHospital paziente2 = new RicoveroDayHospital(null, 0, 100);
                    System.out.print("\n\n\nInserisci nome: ");
                    nome = scanner.nextLine();
                    scanner.nextLine();
                    paziente2.setNome(nome);

                    System.out.print("Inserisci codice cartella: ");
                    codiceCartella = scanner.nextInt();
                    scanner.nextLine();
                    paziente2.setCodiceCartella(codiceCartella);

                    System.out.print("Inserisci se ha il pasto personalizzato [true/false]: ");
                    pastoPersonalizzato = scanner.nextBoolean();
                    scanner.nextLine();

                    System.out.print("Inserisci il numero di giorni: ");
                    numeroGiorni = scanner.nextInt();
                    scanner.nextLine();
                    
                    paziente2.calcolaCostoRicovero(pastoPersonalizzato, numeroGiorni);

                    try {
                        manager.aggiungiPaziente(paziente2);
                        try {
                            bufferedWriter = new BufferedWriter(new FileWriter(percorso, true));
                            bufferedWriter.write(" - " + paziente2.getNome() + " "  + paziente2.getCodiceCartella() + " " + paziente2.getTariffaBase() + " euro (Paziente Day Hospital)");
                            bufferedWriter.newLine();
                        } catch (IOException e) {
                            System.out.println("Errore: " + e.getMessage());
                        } finally {
                            try {
                                if (bufferedWriter != null) {
                                    bufferedWriter.close();
                                }
                            } catch (IOException ex) {
                                System.out.println("Errore: " + ex.getMessage());
                            }
                        }
                    } catch (OspedalePienoException exc) {
                        System.out.println("Errore: " + exc.getMessage());
                    }

                    break;

                case "3":
                    try {
                        bufferedReader = new BufferedReader(new FileReader(percorso));
                        String linea;
                        while ((linea = bufferedReader.readLine()) != null) {
                            System.out.println(linea);
                        }
                    } catch (IOException e) {
                        System.out.println("Errore: " + e.getMessage());
                    } finally {
                        try {
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                        } catch (IOException ex) {
                            System.out.println("Errore: " + ex.getMessage());
                        }
                    }
                    break;

                default:
                    System.out.println("\n\n\n\"" + scelta + "\" non e' una scelta!\n\n\n");
            }
        } while (true);

    }

    public static void main(String[] args) {
        new Main();
    }
}