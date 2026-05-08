import java.util.Scanner;

public class Fattoriale {
    
    private Scanner scanner = new Scanner(System.in);
    private int numero;
    
    public static int calcolaFattoriale(int n){
        if (n == 0 || n == 1) {
            return 1;
        }

        return n * calcolaFattoriale(n - 1);
    }

    public Fattoriale(){
        try {
            System.out.print("\n\nInserisci un numero INTERO: ");
            numero = scanner.nextInt();
            System.out.println("\nIl fattoriale di [" + numero + "] e': " + calcolaFattoriale(numero) + "\n\n");
        } catch (Exception e) {
            System.out.println("\n\n<!> Non hai inserito un numero intero <!>\n\n");
        }
    }

    public static void main(String[] args) {
        new Fattoriale();
    }

}