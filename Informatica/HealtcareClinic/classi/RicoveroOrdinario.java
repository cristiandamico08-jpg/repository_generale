package classi;

public class RicoveroOrdinario extends Paziente{

    public RicoveroOrdinario(String nome, int codiceCartella, double tariffaBase){
        super(nome, codiceCartella, tariffaBase);
    }

    @Override
    public void calcolaCostoRicovero(boolean pastoPersonalizzato, int numeroGiorni) {
        double tariffaBase = 100;
        super.setTariffaBase(tariffaBase);
        double arrotondamento = 0;
        if(pastoPersonalizzato == true){
            tariffaBase = (tariffaBase + 20) * numeroGiorni;
        }
        arrotondamento = Math.round(tariffaBase * 100) / 100;
        this.setTariffaBase(arrotondamento);
    }

}
