package classi;

public abstract class Paziente {

    private String nome;
    private int codiceCartella;
    private double tariffaBase;

    public Paziente(String nome, int codiceCartella, double tariffaBase){
        this.nome = nome;
        this.codiceCartella = codiceCartella;
        this.tariffaBase = tariffaBase;
    }

    public String getNome(){
        return nome;
    }

    public int getCodiceCartella(){
        return codiceCartella;
    }

    public double getTariffaBase(){
        return tariffaBase;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCodiceCartella(int codiceCartella){
        this.codiceCartella = codiceCartella;
    }

    public void setTariffaBase(double tariffaBase){
        this.tariffaBase = tariffaBase;
    }

    public abstract void calcolaCostoRicovero(boolean pastoPersonalizzato, int numeroGiorni);

}
