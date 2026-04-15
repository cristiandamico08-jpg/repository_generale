package classi;

public class Paziente extends Persona{

    private String codiceFiscale;

    public Paziente(String nome, String cognome, String codiceFiscale){
        super(nome, cognome);
        this.codiceFiscale = codiceFiscale;
    }

    public String getCodiceFiscale(){
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale){
        this.codiceFiscale = codiceFiscale;
    }
}
