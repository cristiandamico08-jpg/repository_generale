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
    private String targaDaRimuovere;
    
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
                    // Codice per aggiungere/rimuovere veicolo
                    System.out.println("1. Aggiungi veicolo");
                    System.out.println("2. Rimuovi veicolo");
                    System.out.print("Scelta: ");
                    scelta = input.nextInt();
                    input.nextLine();

                    switch (scelta) {
                        case 1:
                            
                            break;

                        case 2:
                            System.out.println("Inserisci targa del veicolo da rimuovere: ");
                            targaDaRimuovere = input.nextLine();
                            input.nextLine();
                            for (int i = 0; i < veicoli.size(); i++) {
                                if (veicoli.get(i).getTarga().equals(targaDaRimuovere)) {
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
