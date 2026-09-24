package classi;

public class Cliente {
    private String nome;
    private String cognome;
    private double saldo;
    private Cliente next;

    public Cliente(String nome, String cognome, double saldo){
        this.nome = nome;
        this.cognome = cognome;
        this.saldo = saldo;
        this.next = null;
    }

    public String getNome(){
        return nome;
    }

    public String getCognome(){
        return cognome;
    }

    public double getSaldo(){
        return saldo;
    }

    public void setNext(Cliente next){
        this.next = next;
    }

    public Cliente getNext(){
        return next;
    }

}
