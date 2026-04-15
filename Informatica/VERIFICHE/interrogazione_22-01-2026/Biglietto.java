public class Biglietto {
    private Integer giorno;
    private Integer mese;
    private Integer anno;
    private String cantante;
    private Double prezzo;

    public Biglietto(Integer giorno, Integer mese, Integer anno, String cantante, Double prezzo){
        this.giorno = giorno;
        this.mese = mese;
        this.anno = anno;
        this.cantante = cantante;
        this.prezzo = prezzo;
    }

    public Integer getGiorno(){
        return giorno;
    }

    public Integer getMese(){
        return mese;
    }

    public Integer getAnno(){
        return anno;
    }

    public String getCantante(){
        return cantante;
    }

    public Double getPrezzo(){
        return prezzo;
    }

    public void setGiorno(){
        this.giorno = giorno;
    }

    public void setMese(){
        this.mese = mese;
    }

    public void setAnno(){
        this.anno = anno;
    }

    public void setCantante(){
        this.cantante = cantante;
    }

    public void setPrezzo(){
        this.prezzo = prezzo;
    }
}
