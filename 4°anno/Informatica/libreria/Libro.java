/**
 * La classe {@code Libro} rappresenta un libro con informazioni di base come titolo, autore,
 * anno di pubblicazione, prezzo e disponibilità.
 */
public class Libro {

    /**
     * Titolo del libro.
     */
    public String titolo;

    /**
     * Autore del libro.
     */
    public String autore;

    /**
     * Anno di pubblicazione del libro.
     */
    public int anno;

    /**
     * Prezzo del libro.
     */
    public double prezzo;

    /**
     * Indica se il libro è disponibile o meno.
     */
    public boolean disponibile;

    /**
     * Costruttore della classe {@code Libro}.
     *
     * @param titolo       il titolo del libro
     * @param autore       l'autore del libro
     * @param anno         l'anno di pubblicazione
     * @param prezzo       il prezzo del libro
     * @param disponibile  true se il libro è disponibile, false altrimenti
     */
    public Libro(String titolo, String autore, int anno, double prezzo, boolean disponibile) {
        this.titolo = titolo;
        this.autore = autore;
        this.anno = anno;
        this.prezzo = prezzo;
        this.disponibile = disponibile;
    }

    /**
     * Restituisce il titolo del libro.
     *
     * @return il titolo del libro
     */
    public String getTitolo() {
        return titolo;
    }

    /**
     * Restituisce l'autore del libro.
     *
     * @return l'autore del libro
     */
    public String getAutore() {
        return autore;
    }

    /**
     * Restituisce l'anno di pubblicazione del libro.
     *
     * @return l'anno di pubblicazione
     */
    public int getAnno() {
        return anno;
    }

    /**
     * Restituisce il prezzo del libro.
     *
     * @return il prezzo del libro
     */
    public double getPrezzo() {
        return prezzo;
    }

    /**
     * Verifica se il libro è disponibile.
     *
     * @return true se disponibile, false altrimenti
     */
    public boolean isDisponibile() {
        return disponibile;
    }
}
