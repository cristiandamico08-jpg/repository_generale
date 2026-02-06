package Model;

public class Ristorante extends Negozio {
    private double prezzoCoperto;

    public Ristorante(String nome, double prezzoCoperto, Prodotto... p){
        super(nome, p);
        this.prezzoCoperto = prezzoCoperto;
    }

    public double getPrezzoCoperto(){
        return prezzoCoperto;
    }

    public void setPrezzoCoperto(double prezzoCoperto){
        this.prezzoCoperto = prezzoCoperto;
    }

    @Override
    public void stampaDettagli(){
        //
    }
}
