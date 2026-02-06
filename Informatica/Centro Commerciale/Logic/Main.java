package Logic;

import Model.Abbigliamento;
import Model.CentroCommerciale;
import Model.Prodotto;
import Model.Ristorante;

public class Main {
    public Main(){
        CentroCommerciale centroCommerciale = new CentroCommerciale();
        centroCommerciale.registraNegozio(new Abbigliamento("Zara", new Prodotto("Jeans", 20.99), new Prodotto("Maglietta", 10.99), new Prodotto("Cappellino", 5.99)));
        centroCommerciale.registraNegozio(new Ristorante("Antica Trattoria Bersaglieri", 4.00, new Prodotto("Pizza Margherita", 5.00), new Prodotto("Pizza 4 Stagioni", 10.00), new Prodotto("Pizza Diavola", 10.00)));
        System.out.println("Negozi della campagna sconti:");
        centroCommerciale.stampaNegozi();
        System.out.println("\nNegozi dopo la campagna sconti:");
        centroCommerciale.avviaCampagnaSconti(25);
        centroCommerciale.stampaNegozi();
    }

    public static void main(String[] args) {
        new Main();
    }
}
