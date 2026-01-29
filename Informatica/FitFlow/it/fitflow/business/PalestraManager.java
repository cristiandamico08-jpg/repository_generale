package Informatica.FitFlow.it.fitflow.business;

import java.util.ArrayList;

import Informatica.FitFlow.it.fitflow.exception.CapienzaMassimaException;
import Informatica.FitFlow.it.fitflow.model.Abbonamento;

public class PalestraManager {
    private ArrayList<Abbonamento> abbonamenti;
    private static final Integer MAX_INSCRITTI = 50;
    
    public PalestraManager(Abbonamento... abbonamenti) {
        try {
            if (abbonamenti.length + this.abbonamenti.size() > MAX_INSCRITTI) {
                throw new CapienzaMassimaException();
            }
        } catch (CapienzaMassimaException e) {
            System.out.println(e.getMessage());
        }
        this.abbonamenti = new ArrayList<Abbonamento>();
        for (Abbonamento abbonamento : abbonamenti) {
            this.abbonamenti.add(abbonamento);
        }
    }


}
