/**
 * Classe SpazioFiera con all'interno metodi per la classe Main
 * 
 * @author Cristian Dylan D'Amico
 * @version 1.0
 */
public class SpazioFiera {
    
    /** Variabili */
    private int codiceUnivoco;
    private int metriQuadri;
    private double costoBase;
    private boolean isPrenotato;

    public SpazioFiera(int codiceUnivoco, int metriQuadri, double costoBase, boolean isPrenotato){
        this.codiceUnivoco = codiceUnivoco;
        this.metriQuadri = metriQuadri;
        this.costoBase = costoBase;
        this.isPrenotato = isPrenotato;
    }

    public int getCodiceUnivoco(){
        return codiceUnivoco;
    }

    public int getMetriQuadri(){
        return metriQuadri;
    }

    public double getCostoBase(){
        return costoBase;
    }

    public boolean getIsPrenotato(){
        return isPrenotato;
    }

    public boolean setIsPrenotato(){
        return isPrenotato = true;
    }
}
