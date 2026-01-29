package Informatica.FitFlow.it.fitflow.model;

public abstract class Abbonamento {
    private String nomeCliente;
    private String codiceInscrizione;
    private double prezzoBase;

    public Abbonamento(String nomeCliente, String codiceInscrizione, double prezzoBase) {
        this.nomeCliente = nomeCliente;
        this.codiceInscrizione = codiceInscrizione;
        this.prezzoBase = prezzoBase;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }
    public String getCodiceInscrizione() {
        return codiceInscrizione;
    }
    public double getPrezzoBase() {
        return prezzoBase;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    public void setCodiceInscrizione(String codiceInscrizione) {
        this.codiceInscrizione = codiceInscrizione;
    }
    public void setPrezzoBase(double prezzoBase) {  
        this.prezzoBase = prezzoBase;
    }

    public abstract Double calcolaCostoMensile();
}
