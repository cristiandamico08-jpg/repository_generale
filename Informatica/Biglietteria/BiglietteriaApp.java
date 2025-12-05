import java.util.ArrayList;
import java.util.Scanner;

public class BiglietteriaApp {

    private Scanner input = new Scanner(System.in);
    private final int dim = 10;
    private ArrayList<Biglietto> biglietti = new ArrayList<>(dim);
    private int scelta;
    private int postoDaVendere;
    private double totaleIncassi;
    private double stampaIncassi;
    private int contVIP;
    private int cont;
    private String sceltaSettore;
    private int nSettore;

    public BiglietteriaApp() {
        biglietti.add(new Biglietto(1, "A", 20.00, false));
        biglietti.add(new Biglietto(2, "A", 20.00, false));
        biglietti.add(new Biglietto(3, "A", 20.00, false));
        biglietti.add(new Biglietto(4, "A", 20.00, false));
        biglietti.add(new Biglietto(5, "B", 30.00, false));
        biglietti.add(new Biglietto(6, "B", 30.00, false));
        biglietti.add(new Biglietto(7, "B", 30.00, false));
        biglietti.add(new Biglietto(8, "B", 30.00, false));
        biglietti.add(new Biglietto(9, "VIP", 80.00, false));
        biglietti.add(new Biglietto(10, "VIP", 80.00, false));

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Visualizza Posti Disponibili");
            System.out.println("2. Vendi un biglietto");
            System.out.println("3. Report Incassi e Sconto VIP");
            System.out.println("4. Cerca per Settore");
            System.out.println("5. Stampa Dettaglio");
            System.out.println("6. Esci");
            System.out.print("Scegli un'opzione: ");
            scelta = input.nextInt();
            switch (scelta) {
                case 1:
                    for (int i = 0; i < dim; i++) {
                        if(biglietti.get(i).getIsVenduto() == false){
                            System.out.println("Posto '" + biglietti.get(i).getNumeroPosto() + "' nel settore '" + biglietti.get(i).getSettore() + "' e' disponibile al prezzo di " + biglietti.get(i).getPrezzoBase() + " euro.");
                        }
                    }
                    if(cont == 10){
                        System.out.println("\n\nNon ci sono posti disponibili.");
                    }
                    break;
                
                case 2:
                    do {
                        System.out.print("\n\nInserisci il numero del posto da vendere: ");
                        do {
                            postoDaVendere = input.nextInt();
                            if(postoDaVendere < 1 || postoDaVendere > dim){
                                System.out.print("Numero di posto non valido.\n Riprova: ");
                            }
                        } while (postoDaVendere < 1 || postoDaVendere > dim);
                        if (biglietti.get(postoDaVendere - 1).getIsVenduto() == false) {
                            biglietti.get(postoDaVendere - 1).setIsVenduto();
                            System.out.println("Vendita completata! Prezzo: [" + biglietti.get(postoDaVendere - 1).getPrezzoBase() + " euro]");
                            totaleIncassi += biglietti.get(postoDaVendere - 1).getPrezzoBase();
                            if(biglietti.get(postoDaVendere - 1).getSettore() == "VIP"){
                                contVIP++;
                            }
                            cont++;
                        } else {
                            System.out.println("Posto non valido o già occupato.");
                        }

                        System.out.print("\nVuoi vendere un altro biglietto?\nSi[1] - No[2] (default: No): ");
                        scelta = input.nextInt();
                        if(scelta != 1){
                            break;
                        }
                    } while (scelta == 1);
                    break;
                    
                case 3:
                    System.out.println("\n\n--- REPORT INCASSI ---");
                    stampaIncassi = totaleIncassi;
                    System.out.println("Totale LORDO: " + stampaIncassi + " euro");
                    if(contVIP > 1){
                        stampaIncassi = stampaIncassi - ((stampaIncassi * 10) / 100);
                        Biglietto.arrotondamento(stampaIncassi);
                    }
                    System.out.println("Totale NETTO: " + stampaIncassi + " euro");
                    break;
                
                case 4:
                    input.nextLine();
                    do {
                        System.out.print("\n\nInserisci il nome di un settore (A, B, VIP): ");
                        sceltaSettore = input.nextLine();
                        if(!sceltaSettore.equals("A") && !sceltaSettore.equals("B") && !sceltaSettore.equals("VIP")){
                            System.out.println("Settore non valido.");
                        } else {
                            System.out.println("--- SETTORE '" + sceltaSettore + "' ---");
                            for (int j = 0; j < dim; j++) {
                                if(biglietti.get(j).getSettore().equals(sceltaSettore) && biglietti.get(j).getIsVenduto() == false){
                                    nSettore++;
                                }
                            }
                            System.out.println("Posti disponibili: " + nSettore);
                            nSettore = 0;
                            for (int j = 0; j < dim; j++) {
                                if(biglietti.get(j).getSettore().equals(sceltaSettore) && biglietti.get(j).getIsVenduto() == true){
                                    nSettore++;
                                }
                            }
                            System.out.println("Posti non disponibili: " + nSettore);
                            if(sceltaSettore.equals("A")){
                                nSettore = 0;
                            } else if(sceltaSettore.equals("B")){
                                nSettore = 4;
                            } else if(sceltaSettore.equals("VIP")){
                                nSettore = 9;
                            }
                            System.out.println("Euro al posto: [" + biglietti.get(nSettore).getPrezzoBase() + "] euro");
                            nSettore = 0;
                        }
                    } while (!sceltaSettore.equals("A") && !sceltaSettore.equals("B") && !sceltaSettore.equals("VIP"));
                    break;
                
                case 5:
                    System.out.print("\n\nInserisci il numero del posto da dettagliare: ");
                    postoDaVendere = input.nextInt();
                    if(postoDaVendere < 1 || postoDaVendere > dim){
                        System.out.println("Numero di posto non valido.");
                    } else {
                        System.out.println("\n--- DETTAGLIO POSTO '" + postoDaVendere + "' ---");
                        System.out.println("Settore: " + biglietti.get(postoDaVendere - 1).getSettore());
                        System.out.println("Prezzo Base: " + biglietti.get(postoDaVendere - 1).getPrezzoBase() + " euro");
                        if(biglietti.get(postoDaVendere - 1).getIsVenduto() == true){
                            System.out.println("Stato: VENDUTO");
                        } else {
                            System.out.println("Stato: DISPONIBILE");
                        }
                    }
                    break;
                
                case 6:
                    System.out.println("\n\nUscita in corso...");
                    return;
                    
                default:
                    System.out.println(scelta + " non e' una scelta valida.\n\n");
                    break;
            }

        } while (true);
    }
    
    public static void main(String[] args) {
        new BiglietteriaApp();
    }
}