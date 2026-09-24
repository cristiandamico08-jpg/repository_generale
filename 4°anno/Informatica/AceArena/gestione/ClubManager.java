package gestione;
import java.util.ArrayList;

import classi.*;
import eccezioni.*;


public class ClubManager {
    private final int campienzaMassima = 15;
    private ArrayList<Giocatore> gestione = new ArrayList<Giocatore>(campienzaMassima);

    public void aggiungiGiocatore(Giocatore g) throws CampiEsauritiException{
        if((gestione.size() + 1) > campienzaMassima){
            throw new CampiEsauritiException();
        } else {
            gestione.add(g);
        }
    }

}
