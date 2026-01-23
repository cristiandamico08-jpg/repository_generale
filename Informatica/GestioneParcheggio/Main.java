package Informatica.GestioneParcheggio;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    private Scanner input = new Scanner(System.in);
    private final int dim = 5;
    private ArrayList<Veicolo> veicoli = new ArrayList<Veicolo>(dim);
    private final double costoOrarioA = 2;
    private final double costoOrarioB = 1.50;
    private double totale = 0;
    private int scelta;
    private String targa;
    private String marca;
    private int orarioIngresso = 0;
    private int numeroPosti = 0;
    private int cilindrata = 0;
    private Veicolo veicolo;
    
    public Main(){
        veicoli.add(new Automobile("AB123CD", "Fiat", 10, 5, 1200));
        veicoli.add(new Motociclo("EF456GH", "Yamaha", 11, 2, 600));
        veicoli.add(new Automobile("EB000LA", "Ferrari", 8, 2, 3000));

        do {
            System.out.println("\nMenu':");
            System.out.println("1. Individua veicolo tramite targa");
            System.out.println("2. Calcola costo parcheggio");
            System.out.println("3. Aggiungi/Rimuovi veicolo");
            System.out.println("4. Esci");
            System.out.print("Scelta: ");
            scelta = input.nextInt();
            input.nextLine();
            System.out.println("\n\n");

            switch (scelta) {
                case 1:
                    System.out.println("Inserisci targa da cercare: ");
                    targa = input.nextLine();
                    int temp = 0;
                    for (int i = 0; i < veicoli.size(); i++) {
                        if(veicoli.get(i).getTarga().equals(targa)){
                            System.out.println("\nVeicolo trovato!\nTarga: " + veicoli.get(i).getTarga() + "\nMarca: " + veicoli.get(i).getMarca() + "\nOrario Ingresso: " + veicoli.get(i).getOrarioIngresso());
                            temp = 0;
                            break;
                        }else {
                            temp = 1;
                        }
                    }

                    if(temp == 1){
                        System.out.println("\nVeicolo non trovato.");
                    }

                    break;

                
                case 2:
                    System.out.println("Inserisci orario corrente (formato 24h, numero intero): ");
                    int orarioCorrente = input.nextInt();
                    for (int i = 0; i < veicoli.size(); i++) {
                        if(veicoli.get(i) instanceof Automobile){
                            totale = (orarioCorrente - veicoli.get(i).getOrarioIngresso()) * costoOrarioA;
                            System.out.println("\nAutomobile - Veicolo: " + veicoli.get(i).getTarga() + " - Costo parcheggio: " + totale + " euro.");
                        } else if (veicoli.get(i) instanceof Motociclo) {
                            totale = (orarioCorrente - veicoli.get(i).getOrarioIngresso()) * costoOrarioB;
                            System.out.println("\nMotociclo - Veicolo: " + veicoli.get(i).getTarga() + " - Costo parcheggio: " + totale + " euro.");
                        }
                    }
                    break;


                case 3:
                    System.out.println("1. Aggiungi veicolo");
                    System.out.println("2. Rimuovi veicolo");
                    System.out.print("Scelta: ");
                    scelta = input.nextInt();
                    input.nextLine();
                    System.out.println("\n");

                    switch (scelta) {
                        case 1:
                            if (veicoli.size() == dim) {
                                System.out.println("Parcheggio pieno. Impossibile aggiungere altri veicoli.");
                                break;
                            } else {
                                System.out.println("Inserisci targa: ");
                                targa = input.nextLine();
                                System.out.println("Inserisci marca: ");
                                marca = input.nextLine();
                                System.out.println("Inserisci orario ingresso: ");
                                orarioIngresso = input.nextInt();
                                System.out.println("Inserisci numero posti: ");
                                numeroPosti = input.nextInt();
                                System.out.println("Inserisci cilindrata: ");
                                cilindrata = input.nextInt();
                                System.out.println("Tipo di veicolo:\n1. Automobile\n2. Motociclo");
                                scelta = input.nextInt();
                                input.nextLine();
                                if (scelta == 1) {
                                    veicoli.add(new Automobile(targa, marca, orarioIngresso, numeroPosti, cilindrata));
                                } else if (scelta == 2) {
                                    veicoli.add(new Motociclo(targa, marca, orarioIngresso, numeroPosti, cilindrata));
                                }
                                System.out.println("Veicolo aggiunto con successo.");
                                break;
                            }

                        case 2:
                            System.out.println("Inserisci targa del veicolo da rimuovere: ");
                            targa = input.nextLine();
                            input.nextLine();
                            for (int i = 0; i < veicoli.size(); i++) {
                                if (veicoli.get(i).getTarga().equals(targa)) {
                                    veicoli.remove(i);
                                    System.out.println("Veicolo rimosso con successo.");
                                    break;
                                }
                            }
                            break;
                    
                        default:
                            break;
                    }
                    break;

                
                case 4:
                    System.out.println("Uscita in corso...");
                    return;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }

        } while (true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
