package classi;

public class Pacco {
    private String codice;
    private String descrizione;
    private double peso;
    private Pacco next;

    public Pacco(String codice, String descrizione, double peso){
        this.codice = codice;
        this.descrizione = descrizione;
        this.peso = peso;
        this.next = null;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Pacco getNext() {
        return next;
    }

    public void setNext(Pacco next) {
        this.next = next;
    }

}
