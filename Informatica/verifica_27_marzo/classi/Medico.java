package classi;

public class Medico extends Persona{
    private String matricola;
    private String specializzazione;

    public Medico(String nome, String cognome, String matricola, String specializzazione){
        super(nome, cognome);
        this.matricola = matricola;
        this.specializzazione = specializzazione;
    }

    public String getMatricola(){
        return matricola;
    }

    public String getSpecializzazione(){
        return specializzazione;
    }

    public void setMatricola(String matricola){
        this.matricola = matricola;
    }

    public void setSpecializzazione(String specializzazione){
        this.specializzazione = specializzazione;
    }

}
