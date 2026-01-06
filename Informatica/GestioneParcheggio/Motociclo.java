package Informatica.GestioneParcheggio;

public class Motociclo extends Veicolo {

    private Integer numeroPosti;
    private Integer cilindrata;

    public Motociclo(String targa, String marca, String orarioIngresso, Integer numeroPosti, Integer cilindrata) {
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
