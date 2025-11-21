/**
 * Rappresenta un prodotto presente in magazzino,
 * caratterizzato da un nome e da una quantità di scorte disponibili.
 */
public class Prodotti {

    /** Quantità di scorte disponibili del prodotto */
    private int scorte;

    /** Nome del prodotto */
    private String prodotto;

    /**
     * Costruttore della classe Prodotti.
     *
     * @param scorte   quantità iniziale di scorte del prodotto
     * @param prodotto nome del prodotto
     */
    public Prodotti(int scorte, String prodotto){
        this.scorte = scorte;
        this.prodotto = prodotto;
    }

    /**
     * Restituisce la quantità di scorte disponibili.
     *
     * @return quantità di scorte
     */
    public int getScorte(){
        return scorte;
    }

    /**
     * Restituisce il nome del prodotto.
     *
     * @return nome del prodotto
     */
    public String getProdotto(){
        return prodotto;
    }

    /**
     * Imposta una nuova quantità di scorte per il prodotto.
     * (Metodo vuoto: da implementare)
     */
    public void setScorte(){
        // Da implementare
    }

    /**
     * Imposta un nuovo nome per il prodotto.
     * (Metodo vuoto: da implementare)
     */
    public void setProdotto(){
        // Da implementare
    }
}
