package Informatica.FitFlow.it.fitflow.model;

public class AbbonamentoOpen extends Abbonamento {

    private boolean accessoSpa;

    public AbbonamentoOpen(String nomeCliente, String codiceInscrizione, double prezzoBase, boolean accessoSpa) {
        super(nomeCliente, codiceInscrizione, prezzoBase);
        this.accessoSpa = accessoSpa;
    }

    public boolean getAccessoSpa() {
        return accessoSpa;
    }

    public void setAccessoSpa(boolean accessoSpa) {
        this.accessoSpa = accessoSpa;
    }

    @Override
    public Double calcolaCostoMensile() {
        return getPrezzoBase() + 15;
    }
    
}
