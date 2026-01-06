package Informatica.GestioneParcheggio;

public class Veicolo {
    private String targa;
    private String marca;
    private Integer orarioIngresso;

    public Veicolo(String targa, String marca, Integer orarioIngresso) {
        this.targa = targa;
        this.marca = marca;
        this.orarioIngresso = orarioIngresso;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getOrarioIngresso() {
        return orarioIngresso;
    }

    public void setOrarioIngresso(Integer orarioIngresso) {
        this.orarioIngresso = orarioIngresso;
    }
}