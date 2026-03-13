package classi;

public abstract class Giocatore {
    private String nome;
    private int codiceIdentificativo;
    private double tariffaBase;

    public Giocatore(String nome, int codiceIdentificativo){
        this.nome = nome;
        this.codiceIdentificativo = codiceIdentificativo;
        this.tariffaBase = 25;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodiceIdentificativo() {
        return codiceIdentificativo;
    }

    public void setCodiceIdentificativo(int codiceIdentificativo) {
        this.codiceIdentificativo = codiceIdentificativo;
    }

    public double getTariffaBase() {
        return tariffaBase;
    }

    public abstract void calcolaTariffaFinale();
}
