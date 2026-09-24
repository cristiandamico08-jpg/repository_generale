package gestione;

import java.util.ArrayList;

import classi.*;
import eccezioni.*;

public class OspedaleManager {
    private ArrayList<Paziente> memoria = new ArrayList<>();

    public void aggiungiPaziente(Paziente paziente) throws OspedalePienoException{
        if (memoria.size() + 1 < 30) {
            memoria.add(paziente);
        } else {
            throw new OspedalePienoException();
        }
    }
}
