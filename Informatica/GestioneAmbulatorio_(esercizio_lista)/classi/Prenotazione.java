package classi;

public class Prenotazione {
    private String id;
    private String paziente;
    private String visita;
    private double prezzo;
    private Prenotazione next;

    public Prenotazione(String id, String paziente, String visita, double prezzo){
        this.id = id;
        this.paziente = paziente;
        this.visita = visita;
        this.prezzo = prezzo;
        this.next = null;
    }

    public String getId() {
        return id;
    }

    public String getPaziente() {
        return paziente;
    }

    public String getVisita() {
        return visita;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public Prenotazione getNext() {
        return next;
    }

    public void setNext(Prenotazione next) {
        this.next = next;
    }

}
