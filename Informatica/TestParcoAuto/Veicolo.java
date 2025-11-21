/**
 * La classe {@code Veicolo} rappresenta un veicolo generico con una marca e una velocità massima.
 * Fornisce metodi per avviare e fermare il veicolo, e per ottenere le informazioni di base.
 */
public class Veicolo {

    /**
     * Marca del veicolo.
     */
    private String marca;

    /**
     * Velocità massima del veicolo in km/h.
     */
    private int velocitaMax;

    /**
     * Costruttore della classe {@code Veicolo}.
     *
     * @param marca       la marca del veicolo
     * @param velocitaMax la velocità massima del veicolo in km/h
     */
    public Veicolo(String marca, int velocitaMax) {
        this.marca = marca;
        this.velocitaMax = velocitaMax;
    }

    /**
     * Restituisce la marca del veicolo.
     *
     * @return la marca del veicolo
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Restituisce la velocità massima del veicolo.
     *
     * @return la velocità massima in km/h
     */
    public int getVelocitaMax() {
        return velocitaMax;
    }

    /**
     * Metodo per avviare il veicolo.
     * Può essere sovrascritto dalle classi figlie per comportamenti specifici.
     */
    public void avvia() {
        System.out.println("Il veicolo di marca \"" + marca + "\" si sta avviando.");
    }

    /**
     * Metodo per frenare il veicolo.
     * Può essere sovrascritto dalle classi figlie per comportamenti specifici.
     */
    public void frena() {
        System.out.println("Il veicolo di marca \"" + marca + "\" si sta fermando.");
    }
}
