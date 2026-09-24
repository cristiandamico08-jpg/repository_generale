package Informatica.GestioneParcheggio;

public class Automobile extends Veicolo {

    private Integer numeroPosti;
    private Integer cilindrata;

    public Automobile(String targa, String marca, Integer orarioIngresso, Integer numeroPosti, Integer cilindrata) {
        super(targa, marca, orarioIngresso);
        this.numeroPosti = numeroPosti;
        this.cilindrata = cilindrata;
    }

    public Integer getNumeroPosti() {
        return numeroPosti;
    }

    public void setNumeroPosti(Integer numeroPosti) {
        this.numeroPosti = numeroPosti;
    }

    public Integer getCilindrata() {
        return cilindrata;
    }

    public void setCilindrata(Integer cilindrata) {
        this.cilindrata = cilindrata;
    }
    
}
