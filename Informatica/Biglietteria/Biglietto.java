public class Biglietto {
    
    private int numeroPosto;
    private String settore;
    private double prezzoBase;
    private boolean isVenduto;

    public Biglietto(int numeroPosto, String settore, double prezzoBase, boolean isVenduto){
        this.numeroPosto = numeroPosto;
        this.settore = settore;
        this.prezzoBase = prezzoBase;
        this.isVenduto = isVenduto;
    }

    public int getNumeroPosto(){
        return numeroPosto;
    }

    public String getSettore(){
        return settore;
    }

    public double getPrezzoBase(){
        return prezzoBase;
    }

    public boolean getIsVenduto(){
        return isVenduto;
    }

    public boolean setIsVenduto(){
        return isVenduto = true;
    }

    public static void arrotondamento(double valore){
        valore = Math.round(valore * 100) / 100;
    }
}
