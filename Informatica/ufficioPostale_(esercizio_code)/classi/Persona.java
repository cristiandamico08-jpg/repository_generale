package classi;

public class Persona {

    private String nome;
    private String cognome;
    private double importo;
    private Persona next;

    public Persona(String nome, String cognome, double importo){
        this.nome = nome;
        this.cognome = cognome;
        this.importo = importo;
    }

    public String getNome(){
        return nome;
    }

    public String getCognome(){
        return cognome;
    }

    public double getImporto(){
        return importo;
    }

    public Persona getNext(){
        return next;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCognome(String cognome){
        this.cognome = cognome;
    }

    public void setImporto(double importo){
        this.importo = importo;
    }

    public void setNext(Persona next){
        this.next = next;
    }

}
