package Informatica.FitFlow.it.fitflow.model;

public class AbbonamentoCorsi extends Abbonamento {
    private Integer numeroCorsi;

    public AbbonamentoCorsi(String nomeCliente, String codiceInscrizione, double prezzoBase, Integer numeroCorsi) {
        super(nomeCliente, codiceInscrizione, prezzoBase);
        this.numeroCorsi = numeroCorsi;
    }

    public Integer getNumeroCorsi() {
        return numeroCorsi;
    }

    public void setNumeroCorsi(Integer numeroCorsi) {
        this.numeroCorsi = numeroCorsi;
    }

    @Override
    public Double calcolaCostoMensile() {
        if (numeroCorsi > 3) {
            return (getPrezzoBase() - (getPrezzoBase() * 5 / 100));
        }
        return getPrezzoBase();
    }


}
