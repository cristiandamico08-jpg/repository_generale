package repository_generale.Informatica.Sim_verifica_28_nov_ArrayList;

public class Articolo {

    private String nome;
    private double prezzo;
    private final double IVA = 0.22;


    public Articolo(String nome, double prezzo) {
        this.nome = nome;
        this.prezzo = prezzo;
    }

    public String getNome() {
        return nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public double getIVA() {
        return IVA;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public double calcolaPrezzoConIVA() {
        return prezzo + (prezzo * IVA);
    }
}
