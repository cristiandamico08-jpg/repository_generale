package repository_generale.Informatica.Sim_verifica_28_nov_ArrayList;

/**
 * Classe Articolo che rappresenta un articolo con nome, prezzo e IVA.
 * Fornisce metodi per ottenere e impostare i valori degli attributi,
 * nonché per calcolare il prezzo comprensivo di IVA.
 * 
 * @author Cristian Dylan D'Amico
 */

public class Articolo {

    /** Nome del prodotto */
    private String nome;

    /** Prezzo del prodotto */
    private double prezzo;

    /** IVA applicata */
    private final double IVA = 0.22;

    /** Costruttore della classe Articolo
     * 
     * @param nome  nome del prodotto
     * @param prezzo prezzo del prodotto
     */
    public Articolo(String nome, double prezzo) {
        this.nome = nome;
        this.prezzo = prezzo;
    }

    /**
     * Restituisce il nome del prodotto.
     * 
     * @return nome del prodotto
     */
    public String getNome() {
        return nome;
    }

    /**
     * Restituisce il prezzo del prodotto.
     * 
     * @return prezzo del prodotto
     */
    public double getPrezzo() {
        return prezzo;
    }

    /**
     * Restituisce l'IVA applicata al prodotto.
     * 
     * @return IVA del prodotto
     */
    public double getIVA() {
        return IVA;
    }
    
    /**
     * Imposta il nome del prodotto.
     * 
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Imposta il prezzo del prodotto.
     * 
     * @param prezzo
     */
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    /**
     * Calcola il prezzo del prodotto comprensivo di IVA.
     * 
     * @return prezzo con IVA
     */
    public double calcolaPrezzoConIVA() {
        return prezzo + (prezzo * IVA);
    }
}
