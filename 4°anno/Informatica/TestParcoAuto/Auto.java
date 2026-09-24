/**
 * La classe {@code Auto} estende {@link Veicolo} e rappresenta un'auto con un numero specifico di posti.
 * Include metodi per ottenere il numero di posti, suonare il clacson e avviare l'auto.
 */
public class Auto extends Veicolo {

    /**
     * Numero di posti presenti nell'auto.
     */
    private int numeroPosti;

    /**
     * Costruttore della classe {@code Auto}.
     *
     * @param marca        la marca dell'auto
     * @param velocitaMax  la velocità massima dell'auto
     * @param numeroPosti  il numero di posti disponibili nell'auto
     */
    public Auto(String marca, int velocitaMax, int numeroPosti) {
        super(marca, velocitaMax);
        this.numeroPosti = numeroPosti;
    }

    /**
     * Restituisce il numero di posti dell'auto.
     *
     * @return il numero di posti
     */
    public int getNumeroPosti() {
        return numeroPosti;
    }

    /**
     * Metodo per suonare il clacson dell'auto.
     */
    public void suonaClacson() {
        System.out.println("Beep!");
    }

    /**
     * Metodo per avviare l'auto.
     * Sovrascrive il metodo {@link Veicolo#avvia()} per fornire un comportamento specifico dell'auto.
     */
    @Override
    public void avvia() {
        System.out.println("L'auto si avvia, cambio in posizione P");
    }
}
