/**
 * Classe che rappresenta un conto corrente bancario.
 * Permette di gestire un nome intestatario, un saldo e operazioni
 * di deposito e prelievo.
 */
public class ContoCorrente {

    /** Nome dell'intestatario del conto. */
    private String nome;

    /** Saldo attuale del conto. */
    private double saldo;

    /**
     * Costruttore della classe ContoCorrente.
     *
     * @param nome  nome dell'intestatario del conto
     * @param saldo saldo iniziale del conto
     */
    public ContoCorrente(String nome, double saldo){
        this.nome = nome;
        this.saldo = saldo;
    }

    /**
     * Restituisce il nome dell'intestatario del conto.
     *
     * @return il nome dell'utente
     */
    public String getNome(){
        return nome;
    }

    /**
     * Restituisce il saldo corrente del conto.
     *
     * @return il saldo disponibile
     */
    public double getSaldo(){
        return saldo;
    }

    /**
     * Effettua un deposito sul conto.
     * L'importo viene aggiunto al saldo corrente e arrotondato a due decimali.
     *
     * @param importo somma da depositare
     */
    public void deposita(double importo){
        saldo = saldo + importo;
        saldo = (double) Math.round(saldo * 100) / 100;
    }

    /**
     * Effettua un prelievo dal conto, se l'importo richiesto è disponibile.
     * Il nuovo saldo viene arrotondato a due decimali.
     *
     * @param importo somma da prelevare
     */
    public void preleva(double importo){
        if(importo <= saldo){
            saldo = saldo - importo;
            saldo = (double) Math.round(saldo * 100) / 100;
        }
    }
    
}
