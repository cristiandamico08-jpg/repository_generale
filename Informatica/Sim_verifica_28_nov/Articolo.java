package repository_generale.Informatica.Sim_verifica_28_nov;

public class Articolo {

    private String nome;
    private double prezzo;
    private final double IVA;


    public Articolo(String nome, double prezzo, double IVA) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.IVA = IVA;
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
    
}
