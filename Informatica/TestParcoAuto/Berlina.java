/**
 * La classe {@code Berlina} estende {@link Auto} e rappresenta un'auto berlina con un bagagliaio di capacità specifica.
 * Include metodi per aprire il bagagliaio e un clacson personalizzato.
 */
public class Berlina extends Auto {

    /**
     * Capacità del bagagliaio in litri.
     */
    private int bagagliaioLitri;

    /**
     * Costruttore della classe {@code Berlina}.
     *
     * @param marca          la marca della berlina
     * @param velocitaMax    la velocità massima della berlina
     * @param numeroPosti    il numero di posti disponibili nella berlina
     * @param bagagliaioLitri la capacità del bagagliaio in litri
     */
    public Berlina(String marca, int velocitaMax, int numeroPosti, int bagagliaioLitri) {
        super(marca, velocitaMax, numeroPosti);
        this.bagagliaioLitri = bagagliaioLitri;
    }

    /**
     * Restituisce la capacità del bagagliaio in litri.
     *
     * @return capacità del bagagliaio
     */
    public int getBagagliaioLitri() {
        return bagagliaioLitri;
    }

    /**
     * Metodo per aprire il bagagliaio della berlina.
     */
    public void apriBagagliaio() {
        System.out.println("Il bagagliaio della berlina è aperto.");
    }

    /**
     * Metodo per suonare il clacson della berlina.
     * Sovrascrive {@link Auto#suonaClacson()} per fornire un suono specifico.
     */
    @Override
    public void suonaClacson() {
        System.out.println("Beep-Beep!");
    }
}
