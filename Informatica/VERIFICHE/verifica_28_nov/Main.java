import java.util.Scanner;

/**
 * Classe Main con all'interno costruttore Main e main di avvio
 * 
 * @author Cristian Dylan D'Amico
 * @version 1.0
 */
public class Main {
    
    /** Scanner per far inserire dati in input */
    private Scanner input = new Scanner(System.in);

    /** Costante per la dimensione dell'array */
    private final int dim = 10;

    /** Array di tipo SpazioFiera */
    private SpazioFiera[] array = new SpazioFiera[dim];
    private int[] acquisto = new int[dim];

    /** Variabile per calcolare il costo totale */
    private double totale;

    /** Variabili temporanee */
    private SpazioFiera temp = new SpazioFiera(0, 0, 0, false);
    private int temp1, temp2;

    /** Varibile per eseguire le scelte */
    private int scelta;

    public Main(){
        array[0] = new SpazioFiera(1, 10, 500, false);
        array[1] = new SpazioFiera(2, 20, 1000, true);
        array[2] = new SpazioFiera(3, 30, 1500, false);
        array[3] = new SpazioFiera(4, 10, 500, false);
        array[4] = new SpazioFiera(5, 30, 1500, true);
        array[5] = new SpazioFiera(6, 20, 1000, true);
        array[6] = new SpazioFiera(7, 20, 1000, true);
        array[7] = new SpazioFiera(8, 10, 500, false);
        array[8] = new SpazioFiera(9, 30, 1500, true);
        array[9] = new SpazioFiera(10, 10, 500, false);

        for (int i = 0; i < dim - 1; i++) {
            for (int j = 0; j < dim - 1; j++) {
                if(array[j].getMetriQuadri() < array[j + 1].getMetriQuadri()){
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < dim - 1; i++) {
            for (int j = 0; j < dim - 1; j++) {
                if(array[j].getMetriQuadri() == array[j + 1].getMetriQuadri()){
                    if(array[j].getCodiceUnivoco() > array[j +1].getCodiceUnivoco()){
                        temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        }

        do {
            
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Visualizza spazi disponibili");
            System.out.println("2 - Prenota uno spazio (Acquirente)");
            System.out.println("3 - Report Finanziario e ordinato (Proprietario)");
            System.out.println("4 - Cerca metratura per Codice (Acquirente)");
            System.out.println("5 - Esci");
            System.out.print("Scelta: ");
            scelta = input.nextInt();

            switch (scelta) {
                case 1:
                    System.err.println("\n");
                    for (int i = 0; i < dim; i++) {
                        if(array[i].getIsPrenotato() == false){
                            System.out.println("Lo spazio " + array[i].getCodiceUnivoco() + " e' libero!");
                        }
                    }
                    break;

                case 2:
                    
                    for (int i = 0; i < array.length; i++) {
                        if(array[i].getIsPrenotato() == false){
                            System.out.println("Spazio fiera " + (i+1) + " e' libero\n\nCaratteristiche:\n - Codice univoco: " + array[i].getCodiceUnivoco() + "\n - Metri quadri: " + array[i].getMetriQuadri() + "mq\n - Costo base: " + array[i].getCostoBase() + " euro");
                            System.out.print("\nVuoi prenotarlo?\n1 - Si\n2 - No\nScelta: ");
                            scelta = input.nextInt();
                            if(scelta == 1){
                                array[i].setIsPrenotato();
                                acquisto[i] = array[i].getCodiceUnivoco();
                                for (int j = 0; j < dim; j++) {
                                    if(array[j].getIsPrenotato() == true){
                                        totale = array[j].getCostoBase() + totale;
                                        if(array[j].getMetriQuadri() == 10){
                                            temp1++;
                                        } else if(array[j].getMetriQuadri() == 30){
                                            temp2++;
                                        }
                                    }
                                }
                            }
                        }
                    }

                    break;
                    
                case 3:
                    if(temp1 >= 3 && temp2 >= 1){
                        totale = totale - ((totale * 15)/100);
                    }
                    totale = Math.round(totale * 100) / 100;

                    System.out.println("\n\nSubtotale: " + totale + " euro\n\nProprieta' acquistate:");
                    for (int i = 0; i < dim; i++) {
                        if(acquisto[i] != 0){
                            System.out.println(" - " + array[i].getCodiceUnivoco() + " - " + array[i].getMetriQuadri() + "mq");
                        }
                    }

                    totale = 0;
                    break;
                    
                case 4:
                    System.out.print("\n\nInserisci un codice univoco: ");
                    do {
                        scelta = input.nextInt();
                        if (scelta < 1 || scelta > 10) {
                            System.err.print("\n\nScelta non valida. Riprova: ");
                        }
                    } while (scelta < 1 || scelta > 10);
                    for (int i = 0; i < dim; i++) {
                        if (i + 1 == scelta) {
                            System.out.println(" - Metri Quadri: " + array[scelta + 1].getMetriQuadri() + "mq");
                        }
                    }
                    break;
                    
                case 5:
                    System.out.println("\n\nUscendo dal programma...");
                    return;
            
                default:
                    System.out.println(scelta + " non e' una scelta!\n");
            }

        } while (true);
    }

    /** Metodo per l'avvio */
    public static void main(String[] args) {
        new Main();
    }
}