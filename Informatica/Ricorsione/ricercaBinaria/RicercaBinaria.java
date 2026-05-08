import java.util.Random;
import java.util.Scanner;

public class RicercaBinaria {

    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();
    private int[] array = new int[10];
    private int numero;
    private int risultato;

    public RicercaBinaria(){
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        for (int i = 0; i < array.length - 1; i++){
            for(int j = 0; j < array.length - 1; j++){
                if(array[j] > array[j + 1]){
                    numero = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = numero;
                }
            }
        }

        try {
            System.out.println("\nArray:");
            for (int i = 0; i < array.length; i++) {
                System.out.println(i + " - " + array[i]);
            }
            System.out.print("\n\nInserisci il numero INTERO da RICERCARE: ");
            numero = scanner.nextInt();
            risultato = ricercaBinaria(array, numero, 0, array.length - 1);
            if (risultato == -1) {
                System.out.println("\nIl numero [" + numero + "] NON e' presente nell'array");
            } else {
                System.out.println("\nIl numero [" + numero + "] e' all'indice: " + risultato);
            }
        } catch (Exception e) {
            System.out.println("\n\n<!> Non hai inserito un numero INTERO <!>\n\n");
        }
    }

    public static int ricercaBinaria(int[] array, int target, int inizio, int fine){
        if (inizio > fine) {
            return -1;
        }

        int medio = inizio + (fine - inizio) / 2;

        if (array[medio] == target) {
            return medio;
        }

        if (array[medio] > target) {
            return ricercaBinaria(array, target, inizio, medio - 1);
        }

        return ricercaBinaria(array, target, medio + 1, fine);
    }

    public static void main(String[] args) {
        new RicercaBinaria();
    }
}