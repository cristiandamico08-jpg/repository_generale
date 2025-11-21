/**
 * La classe {@code TestParcoAuto} rappresenta un programma di prova per un parco auto.
 * Crea diverse istanze di veicoli, le inserisce in un array e mostra le operazioni disponibili
 * e il veicolo con la velocità massima.
 */
public class TestParcoAuto {

    /**
     * Istanza di {@link Auto} utilizzata nel parco auto.
     */
    private Auto auto = new Auto("Toyota", 180, 5);

    /**
     * Istanza di {@link Berlina} utilizzata nel parco auto.
     */
    private Berlina berlina = new Berlina("BMW", 240, 5, 500);

    /**
     * Istanza di {@link Moto} utilizzata nel parco auto.
     */
    private Moto moto = new Moto("Ducati", 220, 1100);

    /**
     * Array di {@link Veicolo} che rappresenta l'inventario del parco auto.
     */
    private Veicolo[] inventarioParco = {auto, berlina, moto};

    /**
     * Variabile per memorizzare la velocità massima tra tutti i veicoli.
     */
    private int velocitaMaggiore = 0;

    /**
     * Variabile per memorizzare la marca del veicolo con la velocità massima.
     */
    private String marcaMaggiore = auto.getMarca();

    /**
     * Costruttore della classe {@code TestParcoAuto}.
     * Esegue le operazioni sui veicoli, come avviare, frenare e aprire il bagagliaio
     * per le berline, e determina il veicolo con la velocità massima.
     */
    public TestParcoAuto() {
        System.out.println("\nHo creato l'array inventarioParco con " + inventarioParco.length + " veicoli.\n");

        // Ciclo su tutti i veicoli dell'inventario
        for (Veicolo veicolo : inventarioParco) {
            veicolo.avvia();
            veicolo.frena();

            // Se il veicolo è una berlina, apri il bagagliaio
            if (veicolo instanceof Berlina) {
                Berlina b = (Berlina) veicolo;
                b.apriBagagliaio();      
            }

            // Aggiorna la velocità massima e la marca del veicolo più veloce
            if (velocitaMaggiore < veicolo.getVelocitaMax()) {
                velocitaMaggiore = veicolo.getVelocitaMax();
                marcaMaggiore = veicolo.getMarca();
            }
        }

        System.out.println("\nLa velocità massima tra i veicoli è del veicolo: " + marcaMaggiore + " con " + velocitaMaggiore + " km/h");
    }

    /**
     * Metodo principale che avvia il programma creando un'istanza di {@code TestParcoAuto}.
     *
     * @param args argomenti della riga di comando (non utilizzati)
     */
    public static void main(String[] args) {
        new TestParcoAuto();
    }
}
