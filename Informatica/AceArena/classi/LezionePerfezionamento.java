package classi;

public class LezionePerfezionamento extends Giocatore{
    private int durataLezioneInMinuti;

    public LezionePerfezionamento(int durataLezioneInMinuti, String nome, int codiceIdentificativo){
        super(nome, codiceIdentificativo);
        this.durataLezioneInMinuti = durataLezioneInMinuti;
    }

    public int getDurataLezioneInMinuti() {
        return durataLezioneInMinuti;
    }

    public void setNoleggioRacchetta(int durataLezioneInMinuti) {
        this.durataLezioneInMinuti = durataLezioneInMinuti;
    }

    @Override
    public void calcolaTariffaFinale(){
        double totale = 0;
        double arrotondamento = 0;
        if (durataLezioneInMinuti > 45) {
            totale = durataLezioneInMinuti + ((durataLezioneInMinuti * 25) / 100);
            arrotondamento = Math.round(totale * 100) / 100;
        } else {
            totale = super.getTariffaBase();
            arrotondamento = Math.round(totale * 100) / 100;
        }
        System.out.println("Il prezzo della tariffa finale e' di" + arrotondamento + " euro");
    }
}
