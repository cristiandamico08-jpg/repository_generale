package Model;

import java.util.ArrayList;


public class CentroCommerciale {
    private ArrayList<Negozio> negozi = new ArrayList<Negozio>();

    public void registraNegozio(Negozio n){
        negozi.add(n);
    }

    public void avviaCampagnaSconti(int percentuale){
        for (Negozio negozio : negozi) {
            if(negozio instanceof Abbigliamento){
                try {
                    ((Abbigliamento)negozio).applicaSaldi(percentuale);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void stampaNegozi(){
        for (Negozio negozio : negozi) {
            System.out.println("Nome negozio: " + negozio.getNome());
            System.out.println("    Prodotti:");
            for (Prodotto p : negozio.getProdotti()) {
                System.out.println("    - Nome: " + p.getNome() + "\n    - Prezzo: " + p.getPrezzo() + "\n");
            }
        }
    }
}
