package classi;

public class AffittoSemplice extends Giocatore{
    private boolean noleggioRacchetta;
    
    public AffittoSemplice(boolean noleggioRacchetta, String nome, int codiceIdentificativo){
        super(nome, codiceIdentificativo);
        this.noleggioRacchetta = noleggioRacchetta;
    }

    public boolean getNoleggioRacchetta() {
        return noleggioRacchetta;
    }

    public void setNoleggioRacchetta(boolean noleggioRacchetta) {
        this.noleggioRacchetta = noleggioRacchetta;
    }

    @Override
    public void calcolaTariffaFinale(){
        double totale = 0;
        double arrotondamento = 0;
        if(noleggioRacchetta == true){
            totale = super.getTariffaBase() + 5;
            arrotondamento = Math.round(totale * 100) / 100;
        } else {
            totale = super.getTariffaBase();
            arrotondamento = Math.round(totale * 100) / 100;
        }
        System.out.println("Il prezzo della tariffa finale e' di" + arrotondamento + " euro");
    }
}
