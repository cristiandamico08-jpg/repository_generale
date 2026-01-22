import java.util.ArrayList;
import java.util.Scanner;


//poter inserire un nuovo evento
//visualizza tutti i concerti
//scegli un concerto
//mostra tutti i concerti che ho prenotato
//esci

public class Main {

    private Scanner input = new Scanner(System.in);
    private final int dim = 5;
    private ArrayList<Biglietto> concerti = new ArrayList<Biglietto>();
    private ArrayList<Biglietto> biglietti = new ArrayList<Biglietto>();
    private int scelta = 0;
    private int giorno = 0;
    private int mese = 0;
    private int anno = 0;
    private String cantante;
    private double prezzo = 0.0;
    private double totale = 0.0;

    public Main(){
        concerti.add(new Biglietto(25, 8, 2026, "D3LLA23", 10.00));
        concerti.add(new Biglietto(31, 10, 2028, "FasaLaZone", 8.00));
        concerti.add(new Biglietto(16, 1, 2027, "GX_MandyShadow", 15.00));

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Inserisci nuovo evento");
            System.out.println("2. Visualizza tutti i concerti");
            System.out.println("3. Compra biglietto");
            System.out.println("4. Mostra tutti i biglietti che ho prenotato");
            System.out.println("5. Esci");
            System.out.print("Scelta: ");
            scelta = input.nextInt();
            input.nextLine();

            switch (scelta) {
                case 1:
                    System.out.print("\n\nInserisci il giorno dell'evento: ");
                    do {
                        giorno = input.nextInt();
                        if(giorno > 31 || giorno < 1){
                            System.out.print("\nData non valida! Riprova: ");
                        } else {
                            break;
                        }
                    } while (giorno > 31 || giorno < 1);

                    System.out.print("Inserisci il mese dell'evento: ");
                    do {
                        mese = input.nextInt();
                        if(mese > 12 || mese < 1){
                            System.out.print("\nData non valida! Riprova: ");
                        } else {
                            break;
                        }
                    } while (mese > 31 || mese < 1);

                    System.out.print("Inserisci l'anno dell'evento: ");
                    anno = input.nextInt();
                    input.nextLine();

                    System.out.print("Inserisci il cantante dell'evento: ");
                    cantante = input.nextLine();

                    System.out.print("Inserisci il prezzo dell'evento: ");
                    prezzo = input.nextDouble();

                    concerti.add(new Biglietto(giorno, mese, anno, cantante, prezzo));

                    break;

                case 2:
                    System.out.println("\n\n");
                    for (int i = 0; i < concerti.size(); i++) {
                        System.out.println((i+1) + ".\nData: " + concerti.get(i).getGiorno() + " / " + concerti.get(i).getMese() + " / " + concerti.get(i).getAnno() + "\nCantante: " + concerti.get(i).getCantante() + "\nPrezzo: " + concerti.get(i).getPrezzo() + " euro\n");
                    }
                    break;
                    
                case 3:
                    System.out.println("\n\n");
                    for (int i = 0; i < concerti.size(); i++) {
                        System.out.println((i+1) + ".\nData: " + concerti.get(i).getGiorno() + " / " + concerti.get(i).getMese() + " / " + concerti.get(i).getAnno() + "\nCantante: " + concerti.get(i).getCantante() + "\nPrezzo: " + concerti.get(i).getPrezzo() + " euro\n");
                    }
                    System.out.print("\nInserisci il nome del cantante del biglietto che vuoi comprare: ");
                    cantante = input.nextLine();
                    for (int i = 0; i < concerti.size(); i++) {
                        if(concerti.get(i).getCantante().equals(cantante)){
                            giorno = concerti.get(i).getGiorno();
                            mese = concerti.get(i).getMese();
                            anno = concerti.get(i).getAnno();
                            cantante = concerti.get(i).getCantante();
                            prezzo = concerti.get(i).getPrezzo();

                            biglietti.add(new Biglietto(giorno, mese, anno, cantante, prezzo));
                        }
                    }
                    break;
                    
                case 4:
                    System.out.println("\n\n\nBiglietti prenotati:\n");
                    Biglietto temp = new Biglietto(1, 1, 2026, " ", 0.0);
                    for (int i = 0; i < biglietti.size() - 1; i++) {
                        for (int j = 0; j < biglietti.size() - 1; j++) {
                            if (biglietti.get(j).getAnno() > biglietti.get(j+1).getAnno()) {
                                temp = biglietti.get(j);
                                biglietti.set(j, biglietti.get(j+1));
                                biglietti.set(j+1, temp);

                            } else if(biglietti.get(j).getAnno().equals(biglietti.get(j+1).getAnno())){
                                
                                if (biglietti.get(j).getMese() > biglietti.get(j+1).getMese()) {
                                    temp = biglietti.get(j);
                                    biglietti.set(j, biglietti.get(j+1));
                                    biglietti.set(j+1, temp);
                                } else if(biglietti.get(j).getMese().equals(biglietti.get(j+1).getMese())){
                                    if (biglietti.get(j).getGiorno() > biglietti.get(j+1).getGiorno()) {
                                        temp = biglietti.get(j);
                                        biglietti.set(j, biglietti.get(j+1));
                                        biglietti.set(j+1, temp);
                                    }
                                }
                            }
                        }
                    }
                    for (int i = 0; i < biglietti.size(); i++) {
                        System.out.println((i+1) + ".\nData: " + biglietti.get(i).getGiorno() + " / " + biglietti.get(i).getMese() + " / " + biglietti.get(i).getAnno() + "\nCantante: " + biglietti.get(i).getCantante() + "\nPrezzo: " + biglietti.get(i).getPrezzo() + " euro\n");
                        totale += biglietti.get(i).getPrezzo();
                    }
                    System.out.println("\nTotale biglietti: " + totale + " euro\n\n");
                    totale = 0.0;
                    break;
                    
                case 5:
                    System.out.println("\n\n\nUscita in corso...");
                    return;
            
                default:
                    System.out.println("\nScelta non valida\n\n");
            }
        } while (true);
    }

    public static void main(String[] args) {
        new Main();
    }
}