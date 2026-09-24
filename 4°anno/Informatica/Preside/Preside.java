/**
 * La classe {@code Preside} rappresenta uno studente con nome, classe e voto.
 * Fornisce metodi per accedere ai valori dei campi (getter) e placeholder per eventuali setter.
 */
public class Preside {

    /**
     * Nome dello studente.
     */
    private String nomi;

    /**
     * Classe dello studente.
     */
    private String classi;

    /**
     * Voto dello studente.
     */
    private double voti;

    /**
     * Costruttore della classe {@code Preside}.
     *
     * @param nomi   il nome dello studente
     * @param classi la classe dello studente
     * @param voti   il voto dello studente
     */
    public Preside(String nomi, String classi, double voti) {
        this.nomi = nomi;
        this.classi = classi;
        this.voti = voti;
    }

    /**
     * Restituisce il nome dello studente.
     *
     * @return il nome dello studente
     */
    public String getNomi() {
        return nomi;
    }

    /**
     * Restituisce la classe dello studente.
     *
     * @return la classe dello studente
     */
    public String getClassi() {
        return classi;
    }

    /**
     * Restituisce il voto dello studente.
     *
     * @return il voto dello studente
     */
    public double getVoti() {
        return voti;
    }

    /**
     * Setter placeholder per il nome dello studente.
     * Attualmente non implementato.
     */
    public void setNomi() {
        // Metodo vuoto, da implementare se necessario
    }

    /**
     * Setter placeholder per la classe dello studente.
     * Attualmente non implementato.
     */
    public void setClassi() {
        // Metodo vuoto, da implementare se necessario
    }

    /**
     * Setter placeholder per il voto dello studente.
     * Attualmente non implementato.
     */
    public void setVoti() {
        // Metodo vuoto, da implementare se necessario
    }
}
