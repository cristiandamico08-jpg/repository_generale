/**
 * La classe {@code Moto} estende {@link Veicolo} e rappresenta una motocicletta con una specifica cilindrata.
 * Include metodi per effettuare un'impennata e per frenare in modo specifico.
 */
public class Moto extends Veicolo {

    /**
     * Cilindrata della moto in centimetri cubici (CC).
     */
    private int cilindrataCC;

    /**
     * Costruttore della classe {@code Moto}.
     *
     * @param marca        la marca della moto
     * @param velocitaMax  la velocità massima della moto
     * @param cilindrataCC la cilindrata della moto in CC
     */
    public Moto(String marca, int velocitaMax, int cilindrataCC) {
        super(marca, velocitaMax);
        this.cilindrataCC = cilindrataCC;
    }

    /**
     * Restituisce la cilindrata della moto.
     *
     * @return la cilindrata in CC
     */
    public int getCilindrataCC() {
        return cilindrataCC;
    }

    /**
     * Metodo per effettuare un'impennata con la moto.
     */
    public void impennata() {
        System.out.println("La moto sta facendo un'impennata!");
    }

    /**
     * Metodo per frenare la moto.
     * Sovrascrive {@link Veicolo#frena()} per fornire un comportamento specifico della moto.
     */
    @Override
    public void frena() {
        System.out.println("La moto sta frenando con il freno anteriore e posteriore.");
    }
}
